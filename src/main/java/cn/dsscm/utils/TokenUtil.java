package cn.dsscm.utils;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class TokenUtil {
    @Value("${token.secret-key}")
    private String secretKey;

    /**
     * 加密token
     */
    public String getToken(Integer userId, Date expireAt, Date forceExpireAt) {
        String token = JWT
                .create()
                .withClaim("userId", userId)
                .withClaim("forceExpireAt", forceExpireAt)
                .withExpiresAt(expireAt)
                .sign(Algorithm.HMAC256(secretKey));
        return token;
    }

    /**
     * 解析token
     */
    public Map<String, Object> parseToken(String token) {
        try {
            DecodedJWT decodedjwt = JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
            Claim userId = decodedjwt.getClaim("userId");
            Claim forceExpireAt = decodedjwt.getClaim("forceExpireAt");
            if (forceExpireAt.asDate().before(new Date())) {
                return null;
            }
            Claim expire = decodedjwt.getClaim("exp");
            Map<String, Object> map = Map.of("userId", userId.asInt(), "forceExpireAt", forceExpireAt.asDate(), "expireAt",
                    expire.asDate());
            return map;
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}

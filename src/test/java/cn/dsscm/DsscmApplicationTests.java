package cn.dsscm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DsscmApplicationTests {

	@Test
	void BCryptTest(@Autowired BCryptPasswordEncoder passwordEncoder) {
		String password = "admin";
		String encodedPassword = passwordEncoder.encode(password);
		System.out.println("加密后的密码为：" + encodedPassword);

		boolean same_password_result = passwordEncoder.matches(password, encodedPassword);
		System.out.println("相同密码匹配结果为：" + same_password_result);

		String wrongPassword = "wrong";
		boolean wrong_password_result = passwordEncoder.matches(wrongPassword, encodedPassword);
		System.out.println("不同密码匹配结果为：" + wrong_password_result);

		String lastEncodedPassword = "$2y$05$vSXrMCHgwCbHkiqpJ7bdVuGknS9rY7.kmGvsBQylT5FkKBeEDbkK6";
		boolean last_password_result = passwordEncoder.matches(password, lastEncodedPassword);
		System.out.println("相同密码两次加密结果匹配结果为：" + last_password_result);
	}

}

package cn.dsscm.utils;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtil {
    private static final ThreadLocal<Map<String, Object>> threadLocal = ThreadLocal.withInitial(HashMap::new);

    public static void set(String key, Object value) {
        Map<String, Object> userInfoMap = threadLocal.get();
        userInfoMap.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> userInfoMap = threadLocal.get();
        return userInfoMap.get(key);
    }

    public static void clear() {
        threadLocal.remove();
    }
}

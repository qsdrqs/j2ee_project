package grp.wudi.j2ee.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Util {
    /**
     * 这个方法可以使得字符串经过sha256哈希处理
     * @param source 源字符串
     * @return 转化后的字符串
     */
    public static String stringToSHA256(String source) {
        byte[] bytes;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            bytes = messageDigest.digest(source.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("生成SHA256序列失败");
        }
        String result;
        try {
            result = new String(bytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("转换失败");
        }
        return result;
    }

}

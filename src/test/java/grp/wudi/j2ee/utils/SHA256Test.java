package grp.wudi.j2ee.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SHA256Test {
    String testString = "Hello World!";

    @Test
    public void testString() throws Exception {
        String result = SHA256Util.stringToSHA256(testString);
        System.out.println(result);String tmp="Hello World!";

        System.out.println(SHA256Util.stringToSHA256(tmp));

        assertEquals(result, SHA256Util.stringToSHA256(tmp));
    }
}

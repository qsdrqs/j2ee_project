package grp.wudi.j2ee.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import grp.wudi.j2ee.utils.SHA256Util;
import junit.framework.Assert;

public class SHA256Test {
    String testString = "Hello World!";

    @Test
    public void testString() throws Exception {
        String result = SHA256Util.stringToSHA256(testString);
        String tmp="Hello World!";
        assertEquals(result, SHA256Util.stringToSHA256(tmp));
    }
}

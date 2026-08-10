package org.example;

public class Assert {
    public void assertTest(){
        String contact1 = null;
        Assert.assertNull(contact1);
    }

    public static void assertNull(String contact1) {
        contact1 = null;
        Assert.assertNull(null);
    }
}

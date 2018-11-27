package com.paglione.util;

public class Util {
    public static String getMethodName(Object object) {
        return Thread.currentThread().getStackTrace()[1].getMethodName();
    }
}

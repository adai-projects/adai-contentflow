package com.adaiadai.contentflow.util;

import java.util.UUID;

/**
 * @author adai
 */
public class UUIDUtil {

    public static String getUuidPartOne() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, uuid.indexOf("-"));
    }

    public static void main(String[] args) {
        UUIDUtil.getUuidPartOne();
    }
}

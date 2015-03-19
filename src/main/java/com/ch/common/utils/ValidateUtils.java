package com.ch.common.utils;

import org.springframework.util.StringUtils;

/**
 * User: Jack Wang
 * Date: 15-3-19
 * Time: 下午2:46
 */
public class ValidateUtils {

    public static boolean isValidateURL(String url) {
        if (StringUtils.hasText(url)) {
            String newUrl = url.toLowerCase();
            if (newUrl.startsWith("http://") || newUrl.startsWith("http://")) {
                return true;
            }
            return false;
        }
        return false;
    }
}

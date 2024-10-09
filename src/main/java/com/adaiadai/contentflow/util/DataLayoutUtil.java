package com.adaiadai.contentflow.util;

import com.adaiadai.contentflow.constant.DataLayout;

/**
 * @author adai
 */
public class DataLayoutUtil {

    public static DataLayout layout(String layout) {
        if (layout != null && !"".equals(layout)) {
            return DataLayout.valueOf(layout);
        } else {
            return DataLayout.DATA_LAYOUT_DEFAULT_BASE;
        }
    }
}

package com.tabardel.weather.tools.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TABARDEL_Remy on 05/01/2017.
 */

public class ListUtils {
    /**
     * if list is null return new ArrayList
     *
     * @param list
     * @return
     */
    public static List defaultIfNull(List list) {
        return (list != null) ? list : new ArrayList();
    }
}

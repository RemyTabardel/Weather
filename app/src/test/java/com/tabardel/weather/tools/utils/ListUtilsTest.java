package com.tabardel.weather.tools.utils;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by TABARDEL_Remy on 07/01/2017.
 */
@SmallTest
public class ListUtilsTest {
    @Test
    public void testListUtils_defaultIfNull() {
        assertNotNull(ListUtils.defaultIfNull(null));
    }
}

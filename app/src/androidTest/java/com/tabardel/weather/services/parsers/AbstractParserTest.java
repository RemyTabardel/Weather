package com.tabardel.weather.services.parsers;

import android.test.suitebuilder.annotation.SmallTest;
import android.util.JsonReader;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by TABARDEL_Remy on 10/12/2016.
 */

@SmallTest
public class AbstractParserTest {
    private class FakeParser extends AbstractParser<Object> {
        @Override
        public Object parse(JsonReader reader) throws IOException {
            return null;
        }
    }

    private FakeParser mFakeParser;

    @Before
    public void setUp() {
        mFakeParser = new FakeParser();
    }

    @Test
    public void testAbstractParser_empty_value() throws IOException {
        Object object = mFakeParser.getValue("obj");

        assertNull(null, object);
    }

    @Test
    public void testAbstractParser_set_value() throws IOException {
        mFakeParser.setValue("obj", 56);
        int value = mFakeParser.getValue("obj");

        assertEquals(56, value);
    }

    @Test
    public void testAbstractParser_get_value_throws_with_list() {
        mFakeParser.addListValue("list", new Object());
        List list = null;

        try {
            list = mFakeParser.getValue("list");
            assertEquals(true, false);
        } catch (IOException e) {
            assertEquals(true, true);
        }
    }

    @Test
    public void testAbstractParser_add_value_to_list() {
        mFakeParser.addListValue("list", new Object());
        mFakeParser.addListValue("list", new Object());
        mFakeParser.addListValue("list", new Object());

        List<Object> list = mFakeParser.getList("list");

        assertEquals(3, list.size());
    }
}

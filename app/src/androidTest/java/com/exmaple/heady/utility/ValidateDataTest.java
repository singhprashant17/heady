package com.exmaple.heady.utility;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateDataTest {
    @Test
    public void isNotNullOrBlank() throws Exception {

        String string = null;
        assertFalse(ValidateData.isNotNullOrBlank(string));

        string = "";
        assertFalse(ValidateData.isNotNullOrBlank(string));

        string = "   ";
        assertFalse(ValidateData.isNotNullOrBlank(string));

        string = "tempString";
        assertTrue(ValidateData.isNotNullOrBlank(string));
    }

    @Test
    public void isNotNullOrBlank1() throws Exception {

        String string = null;
        assertFalse(ValidateData.isNotNullOrBlank(string, ""));

        string = "";
        assertFalse(ValidateData.isNotNullOrBlank(string, ""));

        string = "   ";
        assertFalse(ValidateData.isNotNullOrBlank(string, ""));

        string = "tempString";
        assertTrue(ValidateData.isNotNullOrBlank(string, ""));
    }

    @Test
    public void testCondition() throws Exception {
        assertFalse(ValidateData.testCondition(false, ""));

        assertTrue(ValidateData.testCondition(true, ""));
    }

    @Test
    public void isValidCollection() throws Exception {
        ArrayList<Object> list = null;
        assertFalse(ValidateData.isValidCollection(list));

        list = new ArrayList<>();
        assertFalse(ValidateData.isValidCollection(list));

        list.add(1);
        assertTrue(ValidateData.isValidCollection(list));
    }
}

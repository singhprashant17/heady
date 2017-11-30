package com.exmaple.heady.utility;

import android.text.TextUtils;
import android.widget.EditText;

import java.util.Collection;

public class ValidateData {
    /**
     * Method to check if the passed string in empty or not
     *
     * @param valueToCheck the string value
     * @return true if the string is not null or blank, false otherwise
     */
    public static boolean isNotNullOrBlank(String valueToCheck) {
        return null != valueToCheck && !TextUtils.isEmpty(valueToCheck.trim());
    }

    /**
     * Method to check if the passed string in empty or not and display the message if false
     *
     * @param val    the string value
     * @param errMsg the message to be displayed as toast
     * @return true if the string is not null or blank, false otherwise and display toast message
     */
    public static boolean isNotNullOrBlank(String val, String errMsg) {
        final boolean isValid = isNotNullOrBlank(val);
        return testCondition(isValid, errMsg);
    }

    /**
     * Method to check if the passed {@link EditText} has getText() empty or not and display the
     * message if false
     *
     * @param val    The {@link EditText} which need to be checked
     * @param errMsg the message to be displayed as toast
     * @return true if the getText() is not null or blank, false otherwise and display toast message
     */
    public static boolean isNotNullOrBlank(EditText val, String errMsg) {
        return null != val && isNotNullOrBlank(val.getText().toString(), errMsg);
    }

    /**
     * Method to test the supplied condition and display toast if false
     *
     * @param condition boolean condition to be tested
     * @param errMsg    the message to be displayed as toast
     * @return true if the string is not null or blank, false otherwise and display toast message
     */
    public static boolean testCondition(boolean condition, String errMsg) {
        if (!condition) {
            Utility.displayToast(errMsg);
        }
        return condition;
    }

    /**
     * Method to check if {@link Collection} is null or empty
     *
     * @param collection the Collection instance to be checked for non-empty
     * @return true if collection has at-least one item
     */
    public static boolean isValidCollection(Collection collection) {
        return null != collection && !collection.isEmpty();
    }
}

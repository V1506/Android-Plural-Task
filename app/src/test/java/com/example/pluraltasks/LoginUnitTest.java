package com.example.pluraltasks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginUnitTest {
    @Test
    public void emailValidation_isCorrect() {
        assertEquals(false, Utilities.isValidEmail("example"));
        assertEquals(false, Utilities.isValidEmail("example@gmail"));
        assertEquals(true, Utilities.isValidEmail("example@gmail.com"));
        assertEquals(false, Utilities.isValidEmail("example@gmail@.com"));
        assertEquals(true, Utilities.isValidEmail("example.next@gmail.com"));
        assertEquals(false, Utilities.isValidEmail(""));
    }
}
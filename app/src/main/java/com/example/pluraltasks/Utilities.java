package com.example.pluraltasks;

import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
    static boolean isValidEmail(CharSequence email) {
        if (email == null) {
            return true;
        }
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

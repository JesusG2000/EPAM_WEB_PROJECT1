package com.epam.examples.dao;

import java.util.regex.Pattern;

public  class FileParser {
    public static final Pattern FOUR_PARAMS = Pattern.compile("((-|)[0-9]+\\.[0-9]+\\s){3}[0-9]+\\.[0-9]+$");
    public static final Pattern EIGHT_PARAMS = Pattern.compile("((-|)[0-9]+\\.[0-9]+\\s){3}[0-9]+\\.[0-9]+\\sO([XYZ])\\s((-|)[0-9]+\\.[0-9]+\\s){2}[0-9]+\\.[0-9]+$");
}

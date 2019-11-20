package com.epam.examples.util.parser;


import com.epam.examples.util.parser.impl.FileDataParser;

public final class DataParserFactory {
    private static DataParser dataParser = new FileDataParser();

    private DataParserFactory() {
    }

    public static DataParser getDataParser() {
        return dataParser;
    }
}

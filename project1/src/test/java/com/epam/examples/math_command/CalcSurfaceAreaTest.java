package com.epam.examples.math_command;

import com.epam.examples.bean.Glob;
import com.epam.examples.util.parser.DataParser;
import com.epam.examples.util.parser.ParserException;
import com.epam.examples.util.parser.impl.FileDataParser;
import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.ProviderException;
import com.epam.examples.util.provider.impl.FileDataProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class CalcSurfaceAreaTest {

    private CalcSurfaceArea calcSurfaceArea;
    private List<Glob> lines;
    private DataProvider dataProvider;
    private DataParser parser;


    @Before
    public void initAllowableGlob() throws ProviderException, ParserException {
        dataProvider = new FileDataProvider("src\\test\\resources\\information");
        parser = new FileDataParser(dataProvider);
        lines = parser.getGlobes();
        calcSurfaceArea = new CalcSurfaceArea();
    }

    @After
    public void clearAllowableGlob() {
        calcSurfaceArea = null;
        lines = null;
        parser = null;
        dataProvider = null;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkOnException() {
        double expected = 118.4;
        String actual = calcSurfaceArea.execute(lines.get(3));
        Assert.assertEquals(expected, Double.parseDouble(actual), 0.1);
    }

    @Test
    public void checkOnResult() {
        double expected = 118.4;
        String actual = calcSurfaceArea.execute(lines.get(0));
        Assert.assertEquals(expected, Double.parseDouble(actual), 0.1);
    }
}
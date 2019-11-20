package com.epam.examples.math_command;

import com.epam.examples.entity.Glob;
import com.epam.examples.util.parser.DataParser;
import com.epam.examples.util.parser.DataParserFactory;
import com.epam.examples.util.parser.ParserException;
import com.epam.examples.util.provider.ProviderException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class CalcSurfaceAreaTest {

    private CalcSurfaceArea calcSurfaceArea;
    private List<Glob> lines;


    @Before
    public void initAllowableGlob() throws ProviderException, ParserException {
        DataParser parser = DataParserFactory.getDataParser();
        lines = parser.getGlobes();
        calcSurfaceArea = new CalcSurfaceArea();
    }

    @After
    public void clearAllowableGlob() {
        calcSurfaceArea = null;
        lines = null;
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
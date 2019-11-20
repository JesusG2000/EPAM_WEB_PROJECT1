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


public class IsTouchSomeAxisTest {

    private IsTouchSomeAxis touchSomeAxis;
    private List<Glob> lines;


    @Before
    public void initAllowableGlob() throws ProviderException, ParserException {
        DataParser parser = DataParserFactory.getDataParser();
        lines = parser.getGlobes();
        touchSomeAxis = new IsTouchSomeAxis();
    }

    @After
    public void clearAllowableGlob() {
        touchSomeAxis = null;
        lines = null;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkOnException() {
        String expected = "false";
        String actual = touchSomeAxis.execute(lines.get(3));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkOnResult() {
        String expected = "false";
        String actual = touchSomeAxis.execute(lines.get(0));
        Assert.assertEquals(expected, actual);
    }
}
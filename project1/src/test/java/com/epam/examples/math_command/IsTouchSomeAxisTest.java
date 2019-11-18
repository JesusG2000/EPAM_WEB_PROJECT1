package com.epam.examples.math_command;

import com.epam.examples.dao.DaoException;
import com.epam.examples.dao.DaoFactory;
import com.epam.examples.dao.FileDataAction;
import com.epam.examples.dao.FileParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

//@RunWith(Parameterized.class)
public class IsTouchSomeAxisTest {

    private IsTouchSomeAxis touchSomeAxis;
    private  FileDataAction factory;
    private  List<String> lines;
    // private static int i;

//    @Parameterized.Parameters
//    public static List<Object[]> data() throws DaoException {
//        factory = DaoFactory.getFileDataAction();
//        lines = factory.pickLinesByRule(factory.takeAllLines("src\\test\\resources\\information"), FileParser.FOUR_PARAMS);
//        return Arrays.asList(new Object[lines.size()][0]);
//    }

    @Before
    public void initAllowableGlob() throws DaoException {
        touchSomeAxis = new IsTouchSomeAxis();
        factory = DaoFactory.getFileDataAction();
        lines = factory.pickLinesByRule(factory.takeAllLines("src\\test\\resources\\information"), FileParser.FOUR_PARAMS);
    }

    @After
    public void clearAllowableGlob() {
        factory = null;
        touchSomeAxis = null;
        lines = null;
        //i++;
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
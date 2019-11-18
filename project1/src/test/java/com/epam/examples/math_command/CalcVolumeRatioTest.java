package com.epam.examples.math_command;

import com.epam.examples.dao.DaoException;
import com.epam.examples.dao.DaoFactory;
import com.epam.examples.dao.FileDataAction;
import com.epam.examples.dao.FileParser;
import com.epam.examples.math_operation.MathException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;


public class CalcVolumeRatioTest {

    private CalcVolumeRatio calcVolumeRatio;
    private  FileDataAction factory;
    private  List<String> lines;


    @Before
    public void initAllowableGlob() throws DaoException {
        calcVolumeRatio = new CalcVolumeRatio();
        factory = DaoFactory.getFileDataAction();
        lines = factory.pickLinesByRule(factory.takeAllLines("src\\test\\resources\\information"), FileParser.EIGHT_PARAMS);
    }

    @After
    public void clearAllowableGlob() {
        factory = null;
        calcVolumeRatio = null;
        lines = null;

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkOnIndexOutOfBoundsException() {
        double expected = 10;
        String actual = calcVolumeRatio.execute(lines.get(3));
        Assert.assertEquals(expected, Double.parseDouble(actual), 0.1);
    }

    @Test
    public void checkOnResult() {
        double expected = 3;
        String actual = calcVolumeRatio.execute(lines.get(0));
        Assert.assertEquals(expected, Double.parseDouble(actual), 0.1);
    }
}
package com.epam.examples.math_command;

import com.epam.examples.dao.DaoException;
import com.epam.examples.dao.DaoFactory;
import com.epam.examples.dao.FileDataAction;
import com.epam.examples.dao.FileParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class AllowableGlobTest {

    private AllowableGlob allowableGlob;
    private FileDataAction factory;
    private List<String> lines;


    @Before
    public void initAllowableGlob() throws DaoException {
        factory = DaoFactory.getFileDataAction();
        lines = factory.pickLinesByRule(factory.takeAllLines("src\\test\\resources\\information"), FileParser.FOUR_PARAMS);
        allowableGlob = new AllowableGlob();
    }

    @After
    public void clearAllowableGlob() {
        factory = null;
        allowableGlob = null;
        lines=null;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkOnException() {
        String expected = "true";
        String actual = allowableGlob.execute(lines.get(3));
        Assert.assertEquals(expected, actual);
    }

    @Test()
    public void checkOnResult() {
        String expected = "true";
        String actual = allowableGlob.execute(lines.get(1));
        Assert.assertEquals(expected, actual);
    }
}
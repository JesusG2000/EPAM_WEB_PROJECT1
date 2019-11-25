package com.epam.examples.math.command;

import com.epam.examples.bean.dto.SectionCalcParameters;
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


public class CalcVolumeRatioTest {

    private CalcVolumeRatio calcVolumeRatio;
    private List<SectionCalcParameters> lines;
    private DataProvider dataProvider;
    private DataParser parser;


    @Before
    public void initAllowableGlob() throws ProviderException, ParserException {
        dataProvider = new FileDataProvider();
        parser = new FileDataParser("src\\test\\resources\\information", dataProvider);
        lines = parser.getSectionParams();
        calcVolumeRatio = new CalcVolumeRatio();
    }

    @After
    public void clearAllowableGlob() {
        calcVolumeRatio = null;
        lines = null;
        parser = null;
        dataProvider = null;

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
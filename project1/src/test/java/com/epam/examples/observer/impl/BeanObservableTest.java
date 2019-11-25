package com.epam.examples.observer.impl;

import com.epam.examples.bean.dto.SectionCalcParameters;
import com.epam.examples.service.ServiceException;
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

public class BeanObservableTest {

    private List<SectionCalcParameters> linesParams;
    private DataProvider dataProvider;
    private DataParser parser;
    @Before
    public void initAllowableGlob() throws ProviderException, ParserException {

        dataProvider = new FileDataProvider();
        parser = new FileDataParser("src\\test\\resources\\information", dataProvider);
        linesParams = parser.getSectionParams();


    }

    @After
    public void clearAllowableGlob() {

        parser = null;
        dataProvider = null;
        linesParams = null;
    }
    @Test
    public void checkValueChanges() throws ServiceException {
        BeanObservable beanObservable =new BeanObservable();
        beanObservable.setSectionCalcParameters(linesParams.get(0));

        BeanObserver observer = new BeanObserver();

        beanObservable.addObserver(observer);
        beanObservable.setAxis("OY");

        double expectedCap = 113.09D;
        double expectedArea = 118.4;
        double expectedVolumeRat = 4.3;//3 beanObservable.setAxis("OX");
        boolean expectedAllow = true;
        boolean expectedTouchAxis = false;
        double actualCap = observer.getCapacity();
        double actualArea = observer.getSurfaceArea();
        double actualVolumeRat = observer.getVolumeRatio();
        boolean actualAllow = observer.isAllowableGlob();
        boolean actualTouchAxis = observer.isTouchSomeAxis();

        Assert.assertEquals(expectedCap, actualCap, 0.1);
        Assert.assertEquals(expectedArea, actualArea, 0.1);
        Assert.assertEquals(expectedVolumeRat, actualVolumeRat, 0.1);
        Assert.assertEquals(expectedAllow, actualAllow);
        Assert.assertEquals(expectedTouchAxis, actualTouchAxis);

    }
}
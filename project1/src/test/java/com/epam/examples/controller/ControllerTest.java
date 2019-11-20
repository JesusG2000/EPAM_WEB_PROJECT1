package com.epam.examples.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
    private Controller controller;

    @Before
    public void setUp() {
        controller = new Controller();
    }

    @After
    public void tearDown() {
        controller = null;
    }

    @Test
    public void checkAllowableGLob() {
        String expected = "(true) (true) ";
        String actual = controller.executeTask("ALLOWABLE_GLOB");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkCapacity() {
        String expected = "(113.09733552923255) (33.510321638291124) ";
        String actual = controller.executeTask("CALC_CAPACITY");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkSurfaceArea() {
        String expected = "(118.4352528130723) (78.95683520871486) ";
        String actual = controller.executeTask("CALC_SURFACE_AREA");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkVolumeRatio() {
        String expected = "(3.007545193034575) ";
        String actual = controller.executeTask("CALC_VOLUME_RATIO");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkIsTouchAxis() {
        String expected = "(false) (true) ";
        String actual = controller.executeTask("IS_TOUCH_SOME_AXIS");
        Assert.assertEquals(expected, actual);
    }
}
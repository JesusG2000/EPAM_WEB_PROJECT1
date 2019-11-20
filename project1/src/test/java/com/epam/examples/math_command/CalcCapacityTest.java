package com.epam.examples.math_command;

//import com.epam.examples.dao.DaoException;
//import com.epam.examples.dao.DaoFactory;
//import com.epam.examples.dao.FileDataAction;
//import com.epam.examples.dao.FileParser;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import java.util.List;
//
//
//public class CalcCapacityTest {
//    private CalcCapacity calcCapacity;
//    private FileDataAction factory;
//    private List<String> lines;
//
//
//
//
//    @Before
//    public void initCalcCapacity() throws DaoException {
//        factory = DaoFactory.getFileDataAction();
//        lines = factory.pickLinesByRule(factory.takeAllLines("src\\test\\resources\\information"), FileParser.FOUR_PARAMS);
//        calcCapacity = new CalcCapacity();
//    }
//
//    @After
//    public void clearCalcCapacity() {
//        factory = null;
//        calcCapacity = null;
//        lines=null;
//    }
//
//
////    @Test(expected = IndexOutOfBoundsException.class)
////    public void checkOnException() {
////        double expected = 113.09D;
////        String actual = calcCapacity.execute(lines.get(5));
////        Assert.assertEquals(expected, Double.parseDouble(actual), 0.1);
////    }
////
////    @Test()
////    public void checkOnResult() {
////        double expected = 113.09D;
////        String actual = calcCapacity.execute(lines.get(0));
////        Assert.assertEquals(expected, Double.parseDouble(actual), 0.1);
////    }
//}
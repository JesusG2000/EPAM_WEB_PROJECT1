package com.epam.examples.dao.impl;

import com.epam.examples.bean.Dot;
import com.epam.examples.bean.Glob;
import com.epam.examples.controller.Command;
import com.epam.examples.dao.DaoException;
import com.epam.examples.dao.GlobDao;
import com.epam.examples.math_command.CalcCapacity;
import com.epam.examples.math_command.CalcSurfaceArea;
import com.epam.examples.math_command.IsTouchSomeAxis;
import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.impl.FileDataProvider;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class GlobDaoImpl implements GlobDao {
    private static Logger log = Logger.getLogger(GlobDaoImpl.class);
    private List<Glob> globs;

    public GlobDaoImpl() {
        try {
            FileData fileData = new FileData();
            DataProvider provider = new FileDataProvider("data\\information");
            globs = fileData.getGlobData(provider);
        } catch (DaoException e) {
            log.error("Exception ", e);
            e.printStackTrace();
        }
    }

    @Override
    public List<Glob> getGlobs() {
        log.info("get glob list");
        return globs;
    }

    @Override
    public void addGlob(Glob glob) {
        log.info("add in glob list");
        globs.add(glob);
    }

    @Override
    public void removeGlob(int index) {
        log.info("remove glob");
        globs.remove(index);
    }

    @Override
    public void changeGlob(int index, Glob glob) {
        log.info("change glob");
        globs.set(index, glob);
    }

    @Override
    public List<Glob> findGlobsWithRadius(double rad) {
        log.info("try to find glob by radius");
        List<Glob> list = new ArrayList<>();
        for (Glob g : globs) {
            if (g.getRadius() == rad) {
                list.add(g);
            }
        }
        return list;
    }

    @Override
    public List<Glob> findGlobWithCapacity(double begin, double end) {
        log.info("try to find glob by capacity in range");
        List<Glob> list = new ArrayList<>();
        Command<Glob> command = new CalcCapacity();
        for (Glob g : globs) {
            double result = Double.parseDouble(command.execute(g));
            if (result >= begin && result <= end) {
                list.add(g);
            }
        }
        return list;
    }

    @Override
    public List<Glob> findGlobWithCapacity(double begin) {
        log.info("try to find glob by capacity more than value");
        List<Glob> list = new ArrayList<>();
        Command<Glob> command = new CalcCapacity();
        for (Glob g : globs) {
            double result = Double.parseDouble(command.execute(g));
            if (result >= begin) {
                list.add(g);
            }
        }
        return list;
    }

    @Override
    public List<Glob> findGlobTouchAxis() {
        log.info("try to find glob touch the axis");
        List<Glob> list = new ArrayList<>();
        Command<Glob> command = new IsTouchSomeAxis();
        for (Glob g : globs) {
            if (command.execute(g).equals("true")) {
                list.add(g);
            }
        }
        return list;
    }

    @Override
    public List<Glob> findGlobWithSurfaceArea(double begin, double end) {
        log.info("try to find glob by surface area in range");
        List<Glob> list = new ArrayList<>();
        Command<Glob> command = new CalcSurfaceArea();
        for (Glob g : globs) {
            double result = Double.parseDouble(command.execute(g));
            if (result >= begin && result <= end) {
                list.add(g);
            }
        }
        return list;
    }

    @Override
    public List<Glob> findGlobWithSurfaceArea(double begin) {
        log.info("try to find glob by surface area more than value");
        List<Glob> list = new ArrayList<>();
        Command<Glob> command = new CalcSurfaceArea();
        for (Glob g : globs) {
            double result = Double.parseDouble(command.execute(g));
            if (result >= begin) {
                list.add(g);
            }
        }
        return list;
    }

    @Override
    public void sortGlobByX() {
        log.info("glob sort by X");
        globs.sort(new XSort());
    }

    @Override
    public void sortGlobByY() {
        log.info("glob sort by Y");
        globs.sort(new YSort());
    }

    @Override
    public void sortGlobByZ() {
        log.info("glob sort by Z");
        globs.sort(new ZSort());
    }

    @Override
    public void sortGLobByRadius() {
        log.info("glob sort by radius");
        globs.sort(new RadiusSort());
    }

    class XSort implements Comparator<Glob> {

        @Override
        public int compare(Glob o1, Glob o2) {
            Dot dot1 = o1.getDot();
            Dot dot2 = o2.getDot();

            return (int) (dot1.getX() - dot2.getX());
        }
    }

    class YSort implements Comparator<Glob> {

        @Override
        public int compare(Glob o1, Glob o2) {
            Dot dot1 = o1.getDot();
            Dot dot2 = o2.getDot();

            return (int) (dot1.getY() - dot2.getY());
        }
    }

    class ZSort implements Comparator<Glob> {

        @Override
        public int compare(Glob o1, Glob o2) {
            Dot dot1 = o1.getDot();
            Dot dot2 = o2.getDot();

            return (int) (dot1.getZ() - dot2.getZ());
        }
    }

    class RadiusSort implements Comparator<Glob> {

        @Override
        public int compare(Glob o1, Glob o2) {


            return (int) (o1.getRadius() - o2.getRadius());
        }
    }
}

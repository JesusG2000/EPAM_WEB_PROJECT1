package com.epam.examples.dao.impl;

import com.epam.examples.bean.Dot;
import com.epam.examples.bean.Glob;
import com.epam.examples.controller.Command;
import com.epam.examples.controller.Controller;
import com.epam.examples.dao.DaoException;
import com.epam.examples.dao.ChangeData;
import com.epam.examples.dao.FindData;
import com.epam.examples.dao.SortData;
import com.epam.examples.bean.dto.SectionCalcParameters;
import com.epam.examples.math.command.CalcCapacity;
import com.epam.examples.math.command.CalcSurfaceArea;
import com.epam.examples.math.command.CalcVolumeRatio;
import com.epam.examples.math.command.IsTouchSomeAxis;
import com.epam.examples.util.log.LogProvider;
import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.impl.FileDataProvider;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Action implements ChangeData, FindData , SortData {
    private List<Glob> globs;
    private List<SectionCalcParameters> sectionCalcParameters;
    private static Logger log = LogProvider.getLOGGER(Action.class);

    public Action() {
        try {
            FileData fileData = new FileData();
            DataProvider provider = new FileDataProvider();
            globs = fileData.getGlobData("data\\information", provider);
            sectionCalcParameters = fileData.getSectionCalcParametersData("data\\information", provider);
        } catch (DaoException e) {
            log.log(Level.WARNING,"Exception ",e);
            e.printStackTrace();
        }
    }

    @Override
    public List<Glob> getGlobs() {
        log.info("get glob list");
        return globs;
    }

    @Override
    public List<SectionCalcParameters> getSectionCalcParameters() {
        log.info("get sectionCalcParameters list");
        return sectionCalcParameters;
    }

    @Override
    public void addGlob(Glob glob) {
        log.info("add in glob list");
        globs.add(glob);
    }

    @Override
    public void addSectionCalcParameters(SectionCalcParameters parameters) {
        log.info("add in sectionCalcParameters list");
        sectionCalcParameters.add(parameters);
    }

    @Override
    public void removeGlob(int index) {
        log.info("remove glob");
        globs.remove(index);
    }

    @Override
    public void removeSectionCalcParameters(int index) {
        log.info("remove sectionCalcParameters");
        sectionCalcParameters.remove(index);
    }

    @Override
    public void changeGlob(int index, Glob glob) {
        log.info("change glob");
        globs.set(index, glob);
    }

    @Override
    public void changeSectionCalcParameters(int index, SectionCalcParameters parameters) {
        log.info("change sectionCalcParameters");
        sectionCalcParameters.set(index, parameters);
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
    public List<SectionCalcParameters> findSectionCalcParametersWithAxis(String axis) {
        log.info("try to find SectionCalcParameters by axis");
        List<SectionCalcParameters> list = new ArrayList<>();
        for (SectionCalcParameters s : sectionCalcParameters) {
            if (s.getAxis().equals(axis)) {
                list.add(s);
            }
        }
        return list;
    }

    @Override
    public List<SectionCalcParameters> findSectionCalcParametersWithVolumeRatio(double begin, double end) {
        log.info("try to find SectionCalcParametersW by volume ratio in range");
        List<SectionCalcParameters> list = new ArrayList<>();
        Command<SectionCalcParameters> command = new CalcVolumeRatio();
        for (SectionCalcParameters s : sectionCalcParameters) {
            double result = Double.parseDouble(command.execute(s));
            if (result >= begin && result <= end) {
                list.add(s);
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

    @Override
    public void sortSectionCalcParametersByAxis() {
        log.info("SectionCalcParameters sort by axis");
        sectionCalcParameters.sort(new AxisSort());
    }

    class XSort implements Comparator<Glob> {

        @Override
        public int compare(Glob o1, Glob o2) {
            Dot dot1 = o1.getDot();
            Dot dot2 = o2.getDot();

            return (int)(dot1.getX()-dot2.getX());
        }
    }
    class YSort implements Comparator<Glob> {

        @Override
        public int compare(Glob o1, Glob o2) {
            Dot dot1 = o1.getDot();
            Dot dot2 = o2.getDot();

            return (int)(dot1.getY()-dot2.getY());
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
        class AxisSort implements Comparator<SectionCalcParameters>{

            @Override
            public int compare(SectionCalcParameters o1, SectionCalcParameters o2) {
                return o1.getAxis().compareTo(o2.getAxis());
            }
        }
    }



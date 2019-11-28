package com.epam.examples.dao.impl;

import com.epam.examples.bean.dto.impl.SectionCalcParameters;
import com.epam.examples.controller.Command;
import com.epam.examples.dao.DaoException;
import com.epam.examples.dao.SectionCalcParametersDao;
import com.epam.examples.math_command.CalcVolumeRatio;
import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.impl.FileDataProvider;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class SectionCalcParametersDaoImpl implements SectionCalcParametersDao {
    private static Logger log = Logger.getLogger(SectionCalcParametersDaoImpl.class);
    private List<SectionCalcParameters> sectionCalcParameters;

    public SectionCalcParametersDaoImpl() {
        try {
            FileData fileData = new FileData();
            DataProvider provider = new FileDataProvider("data\\information");
            sectionCalcParameters = fileData.getSectionCalcParametersData(provider);
        } catch (DaoException e) {
            log.error("Exception ", e);
            e.printStackTrace();
        }
    }


    @Override
    public List<SectionCalcParameters> getSectionCalcParameters() {
        log.info("get sectionCalcParameters list");
        return sectionCalcParameters;
    }


    @Override
    public void addSectionCalcParameters(SectionCalcParameters parameters) {
        log.info("add in sectionCalcParameters list");
        sectionCalcParameters.add(parameters);
    }


    @Override
    public void removeSectionCalcParameters(int index) {
        log.info("remove sectionCalcParameters");
        sectionCalcParameters.remove(index);
    }


    @Override
    public void changeSectionCalcParameters(int index, SectionCalcParameters parameters) {
        log.info("change sectionCalcParameters");
        sectionCalcParameters.set(index, parameters);
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
    public void sortSectionCalcParametersByAxis() {
        log.info("SectionCalcParameters sort by axis");
        sectionCalcParameters.sort(new AxisSort());
    }


    class AxisSort implements Comparator<SectionCalcParameters> {

        @Override
        public int compare(SectionCalcParameters o1, SectionCalcParameters o2) {
            return o1.getAxis().compareTo(o2.getAxis());
        }
    }
}


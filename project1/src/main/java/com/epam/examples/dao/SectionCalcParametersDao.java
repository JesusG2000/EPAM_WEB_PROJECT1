package com.epam.examples.dao;

import com.epam.examples.bean.dto.impl.SectionCalcParameters;

import java.util.List;

public interface SectionCalcParametersDao {

    List<SectionCalcParameters> getSectionCalcParameters();

    void addSectionCalcParameters(SectionCalcParameters sectionCalcParameters) throws DaoException;

    void removeSectionCalcParameters(int index) throws DaoException;

    void changeSectionCalcParameters(int index, SectionCalcParameters sectionCalcParameters) throws DaoException;

    List<SectionCalcParameters> findSectionCalcParametersWithAxis(String axis);

    List<SectionCalcParameters> findSectionCalcParametersWithVolumeRatio(double begin, double end);

    void sortSectionCalcParametersByAxis();
}

package com.epam.examples.dao;

import com.epam.examples.bean.Glob;
import com.epam.examples.bean.dto.SectionCalcParameters;

import java.util.List;

public interface ChangeData {

     List<Glob> getGlobs();

     List<SectionCalcParameters> getSectionCalcParameters();

     void addGlob(Glob glob) throws DaoException;

     void addSectionCalcParameters(SectionCalcParameters sectionCalcParameters)throws DaoException;

     void removeGlob(int index)throws DaoException;

     void removeSectionCalcParameters(int index)throws DaoException;

     void changeGlob(int index, Glob glob)throws DaoException;

     void changeSectionCalcParameters(int index, SectionCalcParameters sectionCalcParameters)throws DaoException;
}

package com.epam.examples.dao;

import com.epam.examples.bean.Glob;
import com.epam.examples.bean.dto.SectionCalcParameters;

import java.util.List;

public interface FindData {
    List<Glob> findGlobsWithRadius(double rad);

    List<Glob> findGlobWithCapacity(double begin, double end);

    List<Glob> findGlobWithCapacity(double begin);

    List<Glob> findGlobTouchAxis();

    List<Glob> findGlobWithSurfaceArea(double begin, double end);

    List<Glob> findGlobWithSurfaceArea(double begin);

    List<SectionCalcParameters> findSectionCalcParametersWithAxis(String axis);

    List<SectionCalcParameters> findSectionCalcParametersWithVolumeRatio(double begin, double end);


}

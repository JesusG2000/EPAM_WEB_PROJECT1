package com.epam.examples.dao;

import com.epam.examples.bean.Glob;

import java.util.List;

public interface GlobDao {
    List<Glob> getGlobs();

    void addGlob(Glob glob) throws DaoException;

    void removeGlob(int index) throws DaoException;

    void changeGlob(int index, Glob glob) throws DaoException;

    void sortGlobByX();

    void sortGlobByY();

    void sortGlobByZ();

    void sortGLobByRadius();

    List<Glob> findGlobsWithRadius(double rad);

    List<Glob> findGlobWithCapacity(double begin, double end);

    List<Glob> findGlobWithCapacity(double begin);

    List<Glob> findGlobTouchAxis();

    List<Glob> findGlobWithSurfaceArea(double begin, double end);

    List<Glob> findGlobWithSurfaceArea(double begin);
}

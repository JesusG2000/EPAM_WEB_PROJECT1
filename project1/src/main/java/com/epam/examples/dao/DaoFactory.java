package com.epam.examples.dao;

import com.epam.examples.dao.impl.Action;

public final class DaoFactory {
    private static final ChangeData changeData = new Action();
    private static final FindData findData = new Action();
    private static final SortData sortData = new Action();

    private DaoFactory() {
    }

    public static ChangeData getChangeData() {
        return changeData;
    }

    public static FindData getFindData() {
        return findData;
    }

    public static SortData getSortData() {
        return sortData;
    }
}

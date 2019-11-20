package com.epam.examples.util.provider;

import com.epam.examples.util.provider.impl.FileDataProvider;

public final class DataProviderFactory {
    private static DataProvider provider = new FileDataProvider();

    private DataProviderFactory() {
    }

    public static DataProvider getProvider() {
        return provider;
    }
}

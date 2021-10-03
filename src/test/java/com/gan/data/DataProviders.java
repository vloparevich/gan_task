package com.gan.data;

import org.testng.annotations.DataProvider;

import java.io.IOException;

/**
 * @author vloparevich
 */
public class DataProviders {

    @DataProvider(name = "ports-name")
    public Object[][] portsProvider() throws IOException {
        return new Object[0][0];
    }
}
package com.example.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static com.example.testdata.TestsData.TEST_PROPERTIES;

public class ReadPropertiesUtilTest {

    @Test(expected = Exception.class)
    public void notFoundProperties() throws Exception {
        try {
            Properties properties = ReadPropertiesUtil.getProperties("a:\\notfound.txt", "Properties not found");
        } catch (Exception e) {
            Assert.assertEquals("Properties not found", e.getMessage());
            throw e;
        }
    }

    @Test
    public void foundProperties() throws Exception {
        String url = TEST_PROPERTIES;
        Properties properties = ReadPropertiesUtil.getProperties(TEST_PROPERTIES, "Properties not found");
        Assert.assertEquals("1234", properties.getProperty("testproperty1"));
        Assert.assertEquals("Property2", properties.getProperty("testproperty2"));
    }
}
package com.example.utils;
import org.junit.Assert;
import org.junit.Test;

import static com.example.testdata.TestsData.*;

public class FormatTextUtilTest {

    @Test
    public void cutTextLines() {
        Assert.assertArrayEquals(cutList20, FormatTextUtil.cutTextLines(getList(veryLongText, longtext), 20).toArray());
    }

    @Test
    public void cutString() {
        Assert.assertEquals(17, FormatTextUtil.cutString(text, 10).size());
    }
}
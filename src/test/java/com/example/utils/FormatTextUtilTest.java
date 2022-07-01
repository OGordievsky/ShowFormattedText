package com.example.utils;
import com.example.testdata.TestsData;
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

    @Test
    public void formatLines() {
        Assert.assertArrayEquals(formatList12, FormatTextUtil.formatLines(TestsData.getList(TestsData.text), 12).toArray());
    }
}
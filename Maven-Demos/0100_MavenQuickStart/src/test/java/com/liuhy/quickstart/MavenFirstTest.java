package com.liuhy.quickstart;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple MavenFirst.
 */
public class MavenFirstTest
{
    @Test
    public void testSayHello()
    {
        MavenFirst first = new MavenFirst();
        Assert.assertEquals("hello maven", first.sayHello("maven"));
    }
}

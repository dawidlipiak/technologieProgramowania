package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestElement {
    @Test
    public void testPrizeValueOfArticle(){
        Element element = new Element("mleko", 2, 5.89, 23);
        assertEquals((Double)5.89,element.getArticlePrize());
    }
    @Test
    public void  testNameOfArticle(){
        Element element = new Element("mleko", 2, 5.89, 23);
        assertEquals("mleko",element.getArticleName());
    }
}

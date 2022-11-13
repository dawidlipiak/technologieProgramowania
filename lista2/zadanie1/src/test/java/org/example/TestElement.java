package org.example;

import org.junit.Test;

public class TestElement {
    @Test
    public void showElementValues(){
        Element element = new Element("mleko", 2, 3.50, 23);
        System.out.println(element.getArticleName());
        System.out.println(element.amount);
        System.out.println(element.getArticlePrize() + " zl");
        System.out.println(element.vat + "%");
    }
}

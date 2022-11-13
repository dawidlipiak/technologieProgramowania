package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * Funckja glowna main.
     * @param args argumenty wejscia
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Element> elements = new ArrayList<Element>();

        System.out.println("Witamy w systemie wystawiania faktur");

        Salesman salesman = Salesman.createSalesan();
        Client client = Client.createClient(scan);

        while (Element.addElement(elements, scan));

        Faktura faktura = new Faktura(salesman, client, elements);
        faktura.showFaktura();
    }

}

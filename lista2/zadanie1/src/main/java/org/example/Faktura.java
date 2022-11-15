package org.example;

import java.time.LocalDate;
import java.util.List;

/**
 * Klasa faktury do ich tworzenia.
 */
public class Faktura {
    Salesman salesman;
    Client client;
    List<Element> elements;



    /**
     * Konstruktor faktury posiadajacy niezbedne informacje do jej wystawienia.
     * @param salesman dane osoby wystawiajacej fakture
     * @param client dane klienta na ktorego faktura jest wystawiana
     * @param elements elementy faktury w ktorych jest towar ilosc cen i vat
     */
    public Faktura(final Salesman salesman, final Client client, final List<Element> elements) {
        this.salesman = salesman;
        this.client = client;
        this.elements = elements;
    }



    /**
     * Metoda odpowiedzialna za wyswietlanie faktury w terminalu.
     */
    void showFaktura() {
        System.out.println("\n\n");
        System.out.println("                            FAKTURA                               " + LocalDate.now());
        for (int i = 0; i < 100; i++) { System.out.print("-"); }
        System.out.println();

        salesman.showSalesman(salesman);
        client.showClient(client);

        for (int i = 0; i < 100; i++) { System.out.print("-"); }

        System.out.println("\nLp. | Nazwa towaru | Ilosc | Cena netto | wartosc netto | VAT % | Kwota VAT | Wartosc brutto" );
        double totalVat = Element.showElements(elements);
        for (int i = 0; i < 100; i++) { System.out.print("-"); }
        Element.showTotal(totalVat,elements);
        for (int i = 0; i < 100; i++) { System.out.print("-"); }
    }


}

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

    Faktura() {}

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
     * Metoda odpowiedzialna za policzenie calkowitej sumy netto produktow.
     * @return zwraca sume netto kwot produktow
     */
    public double countTotalPrize() {
        double sum = 0;

        for (int i = 0; i < elements.size(); i++) {
            sum += elements.get(i).getArticlePrize() * elements.get(i).amount;
        }
        return Math.round(sum * 100.0) / 100.0;
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
        double totalVat = showElements();
        for (int i = 0; i < 100; i++) { System.out.print("-"); }
        showTotal(totalVat);
        for (int i = 0; i < 100; i++) { System.out.print("-"); }
    }

    /**
     * Metoda wyswietla elementy faktury.
     * @return zliczona wartosc kwoty vat towarow
     */
    private double showElements() {
        double nettoPrize, vatPrize, totalVat = 0;
        for (int i = 0; i < elements.size(); i++){
            nettoPrize = Math.round(elements.get(i).getArticlePrize()*(double) elements.get(i).amount*100.0)/100.0;
            vatPrize = Math.round(nettoPrize*(double)elements.get(i).vat)/100.0;
            totalVat += vatPrize;

            System.out.println((i+1) + " | " + elements.get(i).getArticleName() + " | " + elements.get(i).amount + " szt. | " +
                    Math.round(elements.get(i).getArticlePrize()*100.0)/100.0 + " zl | " + nettoPrize + " zl | " + elements.get(i).vat + "% | " +
                    vatPrize + " zl | " + Math.round((nettoPrize+vatPrize)*100)/100.0 + " zl");
        }
        return totalVat;
    }

    /**
     * Metoda wyswietla calkowita sume kwot netto, vatu i brutto artykulow.
     * @param totalVat wartosc sumy kwoty podatku vat
     */
    private void showTotal (double totalVat) {
        double totalNetto = countTotalPrize();
        totalVat = (Math.round(totalVat*100.0))/100.0;
        System.out.println("\nRAZEM: " + totalNetto + " zl netto");
        System.out.println("       " + totalVat + " zl kwoty vat" );
        System.out.println("       " + (totalNetto+totalVat) + " zl brutto");
    }
}

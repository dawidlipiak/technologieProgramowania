package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * Klasa elementu faktury.
 */
public class Element {
    private Article towar;
    int amount, vat;


    /**
     * Konstruktor elementu faktury z niezbednymi informacjami o towarach.
     *
     * @param article nazwa towaru
     * @param amount  ilosc towaru
     * @param prize   cena netto towaru
     * @param vat     podatek vat w % towaru
     */
    Element(final String article, final int amount, final double prize, final int vat) {
        super();
        this.towar = new Article(article, prize);
        this.amount = amount;
        this.vat = vat;
    }

    /**
     * Metoda dodajaca nowy elemnt faktury.
     *
     * @param elements lista elementow
     * @param scanner  system in
     * @return czy kontynuowac dalej
     */
    public static boolean addElement(final List<Element> elements, final Scanner scanner) {
        String product;
        String answer;
        int amount = 0;
        double prize = 0;
        int vat = 0;

        System.out.print("Czy chcesz dodac nowy artykul? [y/n]: ");
        answer = scanner.nextLine();

        if (answer.equals("y")) {
            System.out.print("Podaj artykul: ");
            product = scanner.nextLine();

            System.out.print("Podaj ilosc tego artykulu: ");
            try {
                amount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Bledna liczba");
                System.exit(0);
            }

            System.out.print("Podaj cene netto tego artykulu: ");
            try {
                prize = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Bledna liczba");
                System.exit(0);
            }
            System.out.print("Podaj w % podatek VAT dla tego artykulu: ");
            try {
                vat = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Bledna liczba");
                System.exit(0);
            }

            Element element = new Element(product, amount, prize, vat);
            elements.add(element);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metoda zwracajaca nazwe towaru.
     *
     * @return nazwa towaru
     */
    public String getArticleName() {
        return towar.article;
    }

    /**
     * Metoda zwracajaca cene netto towaru.
     *
     * @return cena netto towaru
     */
    public Double getArticlePrize() {
        return towar.prize;
    }

    /**
     * Metoda odpowiedzialna za policzenie calkowitej sumy netto produktow.
     * @return zwraca sume netto kwot produktow
     */
    public static double countTotalPrize(List<Element> elements) {
        double sum = 0;

        for (int i = 0; i < elements.size(); i++) {
            sum += elements.get(i).getArticlePrize() * elements.get(i).amount;
        }
        return Math.round(sum * 100.0) / 100.0;
    }
    /**
     * Metoda wyswietla calkowita sume kwot netto, vatu i brutto artykulow.
     * @param totalVat wartosc sumy kwoty podatku vat
     */
    public static void showTotal(double totalVat, List<Element> elements) {
        double totalNetto = countTotalPrize(elements);
        totalVat = (Math.round(totalVat*100.0))/100.0;
        System.out.println("\nRAZEM: " + totalNetto + " zl netto");
        System.out.println("       " + totalVat + " zl kwoty vat" );
        System.out.println("       " + (totalNetto+totalVat) + " zl brutto");
    }

    /**
     * Metoda wyswietla elementy faktury.
     * @return zliczona wartosc kwoty vat towarow
     */
    public static double showElements(List<Element> elements) {
        double nettoPrize, vatPrize, totalVat = 0;
        for (int i = 0; i < elements.size(); i++){
            nettoPrize = Math.round(elements.get(i).getArticlePrize()*(double) elements.get(i).amount*100.0)/100.0;
            vatPrize = Math.round(nettoPrize*(double)elements.get(i).vat)/100.0;
            totalVat += vatPrize;

            System.out.println((i+1) + " | " + elements.get(i).getArticleName() + " | " + elements.get(i).amount + " szt. | " +
                    Math.round(elements.get(i).getArticlePrize()*100.0)/100.0 + " zl | " + nettoPrize + " zl | " + elements.get(i).vat + "% | " +
                    vatPrize + " zl | " + Math.round((nettoPrize+vatPrize)*100.0)/100.0 + " zl");
        }
        return totalVat;
    }
}

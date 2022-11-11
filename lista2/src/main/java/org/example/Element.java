package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * Klasa elementu faktury.
 */
public class Element extends Faktura {
    /** Obiekt towar. */
    private Article towar;
    /** ilosc towaru. */
    int amount;
    /** podatek vat towaru. */
    int vat;

    Element() {}

    /**
     * Konstruktor elementu faktury z niezbednymi informacjami o towarach.
     * @param article nazwa towaru
     * @param amount ilosc towaru
     * @param prize cena netto towaru
     * @param vat podatek vat w % towaru
     */
    Element(final String article, final int amount, final double prize, final int vat) {
        super();
        this.towar = new Article(article, prize);
        this.amount = amount;
        this.vat = vat;
    }

    /**
     * Metoda dodajaca nowy elemnt faktury.
     * @param elements lista elementow
     * @param scanner system in
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
        }
        else {
            return false;
        }
    }

    /**
     * Metoda zwracajaca nazwe towaru.
     * @return nazwa towaru
     */
    public String getArticleName() {
        return towar.article;
    }

    /**
     * Metoda zwracajaca cene netto towaru.
     * @return cena netto towaru
     */
    public Double getArticlePrize() {
        return towar.prize;
    }
}

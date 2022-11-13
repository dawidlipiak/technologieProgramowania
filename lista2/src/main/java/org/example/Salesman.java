package org.example;

/**
 * Klasa sprzedawcy.
 */
public class Salesman extends Faktura {
    Salesman salesman;
    String firm, nip, street, postcode, city;

    /**
     * Konstruktor obiektu sprzedawcy posiadajacy niezbedne informacje o nim.
     * @param firm firma sprzedawcy
     * @param nip nip firmy
     * @param street ulica na ktorej firma sie znajduje
     * @param postcode kod pocztowy miejsca firmy
     * @param city miasto w jakim jest firma
     */
    Salesman (final String firm, final String nip, final String street, final String postcode, final String city) {
        this.firm = firm;
        this.nip = nip;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
    }

    /**
     * Metoda tworzaca sprzedawce wraz z danymi.
     * @return zwraca sprzedawce
     */
    public static Salesman createSalesan () {
        return new Salesman("ABC FIRMA",  "123-456-78-89", "Prusa 13", "52-200", "Wroclaw");
    }

    /**
     * Wyswietla dane sprzedawcy w fakturze
     * @param salesman Sprzedawca w fakturze
     */
    public void showSalesman (final Salesman salesman ) {
        System.out.println("Sprzedawca" +"\n-----------------------------");
        System.out.println( salesman.firm + "\nNIP: " + salesman.nip +"\n" + salesman.street + "\n" + salesman.postcode +" "+ salesman.city +"\n" );
    }

    /**
     * Metoda dodajaca utworzonego sprzedawce do bazy danych sprzedawcow
     * @param salesman sprzedawca dodawany do bazy danych
     */
    public void addToSalesmansDatabase (Salesman salesman){
        /**
         * Mozemy tu przez salesman.firm, salesman.nip ... salesman.city dostac sie do
         * kazdej wartosci ktora w naszej bazie danych sprzedawcow bylaby zapisana do odpowiedniej kolumny
         */
    }
}

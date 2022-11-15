package org.example;

import java.util.Scanner;

/**
 * Klasa klient.
 */
public class Client{
    String firm, nip, street, postcode, city;

    /**
     * Konstruktor klienta posiadajacy niezbedne informacje dotyczace klienta.
     * @param firm nazwa firmy klienta
     * @param nip numer nip firmy
     * @param street ulica na ktorej firma sie znajduje
     * @param postcode kod pocztowy miejsca firmy
     * @param city miasto w jakim jest firma
     */
    Client (final String firm, final String nip, final String street, final String postcode, final String city ) {
        this.firm = firm;
        this.nip = nip;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
    }

    /**
     * Metoda tworzaca klienta.
     * @param scanner
     * @return klient z danymi
     */
    public static Client createClient(final Scanner scanner) {
        System.out.print("Prosze podac dodac dane klienta:\n"
                + "Nazwa firmy: ");
        String firm = scanner.nextLine();

        System.out.print("NIP: ");
        String nip = scanner.nextLine();

        System.out.print("Ulica: ");
        String street = scanner.nextLine();

        System.out.print("Kod pocztowy: ");
        String postcode = scanner.nextLine();

        System.out.print("Miasto: ");
        String city = scanner.nextLine();

        return new Client(firm, nip, street, postcode, city);
    }

    /**
     * Wyswietla dane klienta w fakturze.
     * @param client dane klienta do faktury
     */
    public void showClient (final Client client) {
        System.out.println("-----------------------------\n" + "Nabywca" + "\n-----------------------------");
        System.out.println(client.firm + "\nNIP: " + client.nip + "\n" + client.street + "\n" + client.postcode + " " + client.city + "\n");
    }


}

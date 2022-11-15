package org.example;

import java.util.List;

public class DataBaseAdapter {
    /**
     * Metoda obslugujaca dodanie danych uzyskanych z faktury do poszczegolnych baz danych
     * @param client klient ktory ma zostac dodany do bazy danych klientow
     * @param salesman sprzedawca ktory ma zostac dodany do bazy danych sprzedawcow
     * @param elements towary z pooszczegolnych elementow ktore maja zostac dodane do bazy danych towarow
     */
    public static void addAllToDataBase(Client client, Salesman salesman, List<Element> elements) {
        ClientDataBase.addToClientsDatabase(client);
        SalesmanDataBase.addToSalesmansDatabase(salesman);
        ElementDataBase.addToElementDataBase(elements);
    }
}

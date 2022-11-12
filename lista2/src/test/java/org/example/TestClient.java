package org.example;

import org.junit.Test;

import java.util.Scanner;

public class TestClient {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void testShowClient(){
        Client client = new Client("ABC FIRMA","123-123-23-34", "Sezamkowa 12", "51-319", "Wroclaw");
        client.showClient(client);
    }
}

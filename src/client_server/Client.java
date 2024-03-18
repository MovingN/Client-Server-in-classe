/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_server;

import java.io.IOException;

/**
 *
 * @author utente
 */
public class Client {

    public static void main(String[] args) throws IOException {
        ClientCl client = new ClientCl("127.0.0.1", 1349);
        client.scrivi();
        client.leggi();
        client.chiudi();

    }
}

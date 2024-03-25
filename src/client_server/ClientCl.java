/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Studenti
 */
public class ClientCl extends Thread {

    String host;
    int port;
    private String colore;
    Socket clientSocket;
    String ricevuto;
    String invio;
    DataInputStream in;
    DataOutputStream out;
    DataOutputStream outServer;
    BufferedReader inServer;
    Scanner scan = new Scanner(System.in);

    public ClientCl(String host, int port) {
        this.host = host;
        this.port = port;
        this.colore = colore;
        try {
            this.clientSocket = new Socket(host, port);
            System.out.println("Client connesso al server \n");
        } catch (IOException ex) {
            System.err.println("errore con l'inizializzazione del socket client");
        }
    }

    @Override
    public void run() {
        scrivi();
        leggi();
        chiudi();
    }

    public Socket connetti() {
        try {
            Socket clientSocket = new Socket(host, port);
            inServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new DataOutputStream(clientSocket.getOutputStream());
        } catch (UnknownHostException ex) {
            System.err.println("Host sconosciuto");
        } catch (Exception ex) {
            System.err.println("Errore in connetti (Client)");
            System.exit(1);
        }
        return clientSocket;
    }

    public void scrivi() {
        try {
            inServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new DataOutputStream(clientSocket.getOutputStream());
            System.out.println("Inserisci un messaggio per il server");
            invio = scan.nextLine();
            System.out.println("Invio ...");
            out.writeBytes(invio);
            ricevuto = inServer.readLine();
            System.out.println("Risposta del server=" + ricevuto);
        } catch (IOException ex) {
            System.err.println("Problema in scrivi(CLIENT)");
        }

    }

    public void leggi() {
        try {
            ricevuto = inServer.readLine();
            System.out.println("(CLIENT)Ho ricevuto il seguente messaggio" + ricevuto);
        } catch (IOException ex) {
            System.err.println("Problema in leggi(CLIENT)");
        }
    }

    public void chiudi() {
        System.out.println("Chiusura della connessione con il server \n");
        try {
            clientSocket.close();
        } catch (IOException ex) {
            System.err.println("Problemi di chiusura del socket client");
        }
    }
}

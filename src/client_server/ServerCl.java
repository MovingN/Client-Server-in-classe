/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Studenti
 */
public class ServerCl{

    int porta;
    ServerSocket serverSocket;
    Socket clientSocket;
    BufferedReader inClient;
    DataOutputStream outClient;
    String ricevuto;
    String invia;
    Scanner scan = new Scanner(System.in);

    public ServerCl(int porta) {
        this.porta = porta;
    }

    public Socket attendi() {

        try {
            while (true) {
            inClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outClient = new DataOutputStream(clientSocket.getOutputStream());
            serverSocket = new ServerSocket(porta);
            System.out.println("Server in ascolto");
            clientSocket = serverSocket.accept();
            System.out.println("La connessione e' avvenuta");
            }
        } catch (BindException e) {
            System.err.println("Porta gia in uso");
        } catch (IOException ex) {
            System.err.println("Problema in attendi");
        }
        return clientSocket;
    }

    public void scrivi() {
        try {
            System.out.println("Metodo scrivi");
            invia = ricevuto + "Il server ha visionato il messaggio";
            System.out.println("Modifica in invio");
            outClient.writeBytes(invia);
        } catch (IOException ex) {
            System.err.println("Problema in scrivi");
        }

    }

    public void leggi() {
        try {
            ricevuto = inClient.readLine();
            System.out.println("(SERVER)Ho ricevuto il seguente messaggio" + ricevuto);
        } catch (IOException ex) {
            System.err.println("Problema in leggi");
        }
    }

    public void chiudi() {
        try {
            inClient.close();
            outClient.close();
        } catch (IOException ex) {
            System.err.println("Problema in chiudi");      
        } 
    }

    public void termina() {
        try {
            serverSocket.close();
            System.out.println("Errore in chiusura");
        } catch (IOException ex) {
            System.err.println("Errore in chiusura");
        }
    }
}

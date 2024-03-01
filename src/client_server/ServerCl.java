/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studenti
 */
public class ServerCl {

    int porta;
    ServerSocket serverSocket;
    Socket clientSocket;

    public ServerCl(int porta) {
        this.porta = porta;
    }

    public Socket attendi() {
        socket = null;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Server in ascolto");
            socket = serverSocket.accept();
            System.out.println("La connessione e' avvenuta");

        } catch (BindException e) {
            System.err.println("Porta gia in uso");
        } catch (IOException ex) {
            System.err.println("Problema in attendi");
        }
        return socket;
    }

    public void scrivi() {

    }

    public void leggi() {

    }

    public void chiudi() {

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

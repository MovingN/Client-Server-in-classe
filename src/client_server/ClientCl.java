/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_server;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Studenti
 */
public class ClientCl {
    String host;
    int port;
    private String colore;
    Socket clientSocket;
    Scanner scan = new Scanner(System.in);;
    public ClientCl(String host, int port) {
        this.host=host;
        this.port=port;
        this.colore=colore;
        try {
            this.clientSocket = new Socket(host, port);
            System.out.println("Client connesso al server \n");
        } catch (IOException ex) {
            System.err.println("errore con l'inizializzazione del socket client");
        }
    }
    
    public void connetti(){
        
    }
    
    public void scrivi(){
        try {
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
             String messaggioInviato = scan.nextLine();
        outputStream.write(messaggioInviato.getBytes());
        while (true) {
            byte[] messaggioRicevuto = new byte[1024];
            int bytesLetti = inputStream.read(messaggioRicevuto);
            String messaggio = new String(messaggioRicevuto, 0, bytesLetti);
            System.out.println("Messaggio ricevuto dal server: " + messaggio + "\n");
            messaggio="FINE";
            messaggioInviato = "Risposta dal client: " + messaggio + "\n";
            outputStream.write(messaggioInviato.getBytes());
        }
        }catch (IOException ex) {
           System.err.println("Errori con Input ed Output stream");
        }
      
        }
        public void leggi(){
            
            
        }
        
        public void chiudi(){
            System.out.println("Chiusura della connessione con il server \n");
        try {
            clientSocket.close();
        } catch (IOException ex) {
            System.err.println("Problemi di chiusura del socket client");
        }
        }
}



package client_server;

/**
 *
 * @author utente
 */
public class Server extends Thread{

    public static void main(String[] args)  {
        ServerCl server=new ServerCl(1349);
        server.attendi();
        server.leggi();
        server.scrivi();
        server.chiudi();
}
}
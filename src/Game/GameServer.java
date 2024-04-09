/**Server client class
 * Receives and sends Strings
 *
 */
package Game;

import Client.GameClient;

import java.io.*;
import java.net.*;
import java.util.concurrent.Semaphore;

public class GameServer {
    private ServerSocket serverSocket;
    public static Semaphore semaphore;

    GameClientHandler[] players;

    /**Creates server with a maximum number of allowed active clients at once
     *
     * @param maxClients    max active clients allowed at once
     */
    GameServer(int maxClients){
        semaphore = new Semaphore(maxClients);   //Creates a server with a limit of maxClients active clients at a time
        players = new GameClientHandler[maxClients];
    }

    /**Starts the server on given port
     *
     * @param port  Port to recieve data from */
    public void start(int port){
        try {
            serverSocket = new ServerSocket(port);
            while(true){
                new GameClientHandler(serverSocket.accept()).start();
                System.out.println(semaphore.availablePermits());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    /**Ends the connection to a client
     * (Specifically closes the socket the client connected to)
     *
     */
    public void stop() {
        try {
            serverSocket.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    /**Starts server on  port 727, with 5 clients max
     *
     * @param args
     */
    public static void main(String[] args) {
        GameServer server = new GameServer(5);
        server.start(727);
    }

}

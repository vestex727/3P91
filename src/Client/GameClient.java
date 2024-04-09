/**A client class that creates client objects that send encrypted files to a server
 *
 * @author Steve Mastrokalos
 */
package Client;

import Game.GameView;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {
    private static DataOutputStream msgOutputStream = null;
    private static DataInputStream msgInputStream = null;

    /**Joins game on port 727 of the localhost
     *
     */
    GameClient(){this("localhost", 727);}

    /**Runs a client that will send a file to the server
     *
     * @param host
     * @param port
     */
    GameClient(String host, int port){
        try (Socket socket = new Socket(host, port)) {
            msgInputStream = new DataInputStream(socket.getInputStream());
            msgOutputStream = new DataOutputStream(socket.getOutputStream());

            while(true){
                if(msgInputStream.read() != -1){
                    byte[] temp = new byte[msgInputStream.available()];
                    msgInputStream.read(temp);
                    GameView.printGameMessage(new String(temp));

                    Scanner response = new Scanner(System.in); //System.in is a standard input stream
                    String out = response.nextLine();
                    if(out == "ESC") break;
                    sendString(out);   //reads and sends string to server
                }
            }

            msgInputStream.close();
            msgOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**Sends strings to the server to process
     *
     * @param msg  message to send to the Server
     * @throws Exception        */
    private static void sendString(String msg) throws Exception {
        byte[] toSend = msg.getBytes();

        msgOutputStream.write(toSend, 0, toSend.length);
        msgOutputStream.flush();
    }


}


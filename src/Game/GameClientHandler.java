/**client handler class for server
 * Can handle multiple clients at once through multithreading
 *
 * @author Steve Mastrokalos 7276900     */
package Game;

import java.io.*;
import java.net.Socket;

/**Creates a multithreaded client handler
 *Allows server to deal with multiple clients at once
 *
 */
public class GameClientHandler extends Thread {
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;

    /**Runs the thread when sephamore is free
     *
     * @param socket
     */
    public GameClientHandler(Socket socket) {
        while(!GameServer.semaphore.tryAcquire()){}
        this.clientSocket = socket;
        GameEngine.view.players[1] = this;
    }

    /**Runs the thread
     * Recieves the files from the clients
     *
     */
    public void run(){
        try {
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(clientSocket.getInputStream());

            while(true){if(false) break;}

            clientSocket.close();

            in.close ();
            out.close ();
            GameServer.semaphore.release();

        } catch (IOException e) {}
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**Sends strings to the client
     *
     * @param msg  message to send to the client
     * @throws Exception        */
    public String sendMsg(String msg) throws Exception{
        byte[] toSend = msg.getBytes();

        out.write(toSend, 0, toSend.length);
        out.flush();

        return msg;
    }

    /**Receives the strings from client
     *
     * @throws Exception
     */
    public String receiveMsg() throws Exception {

        byte[] temp = new byte[in.available()];
        in.read(temp);

        return new String(temp);
    }
}

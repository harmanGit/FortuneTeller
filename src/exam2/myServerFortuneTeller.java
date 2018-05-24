/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 * Server lets multiply clients to connect and get there fortunes.
 *
 * @author hsd77849
 */
public class myServerFortuneTeller {

    private static ServerSocket ss;
    private static Socket client;
    private static int r;

    public static void main(String[] args) {
        try {
            ss = new ServerSocket(3568);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        while (true) {
            System.out.println("While");
            try {

                client = ss.accept();
                System.out.println("Connect");
                // Random number Generater
               ///  Random rn = new Random();
                // random number used to output random fortunes
                // int r = rn.nextInt(4);
                /// int r = rn.nextInt(4);
                System.out.println("RRR: " + r);
                //Creating a thread, and then running
                // Each thread is its own client
                clientThreadFT ft = new clientThreadFT();
                Thread t = new Thread(ft);
                t.start();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Thread recieves and sends the message back to the user that asked for the
     * fortunes.
     */
    private static class clientThreadFT implements Runnable {

        private String message = "";
        private PrintWriter out;
        private Scanner in;

        // Constructor
        clientThreadFT() {
            try {
                out = new PrintWriter(client.getOutputStream(), true);
                in = new Scanner(client.getInputStream());

                System.out.println(message + " FROM CLIENT");
            } catch (IOException ex) {
//                Logger.getLogger(myServerFortuneTeller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            while (true) {
                Random rn = new Random(); //    THIS IS AFTER exam - BUG FIXED
                int r = rn.nextInt(3);
                System.out.println("RRR: " + r);
                message = in.nextLine();
                System.out.println("Thread is running");

                // If the message rescieved is Today thed
                if (message.equals("Today")) {
                    System.out.println("FIRST 1");
                    if (r == 0) {
                        out.println("A friend us near");
                    }
                    if (r == 1) {
                        out.println("Expect a call");
                    }
                    if (r == 2) {
                        out.print("Some misses you");
                    }
                } else if (message.equals("Future")) { // if its future then
                    System.out.println("FIRST 1");
                    if (r == 0) {
                        out.println("Wealth awaits - if you desire it");
                    }
                    if (r == 1) {
                        out.println("Climb the hill of effort for high grades");
                    }
                    if (r == 2) {
                        out.print("the door ro success is open to you");
                    }
                }
            }
        }
    }

}

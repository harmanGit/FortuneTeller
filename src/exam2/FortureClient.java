/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class allows users to input Today of Future and get a 
 * fortune back.
 * @author hsd77849
 */
public class FortureClient {

    private PrintWriter out;
    private Scanner in;
    private String message;

    // Constuctor used to conect to the server
    FortureClient() {
        Socket client;
        try {
            client = new Socket("127.0.0.1", 3568); // conneting to the server
            System.out.println("Client made");
            out = new PrintWriter(client.getOutputStream(), true);
            in = new Scanner(client.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Method used to send the message, to the server
     * @param m is a string Today or Future
     */
    public void askTheTeller(String m) {
        message = m;
        if (message.equals("Today") || message.equals("Future")) {
            out.println(message);
        }
    }

    /**
     * Method used to get the Fortunes from the server
     * @return a string with is the fortunes
     */
    public String getFortunes() {
        String r = "";
        r = in.nextLine();
        return r;
    }

}

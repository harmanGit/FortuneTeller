/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2;

import java.util.Scanner;

/**
 *
 * @author hsd77849
 */
public class Exam2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Forture client
        FortureClient fc = new FortureClient();
        System.out.println("You can ASK ONLY ONCE");
        Scanner sn = new Scanner(System.in);

        // While loop to keep sending and recieving
        while (true) {
            System.out.println(" ");
            System.out.println("Enter Today or Future");
            fc.askTheTeller(sn.nextLine());
            System.out.println(fc.getFortunes());
        }

    }

}

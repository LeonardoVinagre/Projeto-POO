/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Views;

import javax.swing.SwingUtilities;

/**
 *
 * @author leonardo.vinagre
 */
public class Main {

    public static Login login;
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main.login = new Login();
            }
        });
    }
}

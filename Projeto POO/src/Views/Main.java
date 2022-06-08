
package Views;

import javax.swing.SwingUtilities;


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

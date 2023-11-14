package ATM;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount account = new BankAccount(1000.0);

        // Create and display the ATM GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATM(account).setVisible(true);
            }
        });
    }
}

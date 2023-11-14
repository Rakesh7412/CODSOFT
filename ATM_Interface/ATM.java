package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false; // Insufficient funds
        }
    }
}

// Class to represent the ATM machine
class ATM extends JFrame {

    private BankAccount userAccount;
    private JTextField amountField;
    private JTextArea outputArea;

    public ATM(BankAccount account) {
        this.userAccount = account;

        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI();
    }

    private void createUI() {
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountField = new JTextField(10);
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");

        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
        inputPanel.add(withdrawButton);
        inputPanel.add(depositButton);
        inputPanel.add(checkBalanceButton);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        // Add ActionListeners to buttons
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleWithdraw();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDeposit();
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCheckBalance();
            }
        });

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void handleWithdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (userAccount.withdraw(amount)) {
                outputArea.append("Withdrawal successful. Remaining balance: ₹" + userAccount.getBalance() + "\n");
            } else {
                outputArea.append("Insufficient funds. Withdrawal failed.\n");
            }
        } catch (NumberFormatException ex) {
            outputArea.append("Invalid input. Please enter a valid amount.\n");
        }
    }

    private void handleDeposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            userAccount.deposit(amount);
            outputArea.append("Deposit successful. New balance: ₹" + userAccount.getBalance() + "\n");
        } catch (NumberFormatException ex) {
            outputArea.append("Invalid input. Please enter a valid amount.\n");
        }
    }

    private void handleCheckBalance() {
        outputArea.append("Current balance: ₹" + userAccount.getBalance() + "\n");
    }
}




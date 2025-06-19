import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class BankAccountGUI extends JFrame {
    private List<BankAccount> accounts;
    private JTextField txtSearch, txtAmount;
    private JLabel lblName, lblBalance, lblLastTrans, lblLastType;
    private String currentAccNum = null;

    public BankAccountGUI(List<BankAccount> accounts) {
        this.accounts = accounts;
        initUI();
    }

    private void initUI() {
        setSize(680, 450);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtSearch = new JTextField();
        txtSearch.setBounds(150, 30, 180, 30);
        add(txtSearch);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(350, 30, 100, 30);
        add(btnSearch);

        lblName = new JLabel("Name: ");
        lblName.setBounds(100, 80, 300, 25);
        add(lblName);

        lblBalance = new JLabel("Balance: ");
        lblBalance.setBounds(100, 110, 300, 25);
        add(lblBalance);

        lblLastTrans = new JLabel("Last Transaction: ");
        lblLastTrans.setBounds(100, 140, 300, 25);
        add(lblLastTrans);

        lblLastType = new JLabel("Last Transaction Type: ");
        lblLastType.setBounds(100, 170, 300, 25);
        add(lblLastType);

        JLabel lblStatus = new JLabel("All the fields are updated");
        lblStatus.setBounds(410, 90, 200, 25);
        lblStatus.setForeground(Color.GRAY);
        add(lblStatus);

        txtAmount = new JTextField();
        txtAmount.setBounds(150, 280, 100, 30);
        add(txtAmount);

        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(280, 280, 100, 30);
        add(btnDeposit);

        JButton btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(400, 280, 100, 30);
        btnWithdraw.setBackground(new Color(255, 204, 153)); // light orange highlight
        add(btnWithdraw);

        btnSearch.addActionListener(e -> searchAccount());
        btnWithdraw.addActionListener(e -> processTransaction("Withdraw"));
        btnDeposit.addActionListener(e -> processTransaction("Deposit"));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void searchAccount() {
        String accNum = txtSearch.getText().trim();
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNum)) {
                currentAccNum = accNum;
                lblName.setText("Name: " + acc.getAccountName());
                lblBalance.setText("Balance: " + acc.getBalance());
                lblLastTrans.setText("Last Transaction: " + acc.getLastTransaction());
                lblLastType.setText("Last Transaction Type: " + acc.getLastTransactionType());
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Account not found.", "Search", JOptionPane.WARNING_MESSAGE);
    }

    private void processTransaction(String type) {
        if (currentAccNum == null) {
            JOptionPane.showMessageDialog(this, "Please search for an account first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double amt = Double.parseDouble(txtAmount.getText().trim());
            for (BankAccount acc : accounts)
            {
                if (acc.getAccountNumber().equals(currentAccNum))
                {
                    if (type.equals("Withdraw") && amt > acc.getBalance())
                    {
                        JOptionPane.showMessageDialog(this, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (type.equals("Deposit"))
                    {
                        acc.setBalance(acc.getBalance() + amt);
                    }
                    else
                    {
                        acc.setBalance(acc.getBalance() - amt);
                    }
                    acc.setLastTransaction(amt);
                    acc.setLastTransactionType(type);

                    lblBalance.setText("Balance: " + acc.getBalance());
                    lblLastTrans.setText("Last Transaction: " + amt);
                    lblLastType.setText("Last Transaction Type: " + type);
                    return;
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

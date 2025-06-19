import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("Sadia Sakiba", "AC030353E293", 10000, 100, "deposit"));
        accounts.add(new BankAccount("Mohaiminul Islam", "AC030848D091", 78500, 2650, "withdraw"));

        javax.swing.SwingUtilities.invokeLater(() ->
        {
            new BankAccountGUI(accounts);
        });
    }
}

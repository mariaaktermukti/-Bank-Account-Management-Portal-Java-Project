import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BankAccountApp {
    private ArrayList<BankAccount> accounts;

    public BankAccountApp()
    {
        accounts = new ArrayList<>();
    }

    public void createAccountsFile(String filename)
    {
        String[] data = {
                "Sadia Sakiba,AC030353E293,10000,100,deposit",
                "Mohaiminul Islam,AC030848D091,78500,2650,withdraw",
                "Ahsan Habib,AC03453435F203,0,0,null",
                "Imran Ahmed,AC0983117G320,0,1000,withdraw",
                "A. K. M Kamruzzaman,AC0983117G320,198000,2000,withdraw"
        };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
        {
            for (String line : data)
            {
                bw.write(line);
                bw.newLine();
            }
            System.out.println(filename + " created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void loadAccountsFromFile(String filename)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts.length == 5)
                {
                    String accountName = parts[0].trim();
                    String accountNumber = parts[1].trim();
                    double balance = Double.parseDouble(parts[2].trim());
                    double lastTransaction = Double.parseDouble(parts[3].trim());
                    String lastTransactionType = parts[4].trim();

                    if (lastTransactionType.equalsIgnoreCase("null"))
                    {
                        lastTransactionType = "None";
                    }

                    BankAccount account = new BankAccount(accountName, accountNumber, balance, lastTransaction, lastTransactionType);
                    accounts.add(account);
                }
                else
                {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file '" + filename + "': " + e.getMessage());
        }
    }

    public void printAccounts() {
        for (BankAccount account : accounts)
        {
            System.out.println(account);
        }
    }

    public static void main(String[] args)
    {
        BankAccountApp app = new BankAccountApp();

        String filename = "accounts.txt";
        app.createAccountsFile(filename);
        app.loadAccountsFromFile(filename);
        app.printAccounts();
    }
}

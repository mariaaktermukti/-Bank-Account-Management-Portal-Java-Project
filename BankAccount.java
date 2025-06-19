public class BankAccount {
    private String accountName;
    private String accountNumber;
    private double balance;
    private double lastTransaction;
    private String lastTransactionType;

    public BankAccount(String accountName, String accountNumber, double balance, double lastTransaction, String lastTransactionType) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.lastTransaction = lastTransaction;
        this.lastTransactionType = lastTransactionType;
    }

    public String getAccountName()
    {
        return accountName;
    }

    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double getLastTransaction()
    {
        return lastTransaction;
    }

    public void setLastTransaction(double lastTransaction)
    {
        this.lastTransaction = lastTransaction;
    }

    public String getLastTransactionType()
    {
        return lastTransactionType;
    }

    public void setLastTransactionType(String lastTransactionType)
    {
        this.lastTransactionType = lastTransactionType;
    }

    public String toString()
    {
        return "BankAccount{" +
                "accountName='" + accountName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", lastTransaction=" + lastTransaction +
                ", lastTransactionType='" + lastTransactionType + '\'' +
                '}';
    }
}

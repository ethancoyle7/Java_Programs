import java.util.Scanner;
import java.util.Vector;

// BankAccount Class defines an individual account with name, phone number, address, and balance
class BankAccount {
    private String name; // Account holder name
    private String phoneNumber; // Account holder phone number
    private String address; // Account holder address
    private double balance; // Account balance

    // Constructor to initialize BankAccount with given name, phone number and address
    public BankAccount(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.balance = 0.0;
    }

    // Getter method to get the name of the account holder
    public String getName() {
        return name;
    }

    // Getter method to get the phone number of the account holder
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Getter method to get the address of the account holder
    public String getAddress() {
        return address;
    }

    // Getter method to get the balance of the account
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        balance -= amount;
    }
}

// BankDatabase Class stores all bank accounts in a Vector
class BankDatabase {
    private Vector<BankAccount> accounts; // Vector to store all bank accounts

    // Constructor to initialize BankDatabase
    public BankDatabase() {
        accounts = new Vector<BankAccount>();
    }

    // Method to add a bank account into the database
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Method to find a bank account in the database with given name
    public BankAccount findAccount(String name) {
        // Loop through all accounts in the database
        for (BankAccount account : accounts) {
            // Check if the name of the account matches the given name
            if (account.getName().equals(name)) {
                // If found, return the account
                return account;
            }
        }
        // If not found, return null
        return null;
    }

    // Method to transfer funds from one account to another account
    public void transferFunds(BankAccount fromAccount, BankAccount toAccount, double amount) {
        // Withdraw funds from the 'fromAccount'
        fromAccount.withdraw(amount);
        // Deposit funds into the 'toAccount'
        toAccount.deposit(amount);
    }
}


public class Main 
{
    private static Scanner input = new Scanner(System.in);
    private static BankDatabase database = new BankDatabase();

    public static void main(String[] args) 
    {
    System.out.println("Welcome to Ethan Coyle's Royal Bank! Please Select and Option below\n");
    database = new BankDatabase();
    input = new Scanner(System.in);
    while (true) 
    {
        System.out.println("1. Add account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check balance");
        System.out.println("5. Transfer");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();
        switch (choice) 
        {
            case 1:
                addAccount();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                checkBalance();
                break;
            case 5:
                transfer();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}

// This method prompts the user to enter their name, phone number, and address.
// It creates a new BankAccount object using the user-entered information.
// The new BankAccount object is then added to the database (which is a BankDatabase object).
    private static void addAccount() {
        System.out.print("Enter account name: ");
        String name = input.next();
        System.out.print("Enter phone number: ");
        String phoneNumber = input.next();
        System.out.print("Enter address: ");
        String address = input.next();
        database.addAccount(new BankAccount(name, phone, address));
}
//   This method prompts the user to enter their account name and the amount they wish to deposit.
// The deposit() method then calls the getAccount() method of the database object to retrieve the specified BankAccount object.
// The deposit() method then calls the deposit() method of the BankAccount object to deposit the specified amount.
  private static void deposit() {
    System.out.print("Enter account name: ");
    String name = input.next();
    BankAccount account = database.getAccount(name);
    if (account == null) {
        System.out.println("Account not found.");
        return;
    }
    System.out.print("Enter deposit amount: ");
    double amount = input.nextDouble();
    account.deposit(amount);
    System.out.println("Deposit successful. New balance is: " + account.getBalance());
}
// This method prompts the user to enter their account name and the amount they wish to withdraw.
// The withdraw() method then calls the getAccount() method of the database object to retrieve the specified BankAccount object.
// The withdraw() method then calls the withdraw() method of the BankAccount object to withdraw the specified amount.
private static void withdraw() {
    System.out.print("Enter account name: ");
    String name = input.next();
    BankAccount account = database.getAccount(name);
    if (account == null) {
        System.out.println("Account not found.");
        return;
    }
    System.out.print("Enter withdrawal amount: ");
    double amount = input.nextDouble();
    if (account.withdraw(amount)) {
        System.out.println("Withdrawal successful. New balance is: " + account.getBalance());
    } else {
        System.out.println("Insufficient funds.");
    }
}
// This method prompts the user to enter their account name.
// The checkBalance() method then calls the getAccount() method of the database object to retrieve the specified BankAccount object.
// The checkBalance() method then calls the getBalance() method of the BankAccount object to retrieve the current balance.
//The current balance is then displayed to the user.
private static void checkBalance() {
    System.out.print("Enter account name: ");
    String name = input.next();
    BankAccount account = database.getAccount(name);
    if (account == null) {
        System.out.println("Account not found.");
        return;
    }
    System.out.println("Account balance is: " + account.getBalance());
}
 // This method prompts the user to enter their account name and the name of the account they wish to 
// transfer money to. The transfer() method then calls the getAccount() method of the database object twice
// , once for the user's account and once for the recipient's account.The method then prompts the user to 
// enter the amount they wish to transfer.The withdraw() method of the user's BankAccount object is then 
// called to withdraw the specified amount.The deposit() method of the recipient's BankAccount object
// is then called to deposit the specified amount.
private static void transfer() {
    System.out.print("Enter source account name: ");
    String sourceName = input.next();
    BankAccount source = database.getAccount(sourceName);
    if (source == null) {
        System.out.println("Source account not found.");
        return;
    }
    System.out.print("Enter destination account name: ");
    String destinationName = input.next();
    BankAccount destination = database.getAccount(destinationName);
    if (destination == null) {
        System.out.println("Destination account not found.");
        return;
    }
    System.out.print("Enter transfer amount: ");
    double amount = input.nextDouble();
    if (source.withdraw(amount)) {
        destination.deposit(amount);
        System.out.println("Transfer successful.");
    } else {
        System.out.println("Insufficient funds.");
    }
}


           


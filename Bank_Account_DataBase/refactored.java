import java.util.Scanner;
import java.util.Vector;

class BankAccount {
private String name;
private String phoneNumber;
private String address;
private double balance;
public BankAccount(String name, String phoneNumber, String address) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.balance = 0.0;
}

public String getName() {
    return name;
}

public String getPhoneNumber() {
    return phoneNumber;
}

public String getAddress() {
    return address;
}

public double getBalance() {
    return balance;
}

public void deposit(double amount) {
    balance += amount;
}

public boolean withdraw(double amount) {
    if (balance < amount) {
        return false;
    }
    balance -= amount;
    return true;
}
}

class BankDatabase {
private Vector<BankAccount> accounts;
  public BankDatabase() {
    accounts = new Vector<BankAccount>();
}

public void addAccount(BankAccount account) {
    accounts.add(account);
}

public BankAccount findAccount(String name) {
    for (BankAccount account : accounts) {
        if (account.getName().equals(name)) {
            return account;
        }
    }
    return null;
}

public boolean transferFunds(String fromAccountName, String toAccountName, double amount) {
    BankAccount fromAccount = findAccount(fromAccountName);
    BankAccount toAccount = findAccount(toAccountName);
    if (fromAccount == null || toAccount == null) {
        System.out.println("Error: One of the accounts does not exist");
        return false;
    } else if (!fromAccount.withdraw(amount)) {
        System.out.println("Error: Insufficient funds");
        return false;
    } else {
        toAccount.deposit(amount);
        return true;
    }
}}

public class Main {
private static Scanner input = new Scanner(System.in);
private static BankDatabase database = new BankDatabase();public static void main(String[] args) {
    System.out.println("Welcome to Ethan Coyle's Royal Bank! Please select an option below\n");
    while (true) {
        System.out.println("1. Add account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check balance");
        System.out.println("5. Transfer");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();
        switch (choice) {
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
                System.out.println("Thank you for using Ethan Coyle's Royal Bank. Have a great day!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

private static void addAccount() {
    System.out.print("Enter account number: ");
    int accountNumber = input.nextInt();
    System.out.print("Enter account name: ");
    String accountName = input.next();
    System.out.print("Enter initial deposit: ");
    double initialDeposit = input.nextDouble();
    accounts.add(new BankAccount(accountNumber, accountName, initialDeposit));
    System.out.println("Account successfully added.");
}

private static void deposit() {
    System.out.print("Enter account number: ");
    int accountNumber = input.nextInt();
    BankAccount account = getAccount(accountNumber);
    if (account == null) {
        System.out.println("Account not found.");
        return;
    }
    System.out.print("Enter amount to deposit: ");
    double amount = input.nextDouble();
    account.deposit(amount);
    System.out.println("Deposit successful. New balance: " + account.getBalance());
}

private static void withdraw() {
    System.out.print("Enter account number: ");
    int accountNumber = input.nextInt();
    BankAccount account = getAccount(accountNumber);
    if (account == null) {
        System.out.println("Account not found.");
        return;
    }
    System.out.print("Enter amount to withdraw: ");
    double amount = input.nextDouble();
    if (account.withdraw(amount)) {
        System.out.println("Withdraw successful. New balance: " + account.getBalance());
    } else {
        System.out.println("Insufficient funds.");
    }
}

private static void checkBalance() {
    System.out.print("Enter account number: ");
    int accountNumber = input.nextInt();
    BankAccount account = getAccount(accountNumber);
    if (account == null) {
        System.out.println("Account not found.");
        return;
    }
    System.out.println("Account balance: " + account.getBalance());
}

private static void transfer() {
    System.out.print("Enter source account number: ");
    int sourceAccountNumber = input.nextInt();
    BankAccount sourceAccount = getAccount(sourceAccountNumber);
    if (sourceAccount == null) {
        System.out.println("Source account not found.");
        return;
    }
    System.out.print("Enter target account number: ");
    int targetAccountNumber = input.nextInt();
    BankAccount targetAccount = getAccount(targetAccountNumber);
    if (targetAccount == null) {
        System.out.println("Target account not found.");
        return;
    }
    System.out.print("Enter amount to transfer: ");
  double amount = input.nextDouble();
if (sourceAccount.withdraw(amount)) {
targetAccount.deposit(amount);
System.out.println("Transfer completed successfully.");
} else {
System.out.println("Transfer failed. Insufficient funds.");
}
}

private static BankAccount getAccount(int accountNumber) {
for (BankAccount account : accounts) {
if (account.getAccountNumber() == accountNumber) {
return account;
}
}
return null;
}
}

//still some errors in this

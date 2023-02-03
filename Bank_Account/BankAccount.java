// Parent Class: Bank Account
class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double deposit(double amount) {
        this.balance += amount;
        return this.balance;
    }

    public String withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return "Withdrawn successfully";
        } else {
            return "Insufficient balance";
        }
    }

    public String toString() {
        return "Name: " + this.name + ", Balance: " + this.balance;
    }
}

// Child Class: Saving Account
class SavingAccount extends BankAccount {
    private double interestRate;

    public SavingAccount(String name, double balance, double interestRate) {
        super(name, balance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        double interest = this.balance * (this.interestRate / 100);
        return interest;
    }

    public String toString() {
        return "Name: " + this.name + ", Balance: " + this.balance + ", Interest Rate: " + this.interestRate;
    }
}

// Child Class: Checking Account
class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String name, double balance, double overdraftLimit) {
        super(name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public String withdraw(double amount) {
        if (this.balance + this.overdraftLimit >= amount) {
            this.balance -= amount;
            return "Withdrawn successfully";
        } else {
            return "Insufficient balance with overdraft limit";
        }
    }

    public String toString() {
        return "Name: " + this.name + ", Balance: " + this.balance + ", Overdraft Limit: " + this.overdraftLimit;
    }
}

// Class: Customer
class Customer {
    private String name;
    private SavingAccount savingAccount;
    private CheckingAccount checkingAccount;

    public Customer(String name) {
        this.name = name;
        this.savingAccount = null;
        this.checkingAccount = null;
    }

    public void openSavingAccount(double interestRate) {
        this.savingAccount = new SavingAccount(this.name, 0, interestRate);
    }

    public void openCheckingAccount(double overdraftLimit) {
        this.checkingAccount = new CheckingAccount(this.name, 0, overdraftLimit);
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        if (this.savingAccount != null) {
            totalBalance += this.savingAccount.getBalance();
        }
        if (this.checkingAccount != null) {
            totalBalance += this.checkingAccount.getBalance();
        }
        return totalBalance;
    }

    public String toString() {
        return "Name: " + this.name;
    }
}
// In this implementation , inheritance is demonstrated by the relationship between the BankAccount class
// and its child classes SavingAccount and CheckingAccount. The SavingAccount and CheckingAccount classes
// inherit properties and methods from the BankAccount class. Polymorphism is demonstrated by the withdraw
// method in the CheckingAccount class which has the same name as the withdraw method in the BankAccount class,
// but implements different behavior. This is an example of runtime polymorphism. Abstraction is demonstrated
// by the getTotalBalance method in the Customer class. This method provides the total balance for a customer,
// but hides the implementation details of how this is calculated. Encapsulation is demonstrated by the 
// properties and methods in each class. The properties are defined as private, which protects the internal
// state of the objects from external changes. The methods provide a way to access and manipulate the data, 
// but the implementation details are hidden.

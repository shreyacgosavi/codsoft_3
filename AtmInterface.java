import java.util.Scanner;

class AtmInterface {
    private double balance;

    public AtmInterface(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + "  Current balance: " + balance + " ruppees.");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + "  Current balance: " + balance + " ruppees.");
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance + " ruppees.");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------WELCOME TO XYZ BANK ATM------------------");
            System.out.println("*************************");
            System.out.println("ATM Menu");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("*************************");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            double amount;
            switch (choice) {
                case 1:
                    System.out.print("Enter the withdrawal amount: ");
                    amount = scanner.nextDouble();
                    withdraw(amount);
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: ");
                    amount = scanner.nextDouble();
                    deposit(amount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial account balance: ");
        double initialBalance = scanner.nextDouble();
        AtmInterface atm = new AtmInterface(initialBalance);
        atm.start();
    }
}

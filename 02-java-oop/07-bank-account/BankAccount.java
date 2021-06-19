import java.util.Random;

public class BankAccount {
    
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;
    private static double totalAmount = 0;

    public BankAccount() {
        this.accountNumber = this.randAccountNum();
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        numberOfAccounts++;
    }

    private String randAccountNum() {
        String accountNumber = "";
        Random r = new Random();
        for (int i=0; i < 10; i++) {
            accountNumber = accountNumber.concat(String.valueOf(r.nextInt(10)));
        }
        return accountNumber;
    }

    public void depositMoney(double amount, String accountType) {
        if (accountType.equals("checking")) {
            this.setCheckingBalance(this.getCheckingBalance() + amount);
            
        }else if(accountType.equals("savings")){
            this.setSavingsBalance(this.getSavingsBalance() + amount);
            
        }else {
            System.out.println("Invalid Account");
            return;
        }
        totalAmount += amount;
    }

    public void withdrawMoney(double amount, String accountType) {
        if (accountType.equals("checking")) {
            if(this.getCheckingBalance() - amount < 0) {
                System.out.println("Not enough funds");
            } else {
            this.setCheckingBalance(this.getCheckingBalance() - amount);
            totalAmount -= amount;
            }
            
        }else if(accountType.equals("savings")){
            if(this.getSavingsBalance() - amount < 0) {
                System.out.println("Not enough funds");
            } else {
            this.setSavingsBalance(this.getSavingsBalance() - amount);
            totalAmount -= amount;
            }
            
        }else {
            System.out.println("Not enough funds");
            return;
        }
    }

    public String getAccountTotal() {
        return "Total Money in Account: " + this.getCheckingBalance() + this.getSavingsBalance();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    private void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    private void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static void setNumberOfAccounts(int numberOfAccounts) {
        BankAccount.numberOfAccounts = numberOfAccounts;
    }

    public static double getTotalAmount() {
        return totalAmount;
    }

    public static void setTotalAmount(double totalAmount) {
        BankAccount.totalAmount = totalAmount;
    }
}
public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.depositMoney(100,"checking");
        System.out.println(account1.getAccountTotal());
        account1.depositMoney(200, "checking");
        System.out.println(account1.getAccountTotal());
        BankAccount.getNumberOfAccounts();
        account1.withdrawMoney(500, "savings");
        account1.withdrawMoney(100, "checking");
        System.out.println(account1.getAccountTotal());
    }
}
package _ontap_oop_java._2_nganhang;

public class Main {
    public static void main(String[] args) {
        //test
        Account account1=new Account(123,"a",80);
        Account account2=new Account(124,"b",100);
        System.out.println(account1);
        System.out.println(account2);

        account1.paymentAccount(50);
        account2.paymentAccount(50);
        System.out.println(account1);
        System.out.println(account2);

        account1.withdrawalAccount(30);
        account1.bankMoneyAccount(124);
        System.out.println(account1);
        System.out.println(account2);

        account1.expiredDate(2);
        account2.expiredDate(0);
        System.out.println(account1);
        System.out.println(account2);

        account1.bankMoneyAccount(20);
        account2.setMoneyAccount(account2.getMoneyAccount() + 20);

        System.out.println(account1);
        System.out.println(account2);

//        //thuc te
//        Account account1;
//        Account account2;
//        System.out.println("1. Payment money");
//        System.out.println("2. Withdrawal money");
//        System.out.println("3. Expired Date money");
//        System.out.println("4. Bank money");
//        System.out.println("0. EXIT");
    }
}

package _ontap_oop_java._2_nganhang;

import javafx.scene.control.Alert;

public class Account {
    private long numberAccount;
    private String nameAccount;
    private double moneyAccount;
    final double interest = 0.035;

    public Account() {
    }

    public Account(long numberAccount, String nameAccount, double moneyAccount) {
        this.numberAccount = numberAccount;
        this.nameAccount = nameAccount;
        this.moneyAccount = moneyAccount;
    }

    public Account(long numberAccount, String nameAccount) {
        this.numberAccount = numberAccount;
        this.nameAccount = nameAccount;
        this.moneyAccount = 50;
    }

    public long getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(long numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public double getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(double moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "numberAccount=" + numberAccount +
                ", nameAccount='" + nameAccount + '\'' +
                ", moneyAccount=" + moneyAccount +
                '}';
    }

    public void paymentAccount(double moneyPayment) {
        if (moneyPayment <= 0) {
            System.out.println("Số tiền nộp không hợp lệ !!!");
        }else this.setMoneyAccount(this.getMoneyAccount() + moneyPayment);
    }

    public void withdrawalAccount(double moneyWithrawal) {
        if (moneyWithrawal > this.getMoneyAccount() || moneyWithrawal <= 0) {
            System.out.println("Số tiền rút không hợp lệ !!!");
        } else this.setMoneyAccount(this.getMoneyAccount() - moneyWithrawal);
    }

    public void expiredDate(int date) {
        if (date >= 1) {
            for (int i = 1; i <= date; i++) {
                this.setMoneyAccount(this.getMoneyAccount() + this.getMoneyAccount() * interest);
            }
        }else System.out.println("Date không hợp lệ !! ");
    }

    public void bankMoneyAccount(double moneyBank) {
        if (moneyBank <= 0 || moneyBank > this.getMoneyAccount()) {
            System.out.println("Số tiền chuyển không hợp lệ");
        } else this.setMoneyAccount(this.getMoneyAccount() - moneyBank);
    }
}

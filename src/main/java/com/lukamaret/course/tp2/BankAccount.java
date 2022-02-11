package com.lukamaret.course.tp2;

public class BankAccount {

    private static int id = 1;

    private int accountId;
    private int amount;
    private double limit;
    private Client client;
    private Date openDate;

    public BankAccount(int amount, double limit, Client client, Date openDate) {
        this.accountId = id++;
        this.amount = amount;
        this.limit = limit;
        this.client = client;
        this.openDate = openDate;
    }

    public boolean withdraw(int amount) {

        if (amount > this.amount) {
            return false;
        }

        this.amount -= amount;
        return true;
    }

    public void deposit(int amount) {
        this.amount += amount;
    }

    public boolean pay(BankAccount otherAccount, int amount) {

        if (amount > this.amount) {
            return false;
        }

        otherAccount.deposit(amount);
        this.withdraw(amount);
        return true;
    }

    public String description() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", amount=" + amount +
                ", limit=" + limit +
                ", client=" + client +
                ", openDate=" + openDate +
                '}';
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        BankAccount.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

}

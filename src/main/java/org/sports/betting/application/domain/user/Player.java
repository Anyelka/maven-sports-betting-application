package org.sports.betting.application.domain.user;

import java.time.LocalDate;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import org.sports.betting.application.domain.BettingDomainDatabase;
import org.sports.betting.application.domain.wager.Wager;

public class Player extends User {
    private String name;
    private String accountNumber;
    private int balance;
    private Currency currency;
    private LocalDate dob;
    private Set<Wager> wagers = new HashSet<Wager>();

    public Player(String name, String accountNumber, int balance, Currency currency, LocalDate dob) {
        super();
        BettingDomainDatabase.getPlayers().add(this);
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Set<Wager> getWagers() {
        return wagers;
    }

    public void setWagers(Set<Wager> wagers) {
        this.wagers = wagers;
    }
    
    

}

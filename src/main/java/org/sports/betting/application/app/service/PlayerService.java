package org.sports.betting.application.app.service;

import java.time.LocalDate;
import java.util.Currency;

import org.sports.betting.application.domain.BettingDomainDatabase;
import org.sports.betting.application.domain.user.Player;

public class PlayerService {

    public static Player createPlayer(String[] string) {
        String name = string[0];
        String accountNumber = string[1];
        int balance = Integer.parseInt(string[2]);
        Currency currency = Currency.getInstance(string[3]);
        LocalDate dob = LocalDate.parse(string[4]);
        return new Player(name, accountNumber, balance, currency, dob);
    }

    public static Player getPlayerByName(String name) {
        for (Player player : BettingDomainDatabase.getPlayers()) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        System.out.println("No players found with the given name :(");
        return null;
    }

    public static void increaseBalance(int amount, Player player) {
        player.setBalance(player.getBalance() + amount);
    }

    public static void decreaseBalance(int amount, Player player) {
        player.setBalance(player.getBalance() - amount);
    }

}

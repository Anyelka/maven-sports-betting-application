package org.sports.betting.application.app.ui;

import java.util.Scanner;

import org.sports.betting.application.app.service.PlayerService;
import org.sports.betting.application.app.service.WagerService;
import org.sports.betting.application.domain.BettingDomainDatabase;
import org.sports.betting.application.domain.bet.Bet;
import org.sports.betting.application.domain.outcome.Outcome;
import org.sports.betting.application.domain.sportevent.Result;
import org.sports.betting.application.domain.user.Player;
import org.sports.betting.application.domain.wager.Wager;

public class SBController {
    private static Scanner scanner;

    public static Player createPlayer() {
        String[] playerData = readPlayerData();
        String playerName = playerData[0];
        PlayerService.createPlayer(playerData);
        System.out.println("Player succesfully created:");
        Player currentPlayer = PlayerService.getPlayerByName(playerName);
        displayPlayer(currentPlayer);
        return currentPlayer;
    }

    public static String[] readPlayerData() {
        scanner = new Scanner(System.in);
        System.out.println("Please enter your name :");
        String name = scanner.nextLine();
        System.out.println("Enter your account number :");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter your balance:");
        String balance = scanner.nextLine();
        if (Integer.parseInt(balance) <= 0) {
            System.out.println("Sorry, you can only play with a positive balance!");
        }
        System.out.println("What is your currency ? ( [HUF] / [EUR] / [GBP] / [USD] )");
        String currency = scanner.nextLine();
        System.out.println("When were you born ? (Format: [2018-01-01]");
        String dob = UserIO.readDate();
        String[] playerData = { name, accountNumber, balance, currency, dob };
        return playerData;
    }

    public static void displayPlayer(Player player) {
        System.out.println("\t-> Name: " + player.getName());
        System.out.println("\t-> AccountNumber: " + player.getAccountNumber());
        System.out.println("\t-> Balance: " + player.getBalance());
        System.out.println("\t-> Currency: " + player.getCurrency());
        System.out.println("\t-> Date of birth: " + player.getDob());
    }

    public static void makeWagers(Player currentPlayer) {
        boolean run = true;
        while (run) {
            System.out.println();
            makeSingleMatchWager(currentPlayer);
            System.out.println("Do you want to make another wager ?  ( [Y] - yes / [N] - no )");
            char response = UserIO.readChar();
            if (!(response == 'Y' || response == 'y')) {
                run = false;
            } else
                TestDataUI.listBets();
        }
    }

    public static Wager makeSingleMatchWager(Player currentPlayer) {
        Bet chosenBet = TestDataUI.choseBet(Integer.parseInt(UserIO.read()));
        TestDataUI.listOutcomes(chosenBet);
        char outcomeLetter = UserIO.readChar();
        Outcome chosenOutcome = BettingDomainDatabase.choseOutcome(chosenBet, outcomeLetter);
        System.out.println("Please define your stake:");
        int stake = Integer.parseInt(UserIO.read());
        if (stake > currentPlayer.getBalance()) {
            System.out.println("You don't have enough money for that stake!");
            return null;
        }
        BettingDomainUI.displayChosenBet(chosenBet, chosenOutcome, stake, currentPlayer);

        Wager wager = WagerService.createWager(currentPlayer, chosenOutcome, stake);
        PlayerService.decreaseBalance(wager.getStake(), currentPlayer);
        System.out.println("Your new balance is " + currentPlayer.getBalance());
        return wager;
    }

    public static void displayResults(Player currentPlayer) {
        System.out.println();
        System.out.println("The outcome of your wager(s) : ");
        for (Wager wager : currentPlayer.getWagers()) {
            Bet wagersBet = wager.getOutcome().getBet();
            Result eventsResult = wagersBet.getEvent().getResult();
            System.out.println("Your bet was " + wagersBet.getDescription());
            Outcome outcome = eventsResult.getOutcome(wagersBet);
            System.out.println("-> The result of the bet is " + outcome.getValue() + " with " + outcome.getOdd().getOdd() + " odd");
            System.out.println("-> This means you " + isWinnerWager(wager) + " your bet! ");
            System.out.println("->You won " + moneyWon(wager) + " " + wager.getCurrency() + " with this wager");
            WagerService.evaluateWager(wager);

        }
        finalBalance(currentPlayer);
    }

    public static String isWinnerWager(Wager wager) {
        return WagerService.isWinner(wager) ? "won" : "lost";
    }

    public static int moneyWon(Wager wager) {
        if (WagerService.isWinner(wager)) {
            int moneyWon = (int) ((wager.getStake()) * (wager.getOutcomeOdd().getOdd()));
            return moneyWon;
        }
        return 0;
    }

    public static void finalBalance(Player currentPlayer) {
        System.out.println();
        System.out.println("Your final balance is " + currentPlayer.getBalance() + " " + currentPlayer.getCurrency());
    }
}

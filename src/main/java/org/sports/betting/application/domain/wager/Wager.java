package org.sports.betting.application.domain.wager;

import java.time.LocalDateTime;
import java.util.Currency;

import org.sports.betting.application.domain.outcome.Outcome;
import org.sports.betting.application.domain.outcome.OutcomeOdd;
import org.sports.betting.application.domain.user.Player;

public class Wager {
    private Player player;
    private Outcome outcome;
    private OutcomeOdd outcomeOdd;
    private int amount;
    private Currency currency;
    private LocalDateTime timestamp;
    private boolean isProcessed;
    private boolean isWinner;

    public Wager(Player player, Outcome outcome, OutcomeOdd outcomeOdd, int amount, Currency currency, LocalDateTime date) {
        this.player = player;
        this.outcome = outcome;
        this.outcomeOdd = outcomeOdd;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = date;
        this.isProcessed = false;
    }

    // Getters & setters:
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public OutcomeOdd getOutcomeOdd() {
        return outcomeOdd;
    }

    public void setOutcomeOdd(OutcomeOdd outcomeOdd) {
        this.outcomeOdd = outcomeOdd;
    }

    public int getStake() {
        return amount;
    }

    public void setStake(int stake) {
        this.amount = stake;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime date) {
        this.timestamp = date;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }

}

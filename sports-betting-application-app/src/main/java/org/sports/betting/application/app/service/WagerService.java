package org.sports.betting.application.app.service;

import java.time.LocalDateTime;

import org.sports.betting.application.domain.outcome.Outcome;
import org.sports.betting.application.domain.sportevent.Result;
import org.sports.betting.application.domain.user.Player;
import org.sports.betting.application.domain.wager.Wager;

public class WagerService {

    public static Wager createWager(Player player, Outcome outcome, int stake) {
        Wager wager = new Wager(player, outcome, outcome.getOdd(), stake, player.getCurrency(), LocalDateTime.now());
        player.getWagers().add(wager);
        return wager;
    }

    public static boolean isWinner(Wager wager) {
        Result result = wager.getOutcome().getBet().getEvent().getResult();
        for (Outcome outcome : result.getOutcomes()) {
            if (outcome.equals(wager.getOutcome())) {
                return true;
            }
        }
        return false;
    }

    public static void evaluateWager(Wager wager) {
        if (isWinner(wager)) {
            Player player = wager.getPlayer();
            PlayerService.increaseBalance((int) ((wager.getStake()) * (wager.getOutcomeOdd().getOdd())), player);
        }
    }
}

package org.sports.betting.application.app;

import org.sports.betting.application.app.service.TestDataGenerator;
import org.sports.betting.application.app.ui.SBController;
import org.sports.betting.application.app.ui.TestDataUI;
import org.sports.betting.application.app.ui.UserIO;
import org.sports.betting.application.domain.user.Player;

public class App {

    public static void main(String[] args) {

         Player currentPlayer = SBController.createPlayer();
//        Player currentPlayer = TestDataGenerator.createPlayer();

        UserIO.confirmPlay();

        TestDataGenerator.create();

        TestDataUI.listBets();

        SBController.makeWagers(currentPlayer);

        TestDataGenerator.randomResults();

        SBController.displayResults(currentPlayer);
    }

}

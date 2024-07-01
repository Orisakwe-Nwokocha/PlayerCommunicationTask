package dev.orisha.player_communication_task;

import static dev.orisha.player_communication_task.IDENTITY.RECIPIENT;
import static dev.orisha.player_communication_task.IDENTITY.SENDER;

public class Main {

    public static void main(String[] args) {
        Player playerOne = new Player("Player 1", SENDER);
        playerOne.setInitialMessage("Hello");
        Player playerTwo = new Player("Player 2", RECIPIENT);


        Thread t1 = new Thread(playerOne, "t1");
        Thread t2 = new Thread(playerTwo, "t2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("exception: " + e.getMessage());
        }

        System.out.println("\nNumber of messages sent by Initiator: " + playerOne.getMessageCount());
        System.out.println("Number of messages received from PlayerTwo: " + playerTwo.getMessageCount());
    }
}

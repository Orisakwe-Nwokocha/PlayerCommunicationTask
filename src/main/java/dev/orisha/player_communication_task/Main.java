package dev.orisha.player_communication_task;

public class Main {

    public static void main(String[] args) {
        Player playerOne = new Player("Initiator");
        Player playerTwo = new Player("PlayerTwo");
        int result = playerOne.sendMessage("Hi", playerTwo);
        System.out.println("\nNumber of messages sent by Initiator: " + result);
        System.out.println("Number of messages received from PlayerTwo: " + playerTwo.getCounter());
    }
}

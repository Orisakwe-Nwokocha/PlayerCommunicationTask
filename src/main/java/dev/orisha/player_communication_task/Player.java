package dev.orisha.player_communication_task;

public class Player {
    private int counter;
    private String name;
    
    public Player() {}

    public Player(String name) {
        this.name = name;
    }

    public int sendMessage(String message, Player playerTwo) {
        ++counter;
        String description = String.format("%s sending message to %s: %s", name, playerTwo.name, message);
        System.out.println(description);
        playerTwo.receiveMessage(message, this);
        return counter;
    }

    private void receiveMessage(String message, Player initiator) {
        String description = String.format("%s received message from %s: %s", name, initiator.name, message);
        System.out.println(description);
        if (counter < 10) this.sendMessage(message + (counter + 1), initiator);
    }

    public int getCounter() {
        return counter;
    }

}

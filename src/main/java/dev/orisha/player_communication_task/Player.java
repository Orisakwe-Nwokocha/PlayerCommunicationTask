package dev.orisha.player_communication_task;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private int messageCount;
    private int responseCount;
    private String initialMessage;
    private String name;
    private IDENTITY id;
    private static final List<Message> messages = new ArrayList<>();

    public Player() {}

    public Player(String name, IDENTITY id) {
        this.name = name;
        this.id = id;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setInitialMessage(String initialMessage) {
        this.initialMessage = initialMessage;
    }

    public  void sendMessage (String message){
        String description = String.format("%s sending message %s", name, message);
        messages.add(new Message(description, name));
        System.out.println(description);
        messageCount++;
    }

    private synchronized void  receiveMessage() throws InterruptedException {
        Message message = messages.getLast();
        if (!name.equals(message.getSender())) {
            String description = String.format("%s received message from : %s", name, message.getSender());
            System.out.println(description);
            message.setContent(message + " " + messageCount);
            message.setSender(name);
            messages.add(message);
            responseCount++;
        }
    }

    @Override
    public void run() {
        try {
            while (messageCount < 10) {
                sendMessage(initialMessage);
            }
            while (responseCount < 10) receiveMessage();
        }catch (InterruptedException exception){
            System.out.println("exception: "+exception.getMessage());
        }
    }
}

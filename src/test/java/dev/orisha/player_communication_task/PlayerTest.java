package dev.orisha.player_communication_task;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testThatPlayerCanCommunicateWithAnotherPlayer() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        int result = playerOne.sendMessage("Hi", playerTwo);
        assertTrue(result >= 1);
    }

    @Test
    @DisplayName("when player one receives message, then player two sends message in return")
    public void playersCommunicationTest() {
        Player playerOne = new Player("Initiator");
        Player playerTwo = new Player("PlayerTwo");
        int result = playerOne.sendMessage("Hi", playerTwo);
        assertEquals(10, result);
        assertEquals(10, playerOne.getCounter());
        assertEquals(10, playerTwo.getCounter());
    }

}
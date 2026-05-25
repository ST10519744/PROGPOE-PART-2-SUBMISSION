/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog5121p0epart1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    Message msg;

    @BeforeEach
    public void setUp() {
        msg = new Message("+27838968976", "Hi there friend");
    }

    @Test
    public void testGenerateMessageID() {
        String id = msg.generateMessageID();
        assertNotNull(id);
        assertEquals(10, id.length());
    }

    @Test
    public void testCheckMessageID() {
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testCheckRecipientCellCorrectlyFormatted() {
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCellIncorrectlyFormatted() {
        Message badMsg = new Message("08966553", "Hi there friend");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", badMsg.checkRecipientCell());
    }

    @Test
    public void testCreateMessageHash() {
        String hash = msg.getMessageHash();
        assertNotNull(hash);
        assertTrue(hash.contains(":"));
        assertEquals(hash, hash.toUpperCase());
    }

    @Test
    public void testSentMessageSend() {
        assertEquals("Message successfully sent.", msg.sentMessage(1));
    }

    @Test
    public void testSentMessageDisregard() {
        assertEquals("Press 0 to delete the message.", msg.sentMessage(2));
    }

    @Test
    public void testSentMessageStore() {
        assertEquals("Message successfully stored.", msg.sentMessage(3));
    }

    @Test
    public void testSentMessageInvalid() {
        assertEquals("Invalid option.", msg.sentMessage(99));
    }

    @Test
    public void testGetMessageID() {
        assertNotNull(msg.getMessageID());
        assertEquals(10, msg.getMessageID().length());
    }

    @Test
    public void testGetMessageHash() {
        assertNotNull(msg.getMessageHash());
    }

    @Test
    public void testGetRecipient() {
        assertEquals("+27838968976", msg.getRecipient());
    }

    @Test
    public void testGetMessage() {
        assertEquals("Hi there friend", msg.getMessage());
    }

    @Test
    public void testGetNumMessagesSent() {
        assertEquals(0, msg.getNumMessagesSent());
    }
}
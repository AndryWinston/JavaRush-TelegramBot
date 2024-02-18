package com.AlexeyKalitin.javarushtelegrambot;

import com.AlexeyKalitin.javarushtelegrambot.bot.JavaRushTelegramBot;
import com.AlexeyKalitin.javarushtelegrambot.service.SendBotMessageService;
import com.AlexeyKalitin.javarushtelegrambot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing fro SendBorMessageService")
public class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    public JavaRushTelegramBot javarushBot;
    @BeforeEach
    public void init(){
        javarushBot = Mockito.mock(JavaRushTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javarushBot);
    }
    @Test
    public void shouldProperlySendMessage() throws TelegramApiException{
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        sendBotMessageService.sendMessage(chatId,message);

        Mockito.verify(javarushBot).execute(sendMessage);
    }
}

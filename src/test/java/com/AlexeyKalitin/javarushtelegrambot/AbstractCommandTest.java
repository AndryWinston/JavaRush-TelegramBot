package com.AlexeyKalitin.javarushtelegrambot;

import com.AlexeyKalitin.javarushtelegrambot.bot.JavaRushTelegramBot;
import com.AlexeyKalitin.javarushtelegrambot.command.Command;
import com.AlexeyKalitin.javarushtelegrambot.service.SendBotMessageService;
import com.AlexeyKalitin.javarushtelegrambot.service.SendBotMessageServiceImpl;
import com.AlexeyKalitin.javarushtelegrambot.service.TelegramUserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class AbstractCommandTest {

    protected TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);

    protected JavaRushTelegramBot javarushBot = Mockito.mock(JavaRushTelegramBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(javarushBot);

    abstract String getCommandName();
    abstract String getCommandMessage();
    abstract Command getCommand();
    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chatId = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);
        Mockito.verify(javarushBot).execute(sendMessage);
    }

}

package com.AlexeyKalitin.javarushtelegrambot.command;

import com.AlexeyKalitin.javarushtelegrambot.service.SendBotMessageService;
import com.AlexeyKalitin.javarushtelegrambot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";
    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
        telegramUserService.findByChatId(update.getMessage().getChatId().toString())
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
    }
}

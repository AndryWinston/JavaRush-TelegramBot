package com.AlexeyKalitin.javarushtelegrambot;

import com.AlexeyKalitin.javarushtelegrambot.command.Command;
import com.AlexeyKalitin.javarushtelegrambot.command.StatCommand;

import static com.AlexeyKalitin.javarushtelegrambot.command.CommandName.STAT;
import static com.AlexeyKalitin.javarushtelegrambot.command.StatCommand.STAT_MESSAGE;

public class StatCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}

package com.AlexeyKalitin.javarushtelegrambot;

import com.AlexeyKalitin.javarushtelegrambot.command.Command;
import com.AlexeyKalitin.javarushtelegrambot.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.AlexeyKalitin.javarushtelegrambot.command.CommandName.NO;
import static com.AlexeyKalitin.javarushtelegrambot.command.NoCommand.NO_MESSAGE;
@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}

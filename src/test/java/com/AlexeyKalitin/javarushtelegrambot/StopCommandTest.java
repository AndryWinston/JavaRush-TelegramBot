package com.AlexeyKalitin.javarushtelegrambot;

import com.AlexeyKalitin.javarushtelegrambot.command.Command;
import com.AlexeyKalitin.javarushtelegrambot.command.StopCommand;
import org.junit.jupiter.api.DisplayName;

import static com.AlexeyKalitin.javarushtelegrambot.command.CommandName.STOP;
import static com.AlexeyKalitin.javarushtelegrambot.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}

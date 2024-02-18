package com.AlexeyKalitin.javarushtelegrambot;

import com.AlexeyKalitin.javarushtelegrambot.command.Command;
import com.AlexeyKalitin.javarushtelegrambot.command.HelpCommand;
import org.junit.jupiter.api.DisplayName;

import static com.AlexeyKalitin.javarushtelegrambot.command.CommandName.HELP;
import static com.AlexeyKalitin.javarushtelegrambot.command.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}

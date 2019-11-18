package com.epam.examples.math_command;

import com.epam.examples.controller.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String data) {
        return "wrong request";
    }
}

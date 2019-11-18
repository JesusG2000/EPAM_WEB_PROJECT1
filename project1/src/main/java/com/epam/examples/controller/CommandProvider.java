package com.epam.examples.controller;


import com.epam.examples.dao.FileParser;
import com.epam.examples.math_command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

//package private
 final class CommandProvider {

    private final Map<CommandName, Command> repositoryOperation = new HashMap<>();
    private final Map<CommandName, Pattern> repositoryParam = new HashMap<>();

    CommandProvider() {
        repositoryOperation.put(CommandName.ALLOWABLE_GLOB, new AllowableGlob());
        repositoryOperation.put(CommandName.CALC_CAPACITY, new CalcCapacity());
        repositoryOperation.put(CommandName.CALC_SURFACE_AREA, new CalcSurfaceArea());
        repositoryOperation.put(CommandName.CALC_VOLUME_RATIO, new CalcVolumeRatio());
        repositoryOperation.put(CommandName.IS_TOUCH_SOME_AXIS, new IsTouchSomeAxis());
        repositoryOperation.put(CommandName.WRONG_REQUEST, new WrongRequest());

        repositoryParam.put(CommandName.ALLOWABLE_GLOB, FileParser.FOUR_PARAMS);
        repositoryParam.put(CommandName.CALC_CAPACITY, FileParser.FOUR_PARAMS);
        repositoryParam.put(CommandName.CALC_SURFACE_AREA, FileParser.FOUR_PARAMS);
        repositoryParam.put(CommandName.CALC_VOLUME_RATIO, FileParser.EIGHT_PARAMS);
        repositoryParam.put(CommandName.IS_TOUCH_SOME_AXIS, FileParser.FOUR_PARAMS);

    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repositoryOperation.get(commandName);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            command = repositoryOperation.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }

    Pattern getParam(String name) {
        CommandName commandName = CommandName.valueOf(name.toUpperCase());
        repositoryParam.get(commandName);
        return  repositoryParam.get(commandName);
    }
}

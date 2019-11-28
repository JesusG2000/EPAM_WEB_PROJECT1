package com.epam.examples.controller;


import com.epam.examples.math_command.*;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


//package private
final class CommandProvider {

    private static Logger log = Logger.getLogger(CommandProvider.class);
    private final Map<CommandName, Command> repositoryOperation = new HashMap<>();

    CommandProvider() {
        repositoryOperation.put(CommandName.ALLOWABLE_GLOB, new AllowableGlob());
        repositoryOperation.put(CommandName.CALC_CAPACITY, new CalcCapacity());
        repositoryOperation.put(CommandName.CALC_SURFACE_AREA, new CalcSurfaceArea());
        repositoryOperation.put(CommandName.CALC_VOLUME_RATIO, new CalcVolumeRatio());
        repositoryOperation.put(CommandName.IS_TOUCH_SOME_AXIS, new IsTouchSomeAxis());
        repositoryOperation.put(CommandName.WRONG_REQUEST, new WrongRequest());


    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            log.info("founded command - " + commandName.toString());
            command = repositoryOperation.get(commandName);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            command = repositoryOperation.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }

//    Pattern getParam(String name) {
//        CommandName commandName = CommandName.valueOf(name.toUpperCase());
//        repositoryParam.get(commandName);
//        return  repositoryParam.get(commandName);
//    }
}

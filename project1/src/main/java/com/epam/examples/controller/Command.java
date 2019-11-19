package com.epam.examples.controller;

public interface Command<T> {
    String execute(T data);

    Class<T> getInputType();
}

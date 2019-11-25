package com.epam.examples.math.operation;

import com.epam.examples.math.operation.impl.OperationImpl;

public final class MathFactory {
    private final static Operation operation = new OperationImpl();

    private MathFactory(){}

    public static Operation getOperation() {
        return operation;
    }
}

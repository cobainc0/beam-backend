package com.cobainc0.beam;

public class BeamException extends Exception {

    public BeamException(String message, Throwable cause) {
        super(message, cause);

        System.out.println("Beam exception - message: "+message);
        System.out.println("Beam exception - cause: "+message);
    }

    public BeamException() {
        super();
    }


}

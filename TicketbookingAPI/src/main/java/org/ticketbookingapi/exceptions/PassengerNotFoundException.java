package org.ticketbookingapi.exceptions;

public class PassengerNotFoundException  extends  Exception{

    private String message;


    public PassengerNotFoundException(String message) {
      super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }


}

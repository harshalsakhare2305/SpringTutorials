package org.ticketbookingapi.exceptions;

public class TicketNotFoundException extends Exception {

    private String msg;


    public TicketNotFoundException(String msg) {
        super(msg);
    }

    public String getMsg() {
        return msg;
    }
}

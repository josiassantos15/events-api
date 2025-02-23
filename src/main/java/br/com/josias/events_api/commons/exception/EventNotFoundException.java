package br.com.josias.events_api.commons.exception;

public class EventNotFoundException extends RuntimeException {
    
    public EventNotFoundException(String msg) {
        super(msg);
    }
}

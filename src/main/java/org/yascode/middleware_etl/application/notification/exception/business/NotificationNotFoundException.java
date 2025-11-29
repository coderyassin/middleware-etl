package org.yascode.middleware_etl.application.notification.exception.business;

public class NotificationNotFoundException extends Exception {

    public NotificationNotFoundException() {
        super();
    }

    public NotificationNotFoundException(String message) {
        super(message);
    }

    public NotificationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotificationNotFoundException(Throwable cause) {
        super(cause);
    }
}

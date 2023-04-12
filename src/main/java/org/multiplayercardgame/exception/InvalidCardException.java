/**
 * An exception that is thrown when an invalid card is encountered.
 */
package org.multiplayercardgame.exception;

public class InvalidCardException extends Exception {

    /**
     * Constructs a new InvalidCardException with the specified error message.
     *
     * @param message the error message to include in the exception
     */
    public InvalidCardException(String message) {
        super(message);
    }
}

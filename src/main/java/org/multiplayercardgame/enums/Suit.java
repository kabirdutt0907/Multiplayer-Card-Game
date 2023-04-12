/**
 * An enumeration of the suits of cards in a standard deck of playing cards.
 */
package org.multiplayercardgame.enums;

public enum Suit {
    /**
     * The Hearts suit.
     */
    HEARTS("H"),
    /**
     * The Diamonds suit.
     */
    DIAMONDS("D"),
    /**
     * The Clubs suit.
     */
    CLUBS("C"),
    /**
     * The Spades suit.
     */
    SPADES("S");

    /**
     * The symbol representing the suit on the face of a card.
     */
    private final String symbol;

    /**
     * Constructs a new Suit with the given symbol.
     *
     * @param symbol the symbol representing the suit on the face of a card
     */
    Suit(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol representing the suit on the face of a card.
     *
     * @return the symbol representing the suit on the face of a card
     */
    public String getSymbol() {
        return symbol;
    }
}

/**
 * An enumeration of the ranks of cards in a standard deck of playing cards.
 */
package org.multiplayercardgame.enums;

public enum Rank {
    /**
     * The Ace rank.
     */
    ACE("A"),
    /**
     * The Two rank.
     */
    TWO("2"),
    /**
     * The Three rank.
     */
    THREE("3"),
    /**
     * The Four rank.
     */
    FOUR("4"),
    /**
     * The Five rank.
     */
    FIVE("5"),
    /**
     * The Six rank.
     */
    SIX("6"),
    /**
     * The Seven rank.
     */
    SEVEN("7"),
    /**
     * The Eight rank.
     */
    EIGHT("8"),
    /**
     * The Nine rank.
     */
    NINE("9"),
    /**
     * The Ten rank.
     */
    TEN("10"),
    /**
     * The Jack rank.
     */
    JACK("J"),
    /**
     * The Queen rank.
     */
    QUEEN("Q"),
    /**
     * The King rank.
     */
    KING("K");

    /**
     * The symbol representing the rank on the face of a card.
     */
    private final String symbol;

    /**
     * Constructs a new Rank with the given symbol.
     *
     * @param symbol the symbol representing the rank on the face of a card
     */
    Rank(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol representing the rank on the face of a card.
     *
     * @return the symbol representing the rank on the face of a card
     */
    public String getSymbol() {
        return symbol;
    }
}

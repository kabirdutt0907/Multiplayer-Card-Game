/**
 * An enumeration of actions that can be performed in a multiplayer card game.
 */
package org.multiplayercardgame.enums;

public enum Action {
    /**
     * A skip action, indicating that the next player in turn order should be skipped.
     */
    SKIP,
    /**
     * A reverse action, indicating that the direction of turn order should be reversed.
     */
    REVERSE,
    /**
     * A plus-two action, indicating that the next player in turn order should draw two cards and skip their turn.
     */
    PLUS_TWO,
    /**
     * A plus-four action, indicating that the next player in turn order should draw four cards, skip their turn, and choose a new color.
     */
    PLUS_FOUR
}

package org.multiplayercardgame.models;

import org.multiplayercardgame.enums.Action;
import org.multiplayercardgame.enums.Rank;
import org.multiplayercardgame.enums.Suit;

public class Card {

    private Suit suit;

    private Rank rank;

    private boolean isAction;

    private Action action;

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public boolean isAction() {
        return isAction;
    }

    public void setAction(boolean action) {
        isAction = action;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                ", isAction=" + isAction +
                ", action=" + action +
                '}';
    }
}

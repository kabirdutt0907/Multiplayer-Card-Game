package org.multiplayercardgame.models;

import org.multiplayercardgame.exception.InvalidCardException;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private List<Card>hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public int getHandSize() {
        return hand.size();
    }

    public Card playCard(int index) {
        if (index < 0 || index >= hand.size()) {
            try {
                throw new InvalidCardException("Invalid card index : "+index);
            } catch (InvalidCardException e) {
                throw new RuntimeException(e);
            }
        }
        return hand.remove(index);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}

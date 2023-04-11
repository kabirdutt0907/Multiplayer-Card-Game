package org.multiplayercardgame.models;

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
    
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}

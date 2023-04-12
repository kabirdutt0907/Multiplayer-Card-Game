package org.multiplayercardgame.models;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Deck deck;

    private List<Card>discardPile;

    private List<Player>playerList;

    private int currentPlayerIndex;

    private int direction;

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List<Card> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(List<Card> discardPile) {
        this.discardPile = discardPile;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Game() {
        this.deck = new Deck();
        this.discardPile = new ArrayList<>();
        this.playerList = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.direction = 1;
    }

    @Override
    public String toString() {
        return "Game{" +
                "deck=" + deck +
                ", discardPile=" + discardPile +
                ", playerList=" + playerList +
                ", currentPlayerIndex=" + currentPlayerIndex +
                ", direction=" + direction +
                '}';
    }
    public void initializeDeck() {
        this.deck = new Deck();
    }
    public void shuffleDeck() {
        this.deck.shuffle();
    }
    public void addPlayer(Player player) {
        this.playerList.add(player);
    }
    
}

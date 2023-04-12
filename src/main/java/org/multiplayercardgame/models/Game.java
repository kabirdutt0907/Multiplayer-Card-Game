package org.multiplayercardgame.models;

import org.multiplayercardgame.implementation.PlayerUtilImpl;
import org.multiplayercardgame.utilities.IPlayerUtils;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Deck deck;

    private List<Card> discardPile;

    private List<Player> playerList;

    private int currentPlayerIndex;

    private int direction;

    private boolean isClockWise;

    public boolean isClockWise() {
        return isClockWise;
    }

    public void setClockWise(boolean clockWise) {
        isClockWise = clockWise;
    }

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
        this.isClockWise = true;
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

    private PlayerUtilImpl playerUtil = new PlayerUtilImpl();

    public void startGameWithPlayers(int numOfPlayers) {
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numOfPlayers; i++) {
            Player player = new Player("Player " + i);
            List<Card> playerCards = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                playerCards.add(deck.drawCard());
            }
            player.setHand(playerCards);
            playerUtil.displayPlayerInfo(player);
            players.add(player);
        }
        playerList = players;
    }

    public void addToDiscardPile(Card card) {
        this.discardPile.add(card);
    }

    public void removeFromDiscardPile(Card card) {
        this.discardPile.remove(card);
    }



    public Player skipNextPlayer(Game game, int skipCount) {
        System.out.println("Current Index : "+game.getCurrentPlayerIndex());
        System.out.println("Skip Index : "+skipCount);
        int nextPlayerIndex = game.getCurrentPlayerIndex() + (game.isClockWise ? skipCount : -skipCount);
        int numPlayers = game.getPlayerList().size();
        nextPlayerIndex = (nextPlayerIndex + numPlayers) % numPlayers;
        game.setCurrentPlayerIndex(nextPlayerIndex);
        return game.getPlayerList().get(nextPlayerIndex);
    }


}

package org.multiplayercardgame.implementation;

import org.multiplayercardgame.enums.Rank;
import org.multiplayercardgame.enums.Suit;
import org.multiplayercardgame.models.Card;
import org.multiplayercardgame.models.Player;
import org.multiplayercardgame.utilities.IPlayerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerUtilImpl implements IPlayerUtils {

    CardUtilsImpl cardUtils = new CardUtilsImpl();


    @Override
    public void displayPlayerInfo(Player player) {
        System.out.println("Player Name : "+player.getName());
        System.out.println("Hand of "+player.getName());
        for(Card card : player.getHand()){
            System.out.println("Card Name : "+card.getRank() + " of "+card.getSuit());
        }
    }


    @Override
    public Card playCard(Suit suit, Rank rank, List<Card> hand , Scanner scanner) {
        List<Card> playableCards = new ArrayList<>();



        // Find all cards that match either the suit or the rank of the top card
        for (Card card : hand) {

            if (card != null && (card.getSuit() == suit || card.getRank() == rank)) {
                playableCards.add(card);
            }
        }

        // If there are no playable cards, return null
        if (playableCards.isEmpty()) {
            return null;
        }

        // Ask the player to choose a card to play
        System.out.println("Choose a card to play:");
        for (int i = 0; i < playableCards.size(); i++) {
            System.out.println((i + 1) + ": " + cardUtils.getCardName(playableCards.get(i)));
        }
        int choice = scanner.nextInt();
        Card playedCard = playableCards.get(choice - 1);

        // Remove the played card from the player's hand
        hand.remove(playedCard);

        return playedCard;
    }
}

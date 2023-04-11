package org.multiplayercardgame.models;

import org.multiplayercardgame.enums.Action;
import org.multiplayercardgame.enums.Rank;
import org.multiplayercardgame.enums.Suit;
import org.multiplayercardgame.utilities.ICardUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cardList;

    public Deck(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    private ICardUtils cardUtils;

    public Deck() {
        this.cardList = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                if (cardUtils.checkIfActionCardOrNot(rank)) {
                    Action action = cardUtils.getCardAction(rank);
                    cardList.add(new Card(suit, rank, true, action));
                } else {
                    cardList.add(new Card(suit, rank, false, null));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cardList);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardList=" + cardList +
                '}';
    }

    public Card drawCard() {
        if (cardList.isEmpty()) {
            return null;
        }
        return cardList.remove(0);
    }

    public int cardsRemaining() {
        return cardList.size();
    }

}

package org.multiplayercardgame.implementation;

import org.multiplayercardgame.models.Card;
import org.multiplayercardgame.models.Game;
import org.multiplayercardgame.models.Player;
import org.multiplayercardgame.utilities.IGameUtils;

public class GameUtilsImpl implements IGameUtils {

    @Override
    public boolean isDiscardPileEmpty(Game game) {
        return game.getDeck().getCardList().isEmpty();
    }

    @Override
    public void addToDiscardPile(Game game, Player currentPlayer, Card card) {
        currentPlayer.removeCardFromHand(card);
        game.addToDiscardPile(card);
    }

    @Override
    public void addToHand(Game game, Player currentPlayer, Card card) {
        System.out.println("Recived Card : "+card.getRank() + " of " +card.getSuit());
        currentPlayer.addToHand(card);
        game.removeFromDiscardPile(card);
    }


}

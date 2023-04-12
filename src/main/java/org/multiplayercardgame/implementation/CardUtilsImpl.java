package org.multiplayercardgame.implementation;

import org.multiplayercardgame.enums.Action;
import org.multiplayercardgame.enums.Rank;
import org.multiplayercardgame.enums.Suit;
import org.multiplayercardgame.models.Card;
import org.multiplayercardgame.models.Game;
import org.multiplayercardgame.models.Player;
import org.multiplayercardgame.utilities.ICardUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardUtilsImpl implements ICardUtils {


    private GameUtilsImpl gameUtils = new GameUtilsImpl();


    @Override
    public boolean checkIfActionCardOrNot(Rank rank) {
        return (rank.equals(Rank.ACE) || rank.equals(Rank.JACK) || rank.equals(Rank.KING) || rank.equals(Rank.QUEEN));
    }

    @Override
    public Action getCardAction(Rank rank) {
        if (checkIfActionCardOrNot(rank)) {

            switch (rank.getSymbol()) {
                case "A":
                    return Action.SKIP;
                case "K":
                    return Action.REVERSE;
                case "Q":
                    return Action.PLUS_TWO;
                default:
                    return Action.PLUS_FOUR;
            }

        }
        return null;
    }

    @Override
    public String getCardName(Card card) {
        return card.getRank() + " of "+card.getSuit();
    }

    @Override
    public void handleQueenCard(Game game, Player currentPlayer) {
        Player nextPlayer = game.skipNextPlayer(game ,1);
        System.out.println("Next Player Name : "+nextPlayer.getName());
        Card drawnCard1 = game.getDeck().drawCard();
        Card drawnCard2 = game.getDeck().drawCard();
        System.out.println(currentPlayer.getName() + " played a Queen. "
                + nextPlayer.getName() + " drew " + drawnCard1 + " and " + drawnCard2);
        gameUtils.addToHand(game ,nextPlayer ,  drawnCard1 );
        gameUtils.addToHand(game , nextPlayer , drawnCard2);



    }

    @Override
    public void handleJackCard(Game game, Player currentPlayer) {
        int currentIndex = (game.getCurrentPlayerIndex() + (game.isClockWise() ? 1 : (-1 + game.getPlayerList().size())) ) % game.getPlayerList().size();
        Player nextPlayer = game.getPlayerList().get(currentIndex);
        System.out.println("Next Player Name : "+nextPlayer.getName());
        Card drawnCard1 = game.getDeck().drawCard();
        Card drawnCard2 = game.getDeck().drawCard();
        Card drawnCard3 = game.getDeck().drawCard();
        Card drawnCard4 = game.getDeck().drawCard();
        System.out.println("drawnCard3 : "+drawnCard3);
        System.out.println("drawnCard3 : "+drawnCard4);
        System.out.println(currentPlayer.getName() + " played a Jack. "
                + nextPlayer.getName() + " drew " + drawnCard1 + ", " + drawnCard2 + ",");
        gameUtils.addToHand(game ,nextPlayer ,  drawnCard1);
        gameUtils.addToHand(game , nextPlayer , drawnCard2);
        gameUtils.addToHand(game , nextPlayer , drawnCard3);
        gameUtils.addToHand(game , nextPlayer , drawnCard4);


    }


}

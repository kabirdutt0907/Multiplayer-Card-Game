package org.multiplayercardgame.utilities;

import org.multiplayercardgame.enums.Action;
import org.multiplayercardgame.enums.Rank;
import org.multiplayercardgame.enums.Suit;
import org.multiplayercardgame.models.Card;
import org.multiplayercardgame.models.Game;
import org.multiplayercardgame.models.Player;

import java.util.Scanner;

public interface ICardUtils {

    public boolean checkIfActionCardOrNot(Rank rank);

    public Action getCardAction(Rank rank);


    public String getCardName(Card card);

    public void handleQueenCard(Game game, Player currentPlayer);
    public void handleJackCard(Game game, Player currentPlayer);


}

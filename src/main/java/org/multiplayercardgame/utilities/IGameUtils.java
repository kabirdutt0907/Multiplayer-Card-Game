package org.multiplayercardgame.utilities;

import org.multiplayercardgame.models.Card;
import org.multiplayercardgame.models.Game;
import org.multiplayercardgame.models.Player;

public interface IGameUtils {

    public boolean isDiscardPileEmpty(Game game);

    public void addToDiscardPile(Game game, Player currentPlayer, Card card);

    public void addToHand(Game game, Player currentPlayer, Card card);

}

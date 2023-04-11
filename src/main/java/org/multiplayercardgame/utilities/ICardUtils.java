package org.multiplayercardgame.utilities;

import org.multiplayercardgame.enums.Action;
import org.multiplayercardgame.enums.Rank;

public interface ICardUtils {

    public boolean checkIfActionCardOrNot(Rank rank);

    public Action getCardAction(Rank rank);

}

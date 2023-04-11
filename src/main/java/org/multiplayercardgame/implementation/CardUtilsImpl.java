package org.multiplayercardgame.implementation;

import org.multiplayercardgame.enums.Action;
import org.multiplayercardgame.enums.Rank;
import org.multiplayercardgame.utilities.ICardUtils;

public class CardUtilsImpl implements ICardUtils {


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
}

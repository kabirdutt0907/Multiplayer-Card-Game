package org.multiplayercardgame.utilities;

import org.multiplayercardgame.enums.Rank;
import org.multiplayercardgame.enums.Suit;
import org.multiplayercardgame.models.Card;
import org.multiplayercardgame.models.Player;

import java.util.List;
import java.util.Scanner;

public interface IPlayerUtils {

    public void displayPlayerInfo(Player player);

    public Card playCard(Suit suit, Rank rank , List<Card>Hand , Scanner scanner);


}

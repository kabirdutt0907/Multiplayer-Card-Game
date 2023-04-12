package org.multiplayercardgame;

import org.multiplayercardgame.enums.Rank;
import org.multiplayercardgame.implementation.CardUtilsImpl;
import org.multiplayercardgame.implementation.GameUtilsImpl;
import org.multiplayercardgame.implementation.PlayerUtilImpl;
import org.multiplayercardgame.models.Card;
import org.multiplayercardgame.models.Game;
import org.multiplayercardgame.models.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players : ");
        int numOfPlayers = scanner.nextInt();


        Game game = new Game();

        CardUtilsImpl cardUtils = new CardUtilsImpl();

        PlayerUtilImpl playerUtil = new PlayerUtilImpl();

        GameUtilsImpl gameUtils = new GameUtilsImpl();

        game.initializeDeck();

        game.shuffleDeck();

        game.startGameWithPlayers(numOfPlayers);



        game.setCurrentPlayerIndex(0);

        Card firstCard = game.getDeck().drawCard();
        game.getDiscardPile().add(firstCard);

        boolean isGameFinished = false;

        while (!isGameFinished){
            System.out.println("Player Index :"+game.getCurrentPlayerIndex());
            Player currentPlayer = game.getPlayerList().get(game.getCurrentPlayerIndex());

            playerUtil.displayPlayerInfo(currentPlayer);
            System.out.println("Card on top of the discard Pile : "+ cardUtils.getCardName(game.getDiscardPile().get(game.getDiscardPile().size()-1)));

            Card topCard = game.getDiscardPile().get(game.getDiscardPile().size() - 1);
            Card playedCard = playerUtil.playCard(topCard.getSuit(), topCard.getRank() , currentPlayer.getHand() , scanner);

            System.out.println("Deck : "+game.getDeck());

            if(playedCard == null){
                Card drawCard = game.getDeck().drawCard();
                System.out.println("Drawn Card : "+drawCard);
                System.out.println("Player " + currentPlayer.getName() + " drew " + cardUtils.getCardName(drawCard));
                gameUtils.addToHand(game , currentPlayer , drawCard);
                if (gameUtils.isDiscardPileEmpty(game)) {
                    isGameFinished = true;
                    System.out.println("Draw pile is empty. Game ended in a draw.");
                }
            }
            else{
                System.out.println(currentPlayer.getName() + " played " + playedCard);
                gameUtils.addToDiscardPile(game , currentPlayer , playedCard);
                if(currentPlayer.getHand().isEmpty()){
                    isGameFinished = true;
                    System.out.println(currentPlayer.getName() + " has won the game!");
                }
                else{

                    Rank rank = game.getDiscardPile().get(game.getDiscardPile().size()-1).getRank();
                    switch (rank){

                        case ACE :
                            int nextIndex = game.getCurrentPlayerIndex();
                            if(game.isClockWise()){
                                nextIndex = (nextIndex + 2)%game.getPlayerList().size();
                            }
                            else{
                                if(nextIndex == 0){
                                    nextIndex = game.getPlayerList().size()-2;
                                }
                                else{
                                    nextIndex = nextIndex-2;
                                }
                            }
                            int currentIndex = nextIndex;
                            game.setCurrentPlayerIndex(currentIndex);
                            break;
                        case KING:
                            boolean newDirection = !game.isClockWise();
                            game.setClockWise(newDirection);
                            System.out.println("Before reversal Current Index : "+game.getCurrentPlayerIndex() + " "+game.isClockWise());
                            nextIndex = game.getCurrentPlayerIndex();
                            if(game.isClockWise()){
                                nextIndex = (nextIndex + 1)%game.getPlayerList().size();
                            }
                            else{
                                if(nextIndex == 0){
                                    nextIndex = game.getPlayerList().size()-1;
                                }
                                else{
                                    nextIndex = nextIndex-1;
                                }
                            }
                            currentIndex = nextIndex;

                            System.out.println("After reversal Current Index : "+game.getCurrentPlayerIndex());
                            game.setCurrentPlayerIndex(currentIndex);
                            break;

                        case QUEEN:
                            cardUtils.handleQueenCard(game , currentPlayer);
                            nextIndex = game.getCurrentPlayerIndex();
                            if(game.isClockWise()){
                                nextIndex = (nextIndex + 1)%game.getPlayerList().size();
                            }
                            else{
                                if(nextIndex == 0){
                                    nextIndex = game.getPlayerList().size()-1;
                                }
                                else{
                                    nextIndex = nextIndex-1;
                                }
                            }
                            currentIndex = nextIndex;
                            game.setCurrentPlayerIndex(currentIndex);
                            break;

                        case JACK:
                            cardUtils.handleJackCard(game , currentPlayer);
                            nextIndex = game.getCurrentPlayerIndex();
                            if(game.isClockWise()){
                                nextIndex = (nextIndex + 1)%game.getPlayerList().size();
                            }
                            else{
                                if(nextIndex == 0){
                                    nextIndex = game.getPlayerList().size()-1;
                                }
                                else{
                                    nextIndex = nextIndex-1;
                                }
                            }
                            currentIndex = nextIndex;
                            game.setCurrentPlayerIndex(currentIndex);


                        default:
                            nextIndex = game.getCurrentPlayerIndex();
                            if(game.isClockWise()){
                                nextIndex = (nextIndex + 1)%game.getPlayerList().size();
                            }
                            else{
                                if(nextIndex == 0){
                                    nextIndex = game.getPlayerList().size()-1;
                                }
                                else{
                                    nextIndex = nextIndex-1;
                                }
                            }
                            currentIndex = nextIndex;
                            game.setCurrentPlayerIndex(currentIndex);
                    }

                }
            }
        }





    }
}
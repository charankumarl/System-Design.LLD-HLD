package LowLevelDesign.LLDSnakeLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    public Game(){

        initializeGame();
    }

    private void initializeGame() {

        board = new Board(10, 5,4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {

        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        playersList.add(player1);
        playersList.add(player2);
    }

    public void startGame(){

        while(winner == null) {

            //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.id + " current position is: " + playerTurn.currentPosition);

            //roll the dice
            int diceNumbers = dice.rollDice();

            //get the new position
            int playerNewPosition = playerTurn.currentPosition + diceNumbers;

            playerNewPosition = jumpCheck(playerNewPosition);   // check for snake amd ladder.

            playerTurn.currentPosition = playerNewPosition;   // save the new position.

            System.out.println("player turn is:" + playerTurn.id + " new Position is: " + playerNewPosition);

            if(playerNewPosition >= board.cells.length * board.cells.length-1){  //check for winning condition

                winner = playerTurn;
            }
        }

        System.out.println("WINNER IS:" + winner.id);
    }


    private Player findPlayerTurn() {

        Player playerTurns = playersList.removeFirst();  // use queue also, so that we can get player in order.
        playersList.addLast(playerTurns);
        return playerTurns;
    }

    private int jumpCheck (int playerNewPosition) {

        if(playerNewPosition > board.cells.length * board.cells.length-1 ){  // 1. if cross 99, then return same position. win
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);   // get cell of new position. cell obj.

        if(cell.jump != null && cell.jump.start == playerNewPosition) {  // 2. if cell has jump, then jump to end of jump.

            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";

            System.out.println("jump done by: " + jumpBy);

            return cell.jump.end;   // return end of jump.
        }
        return playerNewPosition;   // if there is no snake or ladder, return same position.
    }
}

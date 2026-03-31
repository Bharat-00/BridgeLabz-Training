public class SnakeAndLadderProblem {
    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    static final int WINNING_POSITION = 100;
    // UC-2: Roll Die
    public static int rollDie() {
        return (int) (Math.random() * 6) + 1;
    }
    // UC-3: Check option
    public static int getOption() {
        return (int) (Math.random() * 3);
    }
    // UC-1 to UC-7 Execution
    public static void main(String[] args) {
        int player1Position = 0;
        int player2Position = 0;
        int diceCount = 0;
        int currentPlayer = 1;
        System.out.println("🎲 Welcome to Snake & Ladder Game");
        System.out.println("UC-1: Game started with two players at position 0");
        // UC-4: Repeat till someone wins
        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            int dieValue = rollDie();
            int option = getOption();
            diceCount++;
            System.out.println("\nDice Rolled: " + dieValue);
            if (currentPlayer == 1) {
                System.out.println("Player 1 Turn");
                int previousPosition = player1Position;
                switch (option) {
                    case NO_PLAY -> System.out.println("Option: No Play");
                    case LADDER -> {
                        System.out.println("Option: Ladder");
                        player1Position += dieValue;
                    }
                    case SNAKE -> {
                        System.out.println("Option: Snake");
                        player1Position -= dieValue;
                    }
                }
                // UC-5: Exact 100 condition
                if (player1Position > WINNING_POSITION) {
                    player1Position = previousPosition;
                }
                // UC-4: Position cannot be negative
                if (player1Position < 0) {
                    player1Position = 0;
                }
                System.out.println("Player 1 Position: " + player1Position);
                // UC-7: Ladder gives extra turn
                if (option != LADDER) {
                    currentPlayer = 2;
                }
            } else {
                System.out.println("Player 2 Turn");
                int previousPosition = player2Position;
                switch (option) {
                    case NO_PLAY -> System.out.println("Option: No Play");
                    case LADDER -> {
                        System.out.println("Option: Ladder");
                        player2Position += dieValue;
                    }
                    case SNAKE -> {
                        System.out.println("Option: Snake");
                        player2Position -= dieValue;
                    }
                }
                // UC-5: Exact 100 condition
                if (player2Position > WINNING_POSITION) {
                    player2Position = previousPosition;
                }
                // UC-4: Position cannot be negative
                if (player2Position < 0) {
                    player2Position = 0;
                }
                System.out.println("Player 2 Position: " + player2Position);
                // UC-7: Ladder gives extra turn
                if (option != LADDER) {
                    currentPlayer = 1;
                }
            }
        }
        // UC-7: Report Winner
        if (player1Position == WINNING_POSITION) {
            System.out.println("\n🏆 Player 1 WON the game!");
        } else {
            System.out.println("\n🏆 Player 2 WON the game!");
        }
        // UC-6: Dice count
        System.out.println("Total Dice Rolls: " + diceCount);
    }
}

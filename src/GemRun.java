import java.util.Scanner;
import java.lang.Math;

public class GemRun {

    public static void main(String[] args) {
        final int MAZE_SIZE = 20; // uneditable board size measurement

        // Scanner incantation
        Scanner input = new Scanner(System.in);

        // Ask user for player and gem positions
        // 'gem' is an int -1-19; if -1, randomize position
        // 'player' is an int -1-19; if -1, randomize position
        System.out.print("Enter 0-19 for gem position or -1 to randomize: ");
        int gem = input.nextInt();
        System.out.print("Enter 0-19 for player position or -1 to randomize: ");
        int player = input.nextInt();
        input.nextLine(); // Scanner incantation


        /* TODO: Initializing The Game
         * - Initialize the player and/or gem positions if user entered -1
         * - Print the starter board */
        if (gem == -1)
            gem = (int) (Math.random() * MAZE_SIZE);
        if (player == -1)
            player = (int) (Math.random() * MAZE_SIZE);

        //make sure gem and player do not start at the same point
        while (gem == player)
            gem = (int) (Math.random() * MAZE_SIZE);

        //print the start board

        for (int i = 0; i < MAZE_SIZE; i++) {
            if (i == player)
                System.out.print("P");
            else if (i == gem)
                System.out.print("*");
            else
                System.out.print("_");
        }
        System.out.println();








        /* TODO: Progressing The Game
         * - Ask for player input
         * - Update variables and print messages accordingly
         * - Print the updated board */

        while (player != gem) {
            System.out.print("Enter left or right to move: ");
            String direction = input.nextLine();

            if (direction.equalsIgnoreCase("left")) {
                player = Math.max(0, player-1); //ensure player does not move beyond left edge
            } else if (direction.equalsIgnoreCase("right")) {
                player = Math.min(MAZE_SIZE - 1, player + 1);
            } else {
                System.out.println("Invalid input. Please enter left or right.");
                continue; //ask for input again
            }





            //Print helpful message based on player and gem positions
            int distance = Math.abs(player-gem);
            if (distance >= 7) {
                System.out.println("Very cold!");
            } else if (distance == 1) {
                System.out.println("Very warm!");
            }



            //print the updated board
            for (int i = 0; i < MAZE_SIZE; i++) {
                if (i == player)
                    System.out.print("P");
                else if (i == gem)
                    System.out.print("*");
                else
                    System.out.print("_");
            }
            System.out.println();






        }



        /* TODO: Ending The Game
         * - Print the final board
         * - Print the victory message */

        System.out.print("Found the gem!");
        for (int i =0; i < MAZE_SIZE; i++) {
            if (i == gem)
                System.out.print("*");
            else
                System.out.print("_");
        }
        System.out.println();




        // Scanner incantation finish
        input.close();
    }
}
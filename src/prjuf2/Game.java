package prjuf2;

import java.util.Scanner;

public class Game {
    /**
     * Executa el main.
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.beginning();
    }

    /**
     * Executa el programa.
     */
    public void beginning() {
        Scanner in = new Scanner(System.in);
        String[] menu = {
                "\t       MENU",
                "1. Create a random board", "2. Create an empty board", "3. Add sick people      ", "4. Pass on the virus    ",
                "5. Heal sick people     ", "6. Move sick people    ", "7. Show information     ", "8. Pre made Board        ", "9. COVID-19 Information", "0. Quit                 "
        };
        int option;
        String[] data = new String[4];
        BoardManager g = new BoardManager();
        Board t = new Board();
        Interficie.showMenu(menu);
        option = Utils.validateInt(t, "v1", "Select '1', '2', '8' or '9' to start the game", "You must enter a numeric value",
                "You must enter '0' , '1', '2', '8' or '9'", 0, 0);
        while (option != 0) {
            switch (option) {
                case 1 -> {
                    Interficie.showHeader("You have selected create a random board");
                    g.loadRandom(t);
                    System.out.println(t.toString());
                }
                case 2 -> {
                    Interficie.showHeader("You have selected create an empty board");
                    g.loadEmpty(t);
                    System.out.println(t.toString());
                }
                case 3 -> {
                    Interficie.showHeader("You have selected add sick people");
                    g.addSickPeople(t);
                }
                case 4 -> {
                    Interficie.showHeader("You have selected pass on the virus");
                    g.transmitVirus(t);
                }
                case 5 -> {
                    Interficie.showHeader("You have selected heal sick people");
                    g.healSickPeople(t);
                    if (BoardManager.sumArray(t) != 0) {
                        Interficie.showMessage(t.toString());
                    }
                }
                case 6 -> {
                    Interficie.showHeader("You have selected move sick people");
                    g.moveSickPeople(t);
                }
                case 7 -> {
                    Interficie.showHeader("Show information");
                    Interficie.showData(t, g, data);
                    System.out.println();
                    System.out.println(t.toString());
                }
                case 8 -> {
                    Interficie.showHeader("You have selected play with a created Board");
                    BoardManager.readBoards();
                    BoardManager.readBoards2(t);
                }
                case 9 -> {
                    Interficie.showHeader("Downloading information...");
                    Api.main();
                }
            }
            Interficie.showMenu(menu);
            option = Utils.validateInt(t, "menu", "Select an option", "Please enter a numeric value", "Please enter one of the following menu numbers", 0, 0);
        }
        Interficie.redMessage("GAME OVER");

    }
}
package prjuf2;

public class Interficie {

    public static final String red = "\u001B[31m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36m";
    public static final String reset = "\u001B[0m";

    /**
     * L'utilitzem per a donar color al printat.
     *
     * @param message printa en color el missatge que entri.
     */
    public static void redMessage(String message) {
        System.out.println(red + message + reset);
    }

    public static void purpleMessage(String message) {
        System.out.println(purple + message + reset);
    }

    public static void yellowMessage(String message) {
        System.out.println(yellow + message + reset);
    }

    public static void cyanMessage(String message) {
        System.out.println(cyan + message + reset);
    }

    public static void blueMessage(String message) {
        System.out.println(blue + message + reset);
    }

    /**
     * L'utilitzem per a donar color al printat.
     *
     * @param message printa en color el missatge que entri i retorna el missatge.
     */
    public static String purpleMessageReturn(String message) {
        return (purple + message + reset);
    }

    public static String blueMessageReturn(String message) {
        return (blue + message + reset);
    }

    /**
     * L'utilitzem per a mostrar l'estat actual del taulell.
     *
     * @param t     l'utilitzem per a comparar les posicions del taulell.
     * @param g     l'utilitzem per a accedir a variables que es troben a la classe BoardManager.
     * @param dades l'utilitzem per enmagatzemar les dades de la informació del taulell.
     */
    public static void showData(Board t, BoardManager g, String[] dades) {
        if (BoardManager.sumArray(t) > 0) {
            dades[0] = "Current number of sick people: " + BoardManager.sumArray(t);
            dades[1] = "Total number of healed people: " + g.healedPersons;
            dades[2] = "Percentage that did not complete the confinement: " + BoardManager.sumMovedPeople(g.movedPeople, g.sickTotal) + "%";
            dades[3] = "Total number of runaway people: " + g.runawayPeople;
            for (int i = 0; i < 4; i++) {
                yellowMessage(dades[i]);
            }
            BoardManager.getDate();
            BoardManager.getInfo(dades[0],dades[1],g.sickTotal);
            BoardManager.getBoardStatus(t);
        } else {
            Interficie.redMessage("You may introduce some sick people first");
        }

    }

    /**
     * Mostra per pantalla les diferents opcions que formen el menú
     * que es rep com a paràmetre. La primera posició de l'array menú és el
     * títol del mateix mentre que la resta són les opcions. Aquesta variable
     * ja ve inicialitzada des del codi que en fa la crida.
     *
     * @param menu Conté les diferents opcions que es mostraran per pantalla a
     *             l'usuari.
     */
    public static void showMenu(String[] menu) {
        blueMessage(menu[0]);
        purpleMessage("* * * * * * * * * * * * * * *");
        for (int i = 1; i < menu.length; i++) {
            purpleMessage("* " + (blueMessageReturn(menu[i])) + purpleMessageReturn("\t*"));
        }
        purpleMessage("* * * * * * * * * * * * * * *");
    }

    /**
     * Mostra la informació per pantalla de forma simple
     *
     * @param missatge Missatge a mostrar per pantalla
     */
    public static void showMessage(String missatge) {

        System.out.println(missatge);
    }


    /**
     * Mostra la informació per pantalla en format capçalera
     *
     * @param missatge Missatge a mostrar per pantalla en format capçalera
     */
    public static void showHeader(String missatge) {

        yellowMessage("-------------------------------------------------");
        cyanMessage(missatge);
        yellowMessage("-------------------------------------------------");
    }

}

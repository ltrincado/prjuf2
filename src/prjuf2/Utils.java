package prjuf2;

import java.util.Scanner;

public class Utils {
    /**
     * És una validació d'enters amb diferents opcions.
     *
     * @param t               l'utilitzem per a comparar posicions del taulell.
     * @param v1              l'utilitzem per especificar l'opció que volem.
     * @param message         mostra el missatge d'entrada.
     * @param errorIntMessage mostra el missatge d'error per validació d'enter.
     * @param error0Message   mostra el missatge d'error per validació de rang.
     * @param x               l'utilitzem per comparar-la amb altres posicions el taulell.
     * @param y               l'utilitzem per comparar-la amb altres posicions el taulell.
     */
    public static int validateInt(Board t, String v1, String message, String errorIntMessage, String error0Message, int x, int y) {

        Scanner scanner = new Scanner(System.in);
        int ret = 0;
        boolean correct;
        boolean validateLimits = false;
        while (!validateLimits) {
            do {
                Interficie.purpleMessage(message);
                correct = scanner.hasNextInt();
                if (!correct) {
                    scanner.next();
                    Interficie.redMessage(errorIntMessage);
                }
            } while (!correct);
            ret = scanner.nextInt();
            scanner.nextLine();
            validateLimits = true;
            switch (v1) {
                case "v":
                    if (ret < 0 || ret > 1) {
                        Interficie.redMessage(error0Message);
                        validateLimits = false;
                    }
                    break;
                case "v1":
                    if (ret < 0 || ret > 2 && ret !=8 && ret!=9) {
                        Interficie.redMessage(error0Message);
                        validateLimits = false;
                    }
                    break;
                case "f":
                    if (ret - 1 < 0 || ret - 1 >= t.getRows()) {
                        Interficie.redMessage(error0Message);
                        validateLimits = false;
                    }
                    break;
                case "c":
                    if (ret - 1 < 0 || ret - 1 >= t.getColumns()) {
                        Interficie.redMessage(error0Message);
                        validateLimits = false;
                    }
                    break;
                case "m":
                    if (ret == 0 || ret < -1) {
                        Interficie.redMessage(error0Message);
                        validateLimits = false;
                    }
                    break;
                case "z":
                    if (ret <= 0 || ret > (int) t.getPosition(x,y)) {
                        Interficie.redMessage(error0Message);
                        validateLimits = false;
                    }
                    break;
                case "menu":
                    if (ret < 0 || ret > 10) {
                        Interficie.redMessage(error0Message);
                        validateLimits = false;
                    }
                    break;
            }
        }
        return ret;
    }

    /**
     * És una validació de floats.
     *
     * @param message           mostra el missatge d'entrada.
     * @param errorFloatMessage mostra el missatge d'error per validació de floats.
     * @param error0Message     mostra el missatge d'error per validació de rang.
     */
    public static float validateFloat(String message, String errorFloatMessage, String error0Message) {
        Scanner scanner = new Scanner(System.in);
        float ret = 0;
        boolean correct;
        boolean validateLimits = false;
        while (!validateLimits) {
            do {
                Interficie.purpleMessage(message);
                correct = scanner.hasNextFloat();
                if (!correct) {
                    scanner.next();
                    Interficie.redMessage(errorFloatMessage);
                }
            } while (!correct);
            ret = scanner.nextFloat();
            scanner.nextLine();
            validateLimits = true;
            if (ret <= 0) {
                Interficie.redMessage(error0Message);
                validateLimits = false;
            }
        }
        return ret;
    }

    /**
     * Valida les posicions a l'hora de curar, desplaçar malalts, etc.
     *
     * @param message            mostra el missatge d'entrada.
     * @param errorStringMessage mostra el missatge d'error per validació de Strings.
     */
    public static String validateMove(String message, String errorStringMessage) {
        Scanner scanner = new Scanner(System.in);
        String ret = "";
        boolean correct;
        boolean validateChar = false;
        while (!validateChar) {
            do {
                Interficie.purpleMessage(message);
                correct = scanner.hasNext();
            } while (!correct);
            ret = scanner.next().toLowerCase();
            scanner.nextLine();
            if (ret.equals("q") || ret.equals("w") || ret.equals("e") || ret.equals("a")
                    || ret.equals("d") || ret.equals("z") || ret.equals("x") || ret.equals("c")) {
                validateChar = true;
            } else {
                Interficie.redMessage(errorStringMessage);
                validateChar = false;
            }
        }
        return ret;
    }
}

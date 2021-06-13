package prjuf2;

public class Board {

    private int rows;
    private int columns;
    private float[][] t;

    /**
     * L'utilitzem per obtenir el valor de les files del taulell.
     */
    public int getRows() {
        return rows;
    }

    /**
     * L'utilitzem per donar valor a les files del taulell.
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * L'utilitzem per obtenir el valor de les columnes del taulell.
     */
    public int getColumns() {
        return columns;
    }

    /**
     * L'utilitzem per donar valor a les columnes del taulell.
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * L'utilitzem per donar valors a una posició concreta del taulell.
     *
     * @param i     l'utilitzem per donar la posició de les files.
     * @param j     l'utilitzem per donar la posició de les columnes.
     * @param value l'utilitzem per assignar valor a la posició donada anteriorment.
     */
    public void setPosition(int i, int j, float value) {

        this.t[i][j] = value;
    }
    public void increasePosition(int x, int y, int numberSickPeople){
        t[x][y] += numberSickPeople;
    }
    public void decreasePosition(int x, int y, int numberSickPeople){
        t[x][y] -= numberSickPeople;
    }
    public float getPosition(int x, int y){
        return t[x][y];
    }
    public void setPositionTax(int i, int j, float tax) {

        this.t[i][j] = t[i][j] * tax;
    }

    /**
     * L'utilitzarem per a crear el taulell aleatori.
     */
    public void createRandomBoard() {
        this.t = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int random = (int) (Math.random() * (1 - 13) + 10);
                if (random < 0) {
                    t[i][j] = -1;
                } else {
                    t[i][j] = random;
                }


            }
        }
    }

    /**
     * L'utilitzarem per a crear el taulell buit.
     */
    public void createEmptyBoard() {
        this.t = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                t[i][j] = 0;
            }
        }
    }
    public void updateBoard(String[]values) {
        this.t = new float[5][5];
        for (int r = 0; r < values.length; r++){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    t[i][j] = Float.parseFloat(values[r]);
                }
            }
        }
    }

    /**
     * L'utilitzem pel printat del taulell.
     */
    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (t[i][j] == -1) {
                    cad.append(Interficie.red + "X\t" + Interficie.reset);
                } else {
                    cad.append(Interficie.yellow).append((int) t[i][j]).append("\t").append(Interficie.reset);
                }
            }
            cad.append("\n");
        }
        return cad.toString();
    }
    public String toStringNoColor() {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (t[i][j] == -1) {
                    cad.append("X\t");
                } else {
                    cad.append((int) t[i][j]).append("\t");
                }
            }
            cad.append("\n");
        }
        return cad.toString();
    }

    public void healSicks(float percentage){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (t[i][j] > 0) {
                    t[i][j]*=(100-percentage)/100;
                }
            }
        }
    }
    public void healSicksSV (int x, int y, int specificallyValue){
        if (t[x][y] > 0) {
            t[x][y] = t[x][y] - specificallyValue;
        }
    }
}
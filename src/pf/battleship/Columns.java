package pf.battleship;

public enum Columns {
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I,
    J;

    public static Columns fromInt(int i) {
        switch (i) {
            case 0:
                return A;
            case 1:
                return B;
            case 2:
                return C;
            case 3:
                return D;
            case 4:
                return E;
            case 5:
                return F;
            case 6:
                return G;
            case 7:
                return H;
            case 8:
                return I;
            case 9:
                return J;
            default:
                return null;
        }
    }

    public static int toInt(Columns c) {
        switch (c) {
            case A:
                return 0;
            case B:
                return 1;
            case C:
                return 2;
            case D:
                return 3;
            case E:
                return 4;
            case F:
                return 5;
            case G:
                return 6;
            case H:
                return 7;
            case I:
                return 8;
            case J:
                return 9;
            default:
                return -1;
        }
    }

    public static Columns fromString(String s) {
        switch (s) {
            case "A":
                return A;
            case "B":
                return B;
            case "C":
                return C;
            case "D":
                return D;
            case "E":
                return E;
            case "F":
                return F;
            case "G":
                return G;
            case "H":
                return H;
            case "I":
                return I;
            case "J":
                return J;
            default:
                return null;
        }
    }
}

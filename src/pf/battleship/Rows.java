package pf.battleship;

public enum Rows {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN;


    public static Rows fromInt(int i) {
        switch (i) {
            case 0:
                return ONE;
            case 1:
                return TWO;
            case 2:
                return THREE;
            case 3:
                return FOUR;
            case 4:
                return FIVE;
            case 5:
                return SIX;
            case 6:
                return SEVEN;
            case 7:
                return EIGHT;
            case 8:
                return NINE;
            case 9:
                return TEN;
            default:
                return null;
        }
    }

    public static int toInt(Rows r) {
        switch (r) {
            case ONE:
                return 0;
            case TWO:
                return 1;
            case THREE:
                return 2;
            case FOUR:
                return 3;
            case FIVE:
                return 4;
            case SIX:
                return 5;
            case SEVEN:
                return 6;
            case EIGHT:
                return 7;
            case NINE:
                return 8;
            case TEN:
                return 9;
            default:
                return -1;
        }
    }

    public static Rows fromString(String s) {
        switch (s) {
            case "1":
                return ONE;
            case "2":
                return TWO;
            case "3":
                return THREE;
            case "4":
                return FOUR;
            case "5":
                return FIVE;
            case "6":
                return SIX;
            case "7":
                return SEVEN;
            case "8":
                return EIGHT;
            case "9":
                return NINE;
            case "10":
                return TEN;
            default:
                return null;
        }
    }
}

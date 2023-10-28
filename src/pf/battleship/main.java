package pf.battleship;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Player player = new Player(getName());
        placeShips(player);
        player.printBoard();
        start(player);
    }

    public static void turn(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Where would you like to shoot?");
        System.out.println("Please enter the column and row of the cell you would like to shoot (e.g. A1).");
        String res = scanner.nextLine();
        Location location = new Location(Columns.fromString(res.substring(0, 1)), Rows.fromString(res.substring(1)));
        player.shoot(location);
    }

    public static void start(Player player) {
        while(!player.lost()) {
            turn(player);
            player.checkShips();
            player.sinkShips();
            player.printBoard();
        }
    }

    public static String getName() {
        String name = "Player";
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        return name;
    }

    public static void placeShips(Player player) {
        Scanner scanner = new Scanner(System.in);
        boolean placed5Ship = false;
        boolean placed4Ship = false;
        boolean placed3Ship = false;
        boolean placed2Ship = false;
        boolean placed1Ship = false;
        while(!placed5Ship) {
            System.out.println("Where would you like to place your 5 cell ship?");
            System.out.println("Please enter the column and row of the first cell of the ship (e.g. A1).");
            String res1 = scanner.nextLine();
            Location location1 = new Location(Columns.fromString(res1.substring(0, 1)), Rows.fromString(res1.substring(1)));
            System.out.println("Please enter the column and row of the last cell of the ship (e.g. A1).");
            String res2 = scanner.nextLine();
            Location location2 = new Location(Columns.fromString(res2.substring(0, 1)), Rows.fromString(res2.substring(1)));
            placed5Ship = player.add5Ship(location1, location2);
        }
        while (!placed4Ship) {
            System.out.println("Where would you like to place your 4 cell ship?");
            System.out.println("Please enter the column and row of the first cell of the ship (e.g. A1).");
            String res1 = scanner.nextLine();
            Location location1 = new Location(Columns.fromString(res1.substring(0, 1)), Rows.fromString(res1.substring(1)));
            System.out.println("Please enter the column and row of the last cell of the ship (e.g. A1).");
            String res2 = scanner.nextLine();
            Location location2 = new Location(Columns.fromString(res2.substring(0, 1)), Rows.fromString(res2.substring(1)));
            placed4Ship = player.add4Ship(location1, location2);
        }
        while (!placed3Ship) {
            System.out.println("Where would you like to place your 3 cell ship?");
            System.out.println("Please enter the column and row of the first cell of the ship (e.g. A1).");
            String res1 = scanner.nextLine();
            Location location1 = new Location(Columns.fromString(res1.substring(0, 1)), Rows.fromString(res1.substring(1)));
            System.out.println("Please enter the column and row of the last cell of the ship (e.g. A1).");
            String res2 = scanner.nextLine();
            Location location2 = new Location(Columns.fromString(res2.substring(0, 1)), Rows.fromString(res2.substring(1)));
            placed3Ship = player.add3Ship(location1, location2);
        }
        while(!placed2Ship) {
            System.out.println("Where would you like to place your 2 cell ship?");
            System.out.println("Please enter the column and row of the first cell of the ship (e.g. A1).");
            String res1 = scanner.nextLine();
            Location location1 = new Location(Columns.fromString(res1.substring(0, 1)), Rows.fromString(res1.substring(1)));
            System.out.println("Please enter the column and row of the last cell of the ship (e.g. A1).");
            String res2 = scanner.nextLine();
            Location location2 = new Location(Columns.fromString(res2.substring(0, 1)), Rows.fromString(res2.substring(1)));
            placed2Ship = player.add2Ship(location1, location2);
        }
        while (!placed1Ship) {
            System.out.println("Where would you like to place your 1 cell ship?");
            System.out.println("Please enter the column and row of the ship (e.g. A1).");
            String res1 = scanner.nextLine();
            Location location1 = new Location(Columns.fromString(res1.substring(0, 1)), Rows.fromString(res1.substring(1)));
            placed1Ship = player.add1Ship(location1, location1);
        }
    }

    public static void printBoard(Board board) {
        System.out.println("  A B C D E F G H I J");
        for(int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for(int j = 0; j < 10; j++) {
                Location location = new Location(Columns.fromInt(j), Rows.fromInt(i));
                State state = board.getState(location);
                switch(state) {
                    case WATER:
                        System.out.print("~ ");
                        break;
                    case SHIP:
                        System.out.print("O ");
                        break;
                    case HIT:
                        System.out.print("X ");
                        break;
                    case SUNK:
                        System.out.print("X ");
                        break;
                    case HIDDEN:
                        System.out.print("~ ");
                        break;
                }
            }
            System.out.println();
        }
    }
}

package pf.battleship;

public class Board {
    private Cell[][] board;

    public Board() {
        this.board = new Cell[10][10];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                this.board[i][j] = new Cell(new Location(Columns.fromInt(j), Rows.fromInt(i)));
            }
        }
    }

    public Board(Cell[][] board) {
        this.board = board;
    }

    public Cell[][] getBoard() {
        return this.board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public void setCell(Location location, Cell cell) {
        cell.setLocation(location);
        this.board[location.getRowNumber()][location.getColumnNumber()] = cell;
    }

    public void addShip(Ship ship) {
        Location[] locations = ship.getLocations();
        for (Location location : locations) {
            this.board[location.getRowNumber()][location.getColumnNumber()].setShip(true);
        }
    }

    public void shoot(Location location) {
        this.board[location.getRowNumber()][location.getColumnNumber()].shoot();
    }

    public State getState(Location location) {
        return this.board[location.getRowNumber()][location.getColumnNumber()].getState();
    }

    public void sinkShip(Ship ship) {
        Location[] locations = ship.getLocations();
        for (Location location : locations) {
            this.board[location.getRowNumber()][location.getColumnNumber()].sink();
        }
    }

    public boolean ShipSunk(Ship ship) {
        Location[] locations = ship.getLocations();
        for (Location location : locations) {
            if (this.board[location.getRowNumber()][location.getColumnNumber()].getState() != State.HIT) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < this.board.length; i++) {
            System.out.print(Rows.fromInt(i) + " ");
            for (int j = 0; j < this.board[0].length; j++) {
                System.out.print(this.board[i][j].getState().toString() + " ");
            }
            System.out.println();
        }
    }
}

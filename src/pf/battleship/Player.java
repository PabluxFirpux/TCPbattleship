package pf.battleship;

import java.util.ArrayList;

public class Player {
    private Board board;
    private ArrayList<Ship> ships;
    private String name;

    private boolean[] sizes = {false, false, false, false, false};

    public Player() {
        this.name = "Player";
        this.board = new Board();
        this.ships = new ArrayList<Ship>();
    }

    public Player(String name) {
        this.name = name;
        this.board = new Board();
        this.ships = new ArrayList<Ship>();
    }

    public String getName() {
        return this.name;
    }

    public boolean lost() {
        for(Ship ship: this.ships) {
            if(!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAllShips() {
        for (Ship ship : this.ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public boolean ready() {
        return this.ships.size() == 5;
    }

    public void addShip(Ship ship) {
        if(!this.sizes[ship.getLength() - 1]) {
            if(this.ships.size() < 5 && legalShip(ship)) {
                this.ships.add(ship);
                this.board.addShip(ship);
                this.sizes[ship.getLength() - 1] = true;
            }
        } else {
            System.out.println("You already have a ship of that size.");
        }
    }

    public boolean legalShip(Ship ship) {
        for(Ship s: this.ships) {
            if(s.isAdjacent(ship) || s.isOverlapping(ship)) {
                System.out.println("You cannot place a ship there.");
                return false;
            }
        }
        System.out.println("Ship placed.");
        return true;
    }

    public void checkShips() {
        for(Ship ship: this.ships) {
            if(board.ShipSunk(ship)) {
                ship.setSunk(true);
            }
        }
    }

    public void sinkShips() {
        for(Ship ship: this.ships) {
            if(ship.isSunk()) {
                this.board.sinkShip(ship);
            }
        }
    }

    public void shoot(Location location) {
        this.board.shoot(location);
    }

    public State getState(Location location) {
        return this.board.getState(location);
    }

    public void printBoard() {
        this.board.printBoard();
    }

    public boolean add5Ship(Location loc1, Location loc2) {
        if(loc1.getRow() == loc2.getRow() && Math.abs(Columns.toInt(loc1.getColumn()) - Columns.toInt(loc2.getColumn())) == 4) {
            addShip(new Ship(5, loc1, loc2));
            return true;
        } else if (loc1.getColumn() == loc2.getColumn() && Math.abs(Rows.toInt(loc1.getRow()) - Rows.toInt(loc2.getRow())) == 4) {
            addShip(new Ship(5, loc1, loc2));
            return true;
        } else {
            System.out.println("Invalid ship placement.");
            return false;
        }
    }

    public boolean add4Ship(Location loc1, Location loc2) {
        if(loc1.getRow() == loc2.getRow() && Math.abs(Columns.toInt(loc1.getColumn()) - Columns.toInt(loc2.getColumn())) == 3) {
            addShip(new Ship(4, loc1, loc2));
            return true;
        } else if (loc1.getColumn() == loc2.getColumn() && Math.abs(Rows.toInt(loc1.getRow()) - Rows.toInt(loc2.getRow())) == 3) {
            addShip(new Ship(4, loc1, loc2));
            return true;
        } else {
            System.out.println("Invalid ship placement.");
            return false;
        }
    }

    public boolean add3Ship(Location loc1, Location loc2) {
        if(loc1.getRow() == loc2.getRow() && Math.abs(Columns.toInt(loc1.getColumn()) - Columns.toInt(loc2.getColumn())) == 2) {
            addShip(new Ship(3, loc1, loc2));
            return true;
        } else if (loc1.getColumn() == loc2.getColumn() && Math.abs(Rows.toInt(loc1.getRow()) - Rows.toInt(loc2.getRow())) == 2) {
            addShip(new Ship(3, loc1, loc2));
            return true;
        } else {
            System.out.println("Invalid ship placement.");
            return false;
        }
    }

    public boolean add2Ship(Location loc1, Location loc2) {
        if(loc1.getRow() == loc2.getRow() && Math.abs(Columns.toInt(loc1.getColumn()) - Columns.toInt(loc2.getColumn())) == 1) {
            addShip(new Ship(2, loc1, loc2));
            return true;
        } else if (loc1.getColumn() == loc2.getColumn() && Math.abs(Rows.toInt(loc1.getRow()) - Rows.toInt(loc2.getRow())) == 1) {
            addShip(new Ship(2, loc1, loc2));
            return true;
        } else {
            System.out.println("Invalid ship placement.");
            return false;
        }
    }

    public boolean add1Ship(Location loc1, Location loc2) {
        if(loc1.getRow() == loc2.getRow() && Math.abs(Columns.toInt(loc1.getColumn()) - Columns.toInt(loc2.getColumn())) == 0) {
            addShip(new Ship(1, loc1, loc2));
            return true;
        } else if (loc1.getColumn() == loc2.getColumn() && Math.abs(Rows.toInt(loc1.getRow()) - Rows.toInt(loc2.getRow())) == 0) {
            addShip(new Ship(1, loc1, loc2));
            return true;
        } else {
            System.out.println("Invalid ship placement.");
            return false;
        }
    }
}

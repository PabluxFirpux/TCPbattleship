package pf.battleship;

public class Ship {
    private int length;
    private Location[] locations;
    private boolean isSunk;

    public Ship(int length, Location loc1, Location loc2) {
        this.locations = new Location[length];
        this.length = length;
        processLocations(loc1, loc2);
        this.isSunk = false;
    }

    private void processLocations(Location loc1, Location loc2) {
        int row1 = loc1.getRowNumber();
        int row2 = loc2.getRowNumber();
        int col1 = loc1.getColumnNumber();
        int col2 = loc2.getColumnNumber();

        if (row1 == row2) {
            if (col1 < col2) {
                for (int i = 0; i < this.length; i++) {
                    this.locations[i] = new Location(Columns.fromInt(col1 + i), Rows.fromInt(row1));
                }
            } else {
                for (int i = 0; i < this.length; i++) {
                    this.locations[i] = new Location(Columns.fromInt(col1 - i), Rows.fromInt(row1));
                }
            }
        } else if (col1 == col2) {
            if (row1 < row2) {
                for (int i = 0; i < this.length; i++) {
                    this.locations[i] = new Location(Columns.fromInt(col1), Rows.fromInt(row1 + i));
                }
            } else {
                for (int i = 0; i < this.length; i++) {
                    this.locations[i] = new Location(Columns.fromInt(col1), Rows.fromInt(row1 - i));
                }
            }
        }
    }

    public int getLength() {
        return this.length;
    }

    public Location[] getLocations() {
        return this.locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }

    public boolean isSunk() {
        return this.isSunk;
    }

    public void setSunk(boolean isSunk) {
        this.isSunk = isSunk;
    }

    public boolean isHit(Location location) {
        for (Location loc : this.locations) {
            if (loc.equals(location)) {
                return true;
            }
        }
        return false;
    }

    public void sink() {
        this.isSunk = true;
    }

    public boolean isAt(Location location) {
        for (Location loc : this.locations) {
            if (loc.equals(location)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdjacent(Location location) {
        for (Location loc : this.locations) {
            if (loc.getRowNumber() == location.getRowNumber() && Math.abs(loc.getColumnNumber() - location.getColumnNumber()) == 1) {
                return true;
            }
            if (loc.getColumnNumber() == location.getColumnNumber() && Math.abs(loc.getRowNumber() - location.getRowNumber()) == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdjacent(Ship ship) {
        for (Location loc : this.locations) {
            for (Location loc2 : ship.locations) {
                if (loc.getRowNumber() == loc2.getRowNumber() && Math.abs(loc.getColumnNumber() - loc2.getColumnNumber()) == 1) {
                    return true;
                }
                if (loc.getColumnNumber() == loc2.getColumnNumber() && Math.abs(loc.getRowNumber() - loc2.getRowNumber()) == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isOverlapping(Ship ship) {
        for (Location loc : this.locations) {
            for (Location loc2 : ship.locations) {
                if (loc.equals(loc2)) {
                    return true;
                }
            }
        }
        return false;
    }
}

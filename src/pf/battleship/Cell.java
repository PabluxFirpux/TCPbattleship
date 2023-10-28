package pf.battleship;

public class Cell {
    private State state;
    private boolean isShip;

    private Location location;

    public Cell() {
        this.state = State.WATER;
        this.isShip = false;
    }

    public Cell(boolean isShip) {
        this.isShip = isShip;
        this.state = (isShip ? State.SHIP : State.WATER);
    }
    public Cell(Location location) {
        this.location = location;
        this.state = State.WATER;
        this.isShip = false;
    }

    public Cell(Location location, boolean isShip) {
        this.location = location;
        this.isShip = isShip;
        this.state = (isShip ? State.SHIP : State.WATER);
    }

    public State getState() {
        return this.state;
    }

    public void shoot() {
        if (this.state == State.SHIP) {
            this.state = State.HIT;
        }
    }

    public boolean isShip() {
        return this.isShip;
    }

    public void setShip(boolean isShip) {
        this.isShip = isShip;
        this.state = (isShip ? State.SHIP : State.WATER);
    }

    public void sink() {
        if (this.state == State.HIT) {
            this.state = State.SUNK;
        }
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

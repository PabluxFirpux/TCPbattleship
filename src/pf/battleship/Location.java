package pf.battleship;

public class Location {
    private Rows row;
    private Columns column;

    public Location(Columns column, Rows row) {
        this.row = row;
        this.column = column;
    }

    public Rows getRow() {
        return row;
    }

    public void setRow(Rows row) {
        this.row = row;
    }

    public Columns getColumn() {
        return column;
    }

    public void setColumn(Columns column) {
        this.column = column;
    }

    public boolean equals(Location other) {
        return this.row == other.row && this.column == other.column;
    }

    public int getRowNumber() {
        return Rows.toInt(this.row);
    }

    public int getColumnNumber() {
        return Columns.toInt(this.column);
    }
}

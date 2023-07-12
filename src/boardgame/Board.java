package boardgame;

public class Board {
    private int rows, columns;
    private Piece[][] pieces;

    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public void setRows(int rows){
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }

    public void setColumns(int columns){
        this.columns = columns;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        return pieces[row][column];
    }

    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }
}

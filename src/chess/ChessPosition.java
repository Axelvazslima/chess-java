package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row){
        if(column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Invalid move. Valid ones are from 'a1' to 'h8'.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return this.column;
    }

    public int getRow(){
        return this.row;
    }

    protected Position toPosition(){
        return new Position(8 - this.row, this.column - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString(){
        return String.format("%c%d", this.column, this.row);
    }
}

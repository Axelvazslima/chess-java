package boardgame;

public class Position {

    private int row, column;

    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    public void setRow(int row){
        this.row = row;
    }
    public int getRow(){
        return this.row;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public int getColumn(){
        return this.column;
    }

    @Override
    public String toString(){
        return String.format("Row: %d, Column: %d", this.row, this.column);
    }
}

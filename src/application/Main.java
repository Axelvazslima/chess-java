package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);
        List<ChessPiece> captured = new ArrayList<>();

        while(!chessMatch.getCheckMate()) {
            try{
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.print("\nSource: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.print("\nTarget: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }

                if(chessMatch.getPromoted() != null){
                    System.out.println("Enter a piece for promotion: 'B' (Bishop), 'N' (Knight), 'P' (Pawn), 'Q' (Queen): ");
                    String type = sc.nextLine();
                    chessMatch.replacePromotedPiece(type);
                }

            }catch(ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine(); // Program waits for "Enter" user input
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine(); // Program waits for "Enter" user input
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
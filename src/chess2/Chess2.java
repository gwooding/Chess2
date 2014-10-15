package chess2;

import java.util.Scanner;

import Pieces.AbstractPiece;
import Pieces.Pawn;
import Pieces.Knight;
import Pieces.Bishop;
import Pieces.Queen;
import Pieces.King;
import Pieces.Rook;

public class Chess2 {

	public static void main(String[] args) {

		int ColumnSize = 8;
		int RowSize = 8;

		AbstractPiece[][] board = boardSetUp(ColumnSize, RowSize);

		boolean stopper = false;
		// The first player always uses black pieces
		boolean turn = false;
		int blackScore = 0;
		int whiteScore = 0;
		
		while (stopper == false) {
			if (turn == false) {
				turn = true;
				System.out.println("Player BLACK's turn," + "Black Score:"
						+ blackScore + " White Score:" + whiteScore);
			} else if (turn == true) {
				turn = false;
				System.out.println("Player WHITE's turn," + "Black Score:"
						+ blackScore + " White Score:" + whiteScore);
			}
			boardPrinter(board);
			Scanner positionReader = new Scanner(System.in);
			System.out.println("Move piece from");
			String startPos = positionReader.nextLine();
			
			if (startPos.equals("exit")) {
				stopper = true;
				break;
			}
			
			System.out.println("to");
			String endPos = positionReader.nextLine();
			
			if (endPos.equals("exit")) {
				stopper = true;
				break;
			} else {

				int startX = startPos.charAt(0) - 97;
				int startY = startPos.charAt(1) - 49;
				int finishX = endPos.charAt(0) - 97;
				int finishY = endPos.charAt(1) - 49;
				
				if ((board[startX][startY].isMoveValid(startX, startY, finishX,
						finishY) == true)
						&& (turnAndCaptureRules(startX, startY, finishX,
								finishY, board, turn) == true)) {
					if (turn == true) {
						blackScore = blackScore
								+ capture(finishX, finishY, board);
					} else {
						whiteScore = whiteScore
								+ capture(finishX, finishY, board);
					}
					board[finishX][finishY] = board[startX][startY];
					board[startX][startY] = null;
				} else {
					System.out.println("INVALID MOVE");
					if (turn == false) {
						turn = true;
					} else {
						turn = false;
					}
				}
			}
		}
	}

	private static AbstractPiece[][] boardSetUp(int Column, int Row) {

		AbstractPiece[][] board = new AbstractPiece[Column][Row];

		for (int i = 0; i < board.length; i++) {
			board[i][6] = new Pawn(false);
			board[i][1] = new Pawn(true);
		}

		for (int i = board.length - 6; i < board.length - 2; i++) {
			for (int j = 0; j < board.length; j++) {
				board[j][i] = null;
			}
		}

		board[0][0] = new Rook(true);
		board[7][0] = new Rook(true);
		board[0][7] = new Rook(false);
		board[7][7] = new Rook(false);
		board[1][0] = new Knight(true);
		board[6][0] = new Knight(true);
		board[1][7] = new Knight(false);
		board[6][7] = new Knight(false);
		board[2][0] = new Bishop(true);
		board[5][0] = new Bishop(true);
		board[2][7] = new Bishop(false);
		board[5][7] = new Bishop(false);
		board[3][0] = new King(true);
		board[4][0] = new Queen(true);
		board[3][7] = new King(false);
		board[4][7] = new Queen(false);

		return board;
	}

	public static void boardPrinter(AbstractPiece board[][]) {
		System.out.print("a\tb\tc\td\te\tf\tg\th\n");
		for (int j = 0; j < board[0].length; j++) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][j] != null) {
					board[i][j].draw();
				} else {
					System.out.print(" \t");
				}
			}
			System.out.print("  " + (j + 1) + "\n\n");
		}
	}

	public static boolean turnAndCaptureRules(int startX, int startY,
			int finishX, int finishY, AbstractPiece[][] board, boolean turn) {
		boolean legalMove = false;
		if (((board[finishX][finishY] == null) || (board[finishX][finishY]
				.isWhite() != board[startX][startY].isWhite()))
				&& (turn != board[startX][startY].isWhite())) {
			legalMove = true;
		}
		return legalMove;
	}

	public static int capture(int finishX, int finishY, AbstractPiece board[][]) {
		int score = 0;
		if (board[finishX][finishY] == null) {
			return score;
		} else {
			score = board[finishX][finishY].relativeValue();
			return score;
		}
	}
}
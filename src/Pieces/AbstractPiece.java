package Pieces;

public abstract class AbstractPiece {
	boolean isWhite;

	// If piece is white, set true, otherwise set to false.

	public AbstractPiece() {
		this.isWhite = false;
	}

	public AbstractPiece(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public abstract void draw();

	public abstract boolean isMoveValid(int startX, int startY, int finishX,
			int finishY);

	// Returns chess piece value for scoring
	public abstract int relativeValue();
}

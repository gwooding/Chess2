package Pieces;

public class Rook extends AbstractPiece {
	public Rook(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (this.isWhite())
			System.out.print("\u2656\t");
		else
			System.out.print("\u265C\t");
	}

	@Override
	public boolean isMoveValid(int startX, int startY, int finishX, int finishY) {
		boolean CorrectMovementType = false;

		if (startX == finishX || startY == finishY) {
			CorrectMovementType = true;
		}
		return CorrectMovementType;
	}

	@Override
	public int relativeValue() {
		return 5;
	}

}

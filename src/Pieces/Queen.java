package Pieces;

public class Queen extends AbstractPiece {
	public Queen(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (this.isWhite())
			System.out.print("\u2655\t");
		else
			System.out.print("\u265B\t");
	}

	@Override
	public boolean isMoveValid(int startX, int startY, int finishX, int finishY) {
		boolean CorrectMovementType = false;

		if (((startX == finishX) || (startY == finishY))
				|| (Math.abs(finishX - startX) == Math.abs(startY - finishY))) {
			CorrectMovementType = true;
		}
		return CorrectMovementType;
	}

	@Override
	public int relativeValue() {
		return 9;
	}

}
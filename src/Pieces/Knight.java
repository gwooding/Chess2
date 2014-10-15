package Pieces;

public class Knight extends AbstractPiece {
	public Knight(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (this.isWhite())
			System.out.print("\u2658\t");
		else
			System.out.print("\u265E\t");
	}

	@Override
	public boolean isMoveValid(int startX, int startY, int finishX, int finishY) {
		boolean CorrectMovementType = false;

		if ((Math.abs(finishX - startX) + Math.abs(startY - finishY) == 3)
				&& (Math.abs(finishX - startX) > 0)
				&& (Math.abs(startY - finishY) > 0)) {
			CorrectMovementType = true;
		}
		return CorrectMovementType;
	}

	@Override
	public int relativeValue() {
		return 3;
	}

}

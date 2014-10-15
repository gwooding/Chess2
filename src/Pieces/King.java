package Pieces;

public class King extends AbstractPiece {
	public King(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (this.isWhite())
			System.out.print("\u2654\t");
		else
			System.out.print("\u265A\t");
	}

	@Override
	public boolean isMoveValid(int startX, int startY, int finishX, int finishY) {
		boolean CorrectMovementType = false;

		if (Math.abs(finishX - startX) < 2 && Math.abs(finishY - startY) < 2) {
			CorrectMovementType = true;
		}
		return CorrectMovementType;
	}

	@Override
	public int relativeValue() {
		return 100;
	}

}
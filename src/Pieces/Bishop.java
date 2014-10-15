package Pieces;

public class Bishop extends AbstractPiece {
	public Bishop(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (this.isWhite())
			System.out.print("\u2657\t");
		else
			System.out.print("\u265D\t");
	}

	@Override
	public boolean isMoveValid(int startX, int startY, int finishX, int finishY) {
		boolean correctMovementType = false;

		if (Math.abs(finishX - startX) == Math.abs(finishY - startY)) {
			correctMovementType = true;
		}
		return correctMovementType;
	}

	@Override
	public int relativeValue() {
		return 5;
	}

}

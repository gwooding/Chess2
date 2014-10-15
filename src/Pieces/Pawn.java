package Pieces;

public class Pawn extends AbstractPiece {
	public Pawn(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (this.isWhite())
			System.out.print("\u2659\t");
		else
			System.out.print("\u265F\t");
	}

	@Override
	public boolean isMoveValid(int startX, int startY, int finishX, int finishY) {
		boolean CorrectMovementType = false;

		if (isWhite == true) {
			if ((finishY - startY == 1)
					|| ((finishY - startY == 1) && (Math.abs(finishX - startX) == 1))) {
				CorrectMovementType = true;
			}
		}

		if (isWhite == false) {
			if ((finishY - startY == -1)
					|| ((finishY - startY == -1) && (Math.abs(finishX - startX) == 1))) {
				CorrectMovementType = true;
			}
		}
		return CorrectMovementType;
	}

	@Override
	public int relativeValue() {
		return 1;
	}

}
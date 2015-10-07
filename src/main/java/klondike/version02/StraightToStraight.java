package klondike.version02;

public class StraightToStraight extends MoveController {

	protected StraightToStraight(Board board) {
		super(board);
	}

	@Override
	public void receive(View gameView) {
		gameView.atender(this);
	}

	public boolean straightToStraight(int oldStraight, int newStraight) {
		return board.moveStraightToStraight(oldStraight,newStraight);
	}
}

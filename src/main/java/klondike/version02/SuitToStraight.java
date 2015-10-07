package klondike.version02;

public class SuitToStraight extends MoveController {

	protected SuitToStraight(Board board) {
		super(board);
	}

	@Override
	public void receive(View gameView) {
		gameView.atender(this);
	}

	public boolean suitToStraight(int palo, int escalera) {
		return board.moveSuitToStraight(palo, escalera);
	}

}

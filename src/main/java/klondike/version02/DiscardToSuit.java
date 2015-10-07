package klondike.version02;

public class DiscardToSuit extends MoveController{

	protected DiscardToSuit(Board board) {
		super(board);
	}
	@Override
	public void receive(View gameView) {
		gameView.atender(this);
	}
	
	public boolean move(){
		return board.moveToSuit();
	}

}

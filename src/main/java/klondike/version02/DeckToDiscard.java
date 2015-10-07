package klondike.version02;

public class DeckToDiscard extends MoveController{

	protected DeckToDiscard(Board board) {
		super(board);
	}
	
	@Override
	public void receive(View gameView) {
		gameView.atender(this);
	}
	public void move(){
		assert board.getDeck().size() > 0;
		board.moveToDiscard();
	}
}

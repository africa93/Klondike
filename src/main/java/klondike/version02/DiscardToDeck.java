package klondike.version02;

public class DiscardToDeck extends MoveController{

	protected DiscardToDeck(Board board) {
		super(board);
	}
	
	@Override
	public void receive(View gameView) {
		gameView.atender(this);
	}
	
	public void move(){
		assert board.getDeck().size()==0;
		board.moveToDeck();
	}
}

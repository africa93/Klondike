package klondike.version02;

public class MoveControllerFactory {
	private Board board;
	private  MoveController[] moveControllers;
	
	public MoveControllerFactory(Board board){
		assert board != null;
		this.board = board;
		moveControllers = new MoveController[7];
		moveControllers[0] = new DeckToDiscard(board);
		moveControllers[1] = new DiscardToDeck(board);
		moveControllers[2] = new DiscardToSuit(board);
		moveControllers[3] = new DiscardToStright(board);
		moveControllers[4] = new StraightToSuit(board);
		moveControllers[5] = new StraightToStraight(board);
		moveControllers[6] = new SuitToStraight(board);
	}
	
	public MoveController getController(int controller){
		if(board.isFinished()){
			return null;
		}
		MoveController moveController;
		moveController = moveControllers[controller];
		return moveController;
	}
}

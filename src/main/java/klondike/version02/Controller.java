package klondike.version02;

public abstract class Controller {
	protected Board board;
	
	protected Controller(Board board){
		assert board != null;
		this.board = board;
	}
	
	public BoardForView getBoard(){
		return board;
	}
}

package klondike.version02;

public abstract class MoveController extends Controller {
	protected MoveController(Board board){
		super(board);
	}
	public void close() {
		new MenuView(board).ask();
	}

	public Board getBoard(){
		return board;
	}
	public abstract void receive(View gameView);


}

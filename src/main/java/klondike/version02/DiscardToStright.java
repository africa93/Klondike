package klondike.version02;

public class DiscardToStright extends MoveController {

	protected DiscardToStright(Board board) {
		super(board);
	}
	
	@Override
	public void receive(View gameView) {
		gameView.atender(this);
	}
	
	public boolean move(int numeroEscalera){
		return board.getStraight(numeroEscalera).addMovedCard(board.getLastDiscard());
	}
	

}

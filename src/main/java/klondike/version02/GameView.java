package klondike.version02;

public class GameView implements View{

	private MoveControllerFactory moveControllerFactory;
	private Board board;
	
	public GameView(MoveControllerFactory moveControllerFactory, Board board){
		this.moveControllerFactory = moveControllerFactory;
		this.board = board;
	}
	@Override
	public void render() {
		MoveController controller;
		do{
			controller = moveControllerFactory.getController(new MenuView(board).ask()-1);
			if(controller != null){
				controller.receive(this);
			}
		}while(controller != null);
		
	}

	@Override
	public void atender(DeckToDiscard barajaADescarte) {
		new DeckToDiscardView(barajaADescarte).render();
		
	}

	@Override
	public void atender(DiscardToDeck descarteABaraja) {
		new DiscardToDeckView(descarteABaraja).render();
		
	}

	@Override
	public void atender(DiscardToSuit descarteAPalo) {
		new DiscardToSuitView(descarteAPalo).render();
		
	}

	@Override
	public void atender(DiscardToStright descarteAEscalera) {
		new DiscardToStraightView(descarteAEscalera).render();
		
	}

	@Override
	public void atender(StraightToSuit escaleraAPalo) {
		new StraightToSuitView(escaleraAPalo).render();
		
	}

	@Override
	public void atender(StraightToStraight escaleraAEscalera) {
		new StraightToStraightView(escaleraAEscalera).render();
		
	}

	@Override
	public void atender(SuitToStraight paloAEscalera) {
		new SuitToStraightView(paloAEscalera).render();
	}

}

package klondike.version02;

public class MenuView {
	
	Board board;
	MoveControllerFactory moveControllerFactory;
	
	public MenuView(Board board) {
		this.board = board;
		moveControllerFactory = new MoveControllerFactory(board);
	}
	
	public void print(){
		IO io = new IO();
		io.writeln("===========================");
		io.write("Baraja: ");
		if(board.getDeck().size()>0){
			 io.write("[X,X] \n");
		}else{
			writeEmpty(io);
		}
		io.write("Descarte: ");
		if(board.getDiscard().size()>0){
			for(int i=0; i<board.getDiscard().size();i++){
				io.write("["+board.getDiscard().get(i).getFace()+","+board.getDiscard().get(i).getSuit()+"]");
			}
			io.write("\n");
		}else{
			writeEmpty(io);
		}
		for(int i=0; i<4; i++){
			io.write("Palo "+ board.getSuit(i).getName().toString()+": ");
			if(board.getSuit(i).getSize()>1){
				Card card = board.getSuit(i).getLastCard();
				io.write("["+card.getFace()+","+card.getSuit()+"]");
			}else{
				writeEmpty(io);
			}
		}
		for(int i=0; i<board.straights.length-1; i++){
			Straight escalera = board.getStraight(i);
			if(escalera.getNumCards() == 0){
				writeEmpty(io);
			}
			io.write("Escalera "+escalera.getInitialSize()+": ");
			for(int j=0; j<escalera.getNumCards()-1;j++){
				io.write("[");
			}
			io.write("["+escalera.getLastCard().getFace()+","+escalera.getLastCard().getSuit()+"]\n");
		}
	}
	
	public int ask() {
		print();
		IO io = new IO();
		io.writeln("---------------------------");
		io.writeln("1. Mover de baraja a descarte");
		io.writeln("2. Mover de descarte a baraja");
		io.writeln("3. Mover de descarte a palo");
		io.writeln("4. Mover de descarte a escalera");
		io.writeln("5. Mover de escalera a palo");
		io.writeln("6. Mover de escalera a escalera");
		io.writeln("7. Mover de palo a escalera");
		io.writeln("8. Salir");
		int option = new LimitedIntDialog("Opción ",1,8).read();
		if(option == 8){
			io.write("Adios!!!");
			System.exit(0);
		}
		return option;
	}
	
	public void writeEmpty(IO io){
		io.write("<vacío> \n");
	}
}

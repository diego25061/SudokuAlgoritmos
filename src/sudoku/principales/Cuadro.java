package sudoku.principales;

public class Cuadro {
	Elemento [] elementos;
	
	
	public Cuadro(){
		
	}

	public Cuadro(int[] valores){
		elementos = new Elemento[9];
		for(int i = 0; i < 9 ; i++)
			elementos[i] = new Elemento( false );
	}
	
	public boolean hayRepeticion(){
		return false;
	}
	
	public void setElemento(int pos, Elemento e){
		elementos[pos] = e;
	}
	
	public Elemento getElemento(int pos){
		return elementos[pos];
	}

}

package sudoku.principales;

public class Cuadro {
	Elemento [] elementos;
	Tablero tablero;
	
	public Cuadro(){
		
	}

	/**
	 * solo para test
	 */
	
	public Cuadro(Tablero tablero){
		this( new int []{2,0,1,3,4,0,0,0,0} ,tablero);
	}

	/**
	 * pasar array de tamanho 9
	 * @param valores
	 */	
	public Cuadro(int[] valores, Tablero tablero){
		if ( valores.length != 9)
			throw new RuntimeException("El array de valores no tiene tamaño 9");
		this.tablero = tablero;
		elementos = new Elemento[10];
		for(int i = 0; i < 9 ; i++)
			elementos[i] = new Elemento( valores[i] , null, null);
	}
	
	public boolean hayRepeticion(){
		boolean [] presente = new boolean[10];
		for(int i = 0 ; i < 9 ; i++){
			if (elementos [i].getvalor() != 0){
				if (presente[elementos[i].getvalor()])
					return true;
				else
					presente[elementos[i].getvalor()] = true;
			}
		}
		return false;
	}
	
	public Tablero getTablero(){
		return tablero;
	}
	
	/*
	public void setElemento(int pos, Elemento e){
		elementos[pos] = e;
	}
	*/
	
	public Elemento getElemento(int pos){
		return elementos[pos];
	}

}

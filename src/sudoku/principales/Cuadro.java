package sudoku.principales;

import sudoku.principales.Celda.TIPO;

public class Cuadro {
	Celda [] elementos;
	Tablero tablero;
	
	public Cuadro(){
		this(new int []{0,0,0,0,0,0,0,0,0});
	}

	
	public Cuadro ( int[] valores){
		elementos = new Celda[10];
		for(int i = 0; i < 9 ; i++){
			elementos[i] = new Celda( valores[i] , null, null);
			if(valores[i] == 0)
				elementos[i].tipoCelda = TIPO.variable;
			else
				elementos[i].tipoCelda = TIPO.estatico;
		}
	}
	
	public void refrescarTipos(){
		for(int i = 0; i < 9 ; i++){
			if(elementos[i].valor == 0)
				elementos[i].tipoCelda = TIPO.variable;
			else
				elementos[i].tipoCelda = TIPO.estatico;
		}
	}
	/**
	 * solo para test
	 */
	
	public Cuadro(Tablero tablero){
		this( new int []{2,0,1,3,4,0,0,0,0} ,tablero);
	}

	public Celda getElemento(int x, int y){
		return elementos[y*3 + x];
	}
	
	/**
	 * pasar array de tamanho 9
	 * @param valores
	 */	
	public Cuadro(int[] valores, Tablero tablero){
		if ( valores.length != 9)
			throw new RuntimeException("El array de valores no tiene tamaño 9");
		this.tablero = tablero;
		elementos = new Celda[10];
		for(int i = 0; i < 9 ; i++)
			elementos[i] = new Celda( valores[i] , null, null);
	}
	
	public boolean hayRepeticion(){
		boolean [] presente = new boolean[10];
		for(int i = 0 ; i < 9 ; i++){
			if (elementos [i].getValor() != 0){
				if (presente[elementos[i].getValor()])
					return true;
				else
					presente[elementos[i].getValor()] = true;
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
	
	public Celda getElemento(int pos){
		return elementos[pos];
	}

}

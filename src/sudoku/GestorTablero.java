package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sudoku.principales.Cuadro;
import sudoku.principales.Tablero;

public class GestorTablero implements ActionListener {
	Tablero[] tableros;
	public boolean resuelto;
	
	public GestorTablero(){
		//generarTableros();
	}
	
	void tableroEsModificado(){
		
	}
	
	boolean condicionesGanarCumplidas(){
		return false;
	}
	
	public void agregarTablero(int pos){
		
	}
	
	/**
	 * 
	 * @param x
	 * va de 0 a 20. se refiere a la posicion x del elemento
	 * @param y
	 */
	public Tablero getTablero(int x, int y){
		if(  6 <= x && x <= 14 && 6 <= y && y <= 14)
			return tableros[0];
		else if ( x >= 12){
			if( y <= 8 )
				return tableros[2];
			else if( y >= 12 )
				return tableros[4];
		}else if ( x <= 8)
			if( y <= 8 )
				return tableros[1];
			else if( y >= 12 )
				return tableros[3];
		return null;
	}
	
	public Tablero getTablero(int tab){
		return tableros[tab];
	}

	
	public void resolver(){
		tableros[0].resolver();
		tableros[1].resolver();
		tableros[2].resolver();
		tableros[3].resolver();
		tableros[4].resolver();
	}
	
	public void vaciar(){
		tableros[0].reiniciar();
		tableros[1].reiniciar();
		tableros[2].reiniciar();
		tableros[3].reiniciar();
		tableros[4].reiniciar();
	}
	
	private Tablero crearTableroBorde(Cuadro c , int pos){
		Tablero t;
		Cuadro cuadros[];
		cuadros = new Cuadro[9];
		do{
			for(int i = 0 ; i<9 ; i++){
				cuadros[i] = new Cuadro();
				cuadros[i].getElemento((int) (Math.random()*9)).setValor((int) (Math.random()*9));
			}
			
			t = new Tablero(this, cuadros);
			t.setCuadro(c, pos);
		} 
		while(t.resolver() == false);
		return t;
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		resolver();
	}
	
	
	public void generarTableros(){
		
		
		Tablero tablero0 = new Tablero(this , new Cuadro[]{ 
						// FILA 1
						new Cuadro( new int []{
								0,0,0,
								6,8,0,
								1,9,0} ),
						new Cuadro( new int []{
								2,6,0,
								0,7,0,
								0,0,4} ),
						new Cuadro( new int []{
								7,0,1,
								0,9,0,
								5,0,0} ),
						
						// FILA 2
						new Cuadro( new int []{
								8,2,0,
								0,0,4,
								0,5,0} ),
						new Cuadro( new int []{
								1,0,0,
								6,0,2,
								0,0,3} ),
						new Cuadro( new int []{
								0,4,0,
								9,0,0,
								0,2,8} ),
						
						// FILA 3
						new Cuadro( new int []{
								0,0,9,
								0,4,0,
								7,0,3} ),
						new Cuadro( new int []{
								3,0,0,
								0,5,0,
								0,1,8}),
						new Cuadro( new int []{
								0,7,4,
								0,3,6,
								0,0,0} )
				});
		tableros = new Tablero[]{
				tablero0,
				
				new Tablero(this , new Cuadro[]{ 
						// FILA 1
						new Cuadro( new int []{
								3,0,1,
								0,0,0,
								0,8,0}),
						new Cuadro( new int []{
								5,0,6,
								0,0,9,
								0,1,0}),
						new Cuadro( new int []{
								8,0,0,
								2,0,0,
								5,4,0}),
						
						// FILA 2

						new Cuadro( new int []{
								4,0,0,
								5,6,0,
								7,0,8}),
						new Cuadro( new int []{
								6,0,7,
								0,8,0,
								0,2,0}),
						new Cuadro( new int []{
								9,0,8,
								0,2,0,
								3,0,0}),
								
						// FILA 3

						new Cuadro( new int []{
								2,0,0,
								0,3,9,
								0,4,5}),
						new Cuadro( new int []{
								0,9,0,
								7,5,4,
								0,6,0}),
						tablero0.getCuadro(0),
				}),
				
				new Tablero(this , new Cuadro[]{ 
						// FILA 1
						new Cuadro( new int []{
								0,0,0,
								0,5,0,
								0,0,9}),
						new Cuadro( new int []{
								0,0,6,
								0,0,0,
								0,0,4}),
						new Cuadro( new int []{
								7,0,0,
								0,0,0,
								3,0,6}),
						
						// FILA 2
						new Cuadro( new int []{
								2,0,0,
								0,0,7,
								9,0,0}),
						new Cuadro( new int []{
								0,0,0,
								0,0,8,
								0,0,0}),
						new Cuadro( new int []{
								6,0,8,
								0,1,0,
								2,0,0}),
						// FILA 3
						tablero0.getCuadro(2),
						new Cuadro( new int []{
								0,4,0,
								0,1,0,
								0,7,3}),
						new Cuadro( new int []{
								5,0,0,
								0,0,2,
								0,0,0}),
				}),
				new Tablero(this , new Cuadro[]{ 
						// FILA 1
						new Cuadro( new int []{
								4,0,2,
								0,6,0,
								9,0,5}),
						new Cuadro( new int []{
								6,7,0,
								0,0,9,
								1,2,0}),
						tablero0.getCuadro(6),
						// FILA 2
						new Cuadro( new int []{
								2,0,0,
								0,5,4,
								0,9,7}),
						new Cuadro( new int []{
								0,6,0,
								0,9,7,
								2,0,3}),
						new Cuadro( new int []{
								8,0,0,
								0,3,0,
								4,0,6}),
						// FILA 3
						new Cuadro( new int []{
								3,0,0,
								1,7,0,
								0,0,0}),
						new Cuadro( new int []{
								5,8,0,
								0,4,0,
								0,3,2}),
						new Cuadro( new int []{
								9,0,0,
								0,2,0,
								0,0,1}),
				}),
				new Tablero(this , new Cuadro[]{ 
						// FILA 1
						tablero0.getCuadro(8),
						new Cuadro( new int []{
								0,0,0,
								0,5,0,
								0,0,0}),
						new Cuadro( new int []{
								0,0,0,
								8,0,0,
								4,0,0}),
						// FILA 2
						new Cuadro( new int []{
								3,0,0,
								0,0,0,
								0,9,0}),
						new Cuadro( new int []{
								0,0,6,
								8,0,0,
								0,3,0}),
						new Cuadro( new int []{
								7,0,0,
								0,0,0,
								0,0,4}),
						// FILA 3
						new Cuadro( new int []{
								0,2,0,
								0,4,0,
								9,0,0}),
						new Cuadro( new int []{
								7,0,0,
								0,8,0,
								3,0,0}),
						new Cuadro( new int []{
								0,0,0,
								0,0,0,
								5,0,0}),
				}),
			};
		
		
		/*
		Tablero t1 = new Tablero(this , new Cuadro[]{ 
				// FILA 1
				new Cuadro( new int []{
						1,2,3,
						4,5,6,
						7,8,9} ),
				new Cuadro( new int []{
						4,5,6,
						7,8,9,
						1,2,3} ),
				new Cuadro( new int []{
						7,8,9,
						1,2,3,
						4,5,6} ),
				
				// FILA 2
				new Cuadro( new int []{
						2,3,4,
						5,6,7,
						8,9,1} ),
				new Cuadro( new int []{
						5,6,7,
						8,9,1,
						2,3,4} ),
				new Cuadro( new int []{
						8,9,1,
						2,3,4,
						5,6,7} ),
				
				// FILA 3
				new Cuadro( new int []{
						3,4,5,
						6,7,8,
						9,1,2} ),
				new Cuadro( new int []{
						6,7,8,
						9,1,2,
						3,4,5}),
				new Cuadro( new int []{
						9,1,2,
						3,4,5,
						6,7,8} )
		});
		
		//Tablero t1 = new Tablero();
		//t1.resolver(t1.matrizOriginal);
		
		t1.setMatrizFija(t1.reordenarAleatoriamente(0 , t1.matrizOriginal));
		t1.setMatrizFija(t1.crearHuecos(29, t1.matrizOriginal));
		t1.reiniciar();
		t1.refrescarTipos();
		

		Tablero t2 = new Tablero();
		t2.setCuadro(t1.getCuadro(0), 8);
		//t2.reordenarAleatoriamente(0, 1, 0, 1, 20);

		//t2.reiniciar();
		
		Tablero t3 = new Tablero();
		t3.setCuadro(t1.getCuadro(2), 6);
	//	t3.reordenarAleatoriamente(1, 2, 0, 1, 20);
		
		Tablero t4 = new Tablero();
		t4.setCuadro(t1.getCuadro(6), 2);
		//t4.reordenarAleatoriamente(0, 1, 1, 2, 20);
		
		Tablero t5 = new Tablero();
		t5.setCuadro(t1.getCuadro(8), 0);
		//t5.reordenarAleatoriamente(1, 2, 1, 2, 20);
		
		 
		
		tableros =  new Tablero[]{
				t1,t2,t3,t4,t5
		};
		*/
		
		
		
		
		
		
		/*
		tableros = new Tablero[5];
		Cuadro cuadros[];
		
		//tablero 0 -> tablero central
		
		cuadros = new Cuadro[9];
		do{
			for(int i = 0 ; i<9 ; i++){
				cuadros[i] = new Cuadro(null);
				cuadros[i].getElemento((int) (Math.random()*9)).setValor((int) (Math.random()*9));
			}
			tableros[0] = new Tablero(this, cuadros);
		} 
		while(tableros[0].resolver() == false);
		
		//tablero 1 -> inferior derecha
		tableros[1] = crearTableroBorde( cuadros[8] , 8);

		//tablero 2 -> inferior izquierda
		tableros[2] = crearTableroBorde( cuadros[6] , 6);
		
		//tablero 3 -> superior derecha
		tableros[3] = crearTableroBorde( cuadros[2] , 2);
		
		//tablero 4 -> superior izquierda
		tableros[4] = crearTableroBorde( cuadros[0] , 0);
*/
	}

}

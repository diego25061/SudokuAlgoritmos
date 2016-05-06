package test;

import org.junit.Assert;
import org.junit.Test;

import sudoku.principales.Cuadro;
import sudoku.principales.Tablero;

public class PruebasCuadro {

	public static void main(String[] args){
		//testResolver();
	}
	/*
	@Test
	public void testNoHayRepeticion() {
		Cuadro cuadroSinRepetir = new Cuadro(
				new int[] {1,0,0 ,9,3,4, 5,7,2},
				null);
		
		Assert.assertFalse(cuadroSinRepetir.hayRepeticion());
		
	}*/

/*
	@Test
	public void testHayRepeticion() {

		Cuadro cuadroRepetido = new Cuadro(
				new int[] { 1,0,1 ,9,3,4, 5,7,8},
				null);
		
		Assert.assertTrue(cuadroRepetido.hayRepeticion());
	}
	
	
	@Test
	public void testRepeticionFilas(){

		Tablero t = new Tablero();
		t.matriz = new int[]{
				5,3,0,0,7,0,0,0,0,
				6,0,0,1,9,5,0,0,0,
				0,9,8,0,0,0,0,6,0,
				8,0,0,0,6,0,0,0,3,
				4,0,0,8,0,3,0,0,1,
				7,0,0,0,2,0,0,0,6,
				0,6,0,0,0,0,2,8,0,
				0,0,0,4,1,9,0,0,5,
				0,0,0,0,8,0,0,7,9
		};
		
		Assert.assertTrue(t.encajaFila(9, 0, t.matriz));
		
	}
	
	@Test
	public void testRepeticionColumnas(){

		Tablero t = new Tablero();
		t.matriz = new int[]{
				5,3,0,0,7,0,0,0,0,
				6,0,0,1,9,5,0,0,0,
				0,9,8,0,0,0,0,6,0,
				8,0,0,0,6,0,0,0,3,
				4,0,0,8,0,3,0,0,1,
				7,0,0,0,2,0,0,0,6,
				0,6,0,0,0,0,2,8,0,
				0,2,0,4,1,9,0,0,5,
				0,0,0,0,8,0,0,7,9
		};
		
		Assert.assertTrue(t.encajaColumna(1, 0, t.matriz));
		
	}
*/
	
	@Test
	public  void testResolver(){
		Tablero t = new Tablero(null , new Cuadro[]{ 
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
		/*
		t.volcarMatrizEnCuadros( new int[]{

				5,3,0,0,7,0,0,0,0,
				6,0,0,1,9,5,0,0,0,
				0,9,8,0,0,0,0,6,0,
				8,0,0,0,6,0,0,0,3,
				4,0,0,8,0,3,0,0,1,
				7,0,0,0,2,0,0,0,6,
				0,6,0,0,0,0,2,8,0,
				0,0,0,4,1,9,0,0,5,
				0,0,0,0,8,0,0,7,9
		} );
		*/
		
/*
		t.volcarMatrizEnCuadros( new int[]{
				0,0,0,2,6,0,7,0,1,
				6,8,0,0,7,0,0,9,0,
				1,9,0,0,0,4,5,0,0,
				8,2,0,1,1,0,0,4,0,
				0,0,4,6,0,2,9,0,0,
				0,5,0,0,0,3,0,2,8,
				0,0,9,3,0,0,0,7,4,
				0,4,0,0,5,0,0,3,6,
				7,0,3,0,1,8,0,0,0
		} );
		*/
/*
		Assert.assertTrue(t.resolver( new int[]{
				0,0,0,2,6,0,7,0,1,
				6,8,0,0,7,0,0,9,0,
				1,9,0,0,0,4,5,0,0,
				8,2,0,1,1,0,0,4,0,
				0,0,4,6,0,2,9,0,0,
				0,5,0,0,0,3,0,2,8,
				0,0,9,3,0,0,0,7,4,
				0,4,0,0,5,0,0,3,6,
				7,0,3,0,1,8,0,0,0
		}));*/
	}
	
	@Test
	public void mezclar(){
		Tablero t = new Tablero(null , new Cuadro[]{ 
				// FILA 1
				new Cuadro( new int []{
						0,0,0,
						0,0,0,
						0,0,0} 
				),
				new Cuadro( new int []{
						0,0,0,
						0,0,0,
						0,0,0} 
				),
				new Cuadro( new int []{
						0,0,0,
						0,0,0,
						0,0,0} 
				),
				// FILA 2
				new Cuadro( new int []{
						0,0,0,
						0,0,0,
						0,0,0} 
				),
				new Cuadro( new int []{
						0,0,0,
						0,0,0,
						0,0,0} 
				),
				new Cuadro( new int []{
						0,0,0,
						0,0,0,
						0,0,0} 
				),
				
				// FILA 3
				new Cuadro( new int []{
						4,0,7,
						5,0,0,
						0,2,1} 
				),
				new Cuadro( new int []{
						0,0,0,
						0,0,0,
						0,0,0} 
				),
				new Cuadro( new int []{
						0,0,0,
						0,0,0,
						0,0,0} 
				),
		});
		
		//Assert.assertTrue(t.resolver(t.generarAleatoriamente(0,1,1,2 )));
		Tablero tab = new Tablero();
		//tab.reordenarAleatoriamente(0, 2, 0, 2 , 20);
	}
	
}

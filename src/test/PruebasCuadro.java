package test;

import org.junit.Assert;
import org.junit.Test;

import sudoku.principales.Cuadro;

public class PruebasCuadro {

	@Test
	public void testHayRepeticion() {
		Cuadro cuadroSinRepetir = new Cuadro(
				new int[] { 0,0,1 ,9,3,4, 5,7,8},
				null);
		
		Assert.assertFalse(cuadroSinRepetir.hayRepeticion());
		
		Cuadro cuadroRepetido = new Cuadro(
				new int[] { 1,0,1 ,9,3,4, 5,7,8},
				null);
		
		Assert.assertTrue(cuadroRepetido.hayRepeticion());
	}

	
	
}

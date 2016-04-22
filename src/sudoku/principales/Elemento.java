package sudoku.principales;

/**
 * Si el valor es 0, se considerará que el elemento no tiene numero
 * El valor no puede ser mayor que 9 o la aplicacion se caerá en la clase Cuadro
 * @author Diego
 *
 */
public class Elemento {

	int valor;
	public enum TIPO {estatico, variable}
	
	TIPO tipoElemento;
	Estilo estilo;	
	Cuadro cuadro;
	
	/*
	public Elemento(boolean random, Cuadro cuadro){
		if (random)
			valor = (int)( Math.random() * 10);
	}*/
	
	public Elemento(int valor, TIPO tipo, Cuadro cuadro){
		estilo = new Estilo();
		this. valor = valor;
	}
	
	public void enClick(){
		
	}
	
	public int getvalor(){
		return valor;
	}
	
	public TIPO getTipoElemento(){
		return tipoElemento;
	}
}

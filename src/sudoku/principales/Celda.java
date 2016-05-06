package sudoku.principales;

/**
 * Si el valor es 0, se considerará que el elemento no tiene numero
 * El valor no puede ser mayor que 9 o la aplicacion se caerá en la clase Cuadro
 * @author Diego
 *
 */
public class Celda {

	int valor;
	public enum TIPO {estatico, variable}
	
	public TIPO tipoCelda;
	Estilo estilo;	
	Cuadro cuadro;
	
	/*
	public Elemento(boolean random, Cuadro cuadro){
		if (random)
			valor = (int)( Math.random() * 10);
	}*/
	
	public Celda(){
		
	}
	
	public Celda(int valor, TIPO tipo, Cuadro cuadro){
		estilo = new Estilo();
		this. valor = valor;
	}
	
	public void enClick(){
		
	}
	
	public int getValor(){
		return valor;
	}
	
	public void setValor(int val){
		valor = val;
	}
	
	public void incrementar(){
		valor++;
		valor %= 10;
	}
	public TIPO getTipoCelda(){
		return tipoCelda;
	}
}

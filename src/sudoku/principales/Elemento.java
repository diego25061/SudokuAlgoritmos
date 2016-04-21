package sudoku.principales;

/**
 * Si el valor es 0, se considerará que el elemento no tiene numero
 * @author Diego
 *
 */
public class Elemento {

	int valor;
	public enum TIPO {estatico, variable}
	TIPO tipoElemento;
	Estilo estilo;
	
	public Elemento(boolean random){
		if (random)
			valor = (int)( Math.random() * 10);
	}
	
	public Elemento(int valor, TIPO tipo){
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

package sudoku.principales;

import java.awt.Color;

public class Estilo {
	public Color color, colorBorde;
	public int anchoBorde;
	
	public Estilo(Color color){
		this();
		this.color = color;
	}
	
	public Estilo(){
		color = Color.BLACK;
		colorBorde = Color.DARK_GRAY;
		anchoBorde = 2;
	}
}

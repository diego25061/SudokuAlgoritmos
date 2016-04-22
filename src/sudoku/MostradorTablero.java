package sudoku;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class MostradorTablero extends JPanel{
	
	private GestorTablero gestorTablero;
	private int frames;
	
	int sizeElemento = 25;
	
	Color colorLineasElemento = Color.LIGHT_GRAY;
	Color colorLineasCuadro = Color.BLACK;
	Color colorFondoTablero = Color.white;
	
	public MostradorTablero(GestorTablero gestor){
		gestorTablero = gestor;
	}
	
	public void dibujarTablero(){
	}
	
	public void paint (Graphics g){
		setDoubleBuffered(true);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		dibujarTablero(0,0,g);
		dibujarTablero(4 * sizeElemento * 3, 0 ,g);
		dibujarTablero(4 * sizeElemento * 3, 4 * sizeElemento * 3 ,g);
		dibujarTablero(0, 4 * sizeElemento * 3 ,g);
		dibujarTablero(2 * sizeElemento * 3, 2 * sizeElemento * 3 ,g);

		frames++;
	}
	
	private void dibujarTablero(int x, int y, Graphics g){
		g.setColor(colorFondoTablero);
		g.fillRect( x , y , 9 * sizeElemento , 9 * sizeElemento);
		((Graphics2D)g).setStroke(new BasicStroke(1));
		dibujarGrid( x , y , sizeElemento , 9, colorLineasElemento, g);
		((Graphics2D)g).setStroke(new BasicStroke(2));
		dibujarGrid( x , y , sizeElemento * 3 , 3, colorLineasCuadro, g);
	}
	
	private void dibujarGrid(int x, int y, int separacion, int cuadros, Color colorLineas, Graphics g){
		int lim = cuadros * separacion;
		g.setColor(colorLineas);
		for(int i = 0 ; i < cuadros ; i++){
			g.drawLine(x, y + i * separacion , x + lim , y +i*separacion);
			g.drawLine(x+ i * separacion , y , x + i*separacion , y + lim);
		}
		g.drawLine(x, y+ cuadros * separacion , x + lim , y+ cuadros*separacion);
		g.drawLine(x+cuadros * separacion , y , x+cuadros*separacion , y+ lim);
	}
	
	private void dibujarValoresIniciales(Graphics g){
		
		
	}
	
}

package sudoku;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import sudoku.principales.Celda;
import sudoku.principales.Celda.TIPO;
import sudoku.principales.Cuadro;
import sudoku.principales.Tablero;

public class MostradorTablero extends JPanel implements MouseListener , ActionListener{
	
	private GestorTablero gestorTablero;
	private int frames;
	
	int sizeElemento = 25;
	private final boolean dibujarCeros = false;

	private enum FORMATO { ESTATICA, VARIABLE};
	
	Color colorLineasElemento = Color.LIGHT_GRAY;
	Color colorLineasCuadro = Color.BLACK;
	Color colorFondoTablero = Color.WHITE;
	

	Color colorLineasElementoResuelto = new Color(0x0C7500);
	Color colorLineasCuadroResuelto = new Color(0x0C7500);
	Color colorFondoTableroResuelto = new Color(0xB5FFAD);

	int offsetTextoX = 6;
	int offsetTextoY = 20;

	public MostradorTablero(GestorTablero gestor){
		gestorTablero = gestor;
		gestor = new GestorTablero();
		addMouseListener(this);
        Timer timer = new Timer( 10 , this);
        timer.start();
		/*
        Thread t = new Thread(){        
        	@Override
        	public void run(){
        		timer.start();
        	}
        };
        t.start();
        */
	}
	

	public void paint (Graphics g){
		setDoubleBuffered(true);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(new Color(215,215,215));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if(!gestorTablero.getTablero(0).resuelto)
			dibujarTablero( 0 , g , gestorTablero.getTablero(0).resuelto);
		dibujarTablero( 1 , g , gestorTablero.getTablero(1).resuelto);
		dibujarTablero( 2 , g , gestorTablero.getTablero(2).resuelto);
		dibujarTablero( 3 , g , gestorTablero.getTablero(3).resuelto);
		dibujarTablero( 4 , g , gestorTablero.getTablero(4).resuelto);		
		if(gestorTablero.getTablero(0).resuelto)
			dibujarTablero( 0 , g , gestorTablero.getTablero(0).resuelto);
		
		/*
		dibujarTablero(0,0,g, false);
		dibujarTablero(4 * sizeElemento * 3, 0 ,g, false);
		dibujarTablero(4 * sizeElemento * 3, 4 * sizeElemento * 3 ,g, gestorTablero.getTablero(0).resuelto);
		dibujarTablero(0, 4 * sizeElemento * 3 ,g, false);
		dibujarTablero(2 * sizeElemento * 3, 2 * sizeElemento * 3 ,g, false);
*/
		//dibujarNumerosCuadro(new Cuadro(null) , 1, 1 ,g);
		
		dibujarNumerosTablero(gestorTablero.getTablero(0), 0, g);
		dibujarNumerosTablero(gestorTablero.getTablero(1), 1, g);
		dibujarNumerosTablero(gestorTablero.getTablero(2), 2, g);
		dibujarNumerosTablero(gestorTablero.getTablero(3), 3, g);
		dibujarNumerosTablero(gestorTablero.getTablero(4), 4, g);
		
		//dibujarNumero(1 , 0,0 ,g);
		//dibujarNumero( 5 , 2,3 ,g);
		
		//Tablero t = new Tablero(gestorTablero, null);
		//dibujarNumerosTablero(t,0,g);
		
		frames++;
	}


	private void dibujarNumerosTablero(Tablero t, int pos, Graphics g){
		int x = 0, y = 0;
		switch (pos){
			case 0:
				x = 2;
				y = 2;
				break;
			case 1:
				break;
			case 2:
				x = 4;
				break;
			case 3:
				y = 4;
				break;
			case 4:
				x = 4;
				y = 4;
				break;
		}
		dibujarNumerosTablero(t,x,y,g);
	}
	
	/**
	 * 
	 * @param t
	 * @param posTableroX
	 * Usa las posiciones de los cuadros. va de 0 a 6 xq hay 7 x 7 cuadros
	 * @param posTableroY
	 * @param g
	 */
	private void dibujarNumerosTablero(Tablero t, int posTableroX , int posTableroY, Graphics g){
		int x ,y ;
		x = posTableroX ;
		y = posTableroY ;
		for(int i = 0 ; i< 9; i++){
			dibujarNumerosCuadro( t.cuadros [i] , 
					x + (i % 3) ,
					y + (i / 3) , g );
		}
	}
	
	/**
	 * 
	 * @param c
	 * @param posCuadroX
	 * va de 0 a 6 xq hay 7 x 7 cuadros
	 * @param posCuadroY
	 * va de 0 a 6
	 * @param g
	 */
	private void dibujarNumerosCuadro(Cuadro c, int posCuadroX, int posCuadroY , Graphics g){
		int x ,y ;
		x = posCuadroX * 3;
		y = posCuadroY * 3;
		for(int i = 0 ; i< 9; i++){
			if(c.getElemento(i).tipoCelda == TIPO.estatico)
				dibujarNumero( c.getElemento(i).getValor() , 
						x + (i % 3) ,
						y + (i / 3) , g , FORMATO.ESTATICA);
			else
				dibujarNumero( c.getElemento(i).getValor() , 
						x + (i % 3) ,
						y + (i / 3) , g , FORMATO.VARIABLE);
		}
	}
/*
	private void dibujarNumero(int numero, int pos, Graphics g){
		int celdaX= pos%9;
		int celdaY= pos/9;
		dibujarTexto(""+numero , celdaX * sizeElemento + offsetTextoX, celdaY * sizeElemento + offsetTextoY, g);
	}*/
	
	private void dibujarNumero(int numero, int celdaX, int celdaY, Graphics g, FORMATO f){
		if(numero == 0 && !dibujarCeros)
			return;
		dibujarTexto(""+numero , celdaX * sizeElemento + offsetTextoX, celdaY * sizeElemento + offsetTextoY, g , f);
	}
	
	
	private void dibujarTexto(String texto, int x, int y, Graphics g , FORMATO f){
		//g.drawChars(new char[]{'2'}, 0, 1, 20, 40);
		//AffineTransform af = new AffineTransform();
		//af.setToScale(2, 2);
		//((Graphics2D)g).setTransform(af);
		Font font;
		if( f == FORMATO.VARIABLE ){
			g.setColor(Color.BLACK);
			font= new Font(Font.MONOSPACED, 0, 20);
		}else{
			g.setColor(new Color(0xB40404));
			font= new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 22);
		}
		g.setFont(font);
		//f.deriveFont(Font.ROMAN_BASELINE, 12);
		g.drawString(texto, x ,y);
	}
	
	private void dibujarTablero(int orden, Graphics g, boolean resuelto){
		switch (orden){
		case 0:
			dibujarTablero(2 * sizeElemento * 3, 2 * sizeElemento * 3 ,g, resuelto);
			break;
		case 1:
			dibujarTablero(0,0,g, resuelto);
			break;
		case 2:
			dibujarTablero(4 * sizeElemento * 3, 0 ,g, resuelto);
			break;
		case 3:
			dibujarTablero(0, 4 * sizeElemento * 3 ,g, resuelto);
			break;
		case 4:
			dibujarTablero(4 * sizeElemento * 3, 4 * sizeElemento * 3 ,g, resuelto);
			break;
		}
	}
	
	private void dibujarTablero(int x, int y, Graphics g, boolean resuelto){
		Color colorFondo;
		if(resuelto) colorFondo = colorFondoTableroResuelto; else colorFondo = colorFondoTablero;
		Color colorLineas;
		if(resuelto)colorLineas = colorLineasElementoResuelto; else colorLineas = colorLineasCuadro;
		Color colorLineasCuadro;
		if(resuelto)colorLineasCuadro = colorLineasCuadroResuelto; else colorLineasCuadro = this.colorLineasCuadro;
		g.setColor(colorFondo);
		g.fillRect( x , y , 9 * sizeElemento , 9 * sizeElemento);
		((Graphics2D)g).setStroke(new BasicStroke(1));			
		dibujarGrid( x , y , sizeElemento , 9, colorLineas, g);
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

	//========================================================= EVENTOS MOUSE

	@Override
	public void mouseClicked(MouseEvent evento) {
 
		
		int x = evento.getX() / this.sizeElemento;
		int y = evento.getY() / this.sizeElemento;
		
		int cx = x/3;
		int cy = y/3;
		 
		if( 2 <= cx && cx <= 4 && 2 <= cy && cy <= 4){
			cx -= 2;
			cy -= 2;
		} else{
			cx %= 4;
			cy %= 4; 
		}
		
		Tablero tablero = gestorTablero.getTablero(x, y);
		Cuadro c = tablero.getCuadro( cx, cy );
		Celda celda = c.getElemento(x % 3 ,y % 3 );
		 
		//gestorTablero.getTablero(x, y).resolver();
		//gestorTablero.getTablero(x, y).resuelto = true;
		//gestorTablero.getTablero(x, y).resuelto = true;
		
		/*
		gestorTablero.getTablero(x, y).getCuadro( cx, cy ).getElemento(x % 3 ,y % 3 ).setValor((
				gestorTablero.getTablero(x, y).getCuadro( cx, cy ).getElemento(x % 3 ,y % 3 ).getValor() +1 ) % 9);
		gestorTablero.getTablero(x, y).verificarResolucion();
		*/


		if(evento.getButton() == MouseEvent.BUTTON3 && celda.tipoCelda!=TIPO.estatico)
			celda.incrementar();
		else 
			if(evento.getButton() == MouseEvent.BUTTON1)		
				tablero.resolver();

		if(evento.getButton() == MouseEvent.BUTTON2)		
			tablero.reiniciar();
		
		tablero.verificarResolucion();

		//gestorTablero.getTablero(x, y).msjDebug( gestorTablero.getTablero(x, y).getMatrizDeCuadros());
		/*
		gestorTablero.getTablero(0).resuelto = true;
		gestorTablero.getTablero(1).resuelto = true;
		gestorTablero.getTablero(4).resuelto = true;
		*/	
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//========================================================= EVENTOS ACTION LISTENER PARA REPINTAR

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
	
}

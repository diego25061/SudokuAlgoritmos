package sudoku.principales;

import sudoku.GestorTablero;


public class Tablero {
	public Cuadro[] cuadros;
	GestorTablero gestorTablero;
	private int i ;
	
	public boolean resuelto;
	public int [] matrizOriginal;
	
	private boolean matrizGenerada;
	
	public Tablero(GestorTablero gestor, Cuadro[] cuadros){
		this.cuadros = cuadros;
		gestorTablero = gestor;
		matrizOriginal = this.getMatrizDeCuadros();
	}
	
	public void refrescarTipos(){
		for( int i = 0 ; i< 9 ;i ++)
			cuadros[i].refrescarTipos();
	}

	//crear tablero vacio
	public Tablero(){
		cuadros =new Cuadro[]{
				new Cuadro(),
				new Cuadro(),
				new Cuadro(),
				new Cuadro(),
				new Cuadro(),
				new Cuadro(),
				new Cuadro(),
				new Cuadro(),
				new Cuadro(),
		};
		gestorTablero = null;
		matrizOriginal = new int[81];
	}

	public void setMatrizFija(int [] m){
		matrizOriginal = m.clone();
	}
	
	public void reiniciar(){
		this.volcarMatrizEnCuadros(matrizOriginal);
		this.resuelto = false;
	}	
	
	public void setCuadro(Cuadro c ,int pos){
		cuadros[pos] = c ;
		matrizOriginal = this.getMatrizDeCuadros();
		reiniciar();
		System.out.println("Cuadro nuevo añadido a pos "+pos+"");
		msjDebug(matrizOriginal);
	}
	
	/**
	 * x e y son las posiciones de elementos
	 * @param x
	 * @param y
	 * @return 
	 */
	public Cuadro getCuadro(int x, int y){
		return cuadros[ y * 3 + x ];
	}

	public Cuadro getCuadro(int pos){
		return cuadros[ pos];
	}
	
	//PARA PROBAR ESTÁ COMO PUBLIC
	public boolean resolver(int[] matriz){
		if (resolver(0,matriz)){
			msjDebug( matriz );
			volcarMatrizEnCuadros(matriz);
			this.resuelto = true;
			return true;
		}
		System.out.println("NO HAY SOLUCION");
		return false;
	}

	/*
	public int[] getMatriz(){
		
		
		return new int[]{
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
	}
	*/
	/*
	public int[] getMatrizSolucion(){
		return null;
	}
	*/
	public boolean resolver(){
		return resolver(getMatrizDeCuadros());
		//generar matriz a partir de cuadros
		//int[] m = null;
		//return false;// resolver(matriz);
		
	}
	
	public void msjDebug(int[]matriz){
		String s="";
		System.out.println("-------------------------------------");
		int a = 0;
		for(int i = 0 ; i<81 ;i++){
			if(a > 8){
				s += "\n";
				a = 0;
			}
			s+= matriz[i]+" , ";
			a++;
		}
		System.out.println(s);
		System.out.println("-------------------------------------");
	}
	//Este algoritmo no funcionará para tableros que no tengan solucion: puede iterar sin fin
	private boolean resolver(int celda, int [] matriz){
		i++;		
		if(celda==81)
			return true;
		
		//if(matriz[celda]!=0 )
		if(matrizOriginal[celda]!=0 )
			return resolver( celda +  1 , matriz );
		
        for (int val = 1; val <= 9; ++val) {
            if (celdaEncaja(celda,val,matriz)) {
                matriz[celda] = val;
                if (resolver(celda+1,matriz))
                    return true;
            }
        }
        matriz[celda] = 0;
		//System.out.println(i);
		//this.msjDebug(matrizOriginal);
        return false;
	}

	public boolean celdaEncaja(int celda, int valor,  int [] matriz){
		//if(valor ==0)
			//return false;
		return ( encajaFila(celda, valor, matriz) && encajaColumna(celda, valor, matriz) && encajaCuadro(celda, valor, matriz));
	}
	
	public boolean encajaFila(int celda, int valor, int [] matriz){
		int i = celda / 9 * 9; //inclusivo
		int f = i + 9; //exclusivo
		
		for(int a = i ; a < f ; a++)
			if(matriz[a] == valor && a != celda)
				return false;
		
		return true;
	}
	
	public boolean encajaColumna(int celda, int valor , int[] matriz){
		int pos = celda % 9;
		for(int i = 0; i < 9; i++){
			if(valor == matriz[pos] && pos!= celda)
				return false;
			pos+=9;
		}
		return true;
	}

	private boolean encajaCuadro(int celda, int valor, int[] matriz){
        int boxRowOffset = (celda / 9 / 3)*3;
        int boxColOffset = (celda % 9 / 3)*3;

        if(valor ==0)
        	return false;
        	
        //omg
       if(valor == matriz[celda])
        	return true;
        //...
        
        for (int k = 0; k < 3; ++k) // box
            for (int m = 0; m < 3; ++m)
                if (valor == matriz[(boxRowOffset + k) * 9 + boxColOffset+m])
                    return false;
        
        return true;
	}

	
	public boolean verificarResolucion() {
		int [] m = getMatrizDeCuadros();

		System.out.println("----------------------------------------------------");
		
		this.msjDebug(m);
		
		for( int i = 0 ; i < 81 ; i ++ )
			if (! (celdaEncaja(i , m[i] , m)) ){
				System.out.println("encajaFila: " +encajaFila(i , m[i] , m));
				System.out.println("encajaColumna: " +encajaColumna(i , m[i] , m));
				System.out.println("encajaCuadro: " +encajaCuadro(i , m[i] , m));
				System.out.println("trio: " + i +" , "+m[i]+ " , " + m);
				System.out.println("VALOR: " +celdaEncaja(i , m[i] , m));
				System.out.println("CELDA: " + i);
				System.out.println("Tablero aun no resuelto");
				this.resuelto = false;
				return false;
			}
		
		this.resuelto=true;
		System.out.println("TABLERO RESUELTOO");
		return true;
			
	}
	
	public int[] getMatrizDeCuadros(){
		int [] m = new int[81];
		
		/*
		for( int i = 0 ; i < 9 ; i ++){
			for( int j = 0 ; j < 9 ; j++){
				//m[j* 9 + i] = cuadros[ i / 3 ].getElemento(i % 3, (j % 9) % 3).getValor();
			
			}
		}
		*/
		
		for( int i = 0 ; i < 9 ; i ++){
			for( int j = 0 ; j < 9 ; j++){
				m[ j * 9 + i ] = cuadros[ (j / 3) * 3  + i / 3 ].getElemento( (j * 3 % 9) + i % 3, 0).getValor();
			}
			
			/*
			m[ i ] = cuadros[ i / 3 ].getElemento(i % 3, 0).getValor();
			m[9 + i ] = cuadros[ i / 3 ].getElemento(3 + i % 3, 0).getValor();
			m[18 + i ] = cuadros[ i / 3 ].getElemento(6 + i % 3, 0).getValor();
			
			m[27 + i ] = cuadros[3 + i / 3 ].getElemento(i % 3, 0).getValor();
			m[36 + i ] = cuadros[3 + i / 3 ].getElemento(3 + i % 3, 0).getValor();
			m[45 + i ] = cuadros[3 + i / 3 ].getElemento(6 + i % 3, 0).getValor();
			
			m[54 + i ] = cuadros[6 + i / 3 ].getElemento(i % 3, 0).getValor();
			m[63 + i ] = cuadros[6 + i / 3 ].getElemento(3 + i % 3, 0).getValor();
			m[72 + i ] = cuadros[6 + i / 3 ].getElemento(6 + i % 3, 0).getValor();*/
		}
		
		return m;
	}
	
	
	public void volcarMatrizEnCuadros(int [] m){
		for( int i = 0 ; i < 9 ; i ++){
			for( int j = 0 ; j < 9 ; j++){
				cuadros[ (j / 3) * 3  + i / 3 ].getElemento( (j * 3 % 9) + i % 3, 0).setValor(m[ j * 9 + i ] );
			} 
		}
	}
	
	public int[] reordenarAleatoriamente( int huecos, int [] matriz ){
		return reordenarAleatoriamente(0,2,0,2,huecos , matriz);
	}
		 
	
	public int[] reordenarAleatoriamente( int filaInicial , int filaFinal, int columnaInicial, int columnaFinal, int huecos, int matriz[] ){
		int [] m = new int[81];
		m = matriz.clone();
		msjDebug(m);
		//resolver( 0, m);
		//mezclar filas

		msjDebug(m);
		
		for( int a = 0 ; a< 2 ; a++){
			for(int i = filaInicial; i <= filaFinal ; i++){
				System.out.println("Mezclando filas");
				mezclarFilas(i,m);
			}

			for(int i = columnaInicial; i <= columnaFinal ; i++){
				System.out.println("Mezclando columnas");
				mezclarColumnas(i,m);
			}
		}

		msjDebug(m); 
		//crearHuecos(huecos);
		return m;
	}
	
	private int[] mezclarFilas(int bloque, int matriz[]){
 
		
		int c = bloque * 3;
		int cf = (bloque + 1)  * 3   ;
		for(int i = 0; i < 3; i++){
			int c1 = (int) (Math.random() * (cf - c )) + c ;
			int c2 = (int) (Math.random() * (cf - c )) + c ;
			
			int init1 = c1 * 9;
			//int fin1 = (c1 + 1) * 9;
			
			int init2 = c2 * 9;
			//int fin2 = (c2 + 1) * 9;
			
			int temp[] = new int[9];
			
			for(int j = 0 ; j < 9 ; j ++){
				temp[j] = matriz[j + init2];
			}
			
			for(int j = 0 ; j < 9 ; j ++){
				matriz[init2 + j] = matriz[j+init1];
			}
			
			for(int j = 0 ; j < 9 ; j ++){
				matriz[init1 + j] = temp[j];
			}
		}
		return matriz;
	}

	private int[] mezclarColumnas(int bloque, int matriz[]){
		int c = bloque * 3;
		int cf = (bloque + 1)  * 3   ;
		
		for(int i = 0; i < 3; i++){
			int c1 = (int) (Math.random() * (cf - c )) + c ;
			int c2 = (int) (Math.random() * (cf - c )) + c ;
			
			int init1 = c1 ;
			//int fin1 = (c1 + 1) * 9;
			
			int init2 = c2;
			//int fin2 = (c2 + 1) * 9;
			
			int temp[] = new int[9];
			
			for(int j = 0 ; j < 9 ; j ++){
				temp[j] = matriz[j*9 + init2];
			}
			
			for(int j = 0 ; j < 9 ; j ++){
				matriz[init2 + j*9] = matriz[j*9+init1];
			}
			
			for(int j = 0 ; j < 9 ; j ++){
				matriz[init1 + j*9] = temp[j];
			}
		}
		return matriz;
	}
	
	public int[] crearHuecos(int cantidad , int [] matriz){
		int [] m = new int[81];
		m = matriz.clone();
		
		int i = 0;		
		while ( i < cantidad){
			int rand = (int) (Math.random() * 81);
			if ( m[ rand ] != 0 ){
				 m[ rand ] = 0;
				 i++;
			}
		}
		/*
		for(int j = 0; j < 20;j++){
			m[  j*4] = 0;
		}*/
		return m;
		
		
	}
}


/*
public void llenarMatrizTest(){
	matriz = new int[]{
			15,13,0,0,17,0,0,0,0,
			16,0,0,11,19,15,0,0,0,
			0,19,18,0,0,0,0,16,0,
			18,0,0,0,16,0,0,0,13,
			14,0,0,18,0,13,0,0,11,
			17,0,0,0,12,0,0,0,16,
			0,16,0,0,0,0,12,18,0,
			0,0,0,14,11,19,0,0,15,
			0,0,0,0,18,0,0,17,19
	};
	
}


public int[] hallarMatrizSolucion(){

	int celda = 0;
	int valor = 0;

	
	return null;
}*/

/**
 * Modifica la matriz de entrada
 * 
 * @param celda
 * @param matriz
 * @return
 */

/*
public boolean resolver(int celda, int [][] matriz){
	int c = celda;
	
	if(celdaEncaja(c, matriz)){
		c++;
		if(c==81){
			System.out.println("SE HALLO LA SOLUCION");
			return true;
		}else
			resolver(c,matriz);
	}else{
		if(getValor(c, matriz)>10){
			System.out.println("NO HAY SOLUCION");
			return false;
		}else{
			if(getValor(c, matriz)>8){
				setValor(c,0,matriz);
				c--;
			}
			setValor(c, getValor(c,matriz) + 1 ,matriz);
			resolver(c, matriz);
		}
	}
	return false;		
}
*/

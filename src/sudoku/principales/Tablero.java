package sudoku.principales;

public class Tablero {
	Cuadro[] cuadros;
	
	public Tablero(int[] arregloCuadros){
	}
	
	public boolean hayRepeticionFilas(){
		return false;
	}
	
	public boolean hayRepeticionColumnas(){
		return false;
	}
	
	void setCuadro(int cuadro){
		
	}
	
	int [][] matriz;
	
	
	public void llenarMatrizTest(){
		matriz = new int[][]{
				{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,0,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9}
		};
		
	}
	
	public void asd(int v,int f, int c, int m[][]){
		//int m[][] = matriz.clone();		
		//int i = 0;
		//int cont = 0;

		//int f = 0, c = 0;
		
		if(llenarCelda(v,f,c,m)){
			v = 1;
			c++;
			if(c==9){
				f++;
				c=0;
				if(f==9){
					System.out.println("SE HA SOLUCIONADO");
					return;
				}else{
					asd(v,f,c,m);
				}
			}
		}else
			if(v==9){
				if(c!=1)
					asd(m[f][c--]++,f,c--,m);
				else
					asd(m[f--][8]++,f--,8,m);
			}else{
				asd(v++,f,c,m);
			}
				
		
		/*
			m[f][c--] += 1;
		
			asd(f,c,m);
		
			if(m[f][c] + 1 != 10)
				m[f][c] += 1;
				asd( f, c, m);
			else{
				arr.eliminar ultimo numero
				arr.
				System.out.println("NO HAY SOLUCION");
				return;
			}
			
			*/
	}
	
	
	/*
	 * 
	public void asd(int inicio, int m[][]){
		//int m[][] = matriz.clone();		
		//int i = 0;
		//int cont = 0;
		int f = 0, c = 0;
		
		if(llenarCelda(f,c,m)){
			c++;
			if(c==9){
				f++;
				c=0;
				if(f==9){
					System.out.println("SE HA SOLUCIONADO");
					return;
				}
			}
		}else
			if(inicio + 1 != 10)
				asd(inicio + 1, m);
			else{
				System.out.println("NO HAY SOLUCION");
				return;
			}
	}
	 */
	public int[][] hallarSolucion(){
		int m[][] = matriz.clone();
		
		//asd(1,m);
		
		/*
		int i = 0;
		int cont = 0;
		int f = 0, c = 0;
		while(cont < 80){
			
			//for( int a = 1 ; a < 10 ; a++)
				if(!llenarCelda(f,c,m))
			
			if(m[f][c] == 0){
				
			}else{
				c++;
			}
			cont++;
		}
		*/
		
		return m;
		
	}
	
	/**
	 * Modifica al arreglo matriz, agregadole el valor en la posicion
	 * @param valor
	 * @param fila
	 * @param columna
	 * @param matriz
	 * @return
	 */
	private boolean llenarCelda( int valor, int fila, int columna, int [][] matriz){
		if(!hayRepeticionFilas(0, fila , matriz) && !hayRepeticionColumnas( valor , columna, matriz) && !hayCuadrosConRepeticiones()){
			
		}
		return false;
	}
	
	private boolean hayRepeticionFilas(int valor, int fila, int [][] matriz){
		
		return false;
	}
	
	private boolean hayRepeticionColumnas(int valor, int col, int [][] matriz){
		
		return false;
	}
	
	private boolean hayCuadrosConRepeticiones(){
		return false;
	}
	
	public void getCuadro(int pos){
		
	}
}

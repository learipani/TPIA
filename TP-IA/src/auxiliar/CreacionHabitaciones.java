package auxiliar;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.cidisi.faia.state.datastructure.Pair;

/*Cosas útiles:
 * Manejo de listas en JAVA: http://panamahitek.com/el-uso-de-listas-en-java/ 
 * */

public class CreacionHabitaciones {

	public Habitacion createHabitacion1(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h1 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h1 = new Habitacion(1, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{10,7}, new ArrayList<Objeto>());
		
		//Paredes
		//h14.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h1.addObjeto(new Obstaculo(1, new int[]{1,7}, new int[]{0,0}));
		h1.addObjeto(new Obstaculo(1, new int[]{1,7}, new int[]{9,0}));
		h1.addObjeto(new Obstaculo(1, new int[]{8,1}, new int[]{1,0}));
		h1.addObjeto(new Obstaculo(1, new int[]{3,1}, new int[]{6,6}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Habitacion h2= new Habitacion(2, null, null, null);
		
		h1.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h2, new Puerta(1, new int[]{6,1}, new int[]{1, 0}) ));
		h1.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h2, new Puerta(1, new int[]{6,2}, new int[]{2, 0}) ));
		h1.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h2, new Puerta(1, new int[]{6,3}, new int[]{3, 0}) ));
		h1.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h2, new Puerta(1, new int[]{6,4}, new int[]{4, 0}) ));
		h1.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h2, new Puerta(1, new int[]{6,5}, new int[]{5, 0}) ));
		
		return h1;
	}
	
	public Habitacion createHabitacion2(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h2 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h2 = new Habitacion(2, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{16,7}, new ArrayList<Objeto>());
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h2.addObjeto(new Obstaculo(2, new int[]{1,3}, new int[]{0,0}));
		h2.addObjeto(new Obstaculo(2, new int[]{1,3}, new int[]{15,0}));
		h2.addObjeto(new Obstaculo(2, new int[]{3,1}, new int[]{13,6}));
		h2.addObjeto(new Obstaculo(2, new int[]{9,1}, new int[]{6,0}));
		h2.addObjeto(new Obstaculo(2, new int[]{10,1}, new int[]{0,6}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Habitacion h1= new Habitacion(1, null, null, null);
		Habitacion h3= new Habitacion(3, null, null, null);
		Habitacion h7= new Habitacion(7, null, null, null);
		
		h2.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h1, new Puerta(1, new int[]{1,0}, new int[]{1, 6}) ));
		h2.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h1, new Puerta(1, new int[]{2,0}, new int[]{2, 6}) ));
		h2.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h1, new Puerta(1, new int[]{3,0}, new int[]{3, 6}) ));
		h2.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h1, new Puerta(1, new int[]{4,0}, new int[]{4, 6}) ));
		h2.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h1, new Puerta(1, new int[]{5,0}, new int[]{5, 6}) ));
		
		h2.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h3, new Puerta(2, new int[]{10,6}, new int[]{1, 0}) ));
		h2.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h3, new Puerta(2, new int[]{11,6}, new int[]{2, 0}) ));
		h2.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h3, new Puerta(2, new int[]{12,6}, new int[]{3, 0}) ));
		
		h2.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h7, new Puerta(3, new int[]{0,3}, new int[]{32, 1}) ));
		h2.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h7, new Puerta(3, new int[]{0,4}, new int[]{32, 2}) ));
		h2.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h7, new Puerta(3, new int[]{0,5}, new int[]{32, 3}) ));
		// faltaria agregar puerta que no lleva a ninguna lado
		
		return h2;
	}
	
	public Habitacion createHabitacion3(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h3 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h3 = new Habitacion(3, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{15,11}, new ArrayList<Objeto>());
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h3.addObjeto(new Obstaculo(3, new int[]{1,4}, new int[]{0,0}));
		h3.addObjeto(new Obstaculo(3, new int[]{1,4}, new int[]{0,7}));
		h3.addObjeto(new Obstaculo(3, new int[]{10,1}, new int[]{4,0}));
		h3.addObjeto(new Obstaculo(3, new int[]{13,1}, new int[]{1,10}));
		h3.addObjeto(new Obstaculo(3, new int[]{1,11}, new int[]{14,0}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Habitacion h2= new Habitacion(2, null, null, null);
		Habitacion h4= new Habitacion(4, null, null, null);
		
		h3.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h2, new Puerta(1, new int[]{1,0}, new int[]{10, 6}) ));
		h3.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h2, new Puerta(1, new int[]{2,0}, new int[]{11, 6}) ));
		h3.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h2, new Puerta(1, new int[]{3,0}, new int[]{12, 6}) ));
		
		h3.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h4, new Puerta(2, new int[]{0,4}, new int[]{6, 4}) ));
		h3.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h4, new Puerta(2, new int[]{0,5}, new int[]{6, 5}) ));
		h3.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h4, new Puerta(2, new int[]{0,6}, new int[]{6, 6}) ));
				
		return h3;
	}
	
	public Habitacion createHabitacion4(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h4 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h4 = new Habitacion(4, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{7,11}, new ArrayList<Objeto>());
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h4.addObjeto(new Obstaculo(4, new int[]{1,11}, new int[]{0,0}));
		h4.addObjeto(new Obstaculo(4, new int[]{5,1}, new int[]{1,0}));
		h4.addObjeto(new Obstaculo(4, new int[]{5,1}, new int[]{1,10}));
		h4.addObjeto(new Obstaculo(4, new int[]{1,4}, new int[]{6,0}));
		h4.addObjeto(new Obstaculo(4, new int[]{1,4}, new int[]{6,7}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Habitacion h3= new Habitacion(3, null, null, null);
		
		h4.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h3, new Puerta(1, new int[]{6,4}, new int[]{0,4}) ));
		h4.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h3, new Puerta(1, new int[]{6,5}, new int[]{0,5}) ));
		h4.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h3, new Puerta(1, new int[]{6,6}, new int[]{0,6}) ));
		
		return h4;
	}
	
	public Habitacion createHabitacion5(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h5 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h5 = new Habitacion(5, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{20,29}, new ArrayList<Objeto>());
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h5.addObjeto(new Obstaculo(5, new int[]{1,10}, new int[]{0,0}));
		h5.addObjeto(new Obstaculo(5, new int[]{1,7}, new int[]{0,13}));
		h5.addObjeto(new Obstaculo(5, new int[]{1,9}, new int[]{3,20}));
		h5.addObjeto(new Obstaculo(5, new int[]{1,20}, new int[]{19,0}));
		h5.addObjeto(new Obstaculo(5, new int[]{1,9}, new int[]{16,20}));
		h5.addObjeto(new Obstaculo(5, new int[]{18,1}, new int[]{1,0}));
		h5.addObjeto(new Obstaculo(5, new int[]{3,1}, new int[]{1,19}));
		h5.addObjeto(new Obstaculo(5, new int[]{3,1}, new int[]{16,19}));
		h5.addObjeto(new Obstaculo(5, new int[]{12,1}, new int[]{4,28}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Habitacion h9= new Habitacion(9, null, null, null);
		
		h5.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{0,10}, new int[]{48,3}) ));
		h5.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{0,11}, new int[]{48,4}) ));
		h5.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{0,12}, new int[]{48,5}) ));
		
		return h5;
	}
	
	public Habitacion createHabitacion6(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h6 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h6 = new Habitacion(6, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{28,14}, new ArrayList<Objeto>());
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h6.addObjeto(new Obstaculo(6, new int[]{1,14}, new int[]{0,0}));
		h6.addObjeto(new Obstaculo(6, new int[]{1,9}, new int[]{27,0}));
		h6.addObjeto(new Obstaculo(6, new int[]{1,6}, new int[]{12,8}));
		h6.addObjeto(new Obstaculo(6, new int[]{26,1}, new int[]{1,0}));
		h6.addObjeto(new Obstaculo(6, new int[]{7,1}, new int[]{20,8}));
		h6.addObjeto(new Obstaculo(6, new int[]{11,1}, new int[]{1,13}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Habitacion h7= new Habitacion(7, null, null, null);
		
		h6.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h7, new Puerta(1, new int[]{13,8}, new int[]{18,0}) ));
		h6.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h7, new Puerta(1, new int[]{14,8}, new int[]{19,0}) ));
		h6.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h7, new Puerta(1, new int[]{15,8}, new int[]{20,0}) ));
		h6.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h7, new Puerta(1, new int[]{16,8}, new int[]{21,0}) ));
		h6.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h7, new Puerta(1, new int[]{17,8}, new int[]{22,0}) ));
		h6.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h7, new Puerta(1, new int[]{18,8}, new int[]{23,0}) ));
		h6.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h7, new Puerta(1, new int[]{19,8}, new int[]{24,0}) ));
		
		return h6;
	}
	
	public Habitacion createHabitacion7(){
/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h7 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h7 = new Habitacion(7, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{36,23}, new ArrayList<Objeto>());
		
		//Paredes
		//h7.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h7.addObjeto(new Obstaculo(7, new int[]{18,1}, new int[]{0,5}));
		h7.addObjeto(new Obstaculo(7, new int[]{8,1}, new int[]{25,0}));   
		h7.addObjeto(new Obstaculo(7, new int[]{4,1}, new int[]{32,4}));
		h7.addObjeto(new Obstaculo(7, new int[]{4,1}, new int[]{31,22}));   
		h7.addObjeto(new Obstaculo(7, new int[]{19,1}, new int[]{12,19}));   
		h7.addObjeto(new Obstaculo(7, new int[]{5,1}, new int[]{0,21}));   
		h7.addObjeto(new Obstaculo(7, new int[]{5,1}, new int[]{0,11}));   

		
		//horizontales
		h7.addObjeto(new Obstaculo(7, new int[]{1,5}, new int[]{17,0}));
		h7.addObjeto(new Obstaculo(7, new int[]{1,18}, new int[]{35,5}));  
		h7.addObjeto(new Obstaculo(7, new int[]{1,3}, new int[]{31,19}));  
		h7.addObjeto(new Obstaculo(7, new int[]{1,2}, new int[]{20,12}));		
		h7.addObjeto(new Obstaculo(7, new int[]{1,9}, new int[]{0,12}));
		
		
		//Obstaculos
		//h7.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h7.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		
		Puerta p11 = new Puerta(1, new int[]{0, 6}, new int[]{15, 1});
		Puerta p12 = new Puerta(1, new int[]{0, 7}, new int[]{15, 2});
		Puerta p13 = new Puerta(1, new int[]{0, 8}, new int[]{15, 3});
		Puerta p14 = new Puerta(1, new int[]{0, 9}, new int[]{15, 4});
		Puerta p15 = new Puerta(1, new int[]{0, 10}, new int[]{15, 5});
		
		Puerta p21 = new Puerta(2, new int[]{5, 21}, new int[]{18, 0});
		Puerta p22 = new Puerta(2, new int[]{6, 21}, new int[]{19, 0});
		Puerta p23 = new Puerta(2, new int[]{7, 21}, new int[]{20, 0});
		Puerta p24 = new Puerta(2, new int[]{8, 21}, new int[]{21, 0});
		Puerta p25 = new Puerta(2, new int[]{9, 21}, new int[]{22, 0});
		Puerta p26 = new Puerta(2, new int[]{10, 21}, new int[]{23, 0});
		Puerta p27 = new Puerta(2, new int[]{11, 21}, new int[]{24, 0});
		
		Puerta p31 = new Puerta(3, new int[]{18, 0}, new int[]{13, 8});
		Puerta p32 = new Puerta(3, new int[]{19, 0}, new int[]{14, 8});
		Puerta p33 = new Puerta(3, new int[]{20, 0}, new int[]{15, 8});
		Puerta p34 = new Puerta(4, new int[]{21, 0}, new int[]{16, 8});
		Puerta p35 = new Puerta(4, new int[]{22, 0}, new int[]{17, 8});
		Puerta p36 = new Puerta(4, new int[]{23, 0}, new int[]{18, 8});
		Puerta p37 = new Puerta(5, new int[]{24, 0}, new int[]{19, 8});
		
		Puerta p41 = new Puerta(5, new int[]{32, 1}, new int[]{0, 3});
		Puerta p42 = new Puerta(5, new int[]{32, 2}, new int[]{0, 4});
		Puerta p43 = new Puerta(6, new int[]{32, 3}, new int[]{0, 5});
		
		
		Habitacion h15 = new Habitacion(5, null, null, null);
		Habitacion h9 = new Habitacion(7, null, null, null);
		Habitacion h6 = new Habitacion(8, null, null, null);
		Habitacion h2 = new Habitacion(10, null, null, null);

				

		h7.addHabitacionesContigua(h15, new ArrayList<Puerta>(){p11, p12, p13,p14,p15});
		h7.addHabitacionesContigua(h9, new ArrayList<Puerta>(){p21, p22, p23,p24,p25,p26,p27});
		h7.addHabitacionesContigua(h6, new ArrayList<Puerta>(){p31, p32, p33,p34,p35,p36,p37});
		h7.addHabitacionesContigua(h2, new ArrayList<Puerta>(){p41, p42, p43});

		 		
		return h7;
	}
	
	public Habitacion createHabitacion8(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h8 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h8 = new Habitacion(8, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{11,13}, new ArrayList<Objeto>());
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h8.addObjeto(new Obstaculo(8, new int[]{1,13}, new int[]{0,0}));
		h8.addObjeto(new Obstaculo(8, new int[]{1,4}, new int[]{7,0}));
		h8.addObjeto(new Obstaculo(8, new int[]{1,10}, new int[]{10,3}));
		h8.addObjeto(new Obstaculo(8, new int[]{2,1}, new int[]{5,0}));
		h8.addObjeto(new Obstaculo(8, new int[]{2,1}, new int[]{8,3}));
		h8.addObjeto(new Obstaculo(8, new int[]{9,1}, new int[]{1,12}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Habitacion h9= new Habitacion(9, null, null, null);
		
		h8.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{1,0}, new int[]{42,9}) ));
		h8.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{2,0}, new int[]{43,9}) ));
		h8.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{3,0}, new int[]{44,9}) ));
		h8.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{4,0}, new int[]{45,9}) ));
		
		return h8;
	}
	
	public Habitacion createHabitacion9(){
/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h9 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h9 = new Habitacion(9, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{49,11}, new ArrayList<Objeto>());
		
		//Paredes
		//h9.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h9.addObjeto(new Obstaculo(9, new int[]{18,1}, new int[]{0,0}));
		h9.addObjeto(new Obstaculo(9, new int[]{23,1}, new int[]{26,1}));   
		h9.addObjeto(new Obstaculo(9, new int[]{16,1}, new int[]{0,6}));
		h9.addObjeto(new Obstaculo(9, new int[]{6,1}, new int[]{23,6}));   
		h9.addObjeto(new Obstaculo(9, new int[]{10,1}, new int[]{32,6}));   
		h9.addObjeto(new Obstaculo(9, new int[]{2,1}, new int[]{46,9}));   

		
		//horizontales
		h9.addObjeto(new Obstaculo(9, new int[]{1,2}, new int[]{25,0}));
		h9.addObjeto(new Obstaculo(9, new int[]{1,1}, new int[]{48,2}));  
		h9.addObjeto(new Obstaculo(9, new int[]{1,4}, new int[]{48,6}));  
		h9.addObjeto(new Obstaculo(9, new int[]{1,4}, new int[]{41,7}));		
		h9.addObjeto(new Obstaculo(9, new int[]{1,4}, new int[]{23,7}));
		h9.addObjeto(new Obstaculo(9, new int[]{1,5}, new int[]{20,6}));  
		
		
		//Obstaculos
		//h9.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h9.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		
		Puerta p11 = new Puerta(1, new int[]{0, 1}, new int[]{21, 11});
		Puerta p12 = new Puerta(1, new int[]{0, 2}, new int[]{21, 12});
		Puerta p13 = new Puerta(1, new int[]{0, 3}, new int[]{21, 13});
		Puerta p14 = new Puerta(1, new int[]{0, 4}, new int[]{21, 14});
		Puerta p15 = new Puerta(1, new int[]{0, 5}, new int[]{21, 15});
		Puerta p21 = new Puerta(2, new int[]{18, 0}, new int[]{5, 21});
		Puerta p22 = new Puerta(2, new int[]{19, 0}, new int[]{6, 21});
		Puerta p23 = new Puerta(2, new int[]{20, 0}, new int[]{7, 21});
		Puerta p24 = new Puerta(2, new int[]{21, 0}, new int[]{8, 21});
		Puerta p25 = new Puerta(2, new int[]{22, 0}, new int[]{9, 21});
		Puerta p26 = new Puerta(2, new int[]{23, 0}, new int[]{10, 21});
		Puerta p27 = new Puerta(2, new int[]{24, 0}, new int[]{11, 21});
		Puerta p31 = new Puerta(3, new int[]{16, 6}, new int[]{8, 0});
		Puerta p32 = new Puerta(3, new int[]{17, 6}, new int[]{9, 0});
		Puerta p33 = new Puerta(3, new int[]{18, 6}, new int[]{10, 0});
		Puerta p41 = new Puerta(4, new int[]{20, 10}, new int[]{1,0});
		Puerta p42 = new Puerta(4, new int[]{21, 10}, new int[]{2,0});
		Puerta p43 = new Puerta(4, new int[]{22, 10}, new int[]{3,0});
		Puerta p51 = new Puerta(5, new int[]{29, 6}, new int[]{1, 0});
		Puerta p52 = new Puerta(5, new int[]{30, 6}, new int[]{2, 0});
		Puerta p53 = new Puerta(5, new int[]{31, 6}, new int[]{3, 0});
		Puerta p61 = new Puerta(6, new int[]{42, 9}, new int[]{1, 0});
		Puerta p62 = new Puerta(6, new int[]{43, 9}, new int[]{2, 0});
		Puerta p63 = new Puerta(6, new int[]{44, 9}, new int[]{3, 0});
		Puerta p64 = new Puerta(6, new int[]{45, 9}, new int[]{4, 0});
		Puerta p71 = new Puerta(7, new int[]{48, 3}, new int[]{0, 10});
		Puerta p72 = new Puerta(7, new int[]{48, 4}, new int[]{0, 11});		
		Puerta p73 = new Puerta(7, new int[]{48, 5}, new int[]{0, 12});
		
		Habitacion h5 = new Habitacion(5, null, null, null);
		Habitacion h7 = new Habitacion(7, null, null, null);
		Habitacion h8 = new Habitacion(8, null, null, null);
		Habitacion h10 = new Habitacion(10, null, null, null);
		Habitacion h11 = new Habitacion(11, null, null, null);
		Habitacion h12 = new Habitacion(12, null, null, null);
		Habitacion h14 = new Habitacion(14, null, null, null);
				

		h9.addHabitacionesContigua(h14, new ArrayList<Puerta>(){p11, p12, p13,p14,p15});
		h9.addHabitacionesContigua(h7, new ArrayList<Puerta>(){p21, p22, p23,p24,p25,p26,p27});
		h9.addHabitacionesContigua(h12, new ArrayList<Puerta>(){p31, p32, p33});
		h9.addHabitacionesContigua(h11, new ArrayList<Puerta>(){p41, p42, p43});
		h9.addHabitacionesContigua(h10, new ArrayList<Puerta>(){p51, p52, p53});
		h9.addHabitacionesContigua(h8, new ArrayList<Puerta>(){p61, p62, p63,p64});
		h9.addHabitacionesContigua(h5, new ArrayList<Puerta>(){p71, p72, p73});
		
		 		
		return h9;
	}
	
	public Habitacion createHabitacion10(){
/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h10 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h10 = new Habitacion(10, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{14,18}, new ArrayList<Objeto>());
		
		//Paredes
		//h10.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h10.addObjeto(new Obstaculo(10, new int[]{9,1}, new int[]{4,0}));
		h10.addObjeto(new Obstaculo(10, new int[]{12,1}, new int[]{1,17}));   
		
		//horizontales
		h10.addObjeto(new Obstaculo(10, new int[]{1,18}, new int[]{0,0}));
		h10.addObjeto(new Obstaculo(10, new int[]{1,18}, new int[]{13,0}));  
		h10.addObjeto(new Obstaculo(10, new int[]{1,1}, new int[]{4,1}));  
		
		
		//Obstaculos
		//h10.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h10.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		
		Puerta p1 = new Puerta(1, new int[]{2, 0}, new int[]{29, 6});
		Puerta p2 = new Puerta(1, new int[]{3, 0}, new int[]{30, 6});
		Puerta p3 = new Puerta(1, new int[]{4, 0}, new int[]{31, 6});
				
		Habitacion h9 = new Habitacion(9, null, null, null);

		h10.addHabitacionesContigua(h9, new ArrayList<Puerta>(){pu1, pu2, pu3});
		 		
		return h10;
	}
	
	public Habitacion createHabitacion11(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h11 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h11 = new Habitacion(11, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{10,12}, new ArrayList<Objeto>());
		
		//Paredes
		//h11.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h11.addObjeto(new Obstaculo(11, new int[]{5,1}, new int[]{4,0}));
		h11.addObjeto(new Obstaculo(11, new int[]{8,1}, new int[]{1,11}));   
		
		//horizontales
		h11.addObjeto(new Obstaculo(11, new int[]{1,12}, new int[]{0,0}));
		h11.addObjeto(new Obstaculo(11, new int[]{1,12}, new int[]{9,0}));  
		
		
		//Obstaculos
		//h11.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h11.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		
		Puerta p1 = new Puerta(1, new int[]{2, 0}, new int[]{20, 10});
		Puerta p2 = new Puerta(1, new int[]{3, 0}, new int[]{21, 10});
		Puerta p3 = new Puerta(1, new int[]{4, 0}, new int[]{22, 10});
				
		Habitacion h9 = new Habitacion(9, null, null, null);

		h11.addHabitacionesContigua(h9, new ArrayList<Puerta>(){pu1, pu2, pu3});
		 		
		return h11;
	}
	
	public Habitacion createHabitacion12(){
/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h12 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h12 = new Habitacion(12, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{12,18}, new ArrayList<Objeto>());
		
		//Paredes
		//h12.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h12.addObjeto(new Obstaculo(12, new int[]{8,1}, new int[]{0,0}));
		h12.addObjeto(new Obstaculo(12, new int[]{12,1}, new int[]{0,17}));   
		
		//horizontales
		h12.addObjeto(new Obstaculo(12, new int[]{1,1}, new int[]{6,1}));
		h12.addObjeto(new Obstaculo(12, new int[]{1,16}, new int[]{0,1}));
		h12.addObjeto(new Obstaculo(12, new int[]{1,17}, new int[]{11,0}));  
		
		
		//Obstaculos
		//h12.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h12.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		
		Puerta p1 = new Puerta(1, new int[]{8, 0}, new int[]{16, 6});
		Puerta p2 = new Puerta(1, new int[]{9, 0}, new int[]{17, 6});
		Puerta p3 = new Puerta(1, new int[]{10, 0}, new int[]{18, 6});
				
		Habitacion h9 = new Habitacion(9, null, null, null);

		h12.addHabitacionesContigua(h9, new	 ArrayList<Puerta>(){p1, p2, p3})
		 		
		return h12;
	}
	
	public Habitacion createHabitacion13(){
/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h13 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h13 = new Habitacion(13, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{11,16}, new ArrayList<Objeto>());
		
		//Paredes
		//h13.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h13.addObjeto(new Obstaculo(13, new int[]{11,1}, new int[]{0,0}));
		h13.addObjeto(new Obstaculo(13, new int[]{11,1}, new int[]{0,15}));   
		h13.addObjeto(new Obstaculo(13, new int[]{5,1}, new int[]{5,4}));  
		
		//horizontales
		h13.addObjeto(new Obstaculo(13, new int[]{1,14}, new int[]{10,1}));
		h13.addObjeto(new Obstaculo(13, new int[]{1,11}, new int[]{0,4}));
		
		
		//Obstaculos
		//h13.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h13.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
							
		Puerta p1 = new Puerta(1, new int[]{0, 1}, new int[]{19, 17});
		Puerta p2 = new Puerta(1, new int[]{0, 2}, new int[]{19, 18});
		Puerta p3 = new Puerta(1, new int[]{0, 3}, new int[]{19, 19});
				
		Habitacion h14 = new Habitacion(14, null, null, null);

		h13.addHabitacionesContigua(h14, new ArrayList<Puerta>(){p1, p2, p3});
		 		
		return h13;
	}
	
	public Habitacion createHabitacion14(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h14 = new Habitacion(NUMERO_HABITACION, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h14 = new Habitacion(14, new ArrayList<Pair<Habitacion, Puerta>>(), new int[]{22,24}, new ArrayList<Objeto>());
		
		//Paredes
		//h14.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h14.addObjeto(new Obstaculo(14, new int[]{20,1}, new int[]{0,0}));
		h14.addObjeto(new Obstaculo(14, new int[]{1,9}, new int[]{19,1}));
		h14.addObjeto(new Obstaculo(14, new int[]{3,1}, new int[]{19,10}));
		h14.addObjeto(new Obstaculo(14, new int[]{3,1}, new int[]{19,16}));
		h14.addObjeto(new Obstaculo(14, new int[]{7,1}, new int[]{13,20}));
		h14.addObjeto(new Obstaculo(14, new int[]{1,2}, new int[]{19,16}));
		h14.addObjeto(new Obstaculo(14, new int[]{9,1}, new int[]{5,23}));
		h14.addObjeto(new Obstaculo(14, new int[]{1,2}, new int[]{5,21}));
		h14.addObjeto(new Obstaculo(14, new int[]{6,1}, new int[]{0,20}));
		h14.addObjeto(new Obstaculo(14, new int[]{1,19}, new int[]{0,1}));
		h14.addObjeto(new Obstaculo(14, new int[]{10,1}, new int[]{4,14}));
		h14.addObjeto(new Obstaculo(14, new int[]{1,2}, new int[]{4,15}));
		h14.addObjeto(new Obstaculo(14, new int[]{1,2}, new int[]{13,15}));
		
		//Obstaculos
		//h14.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );

		//Terrenos
		//h14.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Habitacion h9= new Habitacion(9, null, null, null);
		Habitacion h13 = new Habitacion(13, null, null, null);
		
		h14.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{21,11}, new int[]{0, 1}) ));
		h14.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{21,12}, new int[]{0, 2}) ));
		h14.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{21,13}, new int[]{0, 3}) ));
		h14.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{21,14}, new int[]{0, 4}) ));
		h14.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h9, new Puerta(1, new int[]{21,15}, new int[]{0, 5}) ));

		h14.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h13, new Puerta(1, new int[]{19, 17}, new int[]{0, 1}) ));
		h14.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h13, new Puerta(1, new int[]{19, 18}, new int[]{0, 2}) ));
		h14.addHabitacionesContigua(new Pair<Habitacion, Puerta>(h13, new Puerta(1, new int[]{19, 19}, new int[]{0, 3}) ));
		
		
		/**
		 * Que les parece si mejor hacemos que en habitacion, el atributo habitacionesContiguas sea
		 * 	private List<Pair<Habitacion, List<Puerta>>> habitacionesContiguas; en lugar de
		 * 	private List<Pair<Habitacion, Puerta>> habitacionesContiguas;
		 * Así sería mas facil de agregar y además podríamos consultar directamente lista de puertas que
		 * podemos usar para pasar a cierta habitación.
		 * Quedaría algo así
		Puerta pu1 = new Puerta(1, new int[]{21,11}, new int[]{0, 1});
		Puerta pu2 = new Puerta(1, new int[]{21,12}, new int[]{0, 2});
		Puerta pu3 = new Puerta(1, new int[]{21,13}, new int[]{0, 3});
		Puerta pu4 = new Puerta(1, new int[]{21,14}, new int[]{0, 4});
		Puerta pu5 = new Puerta(1, new int[]{21,15}, new int[]{0, 5});
		addHabitacionesContigua(h9, new ArrayList<Puerta>(){pu1, pu2, pu3, pu4, pu5})
		 *No lo hice ahora porque habría que modificar el clone que hizo Lea
		*/
		
		return h14;
	}
	
	public void createHabitacion15(){
		
	}
}

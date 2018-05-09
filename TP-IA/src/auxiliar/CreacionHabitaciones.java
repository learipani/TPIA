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
	
	public void createHabitacion3(){
		
	}
	
	public void createHabitacion4(){
		
	}
	
	public void createHabitacion5(){
		
	}
	
	public void createHabitacion6(){
		
	}
	
	public void createHabitacion7(){
		
	}
	
	public void createHabitacion8(){
		
	}
	
	public void createHabitacion9(){
		
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

		addHabitacionesContigua(h9, new ArrayList<Puerta>(){pu1, pu2, pu3})
		 		
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

		addHabitacionesContigua(h9, new ArrayList<Puerta>(){pu1, pu2, pu3})
		 		
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

		addHabitacionesContigua(h9, new	 ArrayList<Puerta>(){p1, p2, p3})
		 		
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

		addHabitacionesContigua(h14, new ArrayList<Puerta>(){p1, p2, p3});
		 		
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

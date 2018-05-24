package auxiliar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.*;
import frsf.cidisi.faia.state.datastructure.Pair;

/*Cosas útiles:
 * Manejo de listas en JAVA: http://panamahitek.com/el-uso-de-listas-en-java/ 
 * */

public class CreacionHabitaciones {

	public static Habitacion createHabitacion1(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h1 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h1 = new Habitacion(1, new String[10][7], new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{71,3};
		h1.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{5,3};
		h1.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h1.addObjeto(new Pared(1, new int[]{1,7}, new int[]{0,0}));
		h1.addObjeto(new Pared(1, new int[]{1,7}, new int[]{9,0}));
		h1.addObjeto(new Pared(1, new int[]{8,1}, new int[]{1,0}));
		h1.addObjeto(new Pared(1, new int[]{3,1}, new int[]{6,6}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h1.addObjeto(new Obstaculo(1, new int[]{8,1}, new int[]{1,1}));
		h1.addObjeto(new Obstaculo(1, new int[]{1,4}, new int[]{8,2}));
		h1.addObjeto(new Obstaculo(1, new int[]{1,1}, new int[]{7,3}));
		h1.addObjeto(new Obstaculo(1, new int[]{1,4}, new int[]{8,2}));
		h1.addObjeto(new Obstaculo(1, new int[]{1,1}, new int[]{2,2}));
		
		//Terrenos
		h1.addObjeto(new PisoAlfombra(1, new int[]{1,4}, new int[]{1,2}));
		h1.addObjeto(new PisoMojado(1, new int[]{1,3}, new int[]{2,3}));
		h1.addObjeto(new PisoMojado(1, new int[]{1,4}, new int[]{3,2}));
		h1.addObjeto(new PisoAlfombra(1, new int[]{1,4}, new int[]{4,2}));
		h1.addObjeto(new PisoAlfombra(1, new int[]{1,4}, new int[]{5,2}));
		h1.addObjeto(new PisoAlfombra(1, new int[]{1,4}, new int[]{6,2}));
		h1.addObjeto(new PisoAlfombra(1, new int[]{1,1}, new int[]{7,2}));
		h1.addObjeto(new PisoAlfombra(1, new int[]{1,2}, new int[]{7,4}));
		
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Puerta pu1 = new Puerta(1, new int[]{1,6}, new int[]{1, 0});
		Puerta pu2 = new Puerta(1, new int[]{2,6}, new int[]{2, 0});
		Puerta pu3 = new Puerta(1, new int[]{3,6}, new int[]{3, 0});
		Puerta pu4 = new Puerta(1, new int[]{4,6}, new int[]{4, 0});
		Puerta pu5 = new Puerta(1, new int[]{5,6}, new int[]{5, 0});
		
		h1.addHabitacionContigua(new Pair<Integer, List<Puerta>> (2, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3, pu4, pu5))));

		//PlanoHabitacion
		h1.ActualizarPlanoHabitacion(new int[]{10,7});
		
		return h1;
	}
	
	public static Habitacion createHabitacion2(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h2 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h2 = new Habitacion(2, new String[16][7],  new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{73,9};
		h2.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{7,3};
		h2.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h2.addObjeto(new Pared(2, new int[]{1,3}, new int[]{0,0}));
		h2.addObjeto(new Pared(2, new int[]{1,6}, new int[]{15,0}));
		h2.addObjeto(new Pared(2, new int[]{3,1}, new int[]{13,6}));
		h2.addObjeto(new Pared(2, new int[]{9,1}, new int[]{6,0}));
		h2.addObjeto(new Pared(2, new int[]{10,1}, new int[]{0,6}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h2.addObjeto(new PisoMojado(2, new int[]{1,4}, new int[]{1,2}));
		h2.addObjeto(new PisoMojado(2, new int[]{1,4}, new int[]{2,2}));
		h2.addObjeto(new PisoMojado(2, new int[]{1,4}, new int[]{3,2}));
		h2.addObjeto(new PisoMojado(2, new int[]{1,5}, new int[]{7,1}));
		h2.addObjeto(new PisoAlfombra(2, new int[]{1,5}, new int[]{5,1}));
		h2.addObjeto(new PisoAlfombra(2, new int[]{1,5}, new int[]{4,1}));
		h2.addObjeto(new PisoAlfombra(2, new int[]{1,5}, new int[]{6,1}));
		h2.addObjeto(new PisoAlfombra(2, new int[]{3,1}, new int[]{1,1}));
		
		/*prueba agente hab 2 en 8,3 y smartphone en hab e en 1,1
		h2.addObjeto(new PisoMojado(2, new int[]{1,3}, new int[]{9,3}));
		h2.addObjeto(new PisoMojado(2, new int[]{1,1}, new int[]{10,3}));
		h2.addObjeto(new PisoAlfombra(2, new int[]{1,1}, new int[]{10,4}));
		h2.addObjeto(new PisoAlfombra(2, new int[]{1,1}, new int[]{10,5}));
		h2.addObjeto(new PisoMojado(2, new int[]{1,3}, new int[]{11,3}));*/
		
		
		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})

		Puerta pu1 = new Puerta(1, new int[]{1,0}, new int[]{1, 6});
		Puerta pu2 = new Puerta(1, new int[]{2,0}, new int[]{2, 6});
		Puerta pu3 = new Puerta(1, new int[]{3,0}, new int[]{3, 6});
		Puerta pu4 = new Puerta(1, new int[]{4,0}, new int[]{4, 6});
		Puerta pu5 = new Puerta(1, new int[]{5,0}, new int[]{5, 6});
		h2.addHabitacionContigua(new Pair<Integer, List<Puerta>> (1, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3, pu4, pu5))));

		Puerta pu6 = new Puerta(2, new int[]{10,6}, new int[]{1, 0});
		Puerta pu7 = new Puerta(2, new int[]{11,6}, new int[]{2, 0});
		Puerta pu8 = new Puerta(2, new int[]{12,6}, new int[]{3, 0});
		h2.addHabitacionContigua(new Pair<Integer, List<Puerta>> (3, new ArrayList<Puerta>(Arrays.asList(pu6, pu7, pu8))));
		
		/*Puerta pu9 = new Puerta(3, new int[]{0,3}, new int[]{32, 1});
		Puerta pu10 = new Puerta(3, new int[]{0,4}, new int[]{32, 2});
		Puerta pu11 = new Puerta(3, new int[]{0,5}, new int[]{32, 3});
		h2.addHabitacionContigua(new Pair<Integer, List<Puerta>> (7, new ArrayList<Puerta>(Arrays.asList(pu9, pu10, pu11))));
		*//*Para que vaya a la hab 3 y no se vaya por la 7 cargamos la pared de la linea de abajo tapando
		 * la puerta que lleva a hab 7
			h2.addObjeto(new Pared(2, new int[]{1,3}, new int[]{0,3}));
		*/
		h2.addObjeto(new Pared(2, new int[]{1,3}, new int[]{0,3}));
		
		//PlanoHabitacion
		h2.ActualizarPlanoHabitacion(new int[]{16,7});
		
		return h2;
	}
	
	public static Habitacion createHabitacion3(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h3 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h3 = new Habitacion(3, new String[15][11],  new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{82,17};
		h3.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{7,2};
		h3.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h3.addObjeto(new Pared(3, new int[]{1,4}, new int[]{0,0}));
		h3.addObjeto(new Pared(3, new int[]{1,4}, new int[]{0,7}));
		h3.addObjeto(new Pared(3, new int[]{10,1}, new int[]{4,0}));
		h3.addObjeto(new Pared(3, new int[]{13,1}, new int[]{1,10}));
		h3.addObjeto(new Pared(3, new int[]{1,11}, new int[]{14,0}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//CAMA Y MESAS DE LUZ
		h3.addObjeto(new Obstaculo(3, new int[]{1,7}, new int[]{5,3}));
		h3.addObjeto(new Obstaculo(3, new int[]{1,7}, new int[]{6,3}));
		h3.addObjeto(new Obstaculo(3, new int[]{1,7}, new int[]{7,3}));
		h3.addObjeto(new Obstaculo(3, new int[]{1,7}, new int[]{8,3}));
		h3.addObjeto(new Obstaculo(3, new int[]{1,7}, new int[]{9,3}));
		
		h3.addObjeto(new Pared(3, new int[]{1,2}, new int[]{3,8}));
		h3.addObjeto(new Pared(3, new int[]{1,2}, new int[]{4,8}));
		
		h3.addObjeto(new Pared(3, new int[]{1,2}, new int[]{10,8}));
		h3.addObjeto(new Pared(3, new int[]{1,2}, new int[]{11,8}));
		
		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Puerta pu1 = new Puerta(1, new int[]{1,0}, new int[]{10, 6});
		Puerta pu2 = new Puerta(1, new int[]{2,0}, new int[]{11, 6});
		Puerta pu3 = new Puerta(1, new int[]{3,0}, new int[]{12, 6});
		h3.addHabitacionContigua(new Pair<Integer, List<Puerta>> (2, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3))));
		
		Puerta pu4 = new Puerta(2, new int[]{0,4}, new int[]{6, 4});
		Puerta pu5 = new Puerta(2, new int[]{0,5}, new int[]{6, 5});
		Puerta pu6 = new Puerta(2, new int[]{0,6}, new int[]{6, 6});
		h3.addHabitacionContigua(new Pair<Integer, List<Puerta>> (4, new ArrayList<Puerta>(Arrays.asList(pu4, pu5, pu6))));

		//PlanoHabitacion
		h3.ActualizarPlanoHabitacion(new int[]{15,11});
				
		return h3;
	}
	
	public static Habitacion createHabitacion4(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h4 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h4 = new Habitacion(4, new String[7][11],  new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{72,17};
		h4.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{4,5};
		h4.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h4.addObjeto(new Pared(4, new int[]{1,11}, new int[]{0,0}));
		h4.addObjeto(new Pared(4, new int[]{5,1}, new int[]{1,0}));
		h4.addObjeto(new Pared(4, new int[]{5,1}, new int[]{1,10}));
		h4.addObjeto(new Pared(4, new int[]{1,4}, new int[]{6,0}));
		h4.addObjeto(new Pared(4, new int[]{1,4}, new int[]{6,7}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		
		h4.addObjeto(new Obstaculo(4, new int[]{5,1}, new int[]{1,1}));
		h4.addObjeto(new Obstaculo(4, new int[]{5,1}, new int[]{1,2}));
		h4.addObjeto(new Obstaculo(4, new int[]{1,3}, new int[]{1,4}));
		h4.addObjeto(new Obstaculo(4, new int[]{1,3}, new int[]{2,4}));
		h4.addObjeto(new Obstaculo(4, new int[]{1,2}, new int[]{3,8}));
		h4.addObjeto(new Obstaculo(4, new int[]{1,2}, new int[]{4,8}));
		
		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Puerta pu1 = new Puerta(3, new int[]{6,4}, new int[]{0,4});
		Puerta pu2 = new Puerta(3, new int[]{6,5}, new int[]{0,5});
		Puerta pu3 = new Puerta(3, new int[]{6,6}, new int[]{0,6});
		h4.addHabitacionContigua(new Pair<Integer, List<Puerta>> (3, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3))));

		//PlanoHabitacion
		h4.ActualizarPlanoHabitacion(new int[]{7,11});
		
		return h4;
	}
	
	public static Habitacion createHabitacion5(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h5 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h5 = new Habitacion(5, new String[20][29], new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{79,31};
		h5.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{9,9};
		h5.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h5.addObjeto(new Pared(5, new int[]{1,10}, new int[]{0,0}));
		h5.addObjeto(new Pared(5, new int[]{1,7}, new int[]{0,13}));
		h5.addObjeto(new Pared(5, new int[]{1,9}, new int[]{3,20}));
		h5.addObjeto(new Pared(5, new int[]{1,20}, new int[]{19,0}));
		h5.addObjeto(new Pared(5, new int[]{1,9}, new int[]{16,20}));
		h5.addObjeto(new Pared(5, new int[]{18,1}, new int[]{1,0}));
		h5.addObjeto(new Pared(5, new int[]{3,1}, new int[]{1,19}));
		h5.addObjeto(new Pared(5, new int[]{3,1}, new int[]{16,19}));
		h5.addObjeto(new Pared(5, new int[]{12,1}, new int[]{4,28}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//AUTO 1
		h5.addObjeto(new Obstaculo(5, new int[]{8,1}, new int[]{6,3}));
		h5.addObjeto(new Obstaculo(5, new int[]{8,1}, new int[]{6,4}));
		h5.addObjeto(new Obstaculo(5, new int[]{8,1}, new int[]{6,5}));
		h5.addObjeto(new Obstaculo(5, new int[]{8,1}, new int[]{6,6}));
		h5.addObjeto(new Obstaculo(5, new int[]{8,1}, new int[]{6,7}));
		h5.addObjeto(new Pared(5, new int[]{1,1}, new int[]{7,2}));
		h5.addObjeto(new Pared(5, new int[]{1,1}, new int[]{12,2}));
		h5.addObjeto(new Pared(5, new int[]{1,1}, new int[]{7,8}));
		h5.addObjeto(new Pared(5, new int[]{1,1}, new int[]{12,8}));
		h5.addObjeto(new Obstaculo(5, new int[]{1,3}, new int[]{5,4}));
		h5.addObjeto(new Obstaculo(5, new int[]{1,3}, new int[]{14,4}));
		//AUTO 2
		h5.addObjeto(new Obstaculo(5, new int[]{8,1}, new int[]{6,12}));
		h5.addObjeto(new Obstaculo(5, new int[]{8,1}, new int[]{6,13}));
		h5.addObjeto(new Obstaculo(5, new int[]{8,1}, new int[]{6,14}));
		h5.addObjeto(new Obstaculo(5, new int[]{8,1}, new int[]{6,15}));
		h5.addObjeto(new Obstaculo(5, new int[]{8,1}, new int[]{6,16}));
		h5.addObjeto(new Pared(5, new int[]{1,1}, new int[]{7,11}));
		h5.addObjeto(new Pared(5, new int[]{1,1}, new int[]{12,11}));
		h5.addObjeto(new Pared(5, new int[]{1,1}, new int[]{7,17}));
		h5.addObjeto(new Pared(5, new int[]{1,1}, new int[]{12,17}));
		h5.addObjeto(new Obstaculo(5, new int[]{1,3}, new int[]{5,13}));
		h5.addObjeto(new Obstaculo(5, new int[]{1,3}, new int[]{14,13}));

		
		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Puerta pu1 = new Puerta(1, new int[]{0,10}, new int[]{48,3});
		Puerta pu2 = new Puerta(1, new int[]{0,11}, new int[]{48,4});
		Puerta pu3 = new Puerta(1, new int[]{0,12}, new int[]{48,5});
		h5.addHabitacionContigua(new Pair<Integer, List<Puerta>> (9, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3))));
	
		//PlanoHabitacion
		h5.ActualizarPlanoHabitacion(new int[]{20,29});
		
		return h5;
	}
	
	public static Habitacion createHabitacion6(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h6 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h6 = new Habitacion(6,new String[28][14],  new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{51,4};
		h6.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{12,4};
		h6.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h6.addObjeto(new Pared(6, new int[]{1,14}, new int[]{0,0}));
		h6.addObjeto(new Pared(6, new int[]{1,9}, new int[]{27,0}));
		h6.addObjeto(new Pared(6, new int[]{1,6}, new int[]{12,8}));
		h6.addObjeto(new Pared(6, new int[]{26,1}, new int[]{1,0}));
		h6.addObjeto(new Pared(6, new int[]{7,1}, new int[]{20,8}));
		h6.addObjeto(new Pared(6, new int[]{11,1}, new int[]{1,13}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h6.addObjeto(new Obstaculo(6, new int[]{2,1}, new int[]{1,1}));
		h6.addObjeto(new Obstaculo(6, new int[]{2,1}, new int[]{1,2}));
		
		h6.addObjeto(new Obstaculo(6, new int[]{1,9}, new int[]{1,4}));
		h6.addObjeto(new Pared(6, new int[]{1,7}, new int[]{2,5}));
		h6.addObjeto(new Pared(6, new int[]{1,7}, new int[]{3,5}));
		h6.addObjeto(new Obstaculo(6, new int[]{2,1}, new int[]{2,4}));
		h6.addObjeto(new Obstaculo(6, new int[]{8,1}, new int[]{2,12}));
		h6.addObjeto(new Obstaculo(6, new int[]{1,2}, new int[]{9,10}));
		h6.addObjeto(new Pared(6, new int[]{5,1}, new int[]{4,10}));
		h6.addObjeto(new Pared(6, new int[]{5,1}, new int[]{4,11}));
		h6.addObjeto(new Obstaculo(6, new int[]{6,1}, new int[]{4,1}));
		h6.addObjeto(new Pared(6, new int[]{4,1}, new int[]{5,2}));
		h6.addObjeto(new Pared(6, new int[]{4,1}, new int[]{5,3}));
		h6.addObjeto(new Obstaculo(6, new int[]{1,2}, new int[]{4,2}));
		h6.addObjeto(new Obstaculo(6, new int[]{1,2}, new int[]{9,2}));
		
		h6.addObjeto(new Obstaculo(6, new int[]{2,1}, new int[]{6,6}));
		h6.addObjeto(new Obstaculo(6, new int[]{2,1}, new int[]{6,7}));
		
		h6.addObjeto(new PisoAlfombra(6, new int[]{3,1}, new int[]{1,3}));
		h6.addObjeto(new PisoAlfombra(6, new int[]{1,2}, new int[]{3,1}));
		
		h6.addObjeto(new PisoAlfombra(6, new int[]{1,6}, new int[]{4,4}));
		h6.addObjeto(new PisoAlfombra(6, new int[]{1,6}, new int[]{5,4}));
		h6.addObjeto(new PisoAlfombra(6, new int[]{1,6}, new int[]{8,4}));
		h6.addObjeto(new PisoAlfombra(6, new int[]{1,6}, new int[]{9,4}));
		h6.addObjeto(new PisoAlfombra(6, new int[]{1,12}, new int[]{10,1}));
		h6.addObjeto(new PisoAlfombra(6, new int[]{1,12}, new int[]{11,1}));
		h6.addObjeto(new PisoAlfombra(6, new int[]{2,1}, new int[]{6,4}));
		h6.addObjeto(new PisoAlfombra(6, new int[]{2,1}, new int[]{6,5}));
		h6.addObjeto(new PisoAlfombra(6, new int[]{2,1}, new int[]{6,8}));
		h6.addObjeto(new PisoAlfombra(6, new int[]{2,1}, new int[]{6,9}));
		
		h6.addObjeto(new Pared(6, new int[]{1,5}, new int[]{24,2}));
		
		h6.addObjeto(new Obstaculo(6, new int[]{9,1}, new int[]{14,1}));
		
		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})

		Puerta pu1 = new Puerta(1, new int[]{13,8}, new int[]{18,0});
		Puerta pu2 = new Puerta(1, new int[]{14,8}, new int[]{19,0});
		Puerta pu3 = new Puerta(1, new int[]{15,8}, new int[]{20,0});
		Puerta pu4 = new Puerta(1, new int[]{16,8}, new int[]{21,0});
		Puerta pu5 = new Puerta(1, new int[]{17,8}, new int[]{22,0});
		Puerta pu6 = new Puerta(1, new int[]{18,8}, new int[]{23,0});
		Puerta pu7 = new Puerta(1, new int[]{19,8}, new int[]{24,0});
		h6.addHabitacionContigua(new Pair<Integer, List<Puerta>> (7, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3, pu4, pu5, pu6, pu7))));
		
		//PlanoHabitacion
		h6.ActualizarPlanoHabitacion(new int[]{28,14});
		
		return h6;
	}
	
	public static Habitacion createHabitacion7(){
/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h7 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h7 = new Habitacion(7,new String[36][23],  new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heuristica
		int[] ubicacion = new int[]{52,19};
		h7.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{18,11};
		h7.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h7.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h7.addObjeto(new Pared(7, new int[]{18,1}, new int[]{0,5}));
		h7.addObjeto(new Pared(7, new int[]{8,1}, new int[]{25,0}));   
		h7.addObjeto(new Pared(7, new int[]{4,1}, new int[]{32,4}));
		h7.addObjeto(new Pared(7, new int[]{4,1}, new int[]{31,22}));   
		h7.addObjeto(new Pared(7, new int[]{19,1}, new int[]{12,19}));   
		h7.addObjeto(new Pared(7, new int[]{5,1}, new int[]{0,21}));   
		h7.addObjeto(new Pared(7, new int[]{5,1}, new int[]{0,11}));   

		
		//horizontales
		h7.addObjeto(new Pared(7, new int[]{1,5}, new int[]{17,0}));
		h7.addObjeto(new Pared(7, new int[]{1,18}, new int[]{35,5}));  
		h7.addObjeto(new Pared(7, new int[]{1,3}, new int[]{31,19}));  
		h7.addObjeto(new Pared(7, new int[]{1,2}, new int[]{12,20}));		
		h7.addObjeto(new Pared(7, new int[]{1,9}, new int[]{0,12}));
		
		
		//Obstaculos
		//h7.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//heladera
		h7.addObjeto( new Obstaculo(7, new int[]{3, 1}, new int[]{32, 6}));
		h7.addObjeto( new Obstaculo(7, new int[]{3, 1}, new int[]{32, 7}));
		h7.addObjeto( new Obstaculo(7, new int[]{3, 1}, new int[]{32, 8}));
		//mesada
		h7.addObjeto( new Obstaculo(7, new int[]{1, 9}, new int[]{32, 10}));
		h7.addObjeto( new Obstaculo(7, new int[]{1, 9}, new int[]{33, 10}));
		h7.addObjeto( new Obstaculo(7, new int[]{1, 9}, new int[]{34, 10}));
		//mesa
		h7.addObjeto( new Obstaculo(7, new int[]{1, 7}, new int[]{25, 9}));
		h7.addObjeto( new Obstaculo(7, new int[]{1, 7}, new int[]{26, 9}));
		h7.addObjeto( new Obstaculo(7, new int[]{1, 7}, new int[]{27, 9}));
		//sillas
		h7.addObjeto( new Obstaculo(7, new int[]{1, 1}, new int[]{26, 8}));
		h7.addObjeto( new Obstaculo(7, new int[]{1, 1}, new int[]{26, 16}));
		h7.addObjeto( new Obstaculo(7, new int[]{1, 1}, new int[]{24, 10}));
		h7.addObjeto( new Obstaculo(7, new int[]{1, 1}, new int[]{24, 12}));
		h7.addObjeto( new Obstaculo(7, new int[]{1, 1}, new int[]{24, 14}));
		h7.addObjeto( new Obstaculo(7, new int[]{1, 1}, new int[]{28, 10}));
		h7.addObjeto( new Obstaculo(7, new int[]{1, 1}, new int[]{28, 12}));
		h7.addObjeto( new Obstaculo(7, new int[]{1, 1}, new int[]{28, 14}));
		//alfombra
		h7.addObjeto( new PisoAlfombra(7, new int[]{3, 1}, new int[]{20, 2}));
		h7.addObjeto( new PisoAlfombra(7, new int[]{3, 1}, new int[]{20, 3}));
		//
		h7.addObjeto( new Obstaculo(7, new int[]{5, 1}, new int[]{4, 15}));
		h7.addObjeto( new Obstaculo(7, new int[]{5, 1}, new int[]{4, 16}));
		h7.addObjeto( new Obstaculo(7, new int[]{5, 1}, new int[]{4, 17}));
		h7.addObjeto( new Obstaculo(7, new int[]{5, 1}, new int[]{4, 18}));
		
		//h7.addObjeto( new PisoAlfombra(7, new int[]{1, 1}, new int[]{5, 10}));
		//h7.addObjeto( new PisoAlfombra(7, new int[]{1, 1}, new int[]{5, 8}));
		//h7.addObjeto( new PisoAlfombra(7, new int[]{1, 1}, new int[]{5, 8}));
		
		//Escalera
		//h7.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );
		h7.addObjeto( new Escalera(7, new int[]{1, 5}, new int[]{1, 6}));
		h7.addObjeto( new Escalera(7, new int[]{1, 5}, new int[]{2, 6}));
		h7.addObjeto( new Escalera(7, new int[]{1, 5}, new int[]{3, 6}));
		h7.addObjeto( new Escalera(7, new int[]{1, 5}, new int[]{4, 6}));
		
		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		
		Puerta p11 = new Puerta(1, new int[]{0, 6}, new int[]{15, 1});
		Puerta p12 = new Puerta(1, new int[]{0, 7}, new int[]{15, 2});
		Puerta p13 = new Puerta(1, new int[]{0, 8}, new int[]{15, 3});
		Puerta p14 = new Puerta(1, new int[]{0, 9}, new int[]{15, 4});
		Puerta p15 = new Puerta(1, new int[]{0, 10}, new int[]{15, 5});
		h7.addHabitacionContigua(new Pair<Integer, List<Puerta>> (15, new ArrayList<Puerta>(Arrays.asList(p11, p12, p13,p14,p15))));
		
		Puerta p21 = new Puerta(2, new int[]{5, 21}, new int[]{18, 0});
		Puerta p22 = new Puerta(2, new int[]{6, 21}, new int[]{19, 0});
		Puerta p23 = new Puerta(2, new int[]{7, 21}, new int[]{20, 0});
		Puerta p24 = new Puerta(2, new int[]{8, 21}, new int[]{21, 0});
		Puerta p25 = new Puerta(2, new int[]{9, 21}, new int[]{22, 0});
		Puerta p26 = new Puerta(2, new int[]{10, 21}, new int[]{23, 0});
		Puerta p27 = new Puerta(2, new int[]{11, 21}, new int[]{24, 0});
		h7.addHabitacionContigua(new Pair<Integer, List<Puerta>> (9, new ArrayList<Puerta>(Arrays.asList(p21, p22, p23,p24,p25,p26,p27))));
		
		Puerta p31 = new Puerta(3, new int[]{18, 0}, new int[]{13, 8});
		Puerta p32 = new Puerta(3, new int[]{19, 0}, new int[]{14, 8});
		Puerta p33 = new Puerta(3, new int[]{20, 0}, new int[]{15, 8});
		Puerta p34 = new Puerta(4, new int[]{21, 0}, new int[]{16, 8});
		Puerta p35 = new Puerta(4, new int[]{22, 0}, new int[]{17, 8});
		Puerta p36 = new Puerta(4, new int[]{23, 0}, new int[]{18, 8});
		Puerta p37 = new Puerta(5, new int[]{24, 0}, new int[]{19, 8});
		h7.addHabitacionContigua(new Pair<Integer, List<Puerta>> (6, new ArrayList<Puerta>(Arrays.asList(p31, p32, p33,p34,p35,p36,p37))));
		
		Puerta p41 = new Puerta(5, new int[]{32, 1}, new int[]{0, 3});
		Puerta p42 = new Puerta(5, new int[]{32, 2}, new int[]{0, 4});
		Puerta p43 = new Puerta(6, new int[]{32, 3}, new int[]{0, 5});
		h7.addHabitacionContigua(new Pair<Integer, List<Puerta>> (2, new ArrayList<Puerta>(Arrays.asList(p41, p42, p43))));
	
		//PlanoHabitacion
		h7.ActualizarPlanoHabitacion(new int[]{36,23});
		
		return h7;
	}
	
	public static Habitacion createHabitacion8(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h8 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h8 = new Habitacion(8,new String[11][13],  new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{44,67};
		h8.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{5,6};
		h8.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h2.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h8.addObjeto(new Pared(8, new int[]{1,13}, new int[]{0,0}));
		h8.addObjeto(new Pared(8, new int[]{1,4}, new int[]{7,0}));
		h8.addObjeto(new Pared(8, new int[]{1,10}, new int[]{10,3}));
		h8.addObjeto(new Pared(8, new int[]{2,1}, new int[]{5,0}));
		h8.addObjeto(new Pared(8, new int[]{2,1}, new int[]{8,3}));
		h8.addObjeto(new Pared(8, new int[]{9,1}, new int[]{1,12}));
		
		//Obstaculos
		//h1.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		
		h8.addObjeto(new Obstaculo(8, new int[]{1,8}, new int[]{7,4}));
		h8.addObjeto(new Obstaculo(8, new int[]{1,8}, new int[]{8,4}));
		h8.addObjeto(new Obstaculo(8, new int[]{1,8}, new int[]{9,4}));
		
		h8.addObjeto(new Obstaculo(8, new int[]{3,1}, new int[]{2,7}));
		h8.addObjeto(new Obstaculo(8, new int[]{3,1}, new int[]{2,8}));
		h8.addObjeto(new Pared(8, new int[]{1,1}, new int[]{3,6}));
		h8.addObjeto(new Pared(8, new int[]{1,1}, new int[]{3,9}));
		
		//Terrenos
		//h1.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Puerta pu1 = new Puerta(1, new int[]{1,0}, new int[]{42,9});
		Puerta pu2 = new Puerta(1, new int[]{2,0}, new int[]{43,9});
		Puerta pu3 = new Puerta(1, new int[]{3,0}, new int[]{44,9});
		Puerta pu4 = new Puerta(1, new int[]{4,0}, new int[]{45,9});
		h8.addHabitacionContigua(new Pair<Integer, List<Puerta>> (9, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3, pu4))));
		
		//PlanoHabitacion
		h8.ActualizarPlanoHabitacion(new int[]{11,13});
		
		return h8;
	}
	
	public static Habitacion createHabitacion9(){
/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h9 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h9 = new Habitacion(9,new String[49][11],  new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{43,32};
		h9.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{22,3};
		h9.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h9.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h9.addObjeto(new Pared(9, new int[]{18,1}, new int[]{0,0}));
		h9.addObjeto(new Pared(9, new int[]{23,1}, new int[]{26,1}));   
		h9.addObjeto(new Pared(9, new int[]{16,1}, new int[]{0,6}));
		h9.addObjeto(new Pared(9, new int[]{6,1}, new int[]{23,6}));   
		h9.addObjeto(new Pared(9, new int[]{10,1}, new int[]{32,6}));   
		h9.addObjeto(new Pared(9, new int[]{2,1}, new int[]{46,9}));   

		
		//horizontales
		h9.addObjeto(new Pared(9, new int[]{1,2}, new int[]{25,0}));
		h9.addObjeto(new Pared(9, new int[]{1,1}, new int[]{48,2}));  
		h9.addObjeto(new Pared(9, new int[]{1,4}, new int[]{48,6}));  
		h9.addObjeto(new Pared(9, new int[]{1,4}, new int[]{41,7}));		
		h9.addObjeto(new Pared(9, new int[]{1,4}, new int[]{23,7}));
		h9.addObjeto(new Pared(9, new int[]{1,5}, new int[]{19,6}));  
		
		
		//Obstaculos
		//h9.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h9.addObjeto(new Escalera(6, new int[]{1,5}, new int[]{9,1}));
		h9.addObjeto(new Escalera(6, new int[]{1,5}, new int[]{10,1}));
		h9.addObjeto(new Escalera(6, new int[]{1,5}, new int[]{11,1}));
		h9.addObjeto(new Escalera(6, new int[]{1,5}, new int[]{12,1}));
		
		
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

		h9.addHabitacionContigua(new Pair<Integer, List<Puerta>> (14, new ArrayList<Puerta>(Arrays.asList(p11, p12, p13,p14,p15))));
		h9.addHabitacionContigua(new Pair<Integer, List<Puerta>> (7, new ArrayList<Puerta>(Arrays.asList(p21, p22, p23,p24,p25,p26,p27))));
		h9.addHabitacionContigua(new Pair<Integer, List<Puerta>> (12, new ArrayList<Puerta>(Arrays.asList(p31, p32, p33))));
		h9.addHabitacionContigua(new Pair<Integer, List<Puerta>> (11, new ArrayList<Puerta>(Arrays.asList(p41, p42, p43))));
		h9.addHabitacionContigua(new Pair<Integer, List<Puerta>> (10, new ArrayList<Puerta>(Arrays.asList(p51, p52, p53))));
		h9.addHabitacionContigua(new Pair<Integer, List<Puerta>> (8, new ArrayList<Puerta>(Arrays.asList(p61, p62, p63,p64))));
		h9.addHabitacionContigua(new Pair<Integer, List<Puerta>> (5, new ArrayList<Puerta>(Arrays.asList(p71, p72, p73))));
		 		
		//PlanoHabitacion
		h9.ActualizarPlanoHabitacion(new int[]{49,11});
		
		return h9;
	}
	
	public static Habitacion createHabitacion10(){
/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h10 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h10 = new Habitacion(10,new String[14][18],  new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{56,42};
		h10.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{6,8};
		h10.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h10.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h10.addObjeto(new Pared(10, new int[]{9,1}, new int[]{4,0}));
		h10.addObjeto(new Pared(10, new int[]{12,1}, new int[]{1,17}));   
		
		//horizontales
		h10.addObjeto(new Pared(10, new int[]{1,18}, new int[]{0,0}));
		h10.addObjeto(new Pared(10, new int[]{1,18}, new int[]{13,0}));  
		h10.addObjeto(new Pared(10, new int[]{1,1}, new int[]{4,1}));  
		
		
		//Obstaculos
		//h10.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		
		h10.addObjeto(new Pared(12, new int[]{1,2}, new int[]{4,15}));
		h10.addObjeto(new Pared(12, new int[]{1,2}, new int[]{5,15}));
		h10.addObjeto(new Pared(12, new int[]{1,2}, new int[]{11,15}));
		h10.addObjeto(new Pared(12, new int[]{1,2}, new int[]{12,15}));
		
		h10.addObjeto(new Obstaculo(12, new int[]{1,8}, new int[]{6,9}));
		h10.addObjeto(new Obstaculo(12, new int[]{1,8}, new int[]{7,9}));
		h10.addObjeto(new Obstaculo(12, new int[]{1,8}, new int[]{8,9}));
		h10.addObjeto(new Obstaculo(12, new int[]{1,8}, new int[]{9,9}));
		h10.addObjeto(new Obstaculo(12, new int[]{1,8}, new int[]{10,9}));
		
		h10.addObjeto(new Pared(12, new int[]{4,1}, new int[]{7,1}));
		
		h10.addObjeto(new Obstaculo(12, new int[]{1,7}, new int[]{1,6}));
		h10.addObjeto(new Obstaculo(12, new int[]{1,7}, new int[]{2,6}));
		
		h10.addObjeto(new PisoAlfombra(12, new int[]{5,1}, new int[]{6,5}));
		h10.addObjeto(new PisoAlfombra(12, new int[]{5,1}, new int[]{6,6}));
		h10.addObjeto(new PisoAlfombra(12, new int[]{5,1}, new int[]{6,7}));
		
		//Terrenos
		//h10.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Puerta pu1 = new Puerta(1, new int[]{1, 0}, new int[]{29, 6});
		Puerta pu2 = new Puerta(1, new int[]{2, 0}, new int[]{30, 6});
		Puerta pu3 = new Puerta(1, new int[]{3, 0}, new int[]{31, 6});
		h10.addHabitacionContigua(new Pair<Integer, List<Puerta>> (9, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3))));
		 		
		//PlanoHabitacion
		h10.ActualizarPlanoHabitacion(new int[]{14,18});
		
		return h10;
	}
	
	public static Habitacion createHabitacion11(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h11 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h11 = new Habitacion(11,new String[10][12],  new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{44,45};
		h11.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{4,5};
		h11.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h11.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h11.addObjeto(new Pared(11, new int[]{5,1}, new int[]{4,0}));
		h11.addObjeto(new Pared(11, new int[]{8,1}, new int[]{1,11}));   
		
		//horizontales
		h11.addObjeto(new Pared(11, new int[]{1,12}, new int[]{0,0}));
		h11.addObjeto(new Pared(11, new int[]{1,12}, new int[]{9,0}));  
		
		//Obstaculos
		//h11.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h11.addObjeto(new Obstaculo(11, new int[]{6,1}, new int[]{3,7}));
		h11.addObjeto(new Obstaculo(11, new int[]{6,1}, new int[]{3,10}));
		h11.addObjeto(new Obstaculo(11, new int[]{1,2}, new int[]{3,8}));
		h11.addObjeto(new Obstaculo(11, new int[]{1,2}, new int[]{8,8}));
		
		h11.addObjeto(new PisoMojado(11, new int[]{4,1}, new int[]{4,8}));
		h11.addObjeto(new PisoMojado(11, new int[]{4,1}, new int[]{4,9}));
		
		h11.addObjeto(new Obstaculo(11, new int[]{5,1}, new int[]{4,1}));
		h11.addObjeto(new Obstaculo(11, new int[]{5,1}, new int[]{4,2}));
		h11.addObjeto(new Pared(11, new int[]{2,1}, new int[]{6,2}));
		
		h11.addObjeto(new Obstaculo(11, new int[]{1,2}, new int[]{1,4}));
		h11.addObjeto(new Obstaculo(11, new int[]{1,2}, new int[]{2,4}));
		
		//Terrenos
		//h11.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Puerta pu1 = new Puerta(1, new int[]{1, 0}, new int[]{20, 10});
		Puerta pu2 = new Puerta(1, new int[]{2, 0}, new int[]{21, 10});
		Puerta pu3 = new Puerta(1, new int[]{3, 0}, new int[]{22, 10});
		h11.addHabitacionContigua(new Pair<Integer, List<Puerta>> (9, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3))));
		 		
		//PlanoHabitacion
		h11.ActualizarPlanoHabitacion(new int[]{10,12});
		
		return h11;
	}
	
	public static Habitacion createHabitacion12(){
/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h12 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h12 = new Habitacion(12, new String[12][18], new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{35,43};
		h12.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{6,8};
		h12.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h12.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h12.addObjeto(new Pared(12, new int[]{8,1}, new int[]{0,0}));
		h12.addObjeto(new Pared(12, new int[]{12,1}, new int[]{0,17}));   
		
		//horizontales
		h12.addObjeto(new Pared(12, new int[]{1,1}, new int[]{6,1}));
		h12.addObjeto(new Pared(12, new int[]{1,16}, new int[]{0,1}));
		h12.addObjeto(new Pared(12, new int[]{1,17}, new int[]{11,0}));  
		
		
		//Obstaculos
		//h12.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h12.addObjeto(new Obstaculo(12, new int[]{5,1}, new int[]{1,1}));
		h12.addObjeto(new Obstaculo(12, new int[]{5,1}, new int[]{1,2}));
		
		h12.addObjeto(new Pared(12, new int[]{1,2}, new int[]{1,15}));
		h12.addObjeto(new Pared(12, new int[]{1,2}, new int[]{2,15}));
		h12.addObjeto(new Pared(12, new int[]{1,2}, new int[]{8,15}));
		h12.addObjeto(new Pared(12, new int[]{1,2}, new int[]{9,15}));
		
		h12.addObjeto(new Obstaculo(12, new int[]{1,8}, new int[]{3,9}));
		h12.addObjeto(new Obstaculo(12, new int[]{1,8}, new int[]{4,9}));
		h12.addObjeto(new Obstaculo(12, new int[]{1,8}, new int[]{5,9}));
		h12.addObjeto(new Obstaculo(12, new int[]{1,8}, new int[]{6,9}));
		h12.addObjeto(new Obstaculo(12, new int[]{1,8}, new int[]{7,9}));
		
		
		
		//Terrenos
		//h12.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		
		Puerta pu1 = new Puerta(1, new int[]{8, 0}, new int[]{16, 6});
		Puerta pu2 = new Puerta(1, new int[]{9, 0}, new int[]{17, 6});
		Puerta pu3 = new Puerta(1, new int[]{10, 0}, new int[]{18, 6});
		h12.addHabitacionContigua(new Pair<Integer, List<Puerta>> (9, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3))));
		 		
		//PlanoHabitacion
		h12.ActualizarPlanoHabitacion(new int[]{12,18});
		
		return h12;
	}
	
	public static Habitacion createHabitacion13(){
/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h13 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h13 = new Habitacion(13,new String[11][16],  new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro de la habitacion para la heeristica
		int[] ubicacion = new int[]{23,43};
		h13.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro global local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{4,8};
		h13.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h13.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//verticales
		h13.addObjeto(new Pared(13, new int[]{11,1}, new int[]{0,0}));
		h13.addObjeto(new Pared(13, new int[]{11,1}, new int[]{0,15}));   
		h13.addObjeto(new Pared(13, new int[]{6,1}, new int[]{4,5}));  
		
		//horizontales
		h13.addObjeto(new Pared(13, new int[]{1,14}, new int[]{10,1}));
		h13.addObjeto(new Pared(13, new int[]{1,11}, new int[]{0,4}));
		
		
		//Obstaculos
		//h13.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h13.addObjeto(new Obstaculo(13, new int[]{6,1}, new int[]{4,1}));
		h13.addObjeto(new Obstaculo(13, new int[]{6,1}, new int[]{4,4}));
		h13.addObjeto(new Obstaculo(13, new int[]{1,2}, new int[]{4,2}));
		h13.addObjeto(new Obstaculo(13, new int[]{1,2}, new int[]{9,2}));
		
		h13.addObjeto(new Obstaculo(13, new int[]{1,9}, new int[]{8,6}));
		h13.addObjeto(new Obstaculo(13, new int[]{1,9}, new int[]{9,6}));
		
		h13.addObjeto(new Pared(13, new int[]{1,2}, new int[]{8,8}));
		h13.addObjeto(new Pared(13, new int[]{1,2}, new int[]{8,11}));
		
		h13.addObjeto(new Obstaculo(13, new int[]{1,2}, new int[]{2,13}));
		h13.addObjeto(new Obstaculo(13, new int[]{1,2}, new int[]{3,13}));
		
		h13.addObjeto(new PisoMojado(13, new int[]{4,1}, new int[]{5,2}));
		h13.addObjeto(new PisoMojado(13, new int[]{4,1}, new int[]{5,3}));
		
		h13.addObjeto(new PisoAlfombra(13, new int[]{1,5}, new int[]{5,8}));
		h13.addObjeto(new PisoAlfombra(13, new int[]{1,5}, new int[]{6,8}));
		

		
		//Terrenos
		//h13.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
							
		Puerta p1 = new Puerta(1, new int[]{0, 1}, new int[]{19, 17});
		Puerta p2 = new Puerta(1, new int[]{0, 2}, new int[]{19, 18});
		Puerta p3 = new Puerta(1, new int[]{0, 3}, new int[]{19, 19});
		h13.addHabitacionContigua(new Pair<Integer, List<Puerta>> (13, new ArrayList<Puerta>(Arrays.asList(p1, p2, p3))));

		//PlanoHabitacion
		h13.ActualizarPlanoHabitacion(new int[]{11,16});
		 		
		return h13;
	}
	
	public static Habitacion createHabitacion14(){
		/**Instanciación de la habitación, los obstaculos, terrenos y puertas**/
		
		//Habitacion h14 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h14 = new Habitacion(14,new String[22][24], new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{12,29};
		h14.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{13,10};
		h14.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h14.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h14.addObjeto(new Pared(14, new int[]{20,1}, new int[]{0,0}));
		h14.addObjeto(new Pared(14, new int[]{1,9}, new int[]{19,1}));
		h14.addObjeto(new Pared(14, new int[]{3,1}, new int[]{19,10}));
		h14.addObjeto(new Pared(14, new int[]{3,1}, new int[]{19,16}));
		h14.addObjeto(new Pared(14, new int[]{7,1}, new int[]{13,20}));
		h14.addObjeto(new Pared(14, new int[]{1,2}, new int[]{13,21}));
		h14.addObjeto(new Pared(14, new int[]{9,1}, new int[]{5,23}));
		h14.addObjeto(new Pared(14, new int[]{1,2}, new int[]{5,21}));
		h14.addObjeto(new Pared(14, new int[]{6,1}, new int[]{0,20}));
		h14.addObjeto(new Pared(14, new int[]{1,19}, new int[]{0,1}));
		h14.addObjeto(new Pared(14, new int[]{10,1}, new int[]{4,14}));
		h14.addObjeto(new Pared(14, new int[]{1,2}, new int[]{4,15}));
		h14.addObjeto(new Pared(14, new int[]{1,2}, new int[]{13,15}));
		
		//Obstaculos
		//h14.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h14.addObjeto(new Obstaculo(6, new int[]{8,1}, new int[]{5,15}));
		h14.addObjeto(new Obstaculo(6, new int[]{8,1}, new int[]{5,16}));
		
		h14.addObjeto(new Obstaculo(6, new int[]{7,1}, new int[]{6,20}));
		h14.addObjeto(new Obstaculo(6, new int[]{7,1}, new int[]{6,21}));
		h14.addObjeto(new Obstaculo(6, new int[]{7,1}, new int[]{6,22}));
		
		h14.addObjeto(new Pared(6, new int[]{1,2}, new int[]{4,12}));
		h14.addObjeto(new Pared(6, new int[]{1,2}, new int[]{5,12}));
		h14.addObjeto(new Pared(6, new int[]{1,2}, new int[]{12,12}));
		h14.addObjeto(new Pared(6, new int[]{1,2}, new int[]{13,12}));
		
		h14.addObjeto(new Obstaculo(6, new int[]{1,8}, new int[]{6,6}));
		h14.addObjeto(new Obstaculo(6, new int[]{1,8}, new int[]{7,6}));
		h14.addObjeto(new Obstaculo(6, new int[]{1,8}, new int[]{8,6}));
		h14.addObjeto(new Obstaculo(6, new int[]{1,8}, new int[]{9,6}));
		h14.addObjeto(new Obstaculo(6, new int[]{1,8}, new int[]{10,6}));
		h14.addObjeto(new Obstaculo(6, new int[]{1,8}, new int[]{11,6}));
		
		h14.addObjeto(new Pared(6, new int[]{4,1}, new int[]{7,1}));
		
		
		//Terrenos
		//h14.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Puerta pu1 = new Puerta(1, new int[]{21,11}, new int[]{0, 1});
		Puerta pu2 = new Puerta(1, new int[]{21,12}, new int[]{0, 2});
		Puerta pu3 = new Puerta(1, new int[]{21,13}, new int[]{0, 3});
		Puerta pu4 = new Puerta(1, new int[]{21,14}, new int[]{0, 4});
		Puerta pu5 = new Puerta(1, new int[]{21,15}, new int[]{0, 5});
		h14.addHabitacionContigua(new Pair<Integer, List<Puerta>> (9, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3, pu4, pu5))));
		Puerta pu6 = new Puerta(2, new int[]{19, 17}, new int[]{0, 1});
		Puerta pu7 = new Puerta(2, new int[]{19, 18}, new int[]{0, 2});
		Puerta pu8 = new Puerta(2, new int[]{19, 19}, new int[]{0, 3});
		h14.addHabitacionContigua(new Pair<Integer, List<Puerta>> (9, new ArrayList<Puerta>(Arrays.asList(pu6, pu7, pu8))));
		
		//PlanoHabitacion
		h14.ActualizarPlanoHabitacion(new int[]{22,24});
		
		return h14;
	}
	
	public static Habitacion createHabitacion15(){
		//Habitacion h14 = new Habitacion(NUMERO_HABITACION,  new ArrayList<Pair<Integer, List<Puerta>>>(), new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new ArrayList<Objeto>());
		Habitacion h15 = new Habitacion(15,new String[16][17], new ArrayList<Pair<Integer, List<Puerta>>>(), new ArrayList<Objeto>());
		
		//posicion centro global de la habitacion para la heeristica
		int[] ubicacion = new int[]{26,17};
		h15.setUbicacionCentralGlobal(ubicacion);
		
		//posicion centro local de la habitacion para la heuristica
		int[] ubicacionLocal = new int[]{7,4};
		h15.setUbicacionCentralLocal(ubicacionLocal);
		
		//Paredes
		//h14.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		h15.addObjeto(new Pared(15, new int[]{16,1}, new int[]{0,0}));
		h15.addObjeto(new Pared(15, new int[]{1,11}, new int[]{15,6}));
		h15.addObjeto(new Pared(15, new int[]{15,1}, new int[]{0,16}));
		h15.addObjeto(new Pared(15, new int[]{1,15}, new int[]{0,1}));
		
		//Obstaculos
		//h14.addObjeto( new Obstaculo(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}) );
		//sillones y mesas
		h15.addObjeto(new Obstaculo(15, new int[]{1,6}, new int[]{14,9}));
		h15.addObjeto(new Pared(15, new int[]{1,4}, new int[]{12,10}));
		h15.addObjeto(new Pared(15, new int[]{1,4}, new int[]{13,10}));
		h15.addObjeto(new Obstaculo(15, new int[]{2,1}, new int[]{12,9}));
		h15.addObjeto(new Obstaculo(15, new int[]{2,1}, new int[]{12,14}));
		
		
		h15.addObjeto(new Obstaculo(15, new int[]{1,2}, new int[]{12,6}));
		h15.addObjeto(new Obstaculo(15, new int[]{1,2}, new int[]{13,6}));
		
		h15.addObjeto(new Obstaculo(15, new int[]{6,1}, new int[]{5,5}));
		h15.addObjeto(new Pared(15, new int[]{4,1}, new int[]{6,6}));
		h15.addObjeto(new Pared(15, new int[]{4,1}, new int[]{6,7}));
		h15.addObjeto(new Obstaculo(15, new int[]{1,2}, new int[]{5,6}));
		h15.addObjeto(new Obstaculo(15, new int[]{1,2}, new int[]{10,6}));
		
		h15.addObjeto(new PisoAlfombra(15, new int[]{6,1}, new int[]{5,9}));
		h15.addObjeto(new PisoAlfombra(15, new int[]{6,1}, new int[]{5,14}));
		h15.addObjeto(new PisoAlfombra(15, new int[]{1,4}, new int[]{5,10}));
		h15.addObjeto(new PisoAlfombra(15, new int[]{1,4}, new int[]{10,10}));
		
		h15.addObjeto(new PisoMojado(15, new int[]{8,1}, new int[]{4,3}));
		h15.addObjeto(new PisoAlfombra(15, new int[]{7,1}, new int[]{4,2}));
		h15.addObjeto(new PisoMojado(15, new int[]{7,1}, new int[]{4,4}));
		
		h15.addObjeto(new Pared(15, new int[]{1,4}, new int[]{6,10}));
		h15.addObjeto(new Pared(15, new int[]{1,4}, new int[]{7,10}));
		h15.addObjeto(new Pared(15, new int[]{1,4}, new int[]{8,10}));
		h15.addObjeto(new Pared(15, new int[]{1,4}, new int[]{9,10}));
		
		//MUEBLE
		h15.addObjeto(new Obstaculo(15, new int[]{1,9}, new int[]{1,4}));
		h15.addObjeto(new Obstaculo(15, new int[]{1,9}, new int[]{2,4}));
		
		//Terrenos
		//h14.addObjeto( new TerrenoAdverso(NUMERO_HABITACION, new int[]{TAMAÑO_FILAS, TAMAÑO_COLUMNAS}, new int[]{FILA_INICIAL, COLUMNA_INICIAL}, COSTO_TERRENO) );

		//Puertas
		//Puerta pu1 = new Puerta(NUMERO_PUERTA, new int[]{FILA_EN_HAB_ACTUAL, COLUMNA_EN_HAB_ACTUAL}, new int[]{FILA_EN_HAB_DESTINO, COLUMNA_EN_HAB_DESTINO})
		Puerta pu1 = new Puerta(1, new int[]{15, 1}, new int[]{0, 6});
		Puerta pu2 = new Puerta(1, new int[]{15, 2}, new int[]{0, 7});
		Puerta pu3 = new Puerta(1, new int[]{15, 3}, new int[]{0, 8});
		Puerta pu4 = new Puerta(1, new int[]{15, 4}, new int[]{0, 9});
		Puerta pu5 = new Puerta(1, new int[]{15, 5}, new int[]{0, 10});
		h15.addHabitacionContigua(new Pair<Integer, List<Puerta>> (7, new ArrayList<Puerta>(Arrays.asList(pu1, pu2, pu3, pu4, pu5))));
		
		//PlanoHabitacion
		h15.ActualizarPlanoHabitacion(new int[]{16,17});
		
		return h15;
	}
}

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

	public void createHabitacion1(){
		
	}
	
	public void createHabitacion2(){
		
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
	
	public void createHabitacion10(){
		
	}
	
	public void createHabitacion11(){
		
	}
	
	public void createHabitacion12(){
		
	}
	
	public void createHabitacion13(){
		
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

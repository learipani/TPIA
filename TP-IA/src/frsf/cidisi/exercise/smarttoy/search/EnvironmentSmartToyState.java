package frsf.cidisi.exercise.smarttoy.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import auxiliar.CreacionHabitaciones;

import domain.Habitacion;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.cidisi.faia.state.datastructure.Pair;

/**
 * This class represents the real world state.
 */
public class EnvironmentSmartToyState extends EnvironmentState {
	
	//TODO: Setup Variables
    private List<Habitacion> plano;
    private Pair<Habitacion, int[]> ubicacionAgente;
	private boolean[] orientacionAgente;
    private Pair<Habitacion, int[]> ubicacionSmartPhone;
    public int celdasVisitadas;
	
    
    public EnvironmentSmartToyState() {
    	
    	plano = new ArrayList<Habitacion>();
    	ubicacionAgente = new Pair<Habitacion, int[]>(new Habitacion(),  new int[] {0,0});
    	orientacionAgente = new boolean[4];
    	ubicacionSmartPhone = new Pair<Habitacion, int[]>(new Habitacion(), new int[] {0,0});
    	celdasVisitadas = 0;
    	this.initState();

	}
    
	/**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    	//Add de habitaciones al plano
    	this.plano.add(CreacionHabitaciones.createHabitacion1());
    	this.plano.add(CreacionHabitaciones.createHabitacion2());
    	this.plano.add(CreacionHabitaciones.createHabitacion3());
    	this.plano.add(CreacionHabitaciones.createHabitacion4());
    	this.plano.add(CreacionHabitaciones.createHabitacion5());
    	this.plano.add(CreacionHabitaciones.createHabitacion6());
    	this.plano.add(CreacionHabitaciones.createHabitacion7());
    	this.plano.add(CreacionHabitaciones.createHabitacion8());
    	this.plano.add(CreacionHabitaciones.createHabitacion9());
    	this.plano.add(CreacionHabitaciones.createHabitacion10());
    	this.plano.add(CreacionHabitaciones.createHabitacion11());
    	this.plano.add(CreacionHabitaciones.createHabitacion11());
    	this.plano.add(CreacionHabitaciones.createHabitacion12());
    	this.plano.add(CreacionHabitaciones.createHabitacion13());
    	this.plano.add(CreacionHabitaciones.createHabitacion14());
    	this.plano.add(CreacionHabitaciones.createHabitacion15());
    	
    	//Setea la posicion inicial del agente
    	this.ubicacionAgente.setFirst(this.getPlano().get(0)); //Habitacion .get(HABITACION)
    	this.ubicacionAgente.setSecond(new int[]{3,3}); //Posicion dentro de la habitación {FILA, COLUMNA})
    	
    	//Setea la orientación inicial del agente
    	orientacionAgente[0] = true;
    	orientacionAgente[1] = false;
    	orientacionAgente[2] = false;
    	orientacionAgente[3] = false;
    	
    	//Setea la posicion del llamado
    	this.ubicacionSmartPhone.setFirst(this.getPlano().get(1)); //Habitacion .get(HABITACION)
    	this.ubicacionSmartPhone.setSecond(new int[]{13,4}); //Posicion dentro de la habitación {FILA, COLUMNA})
    	
    	//Setea la cantidad inicial de celdas visitadas
    	this.celdasVisitadas = 0;    	
    	
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";
        
        str += "\nAgente ubicado en la posicion ["+ ubicacionAgente.getSecond()[0] +";"+ubicacionAgente.getSecond()[1] +"] de la habitación "+  ubicacionAgente.getFirst().getIdHabitacion();
        
        str += "\nLlamado realizado desde posicion ["+ ubicacionSmartPhone.getSecond()[0] +";"+ubicacionSmartPhone.getSecond()[1] +"] de la habitación "+  ubicacionSmartPhone.getFirst().getIdHabitacion();

        str+= "\n Celdas visitadas: " +celdasVisitadas;
        return str;
    }

	public List<Habitacion> getPlano() {
		return plano;
	}

	public void setPlano(List<Habitacion> plano) {
		this.plano = plano;
	}

	public Pair<Habitacion, int[]> getUbicacionAgente() {
		return ubicacionAgente;
	}

	public void setUbicacionAgente(Pair<Habitacion, int[]> ubicacionAgente) {
		this.ubicacionAgente = ubicacionAgente;
	}

	public Pair<Habitacion, int[]> getUbicacionSmartPhone() {
		return ubicacionSmartPhone;
	}

	public void setUbicacionSmartPhone(Pair<Habitacion, int[]> ubicacionSmartPhone) {
		this.ubicacionSmartPhone = ubicacionSmartPhone;
	}

	public Habitacion getHabitacionDePlano(int idHabitacion) {
		for (Iterator<Habitacion> i = plano.iterator(); i.hasNext();) {
			Habitacion item = i.next();
			if (item.getIdHabitacion() == idHabitacion) {
				return item;
			}
		}
		return null;
	}
	
	public char getCharOrientacionAgente() {
		char orientacion;
		if( this.orientacionAgente[0] == true ){
			orientacion = 'N';
	    }
	    else{
	    	if( this.orientacionAgente[1] == true ){
				orientacion = 'O';
		    }
		    else{
		    	if( this.orientacionAgente[2] == true ){
					orientacion = 'S';
			    }
			    else{
			    	orientacion = 'E';
			    }
		    }
	    }
		return orientacion;
	}
}


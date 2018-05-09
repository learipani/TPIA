package frsf.cidisi.exercise.smarttoy.search;

import java.util.List;

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
    private Pair<Habitacion, int[]> ubicacionSmartPhone;
	
    
    public EnvironmentSmartToyState(List<Habitacion> plano,
			Pair<Habitacion, int[]> ubicacionAgente,
			Pair<Habitacion, int[]> ubicacionSmartPhone) {
		super();
		this.plano = plano;
		this.ubicacionAgente = ubicacionAgente;
		this.ubicacionSmartPhone = ubicacionSmartPhone;
	}

    public EnvironmentSmartToyState() {
		// TODO Auto-generated constructor stub
	}

	/**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        //TODO: Complete Method
    	
    	/**Acá hay que pones el estado inicial del agente, es decir:
    	 * 1) Instanciar todas las habitaciones y agregarlas a al plano     	plano.add(habitacionInstanciada);
    	 * 2) Instanciar un array con la posicion del jueguete y agregarlo al ubicacionAgente		ubicacionAgente = new Pair<Habitacion, int[]>(habitacionAgente, posicionAgente)
    	 * 3) Lo mismo que 2 pero con la posicion del llamado**/
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";
        
        str += "\nAgente ubicado en la posicion ["+ ubicacionAgente.getSecond()[0] +";"+ubicacionAgente.getSecond()[1] +"] de la habitación "+  ubicacionAgente.getFirst().getIdHabitacion();
        
        str += "\nLlamado realizado desde posicion ["+ ubicacionSmartPhone.getSecond()[0] +";"+ubicacionSmartPhone.getSecond()[1] +"] de la habitación "+  ubicacionSmartPhone.getFirst().getIdHabitacion();

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
}


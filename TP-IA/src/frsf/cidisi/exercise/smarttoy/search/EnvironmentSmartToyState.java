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
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

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


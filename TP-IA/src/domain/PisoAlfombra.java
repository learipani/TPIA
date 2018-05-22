package domain;

public class PisoAlfombra extends Objeto {
	
	public static int tipoObjeto = 4;
	
	public PisoAlfombra(int idHabitacion, int[] tamano,
			int[] ubicacionEnHabitacion) {
		super(idHabitacion, tamano, ubicacionEnHabitacion);
	}
	
	protected int getTipoObjeto() {
		return tipoObjeto;
	}

	protected void setTipoObjeto(int tipoObjeto) {
		Obstaculo.tipoObjeto = tipoObjeto;
	}
}
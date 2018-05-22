package domain;

public class PisoMojado extends Objeto {
	
	public static int tipoObjeto = 5;
	
	public PisoMojado(int idHabitacion, int[] tamano,
			int[] ubicacionEnHabitacion, float costo) {
		super(idHabitacion, tamano, ubicacionEnHabitacion);
	}
	
	protected int getTipoObjeto() {
		return tipoObjeto;
	}

	protected void setTipoObjeto(int tipoObjeto) {
		Obstaculo.tipoObjeto = tipoObjeto;
	}

}

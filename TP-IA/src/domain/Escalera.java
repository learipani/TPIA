package domain;

public class Escalera extends Objeto {

	public static int tipoObjeto = 6;
	
	public Escalera(int idHabitacion, int[] tamano,
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
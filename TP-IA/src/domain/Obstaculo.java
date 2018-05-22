package domain;

public class Obstaculo extends Objeto {

	public static int tipoObjeto = 1;
	
	public Obstaculo(int idHabitacion, int[] tamano,
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

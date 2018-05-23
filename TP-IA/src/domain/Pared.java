package domain;

public class Pared extends Objeto {

	public static int tipoObjeto = 7;
	
	public Pared(int idHabitacion, int[] tamano,
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

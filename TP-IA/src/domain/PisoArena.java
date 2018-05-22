package domain;

public class PisoArena extends Objeto {

	public static int tipoObjeto = 2;
	
	public PisoArena(int idHabitacion, int[] tamano,
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
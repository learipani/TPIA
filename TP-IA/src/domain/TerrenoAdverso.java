package domain;

public class TerrenoAdverso extends Objeto {

	private float costo;

	public TerrenoAdverso(int idHabitacion, int[] tamano,
			int[] ubicacionEnHabitacion, float costo) {
		super(idHabitacion, tamano, ubicacionEnHabitacion);
		this.costo = costo;
	}
}

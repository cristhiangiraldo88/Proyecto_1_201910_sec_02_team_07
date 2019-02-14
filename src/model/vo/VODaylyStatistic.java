package model.vo;

public class VODaylyStatistic {
	
	/**
	 * Fecha
	 */
	private String fecha;
	
	/**
	 * Accidentes
	 */
	private int accidentes;
	
	/**
	 * infracciones
	 */
	private int infracciones;
	
	/**
	 * suma
	 */
	private double suma;

	/**
	 * @param fecha
	 * @param accidentes
	 * @param infracciones
	 * @param suma
	 */
	public VODaylyStatistic(String fecha, int accidentes, int infracciones, double suma) {
		super();
		this.fecha = fecha;
		this.accidentes = accidentes;
		this.infracciones = infracciones;
		this.suma = suma;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the accidentes
	 */
	public int getAccidentes() {
		return accidentes;
	}

	/**
	 * @param accidentes the accidentes to set
	 */
	public void setAccidentes(int accidentes) {
		this.accidentes = accidentes;
	}

	/**
	 * @return the infracciones
	 */
	public int getInfracciones() {
		return infracciones;
	}

	/**
	 * @param infracciones the infracciones to set
	 */
	public void setInfracciones(int infracciones) {
		this.infracciones = infracciones;
	}

	/**
	 * @return the suma
	 */
	public double getSuma() {
		return suma;
	}

	/**
	 * @param suma the suma to set
	 */
	public void setSuma(double suma) {
		this.suma = suma;
	}
}

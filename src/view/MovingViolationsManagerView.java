package view;

import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.logic.MovingViolationsManager;
import model.vo.VODaylyStatistic;
import model.vo.VOMovingViolations;

public class MovingViolationsManagerView 
{
	private MovingViolationsManager manager = new MovingViolationsManager();
	public MovingViolationsManagerView() {
		
	}
	
	public void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Taller 3----------------------");
		System.out.println("1. Cree una nueva coleccion de infracciones en movimiento");
		System.out.println("2. Dar estadisticas diarias de las infracciones");
		System.out.println("3. Dar ultimos n infracciones que terminaron en accidente");
		System.out.println("4. Salir");
		System.out.println("Digite el número de opción para ejecutar la tarea, luego presione enter: (Ej., 1):");
		
	}
	
	public void printDailyStatistics(IQueue<VODaylyStatistic> dailyStatistics) {
		System.out.println("Se encontraron "+ dailyStatistics.size() + " elementos");
		for (VODaylyStatistic dayStatistic : dailyStatistics) 
		{
			System.out.println(dayStatistic.getFecha() + " accidentes: "+ dayStatistic.getAccidentes()+ ", infracciones: "+ dayStatistic.getInfracciones()+", multas totales: $"+dayStatistic.getSuma());
		}
	}
	
	public void printMovingViolations(IStack<VOMovingViolations> violations) {
		System.out.println("Se encontraron "+ violations.size() + " elementos");
		for (VOMovingViolations violation : violations) 
		{
			System.out.println(violation.getObjectId() + " " 
								+ violation.getTicketIssue() + " " 
								+ violation.getLocation()+ " " 
								+ violation.getViolationDesc());
		}
	}
	
	public void loadMovingViolations(String path, String path2) {
		manager.loadMovingViolations(path, path2);
	}
	
	
	
	public void printMensage(String mensaje) {
		System.out.println(mensaje);
	}
	
	public IQueue getDailyStatistics() {
		return manager.getDailyStatistics();
	}
	
	public IStack nLastAccidents(int n) {
		return manager.nLastAccidents(n);
	}
}

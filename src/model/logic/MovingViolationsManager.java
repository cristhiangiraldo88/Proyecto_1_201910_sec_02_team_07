package model.logic;


import model.vo.VODaylyStatistic;
import model.vo.VOMovingViolations;
import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.Queue;
import model.data_structures.Stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.time.Clock;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;




public class MovingViolationsManager  {


	IStack<VOMovingViolations> pilaViolaciones;

	public void loadMovingViolations(String movingViolationsFile, String m2){
		System.out.println("ejecuto");
		try {
			pilaViolaciones= new Stack<>();
			CSVReader reader = new CSVReader (new FileReader (movingViolationsFile));
			String [] nextLine;
			try {
				reader.readNext();
				while ((nextLine = reader.readNext()) != null) {


					VOMovingViolations mV =new VOMovingViolations(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5],nextLine[6]
							,nextLine[7],nextLine[8],nextLine[9],nextLine[10],nextLine[11],nextLine[12],nextLine[13]
									,nextLine[14],nextLine[15],nextLine[16]);
					pilaViolaciones.push(mV);
					System.out.println("mapeando");
				}

				CSVReader reader2 = new CSVReader (new FileReader (m2));
				String [] nextLine2;

				reader2.readNext();
				while ((nextLine2 = reader2.readNext()) != null) {


					VOMovingViolations mV =new VOMovingViolations(nextLine2[0],nextLine2[1],nextLine2[2],nextLine2[3],nextLine2[4],nextLine2[5],nextLine2[6]
							,nextLine2[7],nextLine2[8],nextLine2[9],nextLine2[10],nextLine2[11],nextLine2[12],nextLine2[13]
									,nextLine2[14],nextLine2[15],nextLine2[16]);
					pilaViolaciones.push(mV);
					System.out.println("mapeando");
				}




			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			System.out.println("Hecho "+System.currentTimeMillis());
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public IQueue<VODaylyStatistic> getDailyStatistics() {
		//TODO
		IQueue <VODaylyStatistic>cola = new Queue<>();
		for(int i =1; i < 32; i++){
			IQueue <VOMovingViolations> dia = new Queue<VOMovingViolations>();
			int accidentes =0;
			int infracciones = 0;
			double suma =0;
			for(VOMovingViolations mv : pilaViolaciones) {
				if(mv.getTicketIssue().substring(8, 10).equals(i <10? "0"+i: ""+i)) {
					dia.enqueue(mv);
				}
			}
			for(VOMovingViolations vm2: dia) {
				if(vm2.getAccidentId().equals("Yes")) {
					accidentes++;
				}
				infracciones ++;
				suma += Double.parseDouble(vm2.getFine());
			}
			VODaylyStatistic ds = new VODaylyStatistic("2018-01-"+(i <10? "0"+i: ""+i), accidentes, infracciones, suma);
			cola.enqueue(ds);
		}
		return cola;
	}

	public IStack<VOMovingViolations> nLastAccidents(int n){
		IStack<VOMovingViolations> respuesta = new Stack<VOMovingViolations>() ;
		int i =0;
		for(VOMovingViolations mv: pilaViolaciones) {
			if(mv.getAccidentId().equals("Yes")) {
				respuesta.push(mv);
				i++;
			}
			if(i==n) {
				break;
			}
		}
		return respuesta;
	}

}

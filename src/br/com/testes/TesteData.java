package br.com.testes;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteData {

	private static final Logger LOGGER = 
			Logger.getLogger(TesteData.class.getName());
	
	public static void main(String[] args) {
		try {
						
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date data = fmt.parse("17/12/2007 19:30:20");
			String str = fmt.format(data);
			
			SimpleDateFormat fmt2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String str2 = fmt2.format(new Timestamp(System.currentTimeMillis()));
			
			String data1 = str2.replace('/', '_');
			data1 = data1.replace(':', '_');
			String data2 = data1.replace(' ', '_');
			
			System.out.println(" 1 data: " + str
							+"\n 2 data: " + str2
							+"\n 3 data: " + data1);
			
			//FileHandler file name with max size and number of log files limit
            Handler fileHandler = new FileHandler("C:\\Users\\cesar\\eclipse-workspace\\teste\\log\\logger_"+data2+".log", 2000, 5);
            fileHandler.setFormatter(new Formato());
            //setting custom filter for FileHandler
            fileHandler.setFilter(new Filtro());
            
            LOGGER.addHandler(fileHandler);
            
            for(int i = 0 ; i < 6 ; i++) {
            	String temp = fmt.format(new Timestamp(System.currentTimeMillis()));
            	temp = temp.replace(' ', '_');
            	LOGGER.log(Level.INFO,"Data geracao log "+temp);
            
            }		
		} catch (Exception e) {

		}
	}

}

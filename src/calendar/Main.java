package calendar;

import java.util.Calendar;

import javax.swing.SwingUtilities;


public class Main {
	static boolean gui = true;
    public static void main(String[] args) {
    	EventList eventList = new EventList();
    	for(String arg : args)
    		if(arg.equals("--nogui")) gui = false;
    	if(gui) {
    		SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                	new CalendarView(Calendar.getInstance(), eventList);
                }
            });
    	}
    	else new CUI(eventList);
//    	JDBC bazka = new JDBC("mordekaiser");
//    	EventList lista = new EventList();
//    	try {
//    		lista = bazka.read();
//    		System.out.println(lista.toString());
//    	} catch (Exception e) {
//    		System.out.println("No c�, jednak si� nie uda�o xd");
//    	}
//    	lista.add(new Event("Bede siedzial po nocach i pisal jakies gunwa", "W domu przed kompem", 2019, 6, 16, 23, 39));
//    	
//    	try {
////    		bazka.create();
//    		bazka.insert(lista);
//    	} catch (Exception e) {
//    		System.out.println("No co� se posz�o nie tak xd");
//    	}
//    	
//    	try {
//    		lista = bazka.read();
//    		System.out.println(lista.toString());
//    	} catch (Exception e) {
//    		System.out.println("No c�, jednak si� nie uda�o xd");
//    	}
    	
    }
    
  
}


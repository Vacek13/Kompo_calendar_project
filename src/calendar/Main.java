package calendar;

import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingUtilities;


public class Main {
	static boolean gui = true;
	
    public static void main(String[] args) {
    	EventList eventList = new EventList();
    	
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//            	EventList l = new EventList();
//            	l.add(new Event("a", "a", 2019, 6, 25, 4, 5));
//            	System.out.println(l.toString());
//            	DayView d = new DayView(l, new Date());
//                AddEventView a = new AddEventView(new EventList(), new Date());
            	CalendarView TheCalendar = new CalendarView(Calendar.getInstance(), eventList);
            }
        });
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


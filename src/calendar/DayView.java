package calendar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DayView extends JFrame {
	private JList <Event> l;
	private DefaultListModel<Event> lm;
	private JButton add;
	private EventList v;
	private AddEventView a;
	private Date date;
	private final static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
	 

	public DayView(EventList v, Date date) {
		super(sdf.format(date));
		this.setLayout(new BorderLayout());
		this.v = v;
		this.date = date;
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				DayView.this.updateList();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		lm = new DefaultListModel<Event>();
		for(Event e : this.v) 
			if(isEventToday(e))lm.addElement(e);
		l = new JList<Event>(lm);
		JScrollPane s = new JScrollPane(l, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JPanel master = new JPanel();
		add = new JButton("Add");
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Event event : DayView.this.v.events) {
					if(!lm.contains(event))
						lm.addElement(event);
				}
				a = new AddEventView(v, date);
			}
			
		});
		//this.add(l);
		this.add(s, BorderLayout.CENTER);
		master.add(add);
		master.add(remove);
		this.add(master, BorderLayout.SOUTH);
		this.setVisible(true);
		//this.setMinimumSize(new Dimension(500, 100));
		this.pack();
	}
	
	public boolean isEventToday(Event e) {
		String today = sdf.format(this.date);
		String eventDay = sdf.format(e.getEventTime());
		System.out.println(today+":"+eventDay);
		return today.equals(eventDay);
	}
	
	public void updateList() {
		for(Event event : DayView.this.v) {
			System.out.println(/*(!lm.contains(event)) &&*/ this.isEventToday(event));
			if((!lm.contains(event)) && this.isEventToday(event)) {
				lm.addElement(event);
			}
		}
	}

}
package calendar;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class AddEventView extends JFrame{

	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonPanel btnPanel;
	private InputPanel inptPanel;
	private EventList events;
	private JPanel master, msgPanel;
	private JLabel msgLabel;

	public AddEventView(EventList  events, Date date) {
			super("Add Event");
			this.events = events;
	        master = new JPanel();
	        master.setLayout(new GridLayout(3, 1, 0, 5));
	        msgPanel = new JPanel();
	        msgLabel = new JLabel(" ");
	        msgPanel.add(msgLabel);
	        master.add(msgPanel);
	        inptPanel = new InputPanel(date);
	        master.add(inptPanel);
	        btnPanel = new ButtonPanel();
	        master.add(btnPanel);
	        btnPanel.getAddBtn().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						if(!inptPanel.getNameInput().equals("")) {
							if(inptPanel.getPlaceInput().equals("")) {
								AddEventView.this.events.add( new Event(
									inptPanel.getNameInput(),
									inptPanel.getYearInput(),
									inptPanel.getMonthInput(),
									inptPanel.getDayInput(),
									inptPanel.getHourInput(),
									inptPanel.getMinutesInput()));
									setVisible(false);
									CalendarView.dayView.updateList();
									dispose();
							} else {
								AddEventView.this.events.add( new Event(
									inptPanel.getNameInput(),
									inptPanel.getPlaceInput(),
									inptPanel.getYearInput(),
									inptPanel.getMonthInput(),
									inptPanel.getDayInput(),
									inptPanel.getHourInput(),
									inptPanel.getMinutesInput()));
									CalendarView.dayView.updateList();
									setVisible(false);
									dispose();
							}
						} else if (inptPanel.getNameInput().equals("")) {
							msgLabel.setText("Insert name!");
						}
						
						} catch (InputMismatchException arg) {
							msgLabel.setText("Wrong Parameter!");
						} catch (NoSuchElementException nsee) {
							msgLabel.setText("Set proper event time!");
						} catch (WrongTimeException wte) {
							msgLabel.setText(wte.getMessage());
						}
					}
	        });
	        
	        btnPanel.getListBtn().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println(events.toString());
				}
	        	
	        });
	        
	        btnPanel.getCancelBtn().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO dispose on pressing
					AddEventView.this.dispose();
				}
	        	
	        });

	        this.add(master);
	        this.pack();
	        this.setVisible(true);
	        colorUpdate();
	}
	
	public void colorUpdate() {
		if(CalendarView.darkThemed) {
			master.setBackground(Color.DARK_GRAY);
			msgPanel.setBackground(Color.DARK_GRAY);
			msgLabel.setForeground(Color.WHITE);
			btnPanel.setBackground(Color.DARK_GRAY);
		} else {
			Color color = new Color(238,238,238);
			master.setBackground(color);
			msgPanel.setBackground(color);
			msgLabel.setForeground(Color.BLACK);
			btnPanel.setBackground(color);
		}
		btnPanel.colorUpdate();
		inptPanel.colorUpdate();
	}


}

class InputPanel extends JPanel{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField hourTf, minutesTf, nameTf, placeTf;
	private JPanel yearPanel, monthPanel, dayPanel, hourPanel, minutesPanel, namePanel, placePanel;
	private JLabel yearLabel, monthLabel, dayLabel, hourLabel, minutesLabel, nameLabel, placeLabel, yearLabel2, monthLabel2, dayLabel2;
	Calendar c;
	
	public InputPanel(Date date) {
		super();
		this.setLayout(new GridLayout(1, 5, 5, 5));
		this.c = Calendar.getInstance();
		c.setTime(date);
		
		namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
		namePanel.setToolTipText("Insert event description here.");
		nameLabel = new JLabel("Name");
		namePanel.add(nameLabel);
		nameTf = new JTextField();
		nameTf.setToolTipText("Insert event description here.");
		namePanel.add(nameTf);
		this.add(namePanel);
		
		placePanel = new JPanel();
		placePanel.setLayout(new BoxLayout(placePanel, BoxLayout.Y_AXIS));
		placePanel.setToolTipText("You can specify a place the event is going to happen.");
		placeLabel = new JLabel("Place");
		placePanel.add(placeLabel);
		placeTf = new JTextField(); 
		placeTf.setToolTipText("You can specify a place the event is going to happen.");
		placePanel.add(placeTf);
		this.add(placePanel);
		
		yearPanel = new JPanel();
		//yearPanel.setAlignmentX(CENTER_ALIGNMENT);
		yearPanel.setLayout(new BoxLayout(yearPanel, BoxLayout.Y_AXIS));
		yearLabel = new JLabel("Year");
		yearPanel.add(yearLabel);
		yearLabel2 = new JLabel("" + c.get(Calendar.YEAR));
		yearPanel.add(yearLabel2);
		this.add(this.yearPanel);
		
		monthPanel = new JPanel();
		monthPanel.setLayout(new BoxLayout(monthPanel, BoxLayout.Y_AXIS));
		monthLabel = new JLabel("Month");
		monthPanel.add(monthLabel);
		monthLabel2 = new JLabel("" + (c.get(Calendar.MONTH)+1), SwingConstants.RIGHT);
		monthPanel.add(monthLabel2);
		this.add(this.monthPanel);
		
		dayPanel = new JPanel();
		dayPanel.setLayout(new BoxLayout(dayPanel, BoxLayout.Y_AXIS));
		dayLabel = new JLabel("Day");
		dayPanel.add(dayLabel);
		dayLabel2 = new JLabel("" + c.get(Calendar.DAY_OF_MONTH));
		dayPanel.add(dayLabel2);
		this.add(this.dayPanel);
		
		hourPanel = new JPanel();
		hourPanel.setLayout(new BoxLayout(hourPanel, BoxLayout.Y_AXIS));
		hourPanel.setToolTipText("Hour format is HH");
		hourLabel = new JLabel("Hour");
		hourPanel.add(hourLabel);
		hourTf = new JTextField("");
		hourTf.setToolTipText("Hour format is HH");
		hourPanel.add(this.hourTf);
		this.add(this.hourPanel);
		
		minutesPanel = new JPanel();
		minutesPanel.setLayout(new BoxLayout(minutesPanel, BoxLayout.Y_AXIS));
		minutesPanel.setToolTipText("Minutes format is MM");
		minutesLabel = new JLabel("Minutes");
		minutesPanel.add(minutesLabel);
		minutesTf = new JTextField("00");
		minutesTf.setToolTipText("Minutes format is MM");
		minutesPanel.add(this.minutesTf);
		this.add(this.minutesPanel);
	}
	
	public int getYearInput() {
		return this.c.get(Calendar.YEAR);
	}
	
	public int getMonthInput() {
		return this.c.get(Calendar.MONTH);
	}
	
	public int getDayInput() {
		return this.c.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getHourInput() throws NoSuchElementException {
		Scanner s = new Scanner(hourTf.getText());
		int buff = s.nextInt();
		s.close();
		if((buff < 0) || (buff > 23)) throw new WrongTimeException("Hours take values between 0 and 23!");
		return buff;
	}
	
	public int getMinutesInput() throws NoSuchElementException {
		Scanner s = new Scanner(minutesTf.getText());
		int buff = s.nextInt();
		s.close();
		if((buff < 0) || (buff > 59)) throw new WrongTimeException("Minutes take values between 0 and 59!");
		return buff;
	}
	
	public String getPlaceInput() {
		return this.placeTf.getText();
	}
	
	public void colorUpdate() {
		if(CalendarView.darkThemed) {
			Color color = new Color(81,81,81);
			this.setBackground(Color.DARK_GRAY);
			namePanel.setBackground(Color.DARK_GRAY);
			placePanel.setBackground(Color.DARK_GRAY);
			yearPanel.setBackground(Color.DARK_GRAY);
			monthPanel.setBackground(Color.DARK_GRAY);
			dayPanel.setBackground(Color.DARK_GRAY);
			hourPanel.setBackground(Color.DARK_GRAY);
			minutesPanel.setBackground(Color.DARK_GRAY);
			nameTf.setBackground(color);
			placeTf.setBackground(color);
			hourTf.setBackground(color);
			minutesTf.setBackground(color);
			
			nameTf.setForeground(Color.WHITE);
			placeTf.setForeground(Color.WHITE);
			hourTf.setForeground(Color.WHITE);
			minutesTf.setForeground(Color.WHITE);
			nameLabel.setForeground(Color.WHITE);
			placeLabel.setForeground(Color.WHITE);
			yearLabel.setForeground(Color.WHITE);
			yearLabel2.setForeground(Color.WHITE);
			monthLabel.setForeground(Color.WHITE);
			monthLabel2.setForeground(Color.WHITE);
			dayLabel.setForeground(Color.WHITE);
			dayLabel2.setForeground(Color.WHITE);
			hourLabel.setForeground(Color.WHITE);
			minutesLabel.setForeground(Color.WHITE);
		} else {
			Color color = new Color(238,238,238);
			this.setBackground(color);
			namePanel.setBackground(color);
			placePanel.setBackground(color);
			yearPanel.setBackground(color);
			monthPanel.setBackground(color);
			dayPanel.setBackground(color);
			hourPanel.setBackground(color);
			minutesPanel.setBackground(color);
			nameTf.setBackground(Color.WHITE);
			placeTf.setBackground(Color.WHITE);
			hourTf.setBackground(Color.WHITE);
			minutesTf.setBackground(Color.WHITE);
			
			nameTf.setForeground(Color.BLACK);
			placeTf.setForeground(Color.BLACK);
			hourTf.setForeground(Color.BLACK);
			minutesTf.setForeground(Color.BLACK);
			nameLabel.setForeground(Color.BLACK);
			placeLabel.setForeground(Color.BLACK);
			yearLabel.setForeground(Color.BLACK);
			yearLabel2.setForeground(Color.BLACK);
			monthLabel.setForeground(Color.BLACK);
			monthLabel2.setForeground(Color.BLACK);
			dayLabel.setForeground(Color.BLACK);
			dayLabel2.setForeground(Color.BLACK);
			hourLabel.setForeground(Color.BLACK);
			minutesLabel.setForeground(Color.BLACK);
		}
	}
}

class ButtonPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton addBtn, listBtn, cancelBtn;
	
	public JButton getAddBtn() {
		return addBtn;
	}
	public JButton getListBtn() {
		return listBtn;
	}
	public JButton getCancelBtn() {
		return cancelBtn;
	}
	
	public ButtonPanel(){
		//setBorder(BorderFactory.createLineBorder(Color.black));
		super();
		addBtn = new JButton("Add");
		cancelBtn = new JButton("Cancel");
		if(CalendarView.darkThemed) {
			Color color = new Color(81,81,81);
			addBtn.setBackground(color);
			cancelBtn.setBackground(color);
			addBtn.setForeground(Color.WHITE);
			cancelBtn.setForeground(Color.WHITE);
		} else {
			Color color = new Color(245,245,245);
			addBtn.setBackground(color);
			cancelBtn.setBackground(color);
			addBtn.setForeground(Color.BLACK);
			cancelBtn.setForeground(Color.BLACK);
		}
		this.add(addBtn);
		this.add(listBtn);
		this.add(cancelBtn);		
	}
	
	public void colorUpdate() {
		if(CalendarView.darkThemed) {
			Color color = new Color(81,81,81);
			addBtn.setBackground(color);
			cancelBtn.setBackground(color);
			addBtn.setForeground(Color.WHITE);
			cancelBtn.setForeground(Color.WHITE);
		} else {
			Color color = new Color(245,245,245);
			addBtn.setBackground(color);
			cancelBtn.setBackground(color);
			addBtn.setForeground(Color.BLACK);
			cancelBtn.setForeground(Color.BLACK);
		}
	}
}

class WrongTimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public WrongTimeException(String string) {
		 super(string);
	}}

package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class OptionWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel master;
	JPanel management;
	JPanel graphics;
	JPanel csvHolder;
	
	public OptionWindow() {
		super("Options");
		this.setVisible(true);
		
		master = new JPanel();
		management = new JPanel();
		graphics = new JPanel();
		csvHolder = new JPanel();
		
		master.setLayout(new BorderLayout());
		management.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		graphics.setLayout(new BorderLayout());
		
		JCheckBox darkThemedBox = new JCheckBox("Dark themed mode", CalendarView.darkThemed);
		darkThemedBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CalendarView.darkThemed = !CalendarView.darkThemed;
			}
		});
		darkThemedBox.setHorizontalAlignment(SwingConstants.CENTER);

		ImageIcon dbImportIcon = new ImageIcon("C:\\Users\\user\\Desktop\\Kompo\\trunk\\Projekt\\Kompo_calendar_project\\images\\dbimport32.png");
		JLabel dbImport = new JLabel("Import", dbImportIcon, SwingConstants.CENTER);
		dbImport.setToolTipText("Import events from database");
		ImageIcon dbExportIcon = new ImageIcon("C:\\Users\\user\\Desktop\\Kompo\\trunk\\Projekt\\Kompo_calendar_project\\images\\dbexport32.png");
		JLabel dbExport = new JLabel("Export", dbExportIcon, SwingConstants.CENTER);
		dbExport.setToolTipText("Export events to database");
		ImageIcon xmlImportIcon = new ImageIcon("C:\\Users\\user\\Desktop\\Kompo\\trunk\\Projekt\\Kompo_calendar_project\\images\\xmlimport32.png");
		JLabel xmlImport = new JLabel("Import", xmlImportIcon, SwingConstants.CENTER);
		xmlImport.setToolTipText("Import events from XML sheet");
		ImageIcon xmlExportIcon = new ImageIcon("C:\\Users\\user\\Desktop\\Kompo\\trunk\\Projekt\\Kompo_calendar_project\\images\\xmlexport32.png");
		JLabel xmlExport = new JLabel("Export", xmlExportIcon, SwingConstants.CENTER);
		xmlExport.setToolTipText("Export events to XML sheet");
		management.add(xmlExport);
		management.add(xmlImport);
		management.add(dbImport);
		management.add(dbExport);
		
//		GroupLayout layout = new GroupLayout(management);
//		management.setLayout(layout);
//		layout.setAutoCreateGaps(true);
//		layout.setAutoCreateContainerGaps(true);
//		layout.setHorizontalGroup(
//			layout.createSequentialGroup()
//			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
//				.addComponent(xmlImport)
//				.addComponent(dbImport))
//			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
//				.addComponent(xmlExport)
//				.addComponent(dbExport))
//		);
//		layout.setVerticalGroup(
//			layout.createSequentialGroup()
//			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
//				.addComponent(xmlImport)
//				.addComponent(xmlExport))
//			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
//				.addComponent(dbImport)
//				.addComponent(dbExport))
//		);
		
		
//		JPanel elko = new JPanel();
//		elko.setLayout(new BorderLayout());
//		elko.add(management, BorderLayout.CENTER);
		ImageIcon csvExportIcon = new ImageIcon("C:\\Users\\user\\Desktop\\Kompo\\trunk\\Projekt\\Kompo_calendar_project\\images\\csvexport32.png");
		JLabel csvExport = new JLabel("Save as .csv", csvExportIcon, SwingConstants.CENTER);
		csvExport.setHorizontalTextPosition(JLabel.CENTER);
		csvExport.setVerticalTextPosition(JLabel.BOTTOM);
		csvExport.setToolTipText("Save events in standard .csv format.");
		csvHolder.add(csvExport);
		
		master.add(csvHolder, BorderLayout.NORTH);
		master.add(management, BorderLayout.CENTER);
		master.add(darkThemedBox, BorderLayout.SOUTH);
		master.setPreferredSize(new Dimension(200, 200));
		this.add(master);
		this.pack();
	}
	
	

}
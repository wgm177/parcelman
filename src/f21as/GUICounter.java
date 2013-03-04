package f21as;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUICounter implements ActionListener, Observer{

	CustomerList cl;
	ParcelList pl;
	
	JPanel jp;
	JTextArea textArea;
	JScrollPane scrollPane;
	OrderClerk oc;
	String processReport = "Next customer please!";

	public GUICounter(CustomerList cl, ParcelList pl) {
		super();
		this.cl = cl;
		this.pl = pl;
		//this.oc = oc;
		oc = new OrderClerk(cl, pl);
		oc.registerObserver(this);
		//Update();
		//this.setTextArea();
		
	}
	
	private JScrollPane setTextArea() {
		int rows = 5;
		int columns = 5;
		textArea = new JTextArea(rows, columns);
		textArea.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		scrollPane= new JScrollPane(textArea);
		scrollPane.setSize(rows, columns);
		oc.collectParcel();
		textArea.setText(oc.getProcessReport());
		
		return scrollPane;
	}
	
	public JPanel processOrderPanel() {
		jp = new JPanel();
		jp.setLayout(new GridLayout(1,0));
		jp.add(new JLabel("Processed"));
		jp.add(setTextArea());
		
		
		
		return jp;
		
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		//this.processReport = this.oc.getProcessReport();
		this.textArea.setText(oc.getProcessReport());
		
	}


}

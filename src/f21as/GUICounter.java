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

public class GUICounter implements ActionListener{

CustomerList cl;
ParcelList pl;
	
	JPanel jp;
	JTextArea textArea;
	JScrollPane scrollPane;
	OrderClerk oc;

	public GUICounter(CustomerList cl, ParcelList pl) {
		super();
		this.cl = cl;
		this.pl = pl;
		oc = new OrderClerk(cl, pl);
		//this.setTextArea();
		
	}
	
	private JScrollPane setTextArea() {
		int rows = 5;
		int columns = 20;
		textArea = new JTextArea(rows, columns);
		textArea.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		textArea.setEditable(false);
		scrollPane= new JScrollPane(textArea);
		textArea.setText(oc.collectParcel());
		
		return scrollPane;
	}
	
	public JPanel processOrderPanel() {
		jp = new JPanel();
		jp.setLayout(new GridLayout(0,1));
		jp.add(new JLabel("Processed"));
		jp.add(setTextArea());
		
		return jp;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}

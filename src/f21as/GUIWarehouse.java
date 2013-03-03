package f21as;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIWarehouse implements ActionListener, Observer{
	ParcelList pl;
	
	JPanel jp;
	JTextArea textArea;
	JScrollPane scrollPane;
	OrderClerk oc;

	public GUIWarehouse(OrderClerk oc) {
		super();
		this.oc = oc;
		this.pl = oc.parcelList;
		oc.registerObserver(this);
		//this.setTextArea();
		
	}
	
	private JScrollPane setTextArea() {
		int rows = 5;
		int columns = 5;
		textArea = new JTextArea(rows, columns);
		textArea.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		textArea.setEditable(false);
		scrollPane= new JScrollPane(textArea);
		scrollPane.setSize(rows, columns);
		textArea.setText(pl.warehouseReport(7));
		
		return scrollPane;
	}
	
	public JPanel warehousePanel() {
		jp = new JPanel();
		jp.setLayout(new GridLayout(0,1));
		jp.add(new JLabel("Warehouse"));
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
		
	}

}

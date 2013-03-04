package f21as;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUICustomerQue implements ActionListener, Observer{

	CustomerList cl;
	
	JPanel jp;
	JTextArea textArea;
	JScrollPane scrollPane;
	//OrderClerk oc;

	public GUICustomerQue(CustomerList cl) {
		super();
		//this.oc = oc;
		this.cl = cl;
		
		//this.setTextArea();
		//oc.registerObserver(this);
	}
	
	private JScrollPane setTextArea() {
		int rows = 5;
		int columns = 10;
		textArea = new JTextArea(rows, columns);
		textArea.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		textArea.setEditable(false);
		scrollPane= new JScrollPane(textArea);
		scrollPane.setSize(rows, columns);
		textArea.setText(cl.customerQueReport(1));
		
		return scrollPane;
	}
	
	public JPanel customerQuePanel() {
		jp = new JPanel();
		jp.setLayout(new GridLayout(0,1));
		jp.add(new JLabel("Que"));
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
		textArea.setText(cl.customerQueReport(1));
		textArea.validate();
	}

}

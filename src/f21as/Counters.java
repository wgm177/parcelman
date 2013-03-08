package f21as;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Counters extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderClerk oc;
	private JPanel jpProcessOrder, workerSpeed;
	private JTextArea taProcessOrder;
	
	public Counters(OrderClerk oc, int i)
	{
		super();
		this.oc = oc;
		
		jpProcessOrder = new JPanel();
		jpProcessOrder.setLayout(new GridLayout(1,1));
		
		jpProcessOrder.add(new JLabel("Counter " + i));
		//Setup text area and scroll pane
		taProcessOrder = new JTextArea(5, 5);
		taProcessOrder.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		taProcessOrder.setEditable(false);
		taProcessOrder.setText(oc.getProcessReport());
		//taCounters.add(taProcessOrder);
		JScrollPane spProcessOrder = new JScrollPane(taProcessOrder);
		
		jpProcessOrder.add(spProcessOrder);
	}
	
	public JPanel getPanel()
	{
		return jpProcessOrder;
	}
	
	public void upDateText()
	{
		this.taProcessOrder.setText(oc.getProcessReport());
	}
	

}

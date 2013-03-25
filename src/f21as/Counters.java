package f21as;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Counters extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderClerk oc;
	private JPanel jpProcessOrder, jpBtnPanel, jpSign, jpHeader;
	private JTextArea taProcessOrder;
	private JButton btnFast, btnSlow, btnWorking;
	private JLabel lblWorkingSpeed, lblCounter;
	
	public Counters(OrderClerk oc, int i)
	{
		super();
		this.oc = oc;
		
		jpProcessOrder = new JPanel();
		jpProcessOrder.setLayout(new GridLayout(2,1,5,5));
		
			jpSign = new JPanel();
			jpSign.setLayout(new BoxLayout(jpSign, BoxLayout.Y_AXIS));
			jpSign.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			
			jpHeader = new JPanel();
			jpHeader.setLayout(new GridLayout(1,2));
			jpHeader.setBorder(new EmptyBorder(5,5,5,5));
				lblCounter = new JLabel("Counter " + i);
				btnWorking = new JButton("Open");
				btnWorking.addActionListener(this);
			
				if(oc.isWorking()){
					this.btnWorking.setBackground(Color.GREEN);
					this.btnWorking.setText("Open");
					this.btnWorking.setPreferredSize(getMinimumSize());
				}
				else{
					this.btnWorking.setBackground(Color.RED);
					this.btnWorking.setText("Closed");
					this.btnWorking.setPreferredSize(getMinimumSize());
				}
			jpHeader.add(lblCounter);
			jpHeader.add(btnWorking);
				jpSign.add(jpHeader);
				
					lblWorkingSpeed = new JLabel("Speed: " + oc.getWorkingSpeed());
					lblWorkingSpeed.setBorder(new EmptyBorder(5,5,5,5));
				
				jpSign.add(lblWorkingSpeed);
			//jpSign.add(lblCounter, BorderLayout.CENTER);
			
			
			//jpSign.setBorder(new EmptyBorder(10, 10, 10, 10) );
		
		
				jpBtnPanel = new JPanel(new GridLayout(1,2));
				jpBtnPanel.setBorder(new EmptyBorder(5,5,5,5));
					btnFast = new JButton("Slower");
					btnFast.setMaximumSize(new Dimension(5,5));
					btnFast.addActionListener(this);
				jpBtnPanel.add(btnFast);
					
					
					btnSlow = new JButton("Faster");
					btnSlow.setMaximumSize(new Dimension(5,5));
					btnSlow.addActionListener(this);
				jpBtnPanel.add(btnSlow);	
			jpSign.add(jpBtnPanel);
		jpProcessOrder.add(jpSign);
		
		//Setup text area and scroll pane
		taProcessOrder = new JTextArea(5, 6);
		taProcessOrder.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		taProcessOrder.setEditable(false);
		taProcessOrder.setLineWrap(true);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnFast)
		{
			oc.increaseWorkingSpeed();
			
			this.lblWorkingSpeed.setText("Speed: " + oc.getWorkingSpeed());
			
		}
		if(e.getSource() == btnSlow)
		{
			oc.decreaseWorkingSpeed();
			
			this.lblWorkingSpeed.setText("Speed: " + oc.getWorkingSpeed());
			
		}
		if(e.getSource() == btnWorking)
		{
			oc.setWorking(!oc.isWorking());
			if(oc.isWorking()){
				this.btnWorking.setBackground(Color.GREEN);
				this.btnWorking.setText("Open");
				LogFile.addLog("Open counter");
			}
			else{
				this.btnWorking.setBackground(Color.RED);
				this.btnWorking.setText("Closed");
				LogFile.addLog("Close counter");
			}
		}
	}
	
	
	

}

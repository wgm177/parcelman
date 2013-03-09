package f21as;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUIMain extends JFrame implements ActionListener, Observer {
	
	private static final int WIDTH = 900;		
	private static final int HEIGHT = 600;
	private static final int WHCOLUMNS = 10;
	private static final int MAX_OREDERCLERKS = 3;
	
	JPanel jpCustQue, jpWareHouse, jpProcessOrder,  jpCounters ,jpManager, jp;
	JButton btnOpenShop, btnCloseShop;
	JTextArea taCustQue, taWareHouse, taProcessOrder,  taManager;
	JScrollPane spCustQue, spWareHouse, spProcessOrder, spProcessOrder1;
	OrderClerkList orderClerkList;
	CustomerList customerList;
	ParcelList parcelList;
	ArrayList<Counters> counters = new ArrayList<Counters>();
	//ArrayList<JTextArea> taCounters = new ArrayList<JTextArea>(0); 
	
	
	public GUIMain(String title, OrderClerkList orderClerkList)  {
		super(title);
		//this.oc = oc;
		//this.oc1 = oc1;
		this.orderClerkList = orderClerkList;
		this.customerList = orderClerkList.getCustomerList();
		this.parcelList = orderClerkList.getParcelList();
		LogFile.addLog("customerList.size:" + customerList.getCustomerList().size());
		
		
		for (int i = 1; i <= MAX_OREDERCLERKS; i++){
			orderClerkList.addOrderClerk();
		LogFile.addLog("New order clerk added");
		}
					
		for (OrderClerk oc: orderClerkList.getOrderClerkList())
		{
			oc.registerObserver(this);
			oc.start();
		}
		
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		jp = new JPanel();
		c.add(jp);
		jp.setLayout(new BorderLayout(10,10));
		jp.add(warehousePanel(), BorderLayout.NORTH);
		jp.add(customerQuePanel(), BorderLayout.EAST);
		jp.add(managerPanel(), BorderLayout.SOUTH);
		jp.add(counterPanel(), BorderLayout.CENTER);
		
		this.validate();
		
	}
	
	private JPanel warehousePanel()
	{
		jpWareHouse = new JPanel();
		jpWareHouse.setLayout(new GridLayout(0,1));
		jpWareHouse.add(new JLabel("Warehouse"));
		//Setup text area and scroll pane
		taWareHouse = new JTextArea(5, 5);
		taWareHouse.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		taWareHouse.setEditable(false);
		taWareHouse.setText(this.parcelList.warehouseReport(WHCOLUMNS));
		spWareHouse = new JScrollPane(taWareHouse);
		
		jpWareHouse.add(spWareHouse);
		
		return jpWareHouse;
	}
	
	private JPanel customerQuePanel()
	{
		jpCustQue = new JPanel();
		jpCustQue.setLayout(new GridLayout(0,1));
		jpCustQue.add(new JLabel("Que"));
		//Setup text area and scroll pane
		taCustQue = new JTextArea(5, 5);
		taCustQue.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		taCustQue.setEditable(false);
		taCustQue.setText(this.customerList.customerQueReport(1));
		spCustQue = new JScrollPane(taCustQue);
		
		jpCustQue.add(spCustQue);
		jpCustQue.setPreferredSize(new Dimension(300,300));
		jpCustQue.setMaximumSize(new Dimension(300,300));
		jpCustQue.setMinimumSize(new Dimension(300,300));
		return jpCustQue;
	}
	
	private JPanel counterPanel()
	{
		jpCounters = new JPanel();
		jpCounters.setLayout(new GridLayout(0,4));
		int i = 0;
		//Setup text area and scroll pane
		
			for (OrderClerk oc: orderClerkList.getOrderClerkList())
			{
				i++;
				Counters c = new Counters(oc,i);
				jpCounters.add(c.getPanel());
				counters.add(c);
			}
			
		return jpCounters;
	}
	
	
	private JPanel managerPanel()
	{
		jpManager = new JPanel();
		jpManager.setLayout(new GridLayout(0,3));
		//btnOpenShop, btnCloseShop;
		btnOpenShop = new JButton("OpenShop");
		btnCloseShop = new JButton("CloseShop");
		btnCloseShop.addActionListener(this);
		jpManager.add(btnOpenShop);
		jpManager.add(btnCloseShop);
		
		
		return jpManager;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getSource() == btnCloseShop)
		{
			LogFile.saveLogList();
			parcelList.writeParcelReport();
			
		}
		
	}

	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		try{
		taWareHouse.setText(this.parcelList.warehouseReport(WHCOLUMNS));
		taCustQue.setText(this.customerList.customerQueReport(1));
		}catch(NullPointerException e){
			System.out.println("Null pointer to:" + e.getMessage());
		}
		
		for(Counters c: counters)
		{
			c.upDateText();
		}
		
		
	}

	

	

}

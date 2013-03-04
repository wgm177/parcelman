package f21as;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIMain extends JFrame implements ActionListener, Observer {
	
	private static final int WIDTH = 800;		
	private static final int HEIGHT = 800;
	private static final int WHCOLUMNS = 10;
	
	JPanel jpCustQue, jpWareHouse, jpProcessOrder, jpProcessOrder1, jpCounters ,jpManager, jp;
	JButton btnOpenShop, btnCloseShop;
	JTextArea taCustQue, taWareHouse, taProcessOrder, taProcessOrder1, taManager;
	JScrollPane spCustQue, spWareHouse, spProcessOrder, spProcessOrder1;
	OrderClerk oc, oc1;
	
	
	public GUIMain(String title, OrderClerk oc, OrderClerk oc1)  {
		super(title);
		this.oc = oc;
		this.oc1 = oc1;
		
		oc.registerObserver(this);
		oc1.registerObserver(this);
		
		
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		jp = new JPanel();
		c.add(jp);
		jp.setLayout(new BorderLayout(10,10));
		jp.add(warehousePanel(), BorderLayout.NORTH);
		jp.add(customerQuePanel(), BorderLayout.SOUTH);
		
		jp.add(managerPanel(), BorderLayout.EAST);
		
		jpCounters = new JPanel();
		jpCounters.setLayout(new GridLayout(1,0));
		jp.add(jpCounters, BorderLayout.CENTER);
		jpCounters.add(processOrderPanel2());
		jpCounters.add(processOrderPanel());
		
		
		
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
		taWareHouse.setText(oc.parcelList.warehouseReport(WHCOLUMNS));
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
		taCustQue.setText(oc.customerList.customerQueReport(1));
		spCustQue = new JScrollPane(taCustQue);
		
		jpCustQue.add(spCustQue);
		
		return jpCustQue;
	}
	
	private JPanel processOrderPanel()
	{
		jpProcessOrder = new JPanel();
		jpProcessOrder.setLayout(new GridLayout(0,1));
		jpProcessOrder.add(new JLabel("Process"));
		//Setup text area and scroll pane
		taProcessOrder = new JTextArea(5, 5);
		taProcessOrder.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		taProcessOrder.setEditable(false);
		taProcessOrder.setText(oc.getProcessReport());
		spProcessOrder = new JScrollPane(taProcessOrder);
		
		jpProcessOrder.add(spProcessOrder);
		
		return jpProcessOrder;
	}
	
	private JPanel processOrderPanel2()
	{
		jpProcessOrder1 = new JPanel();
		jpProcessOrder1.setLayout(new GridLayout(0,1));
		jpProcessOrder1.add(new JLabel("Process"));
		//Setup text area and scroll pane
		taProcessOrder1 = new JTextArea(5, 5);
		taProcessOrder1.setFont(new Font (Font.MONOSPACED, Font.PLAIN,12));
		taProcessOrder1.setEditable(false);
		taProcessOrder1.setText(oc1.getProcessReport());
		spProcessOrder1 = new JScrollPane(taProcessOrder1);
		
		jpProcessOrder1.add(spProcessOrder1);
		
		return jpProcessOrder1;
	}
	
	private JPanel managerPanel()
	{
		jpManager = new JPanel();
		jpManager.setLayout(new GridLayout(3,0));
		//btnOpenShop, btnCloseShop;
		btnOpenShop = new JButton("OpenShop");
		btnCloseShop = new JButton("CloseShop");
		jpManager.add(btnOpenShop);
		jpManager.add(btnCloseShop);
		
		
		return jpManager;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getSource() == btnOpenShop)
		{
			oc.processCustomer();
			
		}
		
	}

	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		String processReport = oc.getProcessReport();
		this.taProcessOrder.setText(processReport);
		String processReport1 = oc1.getProcessReport();
		this.taProcessOrder1.setText(processReport1);
		String customerQue = oc.customerList.customerQueReport(1);
		this.taCustQue.setText(customerQue);
		String warehouse = oc.parcelList.warehouseReport(WHCOLUMNS);
		this.taWareHouse.setText(warehouse);
	}

	

	

}

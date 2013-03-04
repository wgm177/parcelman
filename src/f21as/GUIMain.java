package f21as;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIMain extends JFrame implements ActionListener {
	
	private static final int WIDTH = 800;		
	private static final int HEIGHT = 800;
	
	//CustomerList cl;
	//ParcelList pl;
	JPanel jpCustQue, jpWareHouse, jpProcessOrder, jpManager , jp;
	JButton btnOpenShop, btnCloseShop;
	JTextArea taCustQue, taWareHouse, taProcessOrder, taManager;
	JScrollPane spCustQue, spWareHouse, spProcessOrder;
	OrderClerk oc;
	
	public GUIMain(String title, CustomerList cl, ParcelList pl)  {
		super(title);
		this.oc = new OrderClerk(cl, pl);
		//this.cl = cl;
		//this.pl = pl;
		
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		jp = new JPanel();
		c.add(jp);
		jp.setLayout(new BorderLayout(10,10));
		jp.add(warehousePanel(), BorderLayout.NORTH);
		jp.add(customerQuePanel(), BorderLayout.SOUTH);
		jp.add(new JLabel("WEST"), BorderLayout.WEST);
		jp.add(managerPanel(), BorderLayout.EAST);
		jp.add(processOrderPanel(), BorderLayout.CENTER);
		
		//jp.add(new JTextArea(5,40));
		this.validate();
		//this.pack();
		
		// TODO Auto-generated constructor stub
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
		taWareHouse.setText(oc.parcelList.warehouseReport(7));
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
	
	
	private JPanel managerPanel()
	{
		jpManager = new JPanel();
		jpManager.setLayout(new GridLayout(3,0));
		//btnOpenShop, btnCloseShop;
		btnOpenShop = new JButton("OpenShop");
		btnCloseShop = new JButton("CloseShop");
		jpManager.add(btnOpenShop);
		jpManager.add(btnCloseShop);
		//Setup text area and scroll pane
		
		return jpManager;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	

}

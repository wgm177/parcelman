package f21as;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIMain extends JFrame implements ActionListener, Observer {
	
	private static final int WIDTH = 800;		
	private static final int HEIGHT = 500;
	
	OrderClerk oc;
	JPanel jp;
	JButton btnOpenShop, btnCloseShop;
	
	
	public GUIMain(String title, OrderClerk oc) throws HeadlessException {
		super(title);
		this.oc = oc;
		
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		GUIWarehouse guiWH = new GUIWarehouse(oc);
		GUICustomerQue guiCQ = new GUICustomerQue(oc);
		GUICounter guiC = new GUICounter(oc);
		Container c = this.getContentPane();
		jp = new JPanel();
		c.add(jp);
		jp.setLayout(new BorderLayout());
		jp.add(guiWH.warehousePanel(), BorderLayout.NORTH);
		jp.add(guiCQ.customerQuePanel(), BorderLayout.SOUTH);
		jp.add(new JLabel("WEST"), BorderLayout.WEST);
		jp.add(new JLabel("EAST"), BorderLayout.EAST);
		jp.add(guiC.processOrderPanel(), BorderLayout.CENTER);
		
		//jp.add(new JTextArea(5,40));
		this.validate();
		this.pack();
		
		// TODO Auto-generated constructor stub
	}
	
	private JPanel setupPanel() {
		JPanel mp = new JPanel();
		mp.setLayout(new BorderLayout());
		
		return mp;
	}
	



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

}

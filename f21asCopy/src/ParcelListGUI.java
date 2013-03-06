
	//import all the GUI classes
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

	/**
	 * Simple GUI for CustomerList application
	 */
	public class ParcelListGUI extends JFrame  implements ActionListener

	{
		
	    // The Parcel list to be searched.
		ParcelList parcelList;
	    
	    //GUI components
	    JTextField result;
	    JTextField searchField;
	    JButton search;
	    JScrollPane scrollList;
	    JButton showListById, showListByName, close;
	    JTextArea displayList;
	    
		public ParcelListGUI(ParcelList list)
	    {
	        this.parcelList = list;
	        
	        //set up window title
	        setTitle("Parcels List");
	        //disable standard close button
			setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
	 
			setupNorthPanel();
			setupCenterPanel();

	        //pack and set visible
	        pack();
	        setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocation(500,200);
	        this.setSize(300,400);
			this.setLayout(new BorderLayout());
		
			
	    }
	    private JPanel createGridPanel(CustomerList customerList) {
			JPanel panel = new JPanel(new GridLayout(3, 2));
			for (int i = 0; i < customerList.getSize(); i++) {
				Customer s = customerList.findBySeqNum(i);
		
			}
			return panel;
		}
	    private void setupCenterPanel() {
	        displayList = new JTextArea(15,20);
	        displayList.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
	        displayList.setEditable(false);
	        scrollList = new JScrollPane(displayList);
	        this.add(scrollList,BorderLayout.CENTER);
	    }
	    
	    
	    private void setupNorthPanel() {
	        //add north panel containing some buttons
	        JPanel northPanel = new JPanel();
	        showListById = new JButton("List By ID");
	        showListById.addActionListener(this);
	        
	        showListByName = new JButton("List By Name");
	        showListByName.addActionListener(this);
	        
	        close = new JButton("Close");
	        close.addActionListener(this);
	        
	        northPanel.add (showListById);
	        northPanel.add(showListByName);
	        northPanel.add(close);
	        this.add(northPanel, BorderLayout.NORTH);
	    }
	    
	    //come here when button is clicked
	    //find which button and act accordingly
	    public void actionPerformed(ActionEvent e) 
	    { 
	    	if (e.getSource() == search) {
	    		//search();
	    	}
	    	else if (e.getSource() == showListById) {
	    		
	    		displayList.setText("amjad");
	    	}
	    	else if (e.getSource() == showListByName ) {
	    		displayList.setText(this.parcelList.parcelReport());
	    		System.out.println("aaaaaa");
	    	}
	    	else if (e.getSource() == close) {
	    		JOptionPane.showMessageDialog(this, 
	    				 "Do 'end of program' things instead of showing this");
	    		System.exit(0);
	    	}
	    }  
	    }


	



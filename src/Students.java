

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class Students extends JPanel{
	
	DBConnect con;
	private JTextField fName;
	private JTextField lName;
	private JTextField fakNum;
	private JScrollPane scrollPane;
	private JTable table;
	private String fNameT,lNameT,fakNumT, spec;
	private boolean clicked = false; 
	
	//not done yet
	private JButton addPplBtn;

	
	public Students(DBConnect con){
		
								
		this.con = con;
		
		//visual stuff
		this.setLayout(null);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//dropdown menu
		JComboBox<String> dropDown = new JComboBox<String>(con.getAllSpec());
		dropDown.setBounds(30, 129, 100, 20);
		dropDown.setVisible(true);
				
		
		this.add(dropDown);
		
		
		//first name text field
		JTextField fName = new JTextField();
		fName.setBounds(30, 36, 100, 20);
		fName.setColumns(10);
		fName.setVisible(true);
		
		//focus listener to store the string value added in the text field
		//when focus is changed away from this field
		fName.addFocusListener(new FocusListener() {
		      public void focusGained(FocusEvent e) {
		      };
		      public void focusLost(FocusEvent e) {
		        if (!e.isTemporary()) {
		        	fNameT = fName.getText();
		        if (fNameT.equals("") ) {
		        	
		            System.out.println("Populni Ime!");		            
		          }
		        }
		      }
		    });

		this.add(fName );
		
		//last name text field
		JTextField lName = new JTextField();
		lName.setBounds(30, 67, 100, 20);
		lName.setColumns(10);
		lName.setVisible(true);	
		
		// focus listener to store the string value added in the text field
		// when focus is changed away from this field
		lName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			};

			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					lNameT = lName.getText();
					if (lNameT.equals("")) {

						System.out.println("Populni Ime!");
					}
				}
			}
		});
		
		this.add(lName );
		
		//fakulteten nomer text field
		JTextField fakNum = new JTextField();
		fakNum.setBounds(30, 98, 100, 20);
		fakNum.setColumns(10);
		fakNum.setVisible(true);		
		
		// focus listener to store the string value added in the text field
		// when focus is changed away from this field
		fakNum.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			};

			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					fakNumT = fakNum.getText();
					if (fakNumT.equals("")) {

						System.out.println("Populni Ime!");
					}
				}
			}
		});
		this.add(fakNum );
		
		//add student button
		addPplBtn = new JButton("Add Student");
		addPplBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		addPplBtn.setBounds(138, 97, 89, 52);
		addPplBtn.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {		
	    	  
	    	  
	    	  int spec = dropDown.getSelectedIndex() + 1;
	    	  con.addPerson(fNameT, lNameT, fakNumT, spec);
	    	  fName.setText("");
	    	  lName.setText("");
	    	  fakNum.setText("");
	      }	   
	    });
		
		this.add(addPplBtn);
		
		
		// refresh table button
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(385, 211, 89, 23);
		this.add(refreshBtn);
		
		//text at top left
		JLabel lblNewLabel = new JLabel("Students");
		lblNewLabel.setBounds(10, 11, 93, 14);
		this.add(lblNewLabel);
		
		//adding a scrollpane with a table inside of it, containing the students data and books taken
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 464, 206);
		scrollPane.setVisible(false);
		this.add(scrollPane);
		
		table = new JTable();
		table.setVisible(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Student", "Fak. Number", "Speciality", "Drp down menu of books taken", "Taken date", "Return date"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(129);
		table.getColumnModel().getColumn(3).setPreferredWidth(125);
		scrollPane.setViewportView(table);
		
		// show/hide table button
		JButton showHideBtn = new JButton("Show Table");
		showHideBtn.setBounds(10, 211, 120, 23);
		showHideBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (clicked)  
		         {  										
					scrollPane.setVisible(false);
					table.setVisible(false);
					showHideBtn.setText("Show Table");
					clicked = false; 
		         }  
		         else  
		         {  
		        	 scrollPane.setVisible(true);
		        	 table.setVisible(true);
		        	 showHideBtn.setText("Hide Table");
		        	 clicked = true; 
		         }  
		         
				
				


				
								
			}
		});

		this.add(showHideBtn);
		
		
		
		
		
	}
	

}

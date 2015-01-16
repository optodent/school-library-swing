import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Specialities extends JPanel{
	DBConnect con;
	
public Specialities(DBConnect con){
		this.con = con;
		JTextField textField = new JTextField("", 10);				
		JButton addSpecBtn = new JButton("Add Specialnost");
		
		addSpecBtn.setSize(100, 100);
		//addSpecBtn.setLocation(150, 50);
		addSpecBtn.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {	
	    	  
	    	// if nothing is in the textfield do nothing, else add the text to the database as a specialnost
	    	if(textField.getText().equals("")){
	    		;
	    	}else{
		        con.addSpec(textField.getText());
		        textField.setText("");
	    	}
	      }
	    });
		
		this.add(addSpecBtn);
		this.add(textField);
		// end of specialnosti tab elements
	}
}

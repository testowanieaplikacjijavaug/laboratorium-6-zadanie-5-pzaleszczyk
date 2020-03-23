import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Buttons extends JFrame {
    
    JTextField text_field;
    JButton add_button;
    JButton subtract_button;
    int amount = 0;

    Buttons() {
    	text_field = new JTextField(10);
    	add_button = new JButton("Add");
    	subtract_button =  new JButton("Minus");
    	
        setTitle("program - pzaleszczyk");
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(add_button);
        cp.add(subtract_button);
        cp.add(text_field);
        setSize(200, 150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add_button.setBackground(Color.yellow);
        subtract_button.setBackground(Color.red);
        
        add_button.addActionListener(new add_button());
        subtract_button.addActionListener(new subtract_button());

       
    }
    
    class add_button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	amount++;
            text_field.setText(amount+"");
            text_field.setBackground(Color.green);
        }
        
    }
    
    class subtract_button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	amount--;
            text_field.setText(amount+"");
            text_field.setBackground(Color.orange);
        }
        
    }
    
    public static void main(String[] arg) {
        new Buttons();
    }
    
}

package evoting;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginDialog extends JDialog implements ActionListener{
		private JLabel user_label;
		private JTextField user;
		private JLabel pass_label;
		private JTextField pass;
		private JButton btn;

		LoginDialog(JFrame owner){
			super(owner,"Login",true);
			setLayout(new FlowLayout());
			setSize(400,150);
			setResizable(false);
			setVisible(true);		

			user_label = new JLabel("Username:");
			pass_label = new JLabel("Password:");
			user = new JTextField(10);
			pass = new JTextField(10);

			add(user_label);
			add(user);
			add(pass_label);
			add(pass);
			add(btn);			
			
		}
		public void actionPerformed(ActionEvent ae){

		}
	}
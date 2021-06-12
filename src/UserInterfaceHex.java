import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * A graphical user interface for the calculator. No calculation is being
 * done here. This class is responsible just for putting up the display on 
 * screen. It then refers to the "CalcEngine" to do all the real work.
 * 
 * @author AlexJger and n-c0de-r
 * @version 27.05.2021
 */
public class UserInterfaceHex extends UserInterface {
	 protected CalcEngineHex calcHex;
	 
	 private Checkbox h;
	 private int mode = 10;
	 
	public UserInterfaceHex(CalcEngine engine) {
		super(engine);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void makeFrame() {
		frame = new JFrame(calc.getTitle());

		JPanel contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel(new GridLayout(6, 6));
		addButton(buttonPanel, "A");
       		addButton(buttonPanel, "B");
       		addButton(buttonPanel, "C");
       		buttonPanel.add(new JLabel(" "));
       		buttonPanel.add(new JLabel(" "));
        	h = (Checkbox) (buttonPanel.add(new Checkbox("Hex", false)));
       
       		addButton(buttonPanel, "D");
       		addButton(buttonPanel, "E");
       		addButton(buttonPanel, "F");
      		buttonPanel.add(new JLabel(" "));
       		buttonPanel.add(new JLabel(" "));
       		buttonPanel.add(new JLabel(" "));
       
       		addButton(buttonPanel, "7");
       		addButton(buttonPanel, "8");
       		addButton(buttonPanel, "9");
       		buttonPanel.add(new JLabel(" "));
       		addButton(buttonPanel, "+");
       		addButton(buttonPanel, "del");
       
       		addButton(buttonPanel, "4");
       		addButton(buttonPanel, "5");
       		addButton(buttonPanel, "6");
       		buttonPanel.add(new JLabel(" "));
       		addButton(buttonPanel, "-");
       		addButton(buttonPanel, "?");
       
       		addButton(buttonPanel, "1");
       		addButton(buttonPanel, "2");
       		addButton(buttonPanel, "3");
       		buttonPanel.add(new JLabel(" "));
       		addButton(buttonPanel, "*");
       		addButton(buttonPanel, "mod");
       
       		addButton(buttonPanel, "0");
       		buttonPanel.add(new JLabel(" "));
        	buttonPanel.add(new JLabel(" "));
       		buttonPanel.add(new JLabel(" "));
       		addButton(buttonPanel, "/");
       		addButton(buttonPanel, "=");
       	
		contentPane.add(buttonPanel, BorderLayout.CENTER);

		status = new JLabel(calc.getAuthor());
		contentPane.add(status, BorderLayout.SOUTH);

		frame.pack();
		toggleLetters();
	}
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if (h.getState()) {
			mode = 16;
		} else {
			mode = 10;
		}
		if (command.equals("0") || 
			command.equals("1") ||
			command.equals("2") ||
			command.equals("3") ||
			command.equals("4") ||
			command.equals("5") ||
			command.equals("6") ||
			command.equals("7") ||
			command.equals("8") ||
			command.equals("9")	||
			command.equals("A") ||
			command.equals("B") ||
			command.equals("C") ||
			command.equals("D") ||
			command.equals("E") ||
			command.equals("F")) {
			
			//HexLetters to int:
			int number = Integer.parseInt(command, mode);
			calc.numberPressed(number, mode);
				
		} else if (command.equals("+")) {
			calc.plus();
		} else if (command.equals("-")) {
			calc.minus();
		} else if (command.equals("*")) {
			calc.multiply();
		} else if (command.equals("/")) {
			calc.divide();
		} else if (command.equals("mod")) {
			calc.modulo();
		} else if (command.equals("=")) {
			calc.equals();
		} else if (command.equals("del")) {
			calc.clear();
		} else if (command.equals("?")) {
			showInfo();
		}
		// else unknown command.
		toggleLetters();
		redisplay();
	}
	
	//Change (int) displayValue to Hex (String) and capitalizes the letter
	private void redisplay() {
		
		if (h.getState()) {
			display.setText("" + Integer.toHexString(calc.getDisplayValue()).toUpperCase());
			 
		} else {
			display.setText("" + calc.getDisplayValue());
		}
	}
	
	private void toggleLetters() {
		//TODO disable buttons
//		frame.getContentPane().getComponent(1).getComponentAt(p).setEnabled(h.getState());
//		frame.getContentPane().getComponent(1).getComponentAt(1, 2).setEnabled(h.getState());
//		frame.getContentPane().getComponent(1).getComponentAt(1, 3).setEnabled(h.getState());
//		frame.getContentPane().getComponent(1).getComponentAt(2, 1).setEnabled(h.getState());
//		frame.getContentPane().getComponent(1).getComponentAt(2, 2).setEnabled(h.getState());
//		frame.getContentPane().getComponent(1).getComponentAt(2, 3).setEnabled(h.getState());
	}
}
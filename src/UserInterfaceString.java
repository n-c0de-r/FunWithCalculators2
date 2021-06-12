/*
 * @author n-c0de-r, jonasblome, and joeysmeets
 * @version 12.06.21
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.EmptyBorder;

public class UserInterfaceString implements ActionListener{
	
	private CalcEngineString calc;
    private boolean showingAuthor;
    private JFrame frame;
    private JTextField display;
    private JLabel status;
	private JCheckBox h;
	private JButton A, B, C, D, E, F;
	private int mode = 10;
	private Postfix postfix = new Postfix(); 

	public UserInterfaceString(CalcEngineString engine) {
		calc = engine;
        showingAuthor = true;
        makeFrame();
        frame.setVisible(true);
	} 
	
	/**
     * Set the visibility of the interface.
     * @param visible true if the interface is to be made visible, false otherwise.
     */
    public void setVisible(boolean visible)
    {
        frame.setVisible(visible);
    }

	private void makeFrame() {
		frame = new JFrame(calc.getTitle());

		JPanel contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8)); 
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel(new GridLayout(6, 6));
		A = new JButton("A");
        buttonPanel.add(A);
        A.setEnabled(false);
        B = new JButton("B");
        buttonPanel.add(B);
        B.setEnabled(false);
        C = new JButton("C");
        buttonPanel.add(C);
        C.setEnabled(false);
  		buttonPanel.add(new JLabel(" "));
  		addButton(buttonPanel, "(");
  		h = new JCheckBox("Hex");
  		h.setSelected(false);
  		buttonPanel.add(h);
        h.addActionListener(this);
  		
        D = new JButton("D");
        buttonPanel.add(D);
        D.setEnabled(false);
        E = new JButton("E");
        buttonPanel.add(E);
        E.setEnabled(false);
        F = new JButton("F");
        buttonPanel.add(F);
        F.setEnabled(false);
 		buttonPanel.add(new JLabel(" "));
 		addButton(buttonPanel, ")");
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
//		toggleLetters();
	}
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if (h.isSelected()) {
			mode = 16;
			A.setEnabled(true);
			B.setEnabled(true);
			C.setEnabled(true);
			D.setEnabled(true);
			E.setEnabled(true);
			F.setEnabled(true);
		} else {
			mode = 10;
			A.setEnabled(false);
			B.setEnabled(false);
			C.setEnabled(false);
			D.setEnabled(false);
			E.setEnabled(false);
			F.setEnabled(false);
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
								
			} else if (command.equals("=")) {
				try {
					calc.equals();
				} catch (StackUnderflowException | IncorrectFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (command.equals("Hex")) {
				return;// does nothing 
			} else if (command.equals("del")) {
				calc.clear();
			} else if (command.equals("?")) {
				showInfo();
			} else {
				calc.applyOperators(command);
			}
		redisplay();
	}
	
	/**
     * Add a button to the button panel.
     * @param panel The panel to receive the button.
     * @param buttonText The text for the button.
     */
    protected void addButton(Container panel, String buttonText)
    {
        JButton button = new JButton(buttonText);
        button.addActionListener(this);
        panel.add(button);
    }
	
	//Change (int) displayValue to Hex (String) and capitalizes the letter
	private void redisplay() {
		display.setText("" + calc.getDisplayString().toUpperCase());
	}
	
	/**
     * Toggle the info display in the calculator's status area between the
     * author and version information.
     */
    protected void showInfo()
    {
        if(showingAuthor)
            status.setText(calc.getVersion());
        else
            status.setText(calc.getAuthor());

        showingAuthor = !showingAuthor;
    }
}


	import java.awt.*;
	import java.awt.event.*;
	
	import javax.swing.*;
	import javax.swing.border.*;


	public class GUI {
	 private JFrame mainFrame;
	 private Simulator simulator;
	protected Window createFrame;
	 

	 public GUI(Simulator s) {
		 final int blankSpace = 6;
		 this.simulator = simulator;
	 
		 
		 
	  
	  //step 1
	  JTextField qField = new JTextField();
	  JTextField pField = new JTextField();
	  JTextField proTimeField = new JTextField();
	  JTextField noProcessField = new JTextField();
	  JTextField noPackField = new JTextField();
	  JTextField simTimeField = new JTextField();
	  JLabel instructions = new JLabel();
	  JButton startButton = new JButton();

	  
	  //step 2
	  qField.setText("q");
	  pField.setText("p");
	  proTimeField.setText("Processing Machines time");
	  noProcessField.setText("Number of Processing Machines");
	  noPackField.setText("Number of Packaging Machines");
	  simTimeField.setText("Simulation Time");
	  instructions.setText("Please enter the following details: ");
	  startButton.setText("Start");
	  startButton.setToolTipText("Button to start running the simulation");
	  
	  //step 3
	  JFrame mainFrame = new JFrame();
	  mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	  
	  JPanel textEntry = new JPanel();
	  JPanel controls = new JPanel();
	  
	  //step 4
	  mainFrame.setLayout(new BorderLayout());
	  ((JPanel)mainFrame.getContentPane()).setBorder(new 
			  EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	  mainFrame.setLayout(new BorderLayout());
	
	  
	  textEntry.setLayout(new FlowLayout());
	  textEntry.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	  controls.setLayout(new FlowLayout());
	  controls.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
	  mainFrame.add(textEntry, BorderLayout.NORTH);
	  mainFrame.add(controls, BorderLayout.SOUTH);
	  
	  //step 5
      textEntry.add(qField);
	  textEntry.add(pField);
	  textEntry.add(proTimeField);
	  textEntry.add(noProcessField);
	  textEntry.add(noPackField);
	  textEntry.add(simTimeField);
	  textEntry.add(instructions);
	  controls.add(startButton);  
	  
	  //step 6
	  
	  startButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				startSimulation();
			}
		});
	  
	  //step 7
	  mainFrame.pack();
	  mainFrame.setVisible(true);
	}
	 
	 private void startSimulation() {

			JTextField startButton;
			startButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object pProbability;
					Object qProbability;
					Simulator s = new Simulator(titleEntry.getText(),
							((Object) pProbability).getValue(),
							((Object) qProbability).getValue());
					createFrame.dispose();
				}
			});
		 createFrame.pack()
		 createFrame.setVisible(true);
	 }
	 }

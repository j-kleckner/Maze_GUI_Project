import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
	static JFrame frame = new JFrame("Maze Generator");
	JPanel buttonPanel = new JPanel(new BorderLayout());
	/* 
	 * Constructor for Main which will add title and buttons to begin
	 * generating a maze or view instructions.
	 * Two anonymous classes which will listen for the click of each button.
	*/
	public Main() {
		JButton begin = new JButton("BEGIN");
		begin.setFont(new Font("Courier New", Font.BOLD, 20));
		begin.setForeground(Color.WHITE);
		begin.setBackground(Color.darkGray);
		begin.setFocusable(false);

		JButton instructions = new JButton("INSTRUCTIONS");
		instructions.setFont(new Font("Courier New", Font.BOLD, 18));
		instructions.setForeground(Color.WHITE);
		instructions.setBackground(Color.darkGray);
		instructions.setFocusable(false);

		buttonPanel.setOpaque(false);
		buttonPanel.add(begin, BorderLayout.NORTH);
		buttonPanel.add(instructions, BorderLayout.SOUTH);
		
		JLabel background = new JLabel(new ImageIcon("maze.jpg"));
		background.setLayout(new GridBagLayout());
		background.add(buttonPanel, new GridBagConstraints());	
		
		
		begin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				frame.dispose();
				new getMazeSize();
			}
		}); //clicking begin will take user to getMazeSize frame
		
		instructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				JFrame frame = new JFrame("Instructions");
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
				JLabel label = new JLabel("" + "<html>" +
						"1. Click 'Begin' to start designing a maze.<br>" + 
						"2. Choose the Height and Width of maze.<br>"+  
						"3. Enter choice of wall character.<br>" + 
						"4. Click 'Generate' to generate the maze.<br>" +
						"5. Click 'View Maze' to view generated maze <br>"
						+ "or 'Reset' to start over. </html>"); 
			
				label.setFont(new Font("Arial", Font.PLAIN, 15));

				frame.getContentPane().add(label, BorderLayout.CENTER);
				frame.getContentPane().setBackground(new Color(204,220,255));
				frame.setLocationRelativeTo(null);	
				frame.setResizable(true); //prevent frame from being resized
				frame.pack();	
				frame.setVisible(true);
				
			}
		}); //clicking instructions will take user to instructions frame
		
		frame.add(background);
		frame.setSize(350,200); //sets dimensions of frame
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application by clicking X
		frame.setResizable(false); //prevent frame from being resized
		frame.setVisible(true); //makes the frame visible	
	}
}
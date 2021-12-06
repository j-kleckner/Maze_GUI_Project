import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Class that handles the design settings including 
 * textField for choosing a Maze Wall and the Generate
 * button to generate the maze using options selected
 * in getMazeSize and getMazeWall.
 */

public class getMazeWall {
	static JFrame frame = new JFrame("Maze Design: Wall");
	JPanel textPanel = new JPanel(new FlowLayout());
	JPanel buttonPanel = new JPanel(new BorderLayout());	
	public String wallC;
	public static String c;
	/*
	 * Constructor for the designMaze class. Sets up JFrame which includes a textField 
	 * to get option for Maze Wall.
	 */
	public getMazeWall() {

		JLabel title = new JLabel("ENTER CHARACTER FOR MAZE WALL:");
		title.setFont(new Font("Courier New", Font.BOLD, 18)); //font size
		title.setForeground(Color.WHITE); //color of text
		title.setBackground(Color.darkGray);
		title.setOpaque(true);
		
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(100,30));
		textField.setForeground(Color.darkGray);
		textField.setFont(new Font("Courier New", Font.BOLD, 18));
				
		JButton generate = new JButton("GENERATE");
		generate.setFont(new Font("Courier New", Font.BOLD, 18));
		generate.setForeground(Color.WHITE);
		generate.setBackground(Color.darkGray);
		generate.setFocusable(false);	
		
		textPanel.setOpaque(false);
		textPanel.add(title);
		textPanel.add(textField);
		buttonPanel.setOpaque(false);
		buttonPanel.add(generate);
		
		JLabel background = new JLabel(new ImageIcon("maze.jpg"));
		background.setLayout(new BorderLayout());
		background.add(textPanel, BorderLayout.CENTER);
		background.add(buttonPanel, BorderLayout.SOUTH);	
		
		//maze
		generate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().isEmpty())  {
					JOptionPane.showMessageDialog(frame,
							"Please enter a single character.",
							"Character error",
							JOptionPane.WARNING_MESSAGE);

				}
				else {
					frame.dispose();
					String g = e.getActionCommand();
					if (g.equals("GENERATE")) {
						wallC = textField.getText();
						c = String.valueOf(wallC.charAt(0));
						new mazeFrame();
					}					
				}

			}
		});
		frame.setSize(367, 200);
		frame.add(background);
		frame.setLocationRelativeTo(null);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
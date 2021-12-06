import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Class that handles the design settings including 
 * Combo Boxes for size of Maze and Next button 
 * to open next frame.
 */
public class getMazeSize {
	static JFrame frame = new JFrame("Maze Design: Size");
	JPanel buttonPanel = new JPanel(new BorderLayout());
	JPanel sizePanel = new JPanel(new FlowLayout());
	public String mHeight;
	public String mWidth;
	public static int h;
	public static int w;
	
	/*
	 * Constructor for the designMaze class. Sets up JFrame which includes two Combo Boxes 
	 * to select width and height of maze
	 */

	public getMazeSize() {
		JLabel title = new JLabel("SELECT WIDTH AND HEIGHT:");
		title.setFont(new Font("Courier New", Font.BOLD, 20));
		title.setForeground(Color.WHITE);
		title.setBackground(Color.darkGray);
		title.setOpaque(true);

		String[] list = {"Width","4", "5", "6", "7", "8", "9", "10", "11", "12"};
		JComboBox<?> width = new JComboBox<Object>(list);
		width.setEditable(false);
		width.setBounds(75, 100, 150, 50);
		width.setFont(new Font("Courier New", Font.BOLD, 18));
		width.setOpaque(false);
		width.setBackground(Color.WHITE);
		width.setForeground(Color.darkGray);

		String[] list1 = {"Height","4", "5", "6", "7", "8", "9", "10", "11", "12"};
		JComboBox<?> height = new JComboBox<Object>(list1);
		height.setEditable(false);
		height.setBounds(100, 100, 150, 50);
		height.setFont(new Font("Courier New", Font.BOLD, 18));
		height.setOpaque(false);
		height.setBackground(Color.WHITE);
		height.setForeground(Color.darkGray);

		JButton next = new JButton("NEXT");
		next.setFont(new Font("Courier New", Font.BOLD, 18));
		next.setForeground(Color.WHITE);
		next.setBackground(Color.darkGray);
		next.setFocusable(false);
		
		sizePanel.setOpaque(false);
		sizePanel.add(title);
		sizePanel.add(width);
		sizePanel.add(height);
		buttonPanel.setOpaque(false);
		buttonPanel.add(next);

		JLabel background = new JLabel(new ImageIcon("maze.jpg"));
		background.setLayout(new BorderLayout());
		background.add(sizePanel, BorderLayout.CENTER);
		background.add(buttonPanel, BorderLayout.SOUTH);	
		
		//Getting user selection of 
		width.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mWidth = width.getSelectedItem().toString();					
				w = Integer.parseInt(mWidth);
			}
		});
		height.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mHeight = height.getSelectedItem().toString();	
				h = Integer.parseInt(mHeight);
			}
		});
		//Next button Action Listener - AH
		next.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e)
			{
				if(height.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(frame,
						    "Please select a Height.",
						    "Height Error",
						    JOptionPane.WARNING_MESSAGE);
				}
				else if(width.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(frame,
						    "Please select a Width.",
						    "Width Error",
						    JOptionPane.WARNING_MESSAGE);
				}
				else {
					frame.dispose();
					String n = e.getActionCommand();
					if (n.equals("NEXT")) {
						next.getSelectedObjects();
						new getMazeWall();
					}					
				}
			}
		});		

		frame.add(background);
		frame.setSize(365,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
}
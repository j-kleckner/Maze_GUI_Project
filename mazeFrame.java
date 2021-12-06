import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * This class includes the elements of the maze including the
 * Reset and View Maze buttons.
 */
public class mazeFrame {
	static JFrame frame = new JFrame("Maze Generator");
	JPanel mazePanel = new JPanel(new BorderLayout());
	JPanel buttonPanel = new JPanel(new FlowLayout());
	JLabel label, image, background;
	
	public mazeFrame() {
		
		label = new JLabel("MAZE GENERATED!");
		label.setFont(new Font("Courier New",Font.BOLD, 20));
		label.setForeground(Color.WHITE);
		label.setBackground(Color.darkGray);
		label.setOpaque(true);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		JButton reset = new JButton("RESET");
		reset.setFont(new Font("Courier New", Font.BOLD, 18)); //font size
		reset.setForeground(Color.WHITE);
		reset.setBackground(Color.darkGray);		
		reset.setFocusable(false);
		reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new Main();
			}
		});	
		JButton viewMaze = new JButton("VIEW MAZE");
		viewMaze.setFont(new Font("Courier New", Font.BOLD, 18)); //font size
		viewMaze.setForeground(Color.WHITE);
		viewMaze.setBackground(Color.darkGray);		
		viewMaze.setFocusable(false);
		viewMaze.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				new viewMaze();
			}
		});	
		mazePanel.setOpaque(false);
		mazePanel.add(label);
		buttonPanel.setOpaque(false);
		buttonPanel.add(reset);
		buttonPanel.add(viewMaze);
		
		background = new JLabel(new ImageIcon("maze.jpg"));
		background.setLayout(new BorderLayout());
		background.add(mazePanel, BorderLayout.NORTH);
		background.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.add(background);
		frame.setSize(300,150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
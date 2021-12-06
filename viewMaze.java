import java.awt.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class viewMaze {
	public static JFrame frame = new JFrame("Generated Maze");
	public static JPanel panel; 
	static JTextPane textArea = new JTextPane();
	JPanel printPanel = new JPanel(new BorderLayout());
	mazeCreator maze = new mazeCreator(getMazeSize.h, getMazeSize.w, getMazeWall.c);
	StringBuffer s = maze.display_maze(getMazeWall.c);
	
	public viewMaze() {
		textArea.setText(s.toString());
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setBackground(new Color(255,255,255));
		
		StyledDocument doc = textArea.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		JButton print = new JButton("PRINT MAZE");
		print.setFont(new Font("Courier New", Font.BOLD, 18));	
		print.setForeground(Color.WHITE);
		print.setBackground(Color.darkGray);
		print.setFocusable(false);
		print.addActionListener(new Print());
		
		printPanel.add(print, BorderLayout.CENTER);
		printPanel.setBackground(Color.white);
		
		frame.add(textArea, BorderLayout.CENTER);
		frame.add(printPanel, BorderLayout.SOUTH);
		frame.setSize(600,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);

	}
}
/*
This is the code that generates mazes.
 */
import java.util.*;

public class mazeCreator {
	private int x; // height
	private int y; // width
	private int[][] maze;
	
	// Constructor
	public mazeCreator(int x, int y, String c) {
		this.x = x;
		this.y = y;
		maze = new int[this.x][this.y];
		generateMaze(0, 0);
	}
	
	// Function to display maze
	public StringBuffer display_maze(String c) {
		StringBuffer track = new StringBuffer();
		for (int i = 0; i < y; i++) {
			
			for (int j = 0; j < x; j++) {
				if (((maze[j][i] & 1) == 0)) {
					track.append(c.repeat(4));
					// System.out.print(c.repeat(4));
				}
				else {
					track.append(c.concat("   "));
					// System.out.print(c.concat("   "));
				}
			}
			track.append(c);
			track.append(System.lineSeparator());
			// System.out.println(c);
			
			for (int j = 0; j < x; j++) {
				
				if ((maze[j][i] & 8) == 0) {
					track.append(c.concat("   "));
					// System.out.print(c.concat("   "));
				}
				else {
					track.append("    ");
					// System.out.print("    ");
				}
			}
			track.append(c);
			track.append(System.getProperty("line.separator"));
			// System.out.println(c);
		}
		
		for (int j = 0; j < x; j++) {
			track.append(c.repeat(4));
			// System.out.print(c.repeat(4));
		}
		track.append(c);
		track.append(System.getProperty("line.separator"));
		// System.out.println(c);
		// String m = track.toString();
		return track;
	}
	
	// Function to generate maze -> Essentially takes all positions and shuffles them and picks from the shuffled collection a random starting point and continues with recursion
	private void generateMaze(int cx, int cy) {
		directions[] dirs = directions.values();
		Collections.shuffle(Arrays.asList(dirs));
		
		for (directions dir : dirs) {
			int nx = cx + dir.dir_x;
			int ny = cy + dir.dir_y;
			
			if (check(nx, x) && check(ny, y)
					&& (maze[nx][ny] == 0)) {
				maze[cx][cy] |= dir.bit;
				maze[nx][ny] |= dir.swap.bit;
				generateMaze(nx, ny);
			}
		}
	}
	
	// Checks position in maze to continue generation
	private static boolean check(int n, int u) {
		return (n >= 0) && (n < u);
	}
	
	// Enum holds directions and can swap them
	private enum directions {
		N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
		private int bit;
		private int dir_x;
		private int dir_y;
		private directions swap;

		static {
			N.swap = S;
			S.swap = N;
			E.swap = W;
			W.swap = E;
		}
 
		private directions(int bit, int dir_x, int dir_y) {
			this.bit = bit;
			this.dir_x = dir_x;
			this.dir_y = dir_y;
		}
	}
}
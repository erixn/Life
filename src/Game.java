import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Game {
	private Board board;
	
	public Game(int width, int height) {
		board = new Board(width, height);
	}
	
	public void play() {
		
		try {
			System.out.println(board.toString());

			while(true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        System.out.print("Ready:");
		        String s = br.readLine();
		        if (s.startsWith("q") || s.startsWith("Q")) {
		        	System.out.print("Done!");
		        	return;
		        }
		        board.move();
		        System.out.println(board.toString());
			}
		}
		catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
		}
	}
	public void move() {
		board.move();
	}
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Takes one argument, the name of the input file");
			return;
		}
		File inputFile = new File(args[0]);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String line = null;
			line = reader.readLine();
			String[] dimensions = line.split(" ");
			int width = new Integer(dimensions[0]);
			int height = new Integer(dimensions[1]);
		
			Game game = new Game(width, height);
			
			int x=0, y=0;
			line = reader.readLine();
			while (line != null) {
				String[] values = line.split(" ");
				for (String s : values) {
					if (s.equals("1")) {
						game.board.setCellState(x, y, Cell.State.Alive);
					}
					y++;
				}
				y=0;
				x++;
				line = reader.readLine();
			}
			reader.close();
			
			game.play();
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			return;
		}
	}
}

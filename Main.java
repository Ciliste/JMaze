import ihm.MazeFrame;
import maze.Maze;

public class Main {

    private Maze maze;
    private MazeFrame frame;

    private Main() {

        new MazeFrame(this);
        System.out.println(new Maze().toString());
    }

    public static void main(String[] args) {
        
        new Main();
    }
}
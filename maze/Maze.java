package maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    
    private static final int WIDTH = 11;
    private static final int HEIGHT = 11;

    private static final int WALL = -1;

    private final int[][] maze;

    public Maze() {

        this(Maze.WIDTH, Maze.HEIGHT);
    }

    public Maze(int width, int height) {

        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("Width and height must be positive");
        }

        if (width  % 2 == 0) width++;
        if (height % 2 == 0) height++;

        this.maze = new int[width][height];

        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {

                if (i == 0 || i == width - 1 || j == 0 || j == height - 1) {

                    this.maze[i][j] = Maze.WALL;
                } 
                else if (i % 2 == 0 || j % 2 == 0) {

                    this.maze[i][j] = Maze.WALL;
                }
                else {

                    this.maze[i][j] = 0;
                }
            }
        }
    }

    public void setupNumbers() {

        int colors = 0;
        for (int i = 0; i < this.maze.length; i++) {

            for (int j = 0; j < this.maze[i].length; j++) {

                if (this.maze[i][j] != Maze.WALL) {

                    colors++;
                }
            }
        }

        List<Integer> numbers = new ArrayList<Integer>();
        for (int cpt = 0; cpt < colors; cpt++) {

            numbers.add(cpt);
        }

        for (int i = 0; i < this.maze.length; i++) {

            for (int j = 0; j < this.maze[i].length; j++) {

                if (this.maze[i][j] != Maze.WALL) {

                    int num = numbers.get((int) (Math.random() * numbers.size()));
                    this.maze[i][j] = num;
                    numbers.remove(num);
                }
            }
        }
    }

    public void nextStep() {

        
    }

    public boolean isComplete() {

        int color = -1;
        for (int i = 0; i < this.maze.length; i++) {

            for (int j = 0; j < this.maze[i].length; j++) {

                if (this.maze[i][j] != Maze.WALL) {

                    if (color == -1) {

                        color = this.maze[i][j];
                    }
                    else if (color != this.maze[i][j]) {

                        return false;
                    }
                }
            }
        }

        return true;
    }

    public int[][] getMaze() {

        return this.maze;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.maze.length; i++) {

            for (int j = 0; j < this.maze[i].length; j++) {

                sb.append(this.maze[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
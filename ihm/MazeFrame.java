package ihm;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MazeFrame extends JFrame {
    
    public <Main> MazeFrame(Main main) {
        
        super("JMaze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);

        setLayout(new BorderLayout());

        
    }
}
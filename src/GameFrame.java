import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GameFrame extends JFrame {
    private TextSource textSource = new TextSource();
    private ScorePanel scorePanel = new ScorePanel();

    private SplitPanel splitPanel = new SplitPanel();
    private GamePlayPanel play = new GamePlayPanel(scorePanel, textSource);

    public GameFrame(){
        setTitle("게임");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(splitPanel);
        setVisible(true);



        Container c = getContentPane();

    }

    public static void main(String[] args) {
        new GameFrame();
    }
}

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private int score = 0;
    private JLabel ScoreLebel = new JLabel(Integer.toString(score));

    public ScorePanel(){
        setBackground(Color.YELLOW);
        add(new JLabel("점수"));
        add(ScoreLebel);
    }

    public void increase(){
        score += 10;
        ScoreLebel.setText(Integer.toString(score));
    }
}

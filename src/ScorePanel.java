import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private int score = 0;
    private JLabel scoreLebel = new JLabel(Integer.toString(score));
    private JLabel text = new JLabel("잡은 개체수 : ");

    public ScorePanel(){
        setBackground(Color.gray);
        text.setFont(new Font("Malgun Gothic",Font.BOLD,20));
        scoreLebel.setFont(new Font("Malgun Gothic",Font.BOLD,20));
        add(text);
        add(scoreLebel);
    }

    public void increase(){
        score += 1;
        scoreLebel.setText(Integer.toString(score));
    }
}

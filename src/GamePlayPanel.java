import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePlayPanel extends JPanel {
    private TextSource textSource = null;
    private ScorePanel scorePanel = null;
    private JLabel fallingLabel = new JLabel("Hello");
    private GameGroundPanel ground = new GameGroundPanel();
    private InputPanel input = new InputPanel();
    private FallingThread fallingThread = new FallingThread();


    public GamePlayPanel(ScorePanel scorePanel, TextSource textSource){
        this.scorePanel = scorePanel;
        this.textSource = textSource;
        setLayout(new BorderLayout());
        add(ground, BorderLayout.CENTER);
        add(input, BorderLayout.SOUTH);
    }
    public void startGeme(){
        fallingLabel.setVisible(true);
        newWord();
        fallingThread.start();
    }
    private void newWord(){
        fallingLabel.setText(textSource.get());
        fallingLabel.setLocation(200,50);
    }
    class GameGroundPanel extends JPanel{
        public GameGroundPanel(){
            setLayout(null);
            fallingLabel.setSize(50, 20);
            fallingLabel.setLocation(200, 50);
            add(fallingLabel);

            fallingLabel.setVisible(false);
        }

    }
    class FallingThread extends Thread{
        @Override
        public void run(){
            while(true){
                fallingLabel.setLocation(fallingLabel.getX(), fallingLabel.getY()+10);
                try {
                    sleep(400);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
    class InputPanel extends JPanel{
        private JTextField tf = new JTextField(10);
        public InputPanel(){
            this.setBackground(Color.LIGHT_GRAY);
            add(tf);
            tf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField t = (JTextField)e.getSource();
                    String text = t.getText();
                    if(text.length() == 0){return;}
                    if(text.equals(fallingLabel.getText())){
                        scorePanel.increase();
                        newWord();
                        t.setText(""); //현재 입력된 내용 지우기
                    }
                }
            });
        }
    }
}

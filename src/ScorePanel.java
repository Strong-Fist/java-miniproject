import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class ScorePanel extends JPanel {
    private int score = 0;
    private int time = 0;
    private boolean timerStop = false;
    private JLabel scoreLebel = new JLabel(Integer.toString(score));
    private JLabel text = new JLabel("잡은 개체수 : ");
    private JLabel timer = new JLabel("00");
    private JLabel timerLabel = new JLabel("초");
    private Font font =  new Font("Malgun Gothic",Font.BOLD,20);
    private TimerThead tt = new TimerThead();
    public ScorePanel(){
        setBackground(Color.gray);
        setLayout(new FlowLayout(FlowLayout.LEFT, 25, 50));
        text.setFont(font);
        scoreLebel.setFont(font);
        timer.setFont(font);
        timerLabel.setFont(font);
        add(text);
        add(scoreLebel);
        add(timer);
        add(timerLabel);
    }

    public void scoreIncrease(){
        score += 1;
        scoreLebel.setText(Integer.toString(score));
    }

    public void start(){
        tt.start();
    }

    public boolean getTimerStop(){
        return timerStop;
    }

    public void setTimer(int timer){
        time = timer;
        if(time < 10){
            this.timer.setText("0"+Integer.toString(time));
        }else{
            this.timer.setText(Integer.toString(time));
        }
    }

    public void timerDecrese(){
        time -= 1;
        if(time < 10){
            this.timer.setText("0"+Integer.toString(time));
        }else{
            this.timer.setText(Integer.toString(time));
        }
    }

    synchronized public void checkTime(){
        if(time <= 0 ){
            try {
                timerStop = true;
                this.wait();
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    class TimerThead extends Thread{
        @Override
        public void run(){
            while (true){
                checkTime();
                timerDecrese();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}

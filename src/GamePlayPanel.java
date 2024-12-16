import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
public class GamePlayPanel extends JPanel {
    private TextSource textSource = null;
    private ScorePanel scorePanel = null;
    private JLabel animalLabel = new JLabel("Hello");
    private InputPanel input = new InputPanel();
    private MainThread mainThread = new MainThread();
    private Vector<Animal> animals = new Vector<Animal>(6);
    private Vector<Mode> modes = new Vector<Mode>(6);
    private Vector<JLabel> labels = new Vector<JLabel>(6);
    private GameGroundPanel ground = new GameGroundPanel();

    public GamePlayPanel(ScorePanel scorePanel, TextSource textSource){
        this.scorePanel = scorePanel;
        this.textSource = textSource;
        setLayout(new BorderLayout());
        add(ground, BorderLayout.CENTER);
        add(input, BorderLayout.SOUTH);

    }
    public void startGeme(){
        mainThread.start();
        ground.init();
    }

    class GameGroundPanel extends JPanel{

        public void init(){
            setLayout(null);
            for(int i=0;i<animals.capacity();i++){
                animals.add(new Animal(6, "eagle"));
                modes.add(new Mode(10));
                labels.add(new JLabel());

                Animal animal = animals.get(i);
                Mode mode = modes.get(i);
                JLabel label = labels.get(i);

                animal.setSize(100,100);
                animal.setLocation((int)(Math.random()*450), (int)(Math.random()*400));

                mode.random();

                label.setText(textSource.get());
                label.setSize(100,50);
                label.setFont(new Font("Malgun Gothic",Font.BOLD,20));
                label.setLocation(animal.getX()+animal.getWidth()/2/2/2,animal.getY()+animal.getHeight()-20);

                add(animals.get(i));
                add(labels.get(i));
                animal.setVisible(true);
                label.setVisible(true);
            }

        }
        public int location(int point, String name){
            if(name.equals("x")){
                if(point > 450)
                    point = 450;
                else if(point < 0)
                    point = 0;

            }else if(name.equals("y")){
                if(point > 400)
                    point = 400;
                else if(point < 0)
                    point = 0;
            }
            return point;
        }

    }
    class MainThread extends Thread{
        @Override
        public void run(){
            while(true){
                for(int i=0;i<animals.size();i++){
                    animals.get(i).repaint();
                    modes.get(i).random();
                    animals.get(i).incread();
                    animals.get(i).setLocation(ground.location(animals.get(i).getX()+modes.get(i).getX(),"x"),ground.location(animals.get(i).getY()+modes.get(i).getY(),"y"));
                    labels.get(i).setLocation(animals.get(i).getX()+animals.get(i).getWidth()/2/2/2,animals.get(i).getY()+animals.get(i).getHeight()-20);
                }
                try {
                    sleep(100);
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
                    for(int i=0; i<labels.capacity();i++) {
                        if (text.equals(labels.get(i).getText())) {
                            scorePanel.increase();
                            animals.get(i).setLocation((int)(Math.random()*450), (int)(Math.random()*400));
                            labels.get(i).setText(textSource.get());
                            t.setText(""); //현재 입력된 내용 지우기
                        }
                    }
                }
            });
        }
    }
}

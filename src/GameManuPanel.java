import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameManuPanel extends JPanel{
    private GameButton start = new GameButton("시작");
    private GameButton explain = new GameButton("설명");
    public GameManuPanel(SplitPanel splitPanel, GamePlayPanel play){
        setBackground(Color.yellow);
        add(start);
        add(explain);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splitPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
                splitPanel.setDividerLocation(550);
                splitPanel.setLeftComponent(play);
                splitPanel.setEnabled(false);
                play.startGeme();
            }
        });

    }

    class GameButton extends JButton{
        public GameButton(String name){
            super(name);
        }
    }

}

import javax.swing.*;

public class SplitPanel extends JSplitPane {
    private ScorePanel scorePanel = new ScorePanel();
    private TextSource textSource = new TextSource();
    private EditPanel editPanel = new EditPanel(textSource);
    private GamePlayPanel play = new GamePlayPanel(scorePanel, textSource);
    private GameManuPanel manu = new GameManuPanel(this, play);

    public SplitPanel(){
        setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        setDividerLocation(550);
        setLeftComponent(manu);
        setEnabled(false);

        JSplitPane vPane = new JSplitPane();
        vPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        vPane.setDividerLocation(250);
        vPane.setTopComponent(scorePanel);
        vPane.setBottomComponent(editPanel);
        vPane.setEnabled(false);
        this.setRightComponent(vPane);
    }



}
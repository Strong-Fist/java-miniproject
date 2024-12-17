import javax.swing.*;
import java.awt.*;

public class Stone extends JLabel {
    private int x,y = 0;
    private int spead = 50;
    private  Image image = null;
    public boolean swich = false;
    public int index = 0;
    public Stone(){
        ImageIcon icon = new ImageIcon("image/stone.png");
        image = icon.getImage();
        setSize(50,50);
    }
    public boolean doom(int animelX, int animelY){
        if(x > animelX-20 && x < animelX+120 && y > animelY-20 && y < animelY+120)
            return true;
        else
            return false;
    }

    public int go(int animelPoint, String operator){
        if(operator.equals("x")) {
            if (x > animelPoint)
                x -= spead;
            else
                x += spead;
            return x;
        } else if (operator.equals("y")) {
            if (y > animelPoint)
                y -= spead;
            else
                y += spead;
            return y;
        }
        return 0;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0,0,this.getWidth(), this.getHeight(), null);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY(){
        return y;
    }

    public void setPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}

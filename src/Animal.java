import javax.swing.*;
import java.awt.*;
import java.util.Vector;


public class Animal extends JLabel{
    private Vector<Image> v = new Vector<Image>();
    private int index = 0;
    public Animal(int n, String name) {
        for (int i = 0; i < n; i++) {
            String path = "image/" + name + "/" + name + i + ".png";
            ImageIcon icon = new ImageIcon(path);
            Image image = icon.getImage();
            v.add(image);
        }
        setSize(100,100);
    }

    public void incread(){
        index++;
        if (index >= v.size()-1){index = 0;}
    }
    @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(v.get(index), 0,0,this.getWidth(),this.getWidth(),null);
        }

}

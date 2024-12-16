import java.util.Vector;

public class Mode {
    private final int stop = 0;
    private final int leftUp = 1;
    private final int leftDown = 2;
    private final int rightUp = 3;
    private final int rightDown = 4;
    private final int hight = 561;
    private final int width = 541;
    private int x,y,time,count, mode = 0;
    public Mode(int time){
        this.time = time;
        this.count = time;
    }
    public void random(){
            if (count >= time) {
                x = (int) (Math.random() * 10 + 10);
                y = (int) (Math.random() * 10 + 10);
                mode = (int) (Math.random() * 4);
                switch (mode) {
                    case stop:
                        stop();
                        break;
                    case leftUp:
                        leftUp();
                        break;
                    case leftDown:
                        leftDown();
                        break;
                    case rightUp:
                        rightUp();
                        break;
                    case rightDown:
                        rightDown();
                        break;
                }
                count = 0;
            }
            count++;
    }

    private void stop(){
        x = 0;
        y = 0;
    }

    private void leftUp(){
        x = -x;
        y = -y;
    }

    private void leftDown(){
        x = -x;
        y = +y;
    }

    private void rightUp(){
        x = +x;
        y = -y;
    }

    private void rightDown(){
        x = +x;
        y = +y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}

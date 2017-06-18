import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Hero {

    public static final int MAX_V = 100;
    public static final int MAX_TOP = 150;
    public static final int MAX_BOTTOM = 400;

    Image img_afk = new ImageIcon("src\\main\\resources\\Hero.png").getImage();
    Image img_up = new ImageIcon("src\\main\\resources\\Up.png").getImage();
    Image img_down = new ImageIcon("src\\main\\resources\\Down.png").getImage();

    Image img = img_afk;



    public Rectangle getRect(){
        return new Rectangle(x, y, 199, 99);
    }

    int v = 0;
    int dv = 0;
    int s = 0;

    int x = 30;
    int y = 100;
    int dy = 0;

    int layer1 = 0;
    int layer2 = 1200;

    public void move() {
        s += v;
        v += dv;
        if (v <= 0) v = 0;
        if (v >= MAX_V) v = MAX_V;
        y -= dy;
        if (y <= MAX_TOP) y = MAX_TOP;
        if (y >= MAX_BOTTOM) y = MAX_BOTTOM;
        if (layer2 - v <= 0) {
            layer1 = 0;
            layer2 = 1200;
        } else {
            layer1 -= v;
            layer2 -= v;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            dv = 2;
        }
        if (key == KeyEvent.VK_LEFT) {
            dv = -2;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 8;
            img = img_up;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = -8;
            img = img_down;
        }

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
            dv = 0;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
            img = img_afk;
        }
    }
}

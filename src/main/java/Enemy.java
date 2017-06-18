import java.awt.*;
import javax.swing.*;

public class Enemy {

    int x;
    int y;
    int v;
    Image img = new ImageIcon("src\\main\\resources\\Enemy.png").getImage();
    Road road;

    public Rectangle getRect(){
        return new Rectangle(x, y, 158, 68);
    }

    public Enemy(int x, int y, int v, Road road) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }

    public void move() {
        x = x - road.p.v + v;
    }


}

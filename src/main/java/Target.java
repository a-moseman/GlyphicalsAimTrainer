import java.awt.*;

public class Target {
    public final int X;
    public final int Y;
    public final int DIAMETER;

    public Target(int x, int y, int radius) {
        this.X = x;
        this.Y = y;
        this.DIAMETER = radius;
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(X - DIAMETER / 2, Y - DIAMETER / 2, DIAMETER, DIAMETER);
    }
}

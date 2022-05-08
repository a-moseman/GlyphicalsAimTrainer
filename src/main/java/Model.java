import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Model {
    private final int WIDTH;
    private final int HEIGHT;
    private Random random;
    private ArrayList<Target> targets;
    private Stats stats;

    public Model(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        random = new Random();
        targets = new ArrayList<>();
        this.stats = new Stats();
        spawnTarget(500, 500, 100);
    }

    private void spawnTarget(int x, int y, int r) {
        targets.add(new Target(x, y, r));
    }

    private void spawnTarget() {
        int x = random.nextInt(WIDTH - 100) + 50;
        int y = random.nextInt(HEIGHT - 100) + 50;
        targets.add(new Target(x, y, 25));
    }

    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private Target findHit(int x, int y) {
        for (Target target : targets) {
            double d = distance(x, y, target.X, target.Y);
            if (d <= target.DIAMETER / 2) {
                return target;
            }
        }
        return null;
    }

    public void click(int x, int y) {
        Target hit = findHit(x, y);
        if (hit != null) {
            stats.hit();
            targets.remove(hit);
            spawnTarget();
        }
        else {
            stats.miss();
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        for (Target target : targets) {
            target.render(g);
        }
        stats.render(g);
    }
}

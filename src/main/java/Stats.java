import java.awt.*;

public class Stats {
    private int hits;
    private int misses;
    private double accuracy;
    private double speed;

    private long lastHitTime;
    private long totalHitTime;

    public Stats() {

    }

    private void calculateAccuracy() {
        accuracy = (double) hits / (hits + misses);
    }

    private void calculateSpeed() {
        long hitTime = System.nanoTime();
        if (lastHitTime == 0) {
            lastHitTime = hitTime;
            return;
        }
        long tth = hitTime - lastHitTime;
        lastHitTime = hitTime;
        totalHitTime += tth / 1_000_000; // convert to milli
        speed = (double) totalHitTime / hits;

    }

    public void hit() {
        calculateSpeed();
        hits++;
        calculateAccuracy();
    }

    public void miss() {
        misses++;
        calculateAccuracy();
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Accuracy: " + accuracy, 1000, 10);
        g.drawString("Speed: " + speed, 1000, 20);
        g.drawString("Score: " + (speed * accuracy * hits), 1000, 30);
    }
}

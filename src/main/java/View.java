import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private Model model;

    public View(Model model) {
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.render(g);
    }
}

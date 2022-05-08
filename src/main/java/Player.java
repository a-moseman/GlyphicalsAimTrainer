import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Player implements MouseListener {
    private Model model;
    private View view;

    public Player(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        model.click(e.getX(), e.getY());
        view.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

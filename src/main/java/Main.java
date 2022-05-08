import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int WIDTH = 1000;
        int HEIGHT = 1000;

        Model model = new Model(WIDTH, HEIGHT);
        View view = new View(model);
        Player player = new Player(model, view);
        view.addMouseListener(player);
        JFrame jframe = new JFrame();
        jframe.add(view);
        jframe.setSize(WIDTH + 200, HEIGHT);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}

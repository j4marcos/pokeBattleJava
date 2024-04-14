import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class Game extends JFrame implements Runnable {
    private JPanel painelAtual;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private Player player;
    private Enemy enemy;

    public void editar() {

        setTitle("pokeBattle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 675);
        setResizable(false);
        setLocationRelativeTo(null);

        player = new Player();
        enemy = new Enemy();

        setVisible(true);

        Intro intro = new Intro(this);
        mudarTela(intro);
    }

    public void run() {
        editar();
    }

    public void mudarTela(JPanel novoPanel) {
        if (painelAtual != null) {
            remove(painelAtual);
        }
        painelAtual = novoPanel;
        add(painelAtual);
        validate();
        repaint();
    }

}

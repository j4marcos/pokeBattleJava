import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JFrame implements Runnable {
    private JPanel painelAtual;

    public void editar() {

        setTitle("pokeBattle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(976, 679);
        setResizable(false);
        setLocationRelativeTo(null);

        new Player();
        new Enemy();

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

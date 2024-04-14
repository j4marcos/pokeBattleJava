import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JFrame implements Runnable {
    private JPanel painelAtual;
    private Player player;
    private Enemy enemy;

    public void editar() {

        setTitle("pokeBattle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(976, 679);
        setResizable(false);
        setLocationRelativeTo(null);

        player = new Player();
        enemy = new Enemy();

        setVisible(true);

        Intro intro = new Intro(this);
        intro.setName("Intro");
        mudarTela(intro);
    }

    public void run() {
        editar();
    }

    public void mudarTela(JPanel novoPanel) {
        String nomePainelAtual = (painelAtual != null) ? painelAtual.getName() : "Inicio";
        String nomeNovoPainel = novoPanel.getName();
    
        if (painelAtual != null) {
            remove(painelAtual);
        }
        painelAtual = novoPanel;
        add(painelAtual);
        validate();
        repaint();
    
        System.out.println(nomePainelAtual + " -> " + nomeNovoPainel);
    }
}

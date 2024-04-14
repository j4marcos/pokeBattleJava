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
        setSize(975, 700);
        setResizable(false);
        setLocationRelativeTo(null);

        player = new Player();
        enemy = new Enemy();

        // // Criação do CardLayout e JPanel para armazenar os "cartões"
        // cardLayout = new CardLayout();
        // cardPanel = new JPanel(cardLayout);

        // // Criando e adicionando os "cartões"
        // JPanel homePanel = new JPanel();
        // homePanel.add(new JLabel("Tela Inicial: home"));
        // JButton buttonHome = new JButton("Iniciar Batalha");
        // buttonHome.addActionListener(e -> mudarTela("battle"));
        // homePanel.add(buttonHome);

        // JPanel battlePanel = new JPanel();
        // battlePanel.add(new Battle());

        // JPanel startGamePanel = new JPanel();
        // startGamePanel.add(new StartGame());

        // cardPanel.add(startGamePanel, "startGame");
        // cardPanel.add(battlePanel, "battle");
        // cardPanel.add(homePanel, "home");

        // getContentPane().add(cardPanel);
        setVisible(true);

        Intro intro = new Intro(this);
        mudarTela(intro);
    }

    public void run() {
        // TelasRef.game = this;
        editar();
    }

    // public void mudarTela(String nomeTela) {

    //     System.out.println("Mudando para a tela " + nomeTela);
    //     cardLayout.show(cardPanel, nomeTela);
    // }

    // nova mudança de paineis 
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

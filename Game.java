import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class Game extends JFrame implements Runnable {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public void editar() {

        setTitle("pokeBattle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(910, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        // Criação do CardLayout e JPanel para armazenar os "cartões"
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Criando e adicionando os "cartões"
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Tela Inicial: home"));

        JPanel battlePanel = new JPanel();
        battlePanel.add(new Battle());

        JPanel introPanel = new JPanel();
        introPanel.add(new Intro());

        cardPanel.add(introPanel, "intro");
        cardPanel.add(battlePanel, "battle");
        cardPanel.add(homePanel, "home");

        getContentPane().add(cardPanel);
        setVisible(true);
    }

    public void run() {
        TelasRef.game = this;
        editar();
    }

    public void mudarTela(String nomeTela) {

        System.out.println("Mudando para a tela " + nomeTela);
        cardLayout.show(cardPanel, nomeTela);
    }

}

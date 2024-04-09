import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class StartGame extends JPanel {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public StartGame() {
        TelasRef.startGame = this;

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Criando e adicionando os "cartões"
        JPanel introPanel = new JPanel();
        introPanel.add(new Intro());

        JPanel infoPanel = new JPanel();
        infoPanel.add(new Info());
        

        JPanel tutorialPanel = new JPanel();
        tutorialPanel.add(new JLabel("tutorial"));
        JButton buttonTutorial = new JButton("proximo");
        buttonTutorial.addActionListener(e -> mudarTela("criarPersonagem"));
        tutorialPanel.add(buttonTutorial);

        JPanel criarPersonagem = new JPanel();
        criarPersonagem.add(new JLabel("criar personagem"));
        JButton buttonCriarPersonagem = new JButton("proximo");
        buttonCriarPersonagem.addActionListener(e -> TelasRef.game.mudarTela("home"));
        criarPersonagem.add(buttonCriarPersonagem);

        cardPanel.add(introPanel, "intro");
        cardPanel.add(infoPanel, "info");
        cardPanel.add(tutorialPanel, "tutorial");
        cardPanel.add(criarPersonagem, "criarPersonagem");

        add(cardPanel);
        setVisible(true);
    }

    public void mudarTela(String nomeTela) {
        System.out.println("Mudando para a tela " + nomeTela);
        cardLayout.show(cardPanel, nomeTela);
    }

}
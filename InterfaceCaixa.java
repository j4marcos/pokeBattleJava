import javax.swing.*;
import java.awt.*;

public class InterfaceCaixa extends JPanel {
    private CaixaDialogo caixaDialogo = new CaixaDialogo();
    private CardLayout maincardLayout = new CardLayout(); 
    private JPanel mainCardPanel = new JPanel(maincardLayout);
    private JPanel battleLayoutPanel = new JPanel(new GridLayout(1, 2)); 
    private CardLayout leftcardLayout = new CardLayout();
    private JPanel leftComponent = new JPanel(leftcardLayout);
    private JLabel msgLabel = new JLabel();

    public InterfaceCaixa(Game frame) {
        Player.setInterfaceCaixa(this);

        mainCardPanel.add(battleLayoutPanel, "BattleLayoutPanel");
        mainCardPanel.add(caixaDialogo, "caixaDialogo");

        leftComponent.add(caixaDialogo, "caixaDeTexto");
        leftComponent.add(new Poderes(this), "poderes");

        Options options = new Options(frame, this);
        // Não entendi qual sentido de ter esse rightComponent
        // sendo que o options é um componete só   
        // rightComponent.add(options);

        // Adicionando os componentes ao painel principal
        battleLayoutPanel.add(leftComponent);
        battleLayoutPanel.add(options);

        // Defina um layout para o JPanel principal
        setLayout(new BorderLayout());
        add(mainCardPanel, BorderLayout.CENTER);

        caixaDialogo.dialogar(new String[] { "Batalha iniciada.", "Escolha sua ação." });
    }

    public void mudarInterfaceLayout(String nomeLayout) {
        System.out.println("Mudando interface para modo " + nomeLayout);
        maincardLayout.show(mainCardPanel, nomeLayout);
    }

    public void mudarInterfaceBattleLayout(String nomeLayout) {
        System.out.println("Mudando interface para modo " + nomeLayout);
        leftcardLayout.show(leftComponent, nomeLayout);
    }
    
    // mostra qual ataque foi usado por 3 segundos e depois volta para a tela de batalha
    public void mostrarAtaque() {
        msgLabel.setIcon(new ImageIcon("assets/battleElements/ataque background.png"));
        mainCardPanel.add(msgLabel, "MsgLabel");
        maincardLayout.show(mainCardPanel, "MsgLabel"); 
        revalidate();
    
        Timer timer = new Timer(3000, e -> {
            mainCardPanel.remove(msgLabel);
            msgLabel.removeAll(); 
            maincardLayout.show(mainCardPanel, "BattleLayoutPanel"); 
            revalidate();
            repaint();
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void mostrarDerrotaInimigo() {
        Font Fonte = DefinirFonte.fonte();
        
        JLabel linha0 = new JLabel(Enemy.inimigoAtual.getNome().toUpperCase() + " inimigo");
        JLabel linha1 = new JLabel("derrotado!");
        
        linha0.setFont(Fonte.deriveFont(Font.PLAIN,60f));
        linha1.setFont(Fonte.deriveFont(Font.PLAIN,60f));
        
        linha0.setBounds(50, 35, 800, 60);
        linha1.setBounds(50, 95, 800, 60);
        
        linha0.setForeground(Color.WHITE);
        linha1.setForeground(Color.WHITE);
        
        msgLabel.add(linha0);
        msgLabel.add(linha1);
        
        msgLabel.setIcon(new ImageIcon("assets/battleElements/ataque background.png"));
        mainCardPanel.add(msgLabel, "MsgLabel");
        maincardLayout.show(mainCardPanel, "MsgLabel"); 
        revalidate();
    
        Timer timer = new Timer(3000, e -> {
            mainCardPanel.remove(msgLabel);
            msgLabel.removeAll(); 
            maincardLayout.show(mainCardPanel, "BattleLayoutPanel"); 
            revalidate();
            repaint();
        });
        timer.setRepeats(false);
        timer.start();
    }

    public JLabel getMsgLabel() {
        return msgLabel;
    }
}

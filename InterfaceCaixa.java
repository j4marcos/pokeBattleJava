import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.io.Serializable;

public class InterfaceCaixa extends JPanel implements Serializable {
    private CardLayout maincardLayout = new CardLayout(); 
    private JPanel mainCardPanel = new JPanel(maincardLayout);
    private JPanel battleLayoutPanel = new JPanel(new GridLayout(1, 2)); 
    private CardLayout leftcardLayout = new CardLayout();
    private JPanel leftComponent = new JPanel(leftcardLayout);
    private JLabel msgLabel = new JLabel();
    private Font Fonte = DefinirFonte.fonte();

    public InterfaceCaixa(Game frame) {
        Player.setInterfaceCaixa(this);
        Enemy.setInterfaceCaixa(this);
        
        msgTexto("O  que  " + Player.pokemonSelecionado.getNome().toUpperCase(), "vai  fazer?");
        msgLabel.setIcon(new ImageIcon("assets/battleElements/ataque background.png")); 
        leftComponent.add(msgLabel, "MessageLabel"); 
    
        Enemy.setInterfaceCaixa(this);
        
        msgTexto("O  que  " + Player.pokemonSelecionado.getNome().toUpperCase(), "vai  fazer?");
        msgLabel.setIcon(new ImageIcon("assets/battleElements/ataque background.png")); 
        leftComponent.add(msgLabel, "MessageLabel"); 
    
        mainCardPanel.add(battleLayoutPanel, "BattleLayoutPanel");

        leftComponent.add(new Poderes(this), "poderes");
    
    
        Options options = new Options(frame, this);
    
    
        // Adicionando os componentes ao painel principal
        battleLayoutPanel.add(leftComponent);
        battleLayoutPanel.add(options);
    
    
        // Defina um layout para o JPanel principal
        setLayout(new BorderLayout());
        add(mainCardPanel, BorderLayout.CENTER);
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

    public void mostrarAtaqueInimigo() {
        String[] poderes = {"scratch", "quick attack", "tackle", "bite"};
        String nomeAtaque = poderes[(int) (Math.random() * poderes.length)];

        msgTexto(Enemy.inimigoAtual.getNome().toUpperCase() + " usou", nomeAtaque.toUpperCase() + "!");
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
        msgTexto(Enemy.inimigoAtual.getNome().toUpperCase() + "  inimigo", "foi  derrotado!");
        
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

    public void mostrarDerrotaPlayer() {
        msgTexto(Player.pokemonSelecionado.getNome().toUpperCase() + "  foi  derrotado", "!");
        
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

    public void limparMsgTexto() {
        msgLabel.removeAll();
        revalidate();
        repaint();
    }

    public void msgTexto(String texto0, String texto1) {
        JLabel linha0 = new JLabel(texto0);
        JLabel linha1 = new JLabel(texto1);
        msgTexto(Enemy.inimigoAtual.getNome().toUpperCase() + "  inimigo", "foi  derrotado!");
        
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

    public void mostrarDerrotaPlayer() {
        msgTexto(Player.pokemonSelecionado.getNome().toUpperCase() + "  foi  derrotado", "!");
        
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

    public void limparMsgTexto() {
        msgLabel.removeAll();
        revalidate();
        repaint();
    }

    public void msgTexto(String texto0, String texto1) {
        JLabel linha0 = new JLabel(texto0);
        JLabel linha1 = new JLabel(texto1);
        
        linha0.setFont(Fonte.deriveFont(Font.PLAIN,60f));
        linha1.setFont(Fonte.deriveFont(Font.PLAIN,60f));
        
        linha0.setBounds(50, 35, 800, 60);
        linha1.setBounds(50, 95, 800, 60);
        
        linha0.setForeground(Color.WHITE);
        linha1.setForeground(Color.WHITE);
        
        msgLabel.add(linha0);
        msgLabel.add(linha1);
    }
    
    public JLabel getMsgLabel() {
        return msgLabel;
    }
}
    }
    
    public JLabel getMsgLabel() {
        return msgLabel;
    }
}
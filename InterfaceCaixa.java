import javax.swing.*;
import java.awt.*;

public class InterfaceCaixa extends JPanel {
    CaixaDialogo caixaDialogo = new CaixaDialogo();
    CardLayout maincardLayout = new CardLayout(); 
    JPanel mainCardPanel = new JPanel(maincardLayout);
    JPanel battleLayoutPanel = new JPanel(new GridLayout(1, 2)); 
    CardLayout leftcardLayout = new CardLayout();
    JPanel leftComponent = new JPanel(leftcardLayout);
    JPanel rightComponent = new JPanel();
    JLabel ataqueLabel = new JLabel();

    public InterfaceCaixa(Game frame) {
        
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
    
    public void mostrarAtaque() {
    	ataqueLabel.setIcon(new ImageIcon("images/ataque background.png"));
    	add(ataqueLabel);
    	revalidate();

    	Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	remove(ataqueLabel);
            	revalidate();
                repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}      
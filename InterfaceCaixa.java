import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


public class InterfaceCaixa extends JPanel {
    private CaixaDialogo textDialogo = new CaixaDialogo();

    public InterfaceCaixa() {
        editar();
        textDialogo.dialogar(new String[] { "Batalha iniciada.", "Escolha sua ação." });
    }

    public void editar() {
        setBackground(Color.blue);
        setLayout(new GridBagLayout()); // Usar GridBagLayout para controlar o posicionamento dos componentes

        GridBagConstraints gbc = new GridBagConstraints();

        // Configuração do textDialogo para ocupar todo o espaço da esquerda
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(textDialogo, gbc);

        // Configuração de Options para ocupar todo o espaço da direita
        Options options = new Options();
        options.setBackground(Color.green);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(options, gbc);

        Poderes poderes = new Poderes();
        poderes.setBackground(Color.green);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(poderes, gbc);
        // Configuração do elemento acima para aparecer em cima do textDialogo

    }
}
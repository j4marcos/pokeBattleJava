import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CaixaDialogo extends JPanel {
    private JButton nextButton;
    private int indiceFalaAtual = 0;
    private String[] falas = new String[0];
    private JLabel textLabel;
    private Font Fonte;

    public CaixaDialogo() {
        Fonte = DefinirFonte.fonte();
        editar();
    }

    private void editar() {
        setLayout(new BorderLayout());

        // Define um painel para o botão "Próximo" com layout FlowLayout alinhado à
        // direita
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(buttonPanel, BorderLayout.EAST);
        // Tirei o acento por conta da fonte, não encontrei ainda com acentos em
        // portugues
        nextButton = new JButton("Proximo");
        nextButton.setFont(Fonte.deriveFont(Font.PLAIN, 20f));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirProximaFala();
            }
        });

        buttonPanel.add(nextButton); // Adiciona o botão ao painel
    }

    public void dialogar(String[] falas) {
        this.falas = falas;
        this.indiceFalaAtual = 0;
        criarInterfaceDeDialogo();
        exibirProximaFala();

    }

    private void criarInterfaceDeDialogo() {
        textLabel = new JLabel();
        add(textLabel, BorderLayout.CENTER);
        textLabel.setFont(Fonte.deriveFont(Font.PLAIN, 30f));
    }

    private void exibirProximaFala() {
        if (indiceFalaAtual < falas.length) {
            textLabel.setText(falas[indiceFalaAtual]);
            indiceFalaAtual++;
            System.out.println("Próxima fala.");

        }

        if (indiceFalaAtual == falas.length ) {
            nextButton.setEnabled(false);
            // Remove o textLabel da interface
            // remove(textLabel);
            revalidate  (); // Atualiza o layout
            repaint(); // Redesenha a interface
        }
    }
}

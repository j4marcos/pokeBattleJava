
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaixaDialogo extends JPanel {

    private JButton nextButton;
    private int indiceFalaAtual = 0;
    private String[] falas = new String[0];
    private JLabel textLabel;
    private Font Fonte;

    public CaixaDialogo() {
        definirFonte();
        editar();
    }

    private void definirFonte() {
        // Definir fonte. Problema, essa não é a fonte correta para esse botão
        // falta encontrar a fonte correta
        try {
            Fonte = Font.createFont(Font.TRUETYPE_FONT, new File("assents/font/pokemon_fire_red.ttf"));

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    public void editar() {
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

    public void criarInterfaceDeDialogo() {
        textLabel = new JLabel();
        add(textLabel, BorderLayout.CENTER);
        textLabel.setFont(Fonte.deriveFont(Font.PLAIN, 30f));
    }

    public void exibirProximaFala() {
        if (indiceFalaAtual < falas.length) {
            textLabel.setText(falas[indiceFalaAtual]);
            indiceFalaAtual++;
            System.out.println("Próxima fala.");

        }

        if (indiceFalaAtual == falas.length ) {
            nextButton.setEnabled(false);
            // Remove o textLabel da interface
            // remove(textLabel);
            revalidate(); // Atualiza o layout
            repaint(); // Redesenha a interface
        }
    }
}

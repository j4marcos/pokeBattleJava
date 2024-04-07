package interfaceCaixas; 

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceCaixaMain extends JPanel {

    private JButton nextButton;
    private int indiceFalaAtual;
    private String[] falas;
    private JLabel textLabel;

    public InterfaceCaixaMain() {
        editar();
    }

    public void editar() {
        setLayout(new BorderLayout());

        // Define um painel para o botão "Próximo" com layout FlowLayout alinhado à direita
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        add(buttonPanel, BorderLayout.EAST);

        nextButton = new JButton("Próximo");
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
    }

    public void exibirProximaFala() {
        if (indiceFalaAtual < falas.length) {
            textLabel.setText(falas[indiceFalaAtual]);
            indiceFalaAtual++;
            System.out.println("Próxima fala.");
        } else {
            nextButton.setEnabled(false);
            // Remove o textLabel da interface
            remove(textLabel);
            revalidate(); // Atualiza o layout
            repaint(); // Redesenha a interface
            System.out.println("Fim das falas.");
        }
    }
}

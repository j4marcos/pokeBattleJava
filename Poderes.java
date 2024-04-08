
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class Poderes extends JPanel {
    public Poderes() {
        editar();
    }

    public void editar() {
        setLayout(new GridLayout(2, 1));

        botao("chutao");
        botao("cabeçada");
        botao("peido venenoso");
        botao("mal olhado");
    }

    public void botao(String nome) {
        JButton botao = new JButton(nome);
        botao.addActionListener(e -> {
            System.out.println(nome + " disparado!!");

        });
        add(botao);
    }
}
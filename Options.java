import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Options extends JPanel {
    public Options() {
        editar();
    }

    public void editar() {
        setLayout(new GridLayout(2, 1));

        botao("FIGHT"); 
        botao("BAG"); 
        botao("POKEMON"); 
        botao("RUN"); 
    }

    public void botao(String nome) {
        JButton botao = new JButton(nome);
        botao.addActionListener(e -> {
            if (nome.equals("FIGHT")) {
                System.out.println(nome + " apertado!");
            } else if (nome.equals("BAG")) {
                System.out.println(nome + " apertado!");
            } else if (nome.equals("POKEMON")) {
                System.out.println(nome + " apertado!");
            } else if (nome.equals("RUN")) {
                System.out.println(nome + " apertado!");
            }
        });
        add(botao);
    }
}

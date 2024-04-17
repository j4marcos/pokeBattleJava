import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Poderes extends JPanel {

    Font Fonte = DefinirFonte.fonte();
    InterfaceCaixa painel;
    
    public Poderes(InterfaceCaixa painel) {
        this.painel = painel;
        editar();
    }


    public void editar() {
        setLayout(new GridLayout(2, 1));

        botao("chutao");
        botao("cabecada");
        botao("peido venenoso");
        botao("mal olhado");
    }

    public void botao(String nome) {
        JButton botao = new JButton(nome);
        botao.addActionListener(e -> {
            System.out.println(nome + " disparado!!");

            JLabel linha0 = new JLabel(Player.pokemonSelecionado.nome.toUpperCase() + " used");
            JLabel linha1 = new JLabel(nome.toUpperCase() + "!");

            linha0.setFont(Fonte.deriveFont(Font.PLAIN,60f));
            linha1.setFont(Fonte.deriveFont(Font.PLAIN,60f));

            linha0.setBounds(50, 35, 800, 60);
            linha1.setBounds(50, 95, 800, 60);

            linha0.setForeground(Color.WHITE);
            linha1.setForeground(Color.WHITE);
            
            painel.ataqueLabel.add(linha0);
            painel.ataqueLabel.add(linha1);

            painel.mostrarAtaque();

            Player.atacar();
        });
        add(botao);
    }
}
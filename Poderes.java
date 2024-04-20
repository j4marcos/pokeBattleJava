import javax.swing.*;
import java.awt.*;

public class Poderes extends JPanel {
    private Font Fonte = DefinirFonte.fonte();
    private InterfaceCaixa painel;
    
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

            JLabel linha0 = new JLabel(Player.pokemonSelecionado.getNome().toUpperCase() + " used");
            JLabel linha1 = new JLabel(nome.toUpperCase() + "!");

            linha0.setFont(Fonte.deriveFont(Font.PLAIN,60f));
            linha1.setFont(Fonte.deriveFont(Font.PLAIN,60f));

            linha0.setBounds(50, 35, 800, 60);
            linha1.setBounds(50, 95, 800, 60);

            linha0.setForeground(Color.WHITE);
            linha1.setForeground(Color.WHITE);
            
            painel.getMsgLabel().add(linha0);
            painel.getMsgLabel().add(linha1);

            painel.mostrarAtaque();

            Timer timer = new Timer(3000, f -> {
                Player.atacar();
            });
            timer.setRepeats(false);
            timer.start();
        });
        add(botao);
    }
}
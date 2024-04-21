import javax.swing.*;
import java.awt.*;

public class Poderes extends JPanel {
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
            
            painel.limparMsgTexto();
            painel.msgTexto(Player.pokemonSelecionado.getNome().toUpperCase() + " used", nome.toUpperCase() + "!");
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
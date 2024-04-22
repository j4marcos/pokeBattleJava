import javax.swing.*;
import java.awt.*;

public class Poderes extends JPanel {
    private InterfaceCaixa painel;
    private JLabel background = new JLabel();
    private Font Fonte = DefinirFonte.fonte();
    
    public Poderes(InterfaceCaixa painel) {
        this.painel = painel;
        editar();
    }

    public void editar() {
        setLayout(new BorderLayout());
        background.setIcon(new ImageIcon("assets/battleElements/fundo poderes.png"));
        background.setLayout(null);

        botao("chutao", 20, 40); 
        botao("cabecada", 230, 40);
        botao("mal  olhado", 20, 100);
        botao("peido  venenoso", 230, 100);

        add(background, BorderLayout.NORTH);
    }

    public void botao(String nome, int x, int y) {
        JButton botao = new JButton(nome.toUpperCase());
        botao.addActionListener(e -> {
            System.out.println(nome.toUpperCase() + " disparado!!");
            
            painel.limparMsgTexto();
            painel.msgTexto(Player.pokemonSelecionado.getNome().toUpperCase() + "  usou", nome.toUpperCase() + "!");
            painel.mostrarAtaque();

            Timer timer = new Timer(3000, f -> {
                Player.atacar();
            });
            timer.setRepeats(false);
            timer.start();
        });
        botao.setContentAreaFilled(false); 
        botao.setBorderPainted(false);
        botao.setFont(Fonte.deriveFont(Font.PLAIN, 40));

        botao.setBounds(x, y, botao.getPreferredSize().width, botao.getPreferredSize().height); // Definir posição e tamanho
    
        background.add(botao);
    }
}
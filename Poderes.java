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

        switch (Player.pokemonSelecionado.getNome()) {
            case "Bulbasaur":
                botao("Tackle", 20, 40); 
                botao("Vine Whip", 230, 40);
                botao("Razor Leaf", 20, 100);
                botao("Seed Bomb", 230, 100);
                break;
            case "Ivysaur":
                botao("Tackle", 20, 40); 
                botao("Vine Whip", 230, 40);
                botao("Razor Leaf", 20, 100);
                botao("Solar Beam", 230, 100);
                break;
            case "Venusaur":
                botao("Tackle", 20, 40); 
                botao("Vine Whip", 230, 40);
                botao("Razor Leaf", 20, 100);
                botao("Solar Beam", 230, 100);
                break;
            case "Squirtle":
                botao("Tackle", 20, 40); 
                botao("Water Gun", 230, 40);
                botao("Bite", 20, 100);
                botao("Hydro Pump", 230, 100);
                break;
            case "Wartortle":
                botao("Tackle", 20, 40); 
                botao("Water Gun", 230, 40);
                botao("Bite", 20, 100);
                botao("Hydro Cannon", 230, 100);
                break;
            case "Blastoise":
                botao("Tackle", 20, 40); 
                botao("Water Gun", 230, 40);
                botao("Bite", 20, 100);
                botao("Hydro Cannon", 230, 100);
                break;
            case "Charmander":
                botao("Scratch", 20, 40); 
                botao("Ember", 230, 40);
                botao("Flamethrower", 20, 100);
                botao("Fire Blast", 230, 100);
                break;
            case "Charmeleon":
                botao("Scratch", 20, 40); 
                botao("Ember", 230, 40);
                botao("Flamethrower", 20, 100);
                botao("Fire Blast", 230, 100);
                break;
            case "Charizard":
                botao("Scratch", 20, 40); 
                botao("Ember", 230, 40);
                botao("Flamethrower", 20, 100);
                botao("Fire Blast", 230, 100);
                break;
        }        

        add(background, BorderLayout.NORTH);
    }

    public void botao(String nome, int x, int y) {
        JButton botao = new JButton(nome.toUpperCase());
        botao.addActionListener(e -> {
            System.out.println(nome.toUpperCase() + " disparado!!");
            
            painel.limparMsgTexto();
            painel.msgTexto(Player.pokemonSelecionado.getNome().toUpperCase() + "  usou", nome.toUpperCase() + "!");
            painel.mostrarAtaque();

            Timer timer = new Timer(1000, f -> {
                Player.atacar();

                if (Enemy.inimigoAtual.getVida() > 0) {
                    painel.mostrarAtaqueInimigo();
                    Timer timer2 = new Timer(1000, g -> {
                        Enemy.atacar();
                    });
                    timer2.setRepeats(false);
                    timer2.start();
                }
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
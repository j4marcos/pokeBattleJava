
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class PokemonsBatle extends JPanel{
    protected InterfaceCaixa interface1;
    public static PokemonsBatle instance;
    JLabel label = new JLabel();
    // private JLabel aliado;
    // private JLabel inimigo;

    public PokemonsBatle(){
        instance = this;
        setBattleCardLayout();
    }

    public void setBattleCardLayout() {
        setLayout(new BorderLayout());
        label.setIcon(new ImageIcon("images/Battle Background.png"));

        interface1 = new InterfaceCaixa();

        Enemy.inimigoAtual.imagemLabel.setBounds(550, 20, 240, 240);
        Player.pokemonSelecionado.imagemLabel.setBounds(120, 180, 240, 240);
        
        // aliado = new JLabel();
        // aliado.setIcon(new ImageIcon("images/charizard costas.png"));
        // aliado.setBounds(120, 180, 240, 232);
        
        // inimigo = new JLabel();
        // inimigo.setIcon(new ImageIcon("images/charizard frente.png"));
        // inimigo.setBounds(550, 20, 240, 232);

        // label.add(inimigo);
        // label.add(aliado);

        label.add(Enemy.inimigoAtual.imagemLabel);
        label.add(Player.pokemonSelecionado.imagemLabel);

        add(label, BorderLayout.NORTH);
        add(interface1, BorderLayout.CENTER);
    }

    public void atualizarInimigo() {
        label.removeAll();
        Enemy.inimigoAtual.imagemLabel.setBounds(550, 20, 240, 240);
        Player.pokemonSelecionado.imagemLabel.setBounds(120, 180, 240, 240);
        label.add(Enemy.inimigoAtual.imagemLabel);
        label.add(Player.pokemonSelecionado.imagemLabel);
        revalidate();
        repaint();
    }
}
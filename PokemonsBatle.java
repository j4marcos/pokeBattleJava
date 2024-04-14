
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class PokemonsBatle extends JPanel{
    protected InterfaceCaixa interface1;
    public static PokemonsBatle instance;
    JLabel label = new JLabel();

    public PokemonsBatle(Game frame){
        instance = this;
        setBattleCardLayout(frame);
    }

    public void setBattleCardLayout(Game frame) {
        setLayout(new BorderLayout());
        label.setIcon(new ImageIcon("images/Battle Background.png"));

        interface1 = new InterfaceCaixa(frame);

        Enemy.inimigoAtual.imagemLabel.setBounds(580, 40, 256, 256);
        Player.pokemonSelecionado.imagemLabel.setBounds(120, 208, 256, 256);

        label.add(Enemy.inimigoAtual.imagemLabel);
        label.add(Player.pokemonSelecionado.imagemLabel);

        add(label, BorderLayout.NORTH);
        add(interface1, BorderLayout.CENTER);
    }

    public void atualizarInimigo() {
        label.removeAll();
        Enemy.inimigoAtual.imagemLabel.setBounds(580, 40, 256, 256);
        Player.pokemonSelecionado.imagemLabel.setBounds(120, 208, 256, 256);
        label.add(Enemy.inimigoAtual.imagemLabel);
        label.add(Player.pokemonSelecionado.imagemLabel);
        revalidate();
        repaint();
    }
}
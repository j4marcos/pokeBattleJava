import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class PokemonsBatle extends JPanel{
    protected InterfaceCaixa interface1;
    public static PokemonsBatle instance;
    Font Fonte = DefinirFonte.fonte();
    JLabel label = new JLabel();
    JLabel inimigoName = new JLabel();
    JLabel inimigoHP = new JLabel();
    JLabel playerName = new JLabel();
    JLabel playerHP = new JLabel();

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

        inimigoHP.setIcon(new ImageIcon("images/inimigo hp.png"));
        inimigoHP.setBounds(50, 30, 400, 116);

        inimigoName.setText(Enemy.inimigoAtual.nome);   
        inimigoName.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        inimigoName.setBounds(25, 13, 320, 40);

        inimigoHP.add(inimigoName);
        label.add(inimigoHP);

        playerHP.setIcon(new ImageIcon("images/player hp.png"));
        playerHP.setBounds(505, 295, 416, 148);

        playerName.setText(Player.pokemonSelecionado.nome);   
        playerName.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        playerName.setBounds(60, 13, 320, 40);

        playerHP.add(playerName);
        label.add(playerHP);

        label.add(Enemy.inimigoAtual.imagemLabel);
        label.add(Player.pokemonSelecionado.imagemLabel);

        add(label, BorderLayout.NORTH);
        add(interface1, BorderLayout.CENTER);
    }

    public void atualizarInimigo() {
        label.removeAll();
        
        Enemy.inimigoAtual.imagemLabel.setBounds(580, 40, 256, 256);
        inimigoName.setText(Enemy.inimigoAtual.nome);   
        inimigoName.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        inimigoName.setBounds(25, 13, 320, 40);
        inimigoHP.add(inimigoName);
        label.add(inimigoHP);
        
        Player.pokemonSelecionado.imagemLabel.setBounds(120, 208, 256, 256);
        playerName.setText(Player.pokemonSelecionado.nome);   
        playerName.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        playerName.setBounds(60, 13, 320, 40);
        playerHP.add(playerName);
        label.add(playerHP);

        label.add(Enemy.inimigoAtual.imagemLabel);
        label.add(Player.pokemonSelecionado.imagemLabel);

        revalidate();
        repaint();
    }
}
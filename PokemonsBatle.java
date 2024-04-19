import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class PokemonsBatle extends JPanel{
    protected InterfaceCaixa interface1;
    public static PokemonsBatle instance;
    Font Fonte = DefinirFonte.fonte();
    JLabel label = new JLabel();
    JLabel inimigoInfo = new JLabel();
    JLabel inimigoName = new JLabel();
    JLabel inimigoHP = new JLabel();
    JLabel playerInfo = new JLabel();
    JLabel playerName = new JLabel();
    JLabel playerHP = new JLabel();

    int playerHPValue = 192;
    int inimigoHPValue = 192;

    public PokemonsBatle(Game frame){
        instance = this;
        setBattleCardLayout(frame);
    }

    public void setBattleCardLayout(Game frame) {
        setLayout(new BorderLayout());
        label.setIcon(new ImageIcon("assets/backgroundImages/Battle Background.png"));

        interface1 = new InterfaceCaixa(frame);

        Enemy.inimigoAtual.imagemLabel.setBounds(580, 40, 256, 256);
        Player.pokemonSelecionado.imagemLabel.setBounds(120, Player.getAlturaPokemon(), 256, 256);

        inimigoInfo.setIcon(new ImageIcon("assets/battleElements/inimigo hp.png"));
        inimigoInfo.setBounds(50, 30, 400, 116);

        inimigoName.setText(Enemy.inimigoAtual.nome);   
        inimigoName.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        inimigoName.setBounds(25, 10, 320, 45);

        inimigoHP.setBackground(new Color(34, 139, 34));
        inimigoHP.setOpaque(true);
        inimigoHP.setBounds(156, 68, inimigoHPValue, 12); // o tamanho max do ahp é 192   

        inimigoInfo.add(inimigoHP);
        inimigoInfo.add(inimigoName);
        label.add(inimigoInfo);

        playerInfo.setIcon(new ImageIcon("assets/battleElements/player hp.png"));
        playerInfo.setBounds(505, 295, 416, 148);

        playerName.setText(Player.pokemonSelecionado.nome);   
        playerName.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        playerName.setBounds(60, 10, 320, 45);

        playerHP.setBackground(new Color(34, 139, 34));
        playerHP.setOpaque(true);
        playerHP.setBounds(192, 68, playerHPValue, 12); // o tamanho max do hp é 192 

        playerInfo.add(playerHP);
        playerInfo.add(playerName);
        label.add(playerInfo);

        label.add(Enemy.inimigoAtual.imagemLabel);
        label.add(Player.pokemonSelecionado.imagemLabel);

        add(label, BorderLayout.NORTH);
        add(interface1, BorderLayout.CENTER);
    }

    public void atualizarVidaInimigo() {
        double porcentagemVida = (double) Enemy.inimigoAtual.vida / Enemy.inimigoAtual.getVidaMaxima();

        if (porcentagemVida <= 0.25) {
            inimigoHP.setBackground(new Color(220, 20, 60)); // Vermelho
        } else if (porcentagemVida <= 0.50) {
            inimigoHP.setBackground(new Color(255, 223, 0)); // Amarelo
        } else {
            inimigoHP.setBackground(new Color(34, 139, 34)); // Verde
        }

        inimigoHPValue = Enemy.inimigoAtual.vida * 192 / Enemy.inimigoAtual.getVidaMaxima();
        inimigoHP.setBounds(156, 68, inimigoHPValue, 12);
        revalidate();
        repaint();
    }

    public void atualizarInimigo() {
        label.removeAll();
        
        Enemy.inimigoAtual.imagemLabel.setBounds(580, 40, 256, 256);
        inimigoName.setText(Enemy.inimigoAtual.nome);   
        inimigoName.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        inimigoName.setBounds(25, 13, 320, 40);
        inimigoInfo.add(inimigoName);
        label.add(inimigoInfo);
        
        Player.pokemonSelecionado.imagemLabel.setBounds(120, Player.getAlturaPokemon(), 256, 256);
        playerName.setText(Player.pokemonSelecionado.nome);   
        playerName.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        playerName.setBounds(60, 13, 320, 40);
        playerInfo.add(playerName);
        label.add(playerInfo);

        label.add(Enemy.inimigoAtual.imagemLabel);
        label.add(Player.pokemonSelecionado.imagemLabel);

        revalidate();
        repaint();
    }
}
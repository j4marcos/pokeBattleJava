import javax.swing.*;
import java.awt.*;

public class PokemonsBatle extends JPanel {
    private InterfaceCaixa interface1;
    public static PokemonsBatle instance;
    private Font Fonte = DefinirFonte.fonte();
    private JLabel label = new JLabel();
    private JLabel inimigoInfo = new JLabel();
    private JLabel inimigoName = new JLabel();
    private JLabel inimigoHP = new JLabel();
    private JLabel playerInfo = new JLabel();
    private JLabel playerName = new JLabel();
    private JLabel playerHP = new JLabel();

    public static int playerHPValue = 192;
    public static int inimigoHPValue = 192;

    public PokemonsBatle(Game frame){
        instance = this;
        setBattleCardLayout(frame);
    }

    public void setBattleCardLayout(Game frame) {
        setLayout(new BorderLayout());
        label.setIcon(new ImageIcon("assets/backgroundImages/Battle Background.png"));

        interface1 = new InterfaceCaixa(frame);

        Enemy.inimigoAtual.getImagemLabel().setBounds(580, 40, 256, 256);
        Player.pokemonSelecionado.getImagemLabel().setBounds(120, Player.getAlturaPokemon(), 256, 256);

        inimigoInfo.setIcon(new ImageIcon("assets/battleElements/inimigo hp.png"));
        inimigoInfo.setBounds(50, 30, 400, 116);

        inimigoName.setText(Enemy.inimigoAtual.getNome().toUpperCase());   
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

        playerName.setText(Player.pokemonSelecionado.getNome().toUpperCase());   
        playerName.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        playerName.setBounds(60, 10, 320, 45);

        playerHP.setBackground(new Color(34, 139, 34));
        playerHP.setOpaque(true);
        playerHP.setBounds(192, 68, playerHPValue, 12); // o tamanho max do hp é 192 

        playerInfo.add(playerHP);

        playerInfo.add(playerName);
        
        label.add(playerInfo);

        label.add(Enemy.inimigoAtual.getImagemLabel());
        label.add(Player.pokemonSelecionado.getImagemLabel());

        add(label, BorderLayout.NORTH);
        add(interface1, BorderLayout.CENTER);
    }

    public void atualizarVidaPlayer() {
        double porcentagemVida = (double) Player.pokemonSelecionado.getVida() / Player.pokemonSelecionado.getVidaMaxima();

        if (porcentagemVida <= 0.25) {
            playerHP.setBackground(new Color(220, 20, 60)); // Vermelho
        } else if (porcentagemVida <= 0.50) {
            playerHP.setBackground(new Color(255, 223, 0)); // Amarelo
        } else {
            playerHP.setBackground(new Color(34, 139, 34)); // Verde
        }

        playerHPValue = (int) (porcentagemVida * 192);
        playerHP.setBounds(192, 68, playerHPValue, 12);
        revalidate();
        repaint();
    }

    public void atualizarVidaInimigo() {
        double porcentagemVida = (double) Enemy.inimigoAtual.getVida() / Enemy.inimigoAtual.getVidaMaxima();

        if (porcentagemVida <= 0.25) {
            inimigoHP.setBackground(new Color(220, 20, 60)); // Vermelho
        } else if (porcentagemVida <= 0.50) {
            inimigoHP.setBackground(new Color(255, 223, 0)); // Amarelo
        } else {
            inimigoHP.setBackground(new Color(34, 139, 34)); // Verde
        }

        inimigoHPValue = (int) (porcentagemVida * 192);
        inimigoHP.setBounds(156, 68, inimigoHPValue, 12);
        revalidate();
        repaint();
    }

    public void atualizarInimigo() {
        label.removeAll();
        
        Enemy.inimigoAtual.getImagemLabel().setBounds(580, 40, 256, 256);
        inimigoName.setText(Enemy.inimigoAtual.getNome().toUpperCase());   
        inimigoName.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        inimigoName.setBounds(25, 13, 320, 40);
        inimigoInfo.add(inimigoName);
        inimigoHPValue = 192;
        label.add(inimigoInfo);
        
        Player.pokemonSelecionado.getImagemLabel().setBounds(120, Player.getAlturaPokemon(), 256, 256);
        playerName.setText(Player.pokemonSelecionado.getNome().toUpperCase());   
        playerName.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        playerName.setBounds(60, 13, 320, 40);
        playerInfo.add(playerName);
        label.add(playerInfo);

        label.add(Enemy.inimigoAtual.getImagemLabel());
        label.add(Player.pokemonSelecionado.getImagemLabel());

        revalidate();
        repaint();
    }
}
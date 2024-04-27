import java.awt.*;
import javax.swing.*;

public class EvolucaoPage extends JPanel {
    Game frame;
    Pokemon pokemon;
    JLabel Personagem;
    JLabel caixaFala;

    public EvolucaoPage(Game frameGame, Pokemon pokemon) {
        editar();
        revalidate();
        repaint();
        this.frame = frameGame;
        this.pokemon = pokemon;
        System.out.println("Mudando para tela de evolução...");
    }

    private void editar() {
        setLayout(new BorderLayout());
        Font Fonte = DefinirFonte.fonte();

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assets/backgroundImages/focusPage.png"));
        background.setBounds(0, 0, 960, 640);

        Personagem = new JLabel();
        Personagem.setFocusable(true);

        ImageIcon icon = new ImageIcon("assets/pokemons/" + pokemon.getNomeAnterior().toLowerCase() + "/" + "front" + ".png");
        Image image = icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH);
        Personagem.setIcon(new ImageIcon(image));
        Personagem.setBounds(350, 0, 960, 640);

        JLabel TextArea = new JLabel();
        TextArea.setFocusable(true);
        TextArea.setIcon(new ImageIcon("assets/backgroundImages/textarea.png"));
        TextArea.setBounds(25, 200, 960, 640);

        JLabel caixaFalaBtn = new JLabel("O seu pokemon, esta evoluindo...");
        caixaFala = caixaFalaBtn;
        caixaFalaBtn.setFont(Fonte.deriveFont(Font.PLAIN, 50f));
        JLabel DialogoBox = caixaFalaBtn;
        DialogoBox.setBounds(60, 450, 850, 140);

        background.add(DialogoBox);
        background.add(TextArea);
        background.add(Personagem);

        add(background, BorderLayout.NORTH);

        Timer timerEvolucao  = new Timer(3000, e -> atualizarPokemonTransformacao());
        timerEvolucao.setRepeats(false);
        timerEvolucao.start();
    }

    private void atualizarPokemonTransformacao() {

        ImageIcon icon = new ImageIcon("assets/pokemons/" + pokemon.getNome().toLowerCase() + "/" + "front" + ".png");
        Image image = icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH);
        Personagem.setIcon(new ImageIcon(image));
        caixaFala.setText("O seu pokemon evoluiu para " + pokemon.getNome());

        revalidate();
        repaint();  

        Timer timerMudanca = new Timer(3000, e -> frame.mudarTela(new PokemonsBatle(frame)));
        timerMudanca.setRepeats(false);
        timerMudanca.start();
    }
}

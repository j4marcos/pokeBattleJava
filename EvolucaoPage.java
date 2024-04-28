import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

public class EvolucaoPage extends JPanel {
    Game frame;
    Pokemon pokemon;
    JLabel Personagem;
    JLabel caixaFala;

    public EvolucaoPage(Game frameGame, Pokemon pokemon) {
        this.frame = frameGame;
        this.pokemon = pokemon;
        editar();

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

        ImageIcon icon = new ImageIcon(
                "assets/pokemons/" + pokemon.getNomeAnterior().toLowerCase() + "/" + "front" + ".png");
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

        // ...

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                atualizarPokemonTransformacao();
            }

        }, 3000);

    }

    private void atualizarPokemonTransformacao() {

        ImageIcon icon = new ImageIcon("assets/pokemons/" + pokemon.getNome().toLowerCase() + "/" + "front" + ".png");
        Image image = icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH);
        Personagem.setIcon(new ImageIcon(image));
        caixaFala.setText("O seu pokemon evoluiu para " + pokemon.getNome());

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                frame.mudarTela(new PokemonsBatle(frame));
            }
        }, 3000);
    }
}
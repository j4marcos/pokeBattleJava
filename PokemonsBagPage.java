import java.awt.*;
import javax.swing.*;

public class PokemonsBagPage extends JPanel{
    private JLabel background = new JLabel();
    private Font Fonte = DefinirFonte.fonte();

    public PokemonsBagPage(Game frame) {
        editar(frame);
    }

    private void editar(Game frame) {
        setLayout(new BorderLayout());
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assets/backgroundImages/pokeBagPage.png"));
       
        background.revalidate();

        JButton backButton = new JButton(new ImageIcon("assets/backgroundImages/cancelButton0.png"));
        backButton.addActionListener(e -> {
            PokemonsBatle pokemonsBatle = new PokemonsBatle(frame);
            frame.mudarTela(pokemonsBatle);
            System.out.println("Voltar apertado!");
        });
        backButton.setBounds(725,525, 230, 100);
        backButton.setBackground(new Color(0, 0, 0, 0));
        background.add(backButton);

        JButton barButton = new JButton(new ImageIcon("assets/backgroundImages/pokeBar0.png"));
        barButton.addActionListener(e -> {
            PokemonsBatle pokemonsBatle = new PokemonsBatle(frame);
            frame.mudarTela(pokemonsBatle);
            System.out.println("Próximo apertado!");
        });
        barButton.setBounds(350, 30, 600, 100);
        barButton.setBackground(new Color(0, 0, 0, 0));
        background.add(barButton);

        JLabel pokeCardLabel = new JLabel(new ImageIcon("assets/backgroundImages/pokeCard0.png"));
        pokeCardLabel.setBounds(-30, -15, 400, 400);
        background.add(pokeCardLabel);

        adicionarPokemonInicial(background);

        
        
        
        add(background, BorderLayout.NORTH);
    }

    private void adicionarPokemonInicial(JLabel background) {
        // JLabel pokemonLabel = Player.
        // pokemonLabel.setBounds(50, 50, 200, 200);
        // background.add(pokemonLabel);

        // JLabel pokemonLabel2 = new JLabel(new ImageIcon("assets/pokemons/squirtle.png"));
        // pokemonLabel2.setBounds(50, 250, 200, 200);
        // background.add(pokemonLabel2);
        
    }

   
}

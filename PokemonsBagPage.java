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
        adicionarPokemonInicial(background);

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
        pokeCardLabel.setBounds(-20, -15, 400, 400);
        background.add(pokeCardLabel);

        

        
        
        
        add(background, BorderLayout.NORTH);
    }

    private void adicionarPokemonInicial(JLabel background) {
        Pokemon pokemonSelecionado = new Pokemon(Player.pokemonNome ,  "front");
        JLabel pokemon = pokemonSelecionado.getImagemLabel();
        pokemon.setFocusable(isFocusable());
        pokemon.setBounds(550, 40, 600, 80);

        background.add(pokemon);

        Pokemon pokemonSelecionado2 = new Pokemon(Player.pokemonNome ,  "front");
        JLabel pokemon2 = pokemonSelecionado2.getImagemLabel();
        pokemon2.setBounds(50, -15, 400, 400);

        background.add(pokemon2);
        
    }

   
}

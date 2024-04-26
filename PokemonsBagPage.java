import java.awt.*;
import javax.swing.*;

public class PokemonsBagPage extends JPanel{
    private JLabel background = new JLabel();
    private Font Fonte = DefinirFonte.fonte();
    private JLabel playerHP = new JLabel();
    public static PokemonsBagPage instance;


    public PokemonsBagPage(Game frame) {
        instance = this;
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
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        background.add(backButton);

        JButton saveButton = new JButton("Salvar Progresso" );
        saveButton.setFont(Fonte.deriveFont(Font.PLAIN, 40));
        saveButton.addActionListener(e -> {
            Player.salvarDados();
            saveButton.setText("Salvo com sucesso!");
            System.out.println("salvo o progresso!");
        });
        saveButton.setBounds(025,525, 700, 100);
        saveButton.setOpaque(false);
        saveButton.setContentAreaFilled(false);
        saveButton.setBorderPainted(false);
        background.add(saveButton);

        playerHP.setBackground(new Color(34, 139, 34));
        playerHP.setOpaque(true);
        playerHP.setBounds(132, 231, PokemonsBatle.playerHPValue, 12);
        background.add(playerHP);



        // JButton barButton = new JButton(new ImageIcon("assets/backgroundImages/pokeBar0.png"));
        // barButton.addActionListener(e -> {
        //     PokemonsBatle pokemonsBatle = new PokemonsBatle(frame);
        //     pokemonsBatle.atualizarVidaPlayer();
        //     frame.mudarTela(pokemonsBatle);
        //     System.out.println("Próximo apertado!");
        // });
        // barButton.setBounds(350, 30, 600, 100);
        // barButton.setBackground(new Color(0, 0, 0, 0));
        // background.add(barButton);

        JLabel pokeCardLabel = new JLabel(new ImageIcon("assets/backgroundImages/pokeCard0.png"));
        pokeCardLabel.setBounds(-20, -15, 400, 400);
        background.add(pokeCardLabel);
        
        add(background, BorderLayout.NORTH);
    }

    private void adicionarPokemonInicial(JLabel background) {
        // Pokemon pokemonSelecionado = new Pokemon(Player.pokemonNome ,  "front");
        // JLabel pokemon = pokemonSelecionado.getImagemLabel();
        // pokemon.setFocusable(isFocusable());
        // pokemon.setBounds(550, 40, 600, 80);

        // background.add(pokemon);

        // Pokemon pokemonSelecionado2 = new Pokemon(Player.pokemonNome ,  "front"); original
        // Pokemon pokemonSelecionado2 = new Pokemon("Blastoise" ,  "front");


        JLabel pokemon = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("assets/pokemons/" + Player.pokemonNome.toLowerCase() + "/front.png"));
        Image image = icon.getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
        pokemon.setIcon(new ImageIcon(image));
        pokemon.setBounds(215, -35, 400, 400);

        JLabel pokemonNome = new JLabel(Player.pokemonNome);
        pokemonNome.setFont(Fonte.deriveFont(Font.PLAIN, 40));
        pokemonNome.setForeground(new Color(0, 0, 0));
        pokemonNome.setBounds(75, 65, 400, 400);

        JLabel pokemonLv = new JLabel();
        pokemonLv.setText(Integer.toString(PokemonsBatle.inimigoLv));
        pokemonLv.setFont(Fonte.deriveFont(Font.PLAIN, 50));
        pokemonLv.setForeground(new Color(255, 255, 255));
        pokemonLv.setBounds(204, 0, 400, 400);
        
        background.add(pokemonLv);
        background.add(pokemonNome);
        background.add(pokemon);
    }
}

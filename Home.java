import java.awt.*;
import java.io.File;

import javax.swing.*;

public class Home extends JPanel {
    private Font Fonte;
    public static Pokemon pokemonSelecionado;
    
    public Home(Game frame) {
        editar(frame);
    }

    private void editar(Game frame) {
        Fonte = DefinirFonte.fonte();
        setLayout(new BorderLayout());
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new ImageIcon("assets/backgroundImages/focusPage.png")); 
        backgroundLabel.setBounds(0, 0, 960, 640);

        setPokemons(backgroundLabel);
        setPersonagemJogador(backgroundLabel);
    
        JLabel titleLabel = new JLabel("Vamos Batalhar!");
        titleLabel.setFont(Fonte.deriveFont(Font.PLAIN, 60));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(650, 450, 800, 50);
    
        JButton nextButton = new JButton("Iniciar Batalha");
        nextButton.setFont(Fonte.deriveFont(Font.PLAIN, 40));
        nextButton.addActionListener(e -> {
            PokemonsBatle pokemonsBatle = new PokemonsBatle(frame);
            pokemonsBatle.atualizarVidaPlayer();
            pokemonsBatle.atualizarVidaInimigo();
            pokemonsBatle.repaint();
            frame.mudarTela(pokemonsBatle);
        });
        nextButton.setBounds(650, 500, 300, 70);

        JLabel sairTitleLabel = new JLabel("Salvar e sair");
        sairTitleLabel.setFont(Fonte.deriveFont(Font.PLAIN, 60));
        sairTitleLabel.setForeground(Color.WHITE);
        sairTitleLabel.setBounds(50, 450, 800, 50);

        JButton sairButton = new JButton("SAIR");
        sairButton.setFont(Fonte.deriveFont(Font.PLAIN, 40));
        sairButton.addActionListener(e -> {

           Player.salvarDados();
            System.exit(0);
            
        });
        sairButton.setBounds(50, 500, 300, 70);


        JButton apagarButton = new JButton("Apagar Save");
        apagarButton.setFont(Fonte.deriveFont(Font.PLAIN, 20));
        apagarButton.addActionListener(e -> {
            File file = new File("player_data.dat");
            if (file.exists()) {
                file.delete();
            }

            System.exit(0);
            
        });
        apagarButton.setBounds(10, 10, 120, 50);

        backgroundLabel.add(apagarButton);
        backgroundLabel.add(titleLabel);
        backgroundLabel.add(nextButton);    
        backgroundLabel.add(sairTitleLabel);
        backgroundLabel.add(sairButton);
    
        add(backgroundLabel, BorderLayout.NORTH);
    }

    private void setPokemons(JLabel backgroundLabel) {
        pokemonSelecionado = new Pokemon(Player.pokemonNome ,  "front");
        JLabel pokemon = pokemonSelecionado.getImagemLabel();
        pokemon.setBounds(  270 , 230 , 300, 300);

        backgroundLabel.add(pokemon);
        
    }

    private void setPersonagemJogador(JLabel backgroundLabel) {
        JLabel Personagem= new JLabel();
        Personagem.setFocusable(true);
        Personagem.setBounds(  400 , -50 , 960, 640); 

        JLabel nomePersonagem = new JLabel(Player.nome);
        nomePersonagem.setFont(Fonte.deriveFont(Font.PLAIN, 40));
        nomePersonagem.setForeground(Color.BLACK);
        nomePersonagem.setBounds(  560 , 150 , 200, 50);
        backgroundLabel.add(nomePersonagem);

        
        if (Player.tipoPersonagem.equals("boy")) {
            Personagem.setIcon(new ImageIcon("assets/personagens/ash.png"));
        } else if (Player.tipoPersonagem.equals("girl")){ 
            Personagem.setIcon(new ImageIcon("assets/personagens/girl.png"));
        }
        
        backgroundLabel.add(Personagem);
    }
}

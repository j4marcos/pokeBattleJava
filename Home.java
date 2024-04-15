import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel {
    
    public Home(Game frame) {
        editar(frame);
    }

    public void editar(Game frame) {
        setLayout(new BorderLayout());
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new ImageIcon("assents/backgroundImages/focusPage.png")); 
        backgroundLabel.setBounds(0, 0, 960, 640);

        setPersonagemJogador(backgroundLabel);
        setPokemons(backgroundLabel);
    
        JLabel titleLabel = new JLabel("Vamos Batalhar!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(650, 450, 800, 50);
    
        JButton nextButton = new JButton("Iniciar Batalha");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20)); 
        nextButton.addActionListener(e -> {
            PokemonsBatle pokemonsBatle = new PokemonsBatle(frame);
            pokemonsBatle.setName("pokemonsBatle");
            frame.mudarTela(pokemonsBatle);
        });
        nextButton.setBounds(700, 500, 200, 70);

        backgroundLabel.add(titleLabel);
        backgroundLabel.add(nextButton);    
    
        add(backgroundLabel, BorderLayout.NORTH);
    }

    private void setPokemons(JLabel backgroundLabel) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setPokemons'");
    }

    private void setPersonagemJogador(JLabel backgroundLabel) {
        int tipoPersonagem = 1;
        // tipo peronagem se refere se o jogador escokheu o personagem boy ou girl, issso sera definido no arquivo de save do jogador

        JLabel Personagem= new JLabel();
        Personagem.setFocusable(true);
        Personagem.setBounds(  400 , -50 , 960, 640); 
        
        if (tipoPersonagem == 1) Personagem.setIcon(new ImageIcon("assents/personagens/ash.png")); 
        if (tipoPersonagem == 2) Personagem.setIcon(new ImageIcon("assents/personagens/girl.png"));

        backgroundLabel.add(Personagem);
    }
}

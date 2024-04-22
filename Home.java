import java.awt.*;
import javax.swing.*;

public class Home extends JPanel {
    
    public Home(Game frame) {
        editar(frame);
    }

    private void editar(Game frame) {
        setLayout(new BorderLayout());
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new ImageIcon("assets/backgroundImages/focusPage.png")); 
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
        JLabel Personagem= new JLabel();
        Personagem.setFocusable(true);
        Personagem.setBounds(  400 , -50 , 960, 640); 
        
        if (Player.tipoPersonagem.equals("boy")) {
            Personagem.setIcon(new ImageIcon("assets/personagens/ash.png"));
        } else if (Player.tipoPersonagem.equals("girl")){ 
            Personagem.setIcon(new ImageIcon("assets/personagens/girl.png"));
        }
        
        backgroundLabel.add(Personagem);
    }
}

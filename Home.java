import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel {
    
    public Home(Game frame) {
        editar(frame);
    }

    public void editar(Game frame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Altere o layout para BoxLayout
    
        JLabel titleLabel = new JLabel("Vamos Batalhar!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); 
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centralize o título
    
        JButton nextButton = new JButton("Iniciar Batalha");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20)); 
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centralize o botão
        nextButton.addActionListener(e -> {
            PokemonsBatle pokemonsBatle = new PokemonsBatle(frame);
            frame.mudarTela(pokemonsBatle);
            System.out.println("Home -> PokemonsBatle");
        });
    
        setBackground(Color.decode("#E6F2FF")); 
        add(Box.createVerticalGlue()); // Adicione espaço antes do título
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 20))); // Adicione espaço entre o título e o botão
        add(nextButton);
        add(Box.createVerticalGlue()); // Adicione espaço após o botão
    }
}

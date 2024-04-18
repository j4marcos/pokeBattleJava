import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class EscolherPokemonInicial extends JPanel{

    public EscolherPokemonInicial(Game frame) {
        editar(frame);
    }

    public void editar(Game frame) {
        setLayout(new BorderLayout());
        Font Fonte = DefinirFonte.fonte();

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assets/backgroundImages/info.png"));
        background.setBounds(0, 0, 960, 640); 

        ActionListener nextPage = e -> {
            Tutorial tutorial = new Tutorial(frame, new String[]{ "Boa sorte na sua Aventura Pokemon!" }, new Home(frame));
            frame.mudarTela(tutorial);
        };

        JButton bulbasaurOption = new JButton(new ImageIcon("assets/pokemons/bulbassaulto.png"));
        bulbasaurOption.setBounds(50, 300, 250, 186);
        bulbasaurOption.addActionListener(e -> {
            System.out.println("Bulbasaur selecionado!");
            nextPage.actionPerformed(e);
        });
        background.add(bulbasaurOption);

        JLabel bulbasaurLabel = new JLabel("Bulbasaur");
        bulbasaurLabel.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        bulbasaurLabel.setBounds(50, 180, 250, 186);
        background.add(bulbasaurLabel);

        JButton charmanderOption = new JButton(new ImageIcon("assets/pokemons/chalizarBaby.png"));
        charmanderOption.setBounds(350, 300, 250, 186);
        charmanderOption.addActionListener(e -> {
            System.out.println("Charmander selecionado!");
            nextPage.actionPerformed(e);
        });
        background.add(charmanderOption);

        JLabel charmanderLabel = new JLabel("Charmander");
        charmanderLabel.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        charmanderLabel.setBounds(350, 180, 250, 186);
        background.add(charmanderLabel);

        JButton squirtleOption = new JButton(new ImageIcon("assets/pokemons/squitou.png"));
        squirtleOption.setBounds(650, 300, 250, 186);
        squirtleOption.addActionListener(e -> {
            System.out.println("Squirtle selecionado!");
            nextPage.actionPerformed(e);
        });
        background.add(squirtleOption);

        JLabel squirtleLabel = new JLabel("Squirtle");
        squirtleLabel.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        squirtleLabel.setBounds(650, 180, 250, 186);
        background.add(squirtleLabel);

        add(background, BorderLayout.NORTH);
    }
}
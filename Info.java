import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Info extends JPanel {

    public Info(Game frame) {
        editar(frame);
    }

    public void editar(Game frame) {
        Font Fonte = DefinirFonte.fonte();

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundImages/info.png"));
        background.setBounds(0, 0, 960, 640); 

        JLabel pikachuIconLabel = new JLabel();
        pikachuIconLabel.setFocusable(true);
        pikachuIconLabel.setIcon(new ImageIcon("assents/backgroundImages/pikachu.gif")); 
        pikachuIconLabel.setBounds(10, 5, 130, 130);

        JLabel linha0 = new JLabel("Pokemon Fire Red - Java Swing Edition");
        JLabel linha1 = new JLabel("Autores:");
        JLabel linha2 = new JLabel("Joao Marcos  -  Rafael  -  Puca");
        JLabel linha3 = new JLabel("CI - UFPB");
        JLabel linha4 = new JLabel("");
        JLabel linha5 = new JLabel("");
        
        linha0.setFont(Fonte.deriveFont(Font.PLAIN,52f));
        linha1.setFont(Fonte.deriveFont(Font.PLAIN,52f));
        linha2.setFont(Fonte.deriveFont(Font.PLAIN,52f));
        linha3.setFont(Fonte.deriveFont(Font.PLAIN,52f));
        linha4.setFont(Fonte.deriveFont(Font.PLAIN,52f));
        linha5.setFont(Fonte.deriveFont(Font.PLAIN,52f));
        
        linha0.setBounds(50, 150, 800, 50);
        linha1.setBounds(50, 200, 800, 50);
        linha2.setBounds(50, 250, 800, 50);
        linha3.setBounds(50, 300, 800, 50);
        linha4.setBounds(50, 350, 800, 50);
        linha5.setBounds(50, 450, 800, 50);

        JButton nextButton = new JButton("Próximo");
        nextButton.addActionListener(e -> {
            Tutorial tutorial = new Tutorial(frame);
            frame.mudarTela(tutorial);
        });
        nextButton.setBounds(800, 20, 100, 40);
        
        background.add(linha0);
        background.add(linha1);
        background.add(linha2);
        background.add(linha3);
        background.add(linha4);
        background.add(linha5);
        background.add(nextButton);
        background.add(pikachuIconLabel);

        add(background);
    }

}

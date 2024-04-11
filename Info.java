import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Info extends JPanel {

    public Info() {
        editar();
    }

    public void editar() {
        // setLayout(null); // Definindo o layout como null

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundImages/info.png"));
        background.setBounds(0, 0, 960, 640); // Definindo o tamanho e posição do background

        JLabel pikachuIconLabel = new JLabel();
        pikachuIconLabel.setFocusable(true);
        pikachuIconLabel.setIcon(new ImageIcon("assents/backgroundImages/pikachu.gif")); // site usado para criar o gif: https://www.piskelapp.com/p/create/sprite
        pikachuIconLabel.setBounds(10, 5, 130, 130);

        JLabel infoLabel = new JLabel("Autores: Joao Marcos, Rafael, Puca Vaz. CI - UFPB");
        // fonte do pokemon
        Font Fonte = DefinirFonte.fonte();
        infoLabel.setFont(Fonte.deriveFont(Font.PLAIN,52f));

        infoLabel.setBounds(50, 150, 800, 50);

        JButton buttonInfo = new JButton("Próximo");
        buttonInfo.addActionListener(e -> TelasRef.startGame.mudarTela("tutorial"));
        buttonInfo.setBounds(800, 20, 100, 40); // Definindo a posição e tamanho do botão
       
        // Adicionando os componentes ao background
        
        background.add(infoLabel);
        background.add(buttonInfo);
        background.add(pikachuIconLabel);

        add(background);
    }

}

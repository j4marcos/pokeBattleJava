import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tutorial extends JPanel {

    public Tutorial() {
        editar();
    }

    public void editar() {
        // setLayout(null); // Definindo o layout como null
        
        // fonte do pokemon
        Font Fonte = DefinirFonte.fonte();

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundImages/info.png"));
        background.setBounds(0, 0, 960, 640); // Definindo o tamanho e posição do background

        JLabel pikachuIconLabel = new JLabel();
        pikachuIconLabel.setFocusable(true);
        pikachuIconLabel.setIcon(new ImageIcon("assents/backgroundImages/pikachu.gif")); // site usado para criar o gif: https://www.piskelapp.com/p/create/sprite
        pikachuIconLabel.setBounds(10, 5, 130, 130);

        JLabel linha1 = new JLabel("TUTORIAL");
        JLabel linha2 = new JLabel("Neste jogo, voce enfrentara oponentes em ");
        JLabel linha3 = new JLabel("batalhas de Pokemon.");
        JLabel linha4 = new JLabel("Para atacar, selecione um ataque no menu inferior.");
        JLabel linha5 = new JLabel("Use itens da bolsa para curar seus Pokemon ou ");
        JLabel linha6 = new JLabel("aumentar seus atributos.");

        linha1.setFont(Fonte.deriveFont(Font.PLAIN,52f));
        linha2.setFont(Fonte.deriveFont(Font.PLAIN,52f));
        linha3.setFont(Fonte.deriveFont(Font.PLAIN,52f));
        linha4.setFont(Fonte.deriveFont(Font.PLAIN,52f));
        linha5.setFont(Fonte.deriveFont(Font.PLAIN,52f));
        linha6.setFont(Fonte.deriveFont(Font.PLAIN,52f));

        linha1.setBounds(50, 150, 800, 50);
        linha2.setBounds(50, 200, 800, 50);
        linha3.setBounds(50, 250, 800, 50);
        linha4.setBounds(50, 300, 800, 50);
        linha5.setBounds(50, 350, 800, 50);
        linha6.setBounds(50, 400, 800, 50);

        JButton buttonInfo = new JButton("Próximo");
        buttonInfo.addActionListener(e -> TelasRef.startGame.mudarTela("criarPersonagem"));
        buttonInfo.setBounds(800, 20, 100, 40); // Definindo a posição e tamanho do botão
       
        // Adicionando os componentes ao background
        
        background.add(linha1);
        background.add(linha2);
        background.add(linha3);
        background.add(linha4);
        background.add(linha5);
        background.add(linha6);
        background.add(buttonInfo);
        background.add(pikachuIconLabel);

        add(background);
    }

}

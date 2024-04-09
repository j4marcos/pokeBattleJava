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
        pikachuIconLabel.setIcon(new ImageIcon("assents/backgroundImages/pika1.png"));
        pikachuIconLabel.setBounds(20, 20, 100, 100);

        JLabel infoLabel = new JLabel("Autores: João Marcos, Rafael, Puca Vaz. CI - UFPB");
        infoLabel.setBounds(50, 150, 400, 50);

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

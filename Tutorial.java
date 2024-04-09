// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JLabel;
// import javax.swing.JPanel;

// public class Tutorial extends JPanel {

//     public Tutorial() {
//         editar();
//     }

//     public void editar() {
//         // setLayout(null); // Definindo o layout como null

//         JLabel background = new JLabel();
//         background.setFocusable(true);
//         background.setIcon(new ImageIcon("assents/backgroundImages/info.png"));
//         background.setBounds(0, 0, 960, 640); // Definindo o tamanho e posição do background

        

//         JLabel infoLabel = new JLabel("Autores: João Marcos, Rafael, Puca Vaz. CI - UFPB");
//         infoLabel.setBounds(50, 150, 400, 50); // Definindo a posição e tamanho do rótulo de informações

//         JButton buttonInfo = new JButton("Próximo");
//         buttonInfo.addActionListener(e -> TelasRef.startGame.mudarTela("tutorial"));
//         buttonInfo.setBounds(800, 20, 100, 40); // Definindo a posição e tamanho do botão
       
//         // Adicionando os componentes ao background
//         background.add(infoLabel);
//         background.add(buttonInfo);
        

//         add(background);
//     }

// }

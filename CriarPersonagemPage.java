import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CriarPersonagemPage extends JPanel{
    
    public CriarPersonagemPage(Game frame) {
        editar(frame);
    }

    public void editar(Game frame) {
        setLayout(new BorderLayout());

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundImages/criarPerosnagemBackground.png"));
        background.setBounds(0, 0, 960, 640); 

        JTextField textField = new JTextField();
        textField.setBackground(Color.WHITE);
        textField.setBounds(390, 200, 220, 50);
        textField.setFont(textField.getFont().deriveFont(50f));
        background.add(textField);


        JButton nextButton = new JButton("OK");
        nextButton.addActionListener(e -> {
            Home home = new Home(frame);
            home.setName("home");
            frame.mudarTela(home);
        });
        nextButton.setBounds(760, 520, 110, 35);

        JPanel panelSelecaoPersonagem = new JPanel();
        panelSelecaoPersonagem.setBackground(Color.WHITE);
        panelSelecaoPersonagem.setBounds(90, 320, 620, 260);

        JLabel label = new JLabel("Selecione o personagem");
        label.setFont(label.getFont().deriveFont(30f));
        label.setBounds(200, 320, 620, 50);
        background.add(label);

        JButton personagem1 = new JButton("Personagem 1");
        personagem1.setBounds(150, 530, 200, 30);
        background.add(personagem1);

        ImageIcon image = new ImageIcon("assents/personagens/ash.png");
        Image scaledImage = image.getImage().getScaledInstance(90, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBounds(160, 380, 150, 150);
        background.add(imageLabel);

        JButton personagem2 = new JButton("Personagem 2");
        personagem2.setBounds(450, 530, 200, 30);
        background.add(personagem2);

        ImageIcon img = new ImageIcon("assents/personagens/girl.png");
        Image scaledImage2 = img.getImage().getScaledInstance(90, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel2 = new JLabel(new ImageIcon(scaledImage2));
        imageLabel2.setBounds(480, 380, 150, 150);

        background.add(imageLabel2);

        background.add(panelSelecaoPersonagem);

        background.add(nextButton);

        add(background, BorderLayout.NORTH);
    }

   
        
    
}

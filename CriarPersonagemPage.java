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
        background.setIcon(new ImageIcon("assets/backgroundImages/criarPerosnagemBackground.png"));
        background.setBounds(0, 0, 960, 640); 

        JTextField textField = new JTextField();
        textField.setBackground(Color.WHITE);
        textField.setBounds(390, 200, 220, 50);
        textField.setFont(textField.getFont().deriveFont(50f));
        background.add(textField);


        JButton nextButton = new JButton("OK");
        nextButton.addActionListener(e -> {
            Tutorial tutorial = new Tutorial(frame, new String[]{ "Escolha seu pokemon Inicial" }, new EscolherPokemonInicial(frame));
            frame.mudarTela(tutorial);
        });
        nextButton.setBounds(760, 520, 110, 35);

        JPanel panelSelecaoPersonagem = new JPanel();
        panelSelecaoPersonagem.setBackground(Color.WHITE);
        panelSelecaoPersonagem.setBounds(90, 320, 620, 260);

        JLabel label = new JLabel("Selecione o personagem");
        label.setFont(label.getFont().deriveFont(30f));
        label.setBounds(200, 320, 620, 50);
        background.add(label);

        ImageIcon image = new ImageIcon("assets/personagens/ash.png");
        Image scaledImage = image.getImage().getScaledInstance(90, 150, Image.SCALE_SMOOTH);
        JButton personagem1 = new JButton(new ImageIcon(scaledImage));
        personagem1.setBounds(150, 380, 200, 200);
        background.add(personagem1);

        ImageIcon img = new ImageIcon("assets/personagens/girl.png");
        Image scaledImage2 = img.getImage().getScaledInstance(90, 150, Image.SCALE_SMOOTH);
        JButton personagem2 = new JButton(new ImageIcon(scaledImage2));
        personagem2.setBounds(450, 380, 200, 200);
        background.add(personagem2);


        background.add(panelSelecaoPersonagem);

        background.add(nextButton);

        add(background, BorderLayout.NORTH);
    }

   
        
    
}



import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tutorial extends JPanel {

    public Tutorial(Game frame) {
        editar(frame);
    }

    public void editar(Game frame) {
        setLayout(new BorderLayout());

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundImages/focusPage.png"));
        background.setBounds(0, 0, 960, 640); 

        JLabel Personagem= new JLabel();
        Personagem.setFocusable(true);
        Personagem.setIcon(new ImageIcon("assents/personagens/professor.png"));
        Personagem.setBounds(  350 , -50 , 960, 640); 

        JLabel TextArea= new JLabel();
        TextArea.setFocusable(true);
        TextArea.setIcon(new ImageIcon("assents/backgroundImages/textarea.png"));
        TextArea.setBounds(  25,200, 960, 640); 

        // adicionei esse botao temporario pra testar a batalha
        JButton nextButton = new JButton("Próximo");
        nextButton.addActionListener(e -> {
            CriarPersonagemPage criarPersonagem = new CriarPersonagemPage(frame);
            criarPersonagem.setName("criarPersonagem");
            frame.mudarTela(criarPersonagem);
        });
        nextButton.setBounds(800, 20, 100, 40);
        background.add(nextButton);

        background.add(TextArea);
        background.add(Personagem);

        add(background, BorderLayout.NORTH);
    }

}

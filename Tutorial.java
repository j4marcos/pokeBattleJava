

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tutorial extends JPanel {

    public Tutorial() {
        editar();
    }

    public void editar() {

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
        nextButton.addActionListener(e -> TelasRef.startGame.mudarTela("criarPersonagem"));
        nextButton.setBounds(800, 20, 100, 40);
        background.add(nextButton);

        background.add(TextArea);
        background.add(Personagem);

        add(background);
    }

}

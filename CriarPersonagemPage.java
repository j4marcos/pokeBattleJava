import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CriarPersonagemPage extends JPanel{
    
    public CriarPersonagemPage() {
        editar();
    }

    public void editar() {

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundImages/criarPerosnagemBackground.png"));
        background.setBounds(0, 0, 960, 640); 

        // adicionei esse botao temporario pra testar a batalha
        JButton nextButton = new JButton("Próximo");
        nextButton.addActionListener(e -> TelasRef.game.mudarTela("home"));
        nextButton.setBounds(800, 20, 100, 40);
        background.add(nextButton);

        add(background);
    }
}

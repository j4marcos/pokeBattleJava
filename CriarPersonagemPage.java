import javax.swing.ImageIcon;
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

        add(background);
    }
}

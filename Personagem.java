import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Personagem extends JPanel{
    
    public Personagem() {
        editar();
    }

    public void editar() {

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundImages/focusPage.png"));
        background.setBounds(0, 0, 960, 640); 

        add(background);
    }
    
}

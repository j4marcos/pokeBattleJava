import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Background extends JLabel {
    
    public Background() {
        editar();
    }

    public void editar() {
        setBounds(0, 0, 650, 600);
        ImageIcon image = new ImageIcon(getClass().getResource("images/background.jpg"));
        setIcon(image);
    }
}

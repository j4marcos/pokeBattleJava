import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Battle extends JPanel {
    public Battle() {
        editar();
    }

    public void editar() {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("images/Battle Background.png"));
        add(label);
        setBounds(0, 0, 915, 640);
    }
}
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
        label.setBounds(0, 0, 940, 400);
        add(label);
        setLayout(null);
        setBounds(0, 0, 940, 400);
    }
}
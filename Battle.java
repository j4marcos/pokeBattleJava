import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Battle extends JPanel {
    public Battle() {
        editar();
    }

    public void editar() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("images/Battle Background.png"));
        add(label, BorderLayout.NORTH);
        add(new Embaixo(), BorderLayout.CENTER);
    }
}
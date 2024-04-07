import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Embaixo extends JPanel {
    public Embaixo() {
        editar();
    }

    public void editar(){
        setLayout(new BorderLayout());
        JLabel label = new JLabel();
        label.setBackground(Color.BLUE);
        add(label, BorderLayout.WEST);
        add(new Options(), BorderLayout.EAST);
    }
}

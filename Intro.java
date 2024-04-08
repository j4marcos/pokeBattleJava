
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Intro extends JPanel {

    public Intro() {
        editar();
    }

    public void editar() {
        // setLayout(null);

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundImages/Untitled.png"));
        background.setBounds(0, 0, 910, 600);
        background.add(pressSpace());
        background.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("Espaço pressionado!");
                    TelasRef.game.mudarTela("battle");
                }
            }
        });
        add(background);
    }

    public JLabel pressSpace() {
        JLabel pressSpace = new JLabel("Press Space");
        pressSpace.setFont(new Font("Arial", Font.BOLD, 50));
        pressSpace.setForeground(Color.WHITE);
        pressSpace.setBounds(170, 470, 350, 50);
        iniciarAnimacao(pressSpace);
        return pressSpace;
    }

    public void iniciarAnimacao(JLabel label) {
        Timer timer = new Timer(700, new ActionListener() {
            boolean isVisible = true;

            public void actionPerformed(ActionEvent e) {
                label.setForeground(isVisible ? Color.WHITE : Color.BLACK);
                isVisible = !isVisible;
            }
        });
        timer.start();
    }
}
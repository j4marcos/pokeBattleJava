
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Intro extends JPanel {
    
    private Font Fonte;

    public Intro() {
        Fonte = DefinirFonte.fonte();
        editar();
    }

    public void editar() {
        // setLayout(null);

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundImages/intro.png"));
        background.add(pressSpace());
        background.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("Espaço pressionado!");
                    TelasRef.startGame.mudarTela("info");
                }
            }
        });
        add(background);
    }

    public JLabel pressSpace() {
        JLabel pressSpace = new JLabel("Press Space");

        pressSpace.setFont(Fonte.deriveFont(Font.PLAIN,52f));
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
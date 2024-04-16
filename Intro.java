
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Intro extends JPanel {
    
    private Font Fonte;

    public Intro(Game frame) {
        Fonte = DefinirFonte.fonte();
        editar(frame);
    }

    public Intro() {
        setLayout(new BorderLayout());
        Fonte = DefinirFonte.fonte();
        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assets/backgroundImages/intro.png"));
        background.add(pressSpace());
        
        add(background, BorderLayout.NORTH);
    }

    public void editar(Game frame) {
        setLayout(new BorderLayout());

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assets/backgroundImages/introR.gif"));
        background.add(pressSpace());
        background.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    Info info = new Info(frame);
                    info.setName("info");
                    frame.mudarTela(info);
                }
            }
        });
        add(background, BorderLayout.NORTH);
    }

    public JLabel pressSpace() {
        JLabel pressSpace = new JLabel("Press Space");

        pressSpace.setFont(Fonte.deriveFont(Font.PLAIN,90f));
        pressSpace.setForeground(Color.WHITE);
        pressSpace.setBounds(140, 460, 340, 100);
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
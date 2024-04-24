import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Final extends JPanel {
    private Font Fonte;

    public Final(Game frame) {
        Fonte = DefinirFonte.fonte();
        editar(frame);
    }

    public Final() {
        Fonte = DefinirFonte.fonte();
        setLayout(new BorderLayout());

        JPanel background = new JPanel();
        background.setFocusable(true);
        background.setBackground(Color.BLACK);
        background.setOpaque(true);
        background.add(pressEnter());
        background.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Aqui você pode definir o que acontece quando o usuário pressiona Enter
                }
            }
        });
        background.setBounds(0, 0, 976, 679);
        add(background, BorderLayout.CENTER); // Altere NORTH para CENTER
    }

    private void editar(Game frame) {
        setLayout(new BorderLayout());

        JPanel background = new JPanel();
        background.setFocusable(true);
        background.setBackground(Color.BLACK);
        background.setOpaque(true);
        background.add(pressEnter());
        background.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Aqui você pode definir o que acontece quando o usuário pressiona Enter
                }
            }
        });
        background.setBounds(0, 0, 976, 679);
        add(background, BorderLayout.CENTER); // Altere NORTH para CENTER
    }

    private JLabel pressEnter() {
        JLabel pressEnter = new JLabel("GAMER OVER");
        pressEnter.setFont(Fonte.deriveFont(Font.PLAIN,90f));
        pressEnter.setForeground(Color.WHITE);
        pressEnter.setBounds(0, 600, 340, 100);
        iniciarAnimacao(pressEnter);
        return pressEnter;
    }

    private void iniciarAnimacao(JLabel label) {
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
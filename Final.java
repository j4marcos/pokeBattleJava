import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Final extends JPanel {
    private Font Fonte;
    private boolean resultado = Player.resultado;

    public Final() {
        Fonte = DefinirFonte.fonte();
        setLayout(new BorderLayout());

        JPanel background = new JPanel(new GridBagLayout());
        background.setFocusable(true);
        background.setBackground(Color.BLACK);
        background.setOpaque(true);
        JLabel gameOverLabel = resultado ? congratulationsMsg() : finalMsg();
        gameOverLabel.setForeground(Color.RED);
        background.add(gameOverLabel);
        add(background, BorderLayout.CENTER);

        Timer colorChangeTimer = new Timer(500, new ActionListener() {
            private boolean colorFlag = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (colorFlag) {
                    gameOverLabel.setForeground(Color.RED);
                } else {
                    gameOverLabel.setForeground(Color.YELLOW);
                }
                colorFlag = !colorFlag;
            }
        });
        colorChangeTimer.start();

        Timer exitTimer = new Timer(7000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitTimer.setRepeats(false); // Isso garante que o timer só será acionado uma vez
        exitTimer.start();
    }

    private JLabel finalMsg() {
        JLabel finalMsg = new JLabel("GAME OVER");
        finalMsg.setFont(Fonte.deriveFont(Font.PLAIN,90f));
        return finalMsg;
    }

    private JLabel congratulationsMsg() {
        JLabel congratulationsMsg = new JLabel("CONGRATULATIONS");
        congratulationsMsg.setFont(Fonte.deriveFont(Font.PLAIN,90f));
        return congratulationsMsg;
    }
}
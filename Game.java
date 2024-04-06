import javax.swing.JFrame;
import java.awt.*;

public class Game extends JFrame implements Runnable {
    public Game() {
        editar();
    }

    public void editar() {
        setTitle("POKEMON");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(940, 640);
        setLocationRelativeTo(null);
        
        add(new Battle());

        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);
    }
    
    public void run() {}
}

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {

    public void editar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(915, 640);
        setLocationRelativeTo(null);
        add(new Battle());

        setVisible(true);
    }
    
    public void run() {
        editar();
    }
}

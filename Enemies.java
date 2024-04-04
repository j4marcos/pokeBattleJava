import javax.swing.*;
import java.awt.event.*;

public class Enemies extends JLabel implements Runnable {
    private int tamanho = 50;
    private int posicaoX = 300;
    private int posicaoY = 100;
    private boolean movendoDireita = true;
    
    public Enemies() {
        editar();
        //SwingUtilities.invokeLater( this);
        new Thread(this).start();
    }

    public void editar() {
        ImageIcon img = new ImageIcon(getClass().getResource("images/etBilu.png"));
        setIcon(img);
        setBounds(posicaoX, posicaoY, tamanho, tamanho);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(500); 
            } catch (Exception e) {
                System.out.println(e);
            }

            if (movendoDireita) {
                if (posicaoX + tamanho < 600) {
                    posicaoX += 20;
                } else {
                    movendoDireita = false;
                }
            } else {
                if (posicaoX > 20) {
                    posicaoX -= 20;
                } else {
                    movendoDireita = true;
                }
            }
            
            setBounds(posicaoX, posicaoY, tamanho, tamanho);
        }
    }
}

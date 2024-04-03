import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Player extends JLabel implements KeyListener {
    private int tamanho = 50;
    private int posicaoX = 300;
    private int posicaoY = 500;

    public Player() {
        setFocusable(true);
        addKeyListener(this);
        editar();
    }

    public void editar() {
        try {
            Image file = ImageIO.read(new File("images/nave.png"));
            Image img = file.getScaledInstance(tamanho, tamanho, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setBounds(posicaoX, posicaoY, tamanho, tamanho);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && posicaoX < 570) {
            posicaoX += 10;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && posicaoX > 10) {
            posicaoX -= 10;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Tiro!");
        }

        setBounds(posicaoX, posicaoY, tamanho, tamanho);
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pokemon {

    String nome;
    int vida;
    JLabel imagemLabel = new JLabel();

    public Pokemon(String nome, int vida, String imgName) {
        this.nome = nome;
        this.vida = vida;
        imagemLabel.setIcon(new ImageIcon(imgName));
    }
}
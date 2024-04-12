import java.awt.Color;

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

    public Pokemon(String nome, int vida) {
        // cria uma area preta que é o espaço que o pokemon vai ocupar, futuramente substituir por uma imagem
        imagemLabel.setSize(240, 240);
        imagemLabel.setBackground(Color.BLACK);
    }
}
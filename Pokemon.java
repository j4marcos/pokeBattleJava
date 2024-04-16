import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pokemon {

    public String nome;
    public int vida;
    String lado;
    public JLabel imagemLabel = new JLabel();

    public Pokemon(String nome, int vida, String lado) {
        this.nome = nome;
        this.vida = vida;
        // Lado precisa ser front ou back
        this.lado = lado;
        String imagePath = "assets/pokemons/" + nome.toLowerCase() + "/" + lado + ".png"; // acredito que é bom colocar um try aqui
        System.out.println(imagePath);

        // aqui todas as imagens estao sendo redimencionadas para o tamanho padra 256 x 256
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image image = icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH);
        imagemLabel.setIcon(new ImageIcon(image));
    }

    // Getter do lado 
    public String getLado(){
        return lado;
    }
    // Setter do lado
    public void setLado(String lado){
        this.lado = lado;
    }
    // Getter do name
    public String getNome() {
        return nome;
    }

    // Setter do name
    public void setNome(String nome) {
        this.nome = nome;
    }

    // pegar a vida
    public int getVida() {
        return vida;
    }

    // definir a vida
    public void setVida(int vida) {
        this.vida = vida;
    }

    // Pegar a label da imagem
    public JLabel getImagemLabel() {
        return imagemLabel;
    }
}
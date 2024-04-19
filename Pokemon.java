import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pokemon {

    public String nome;
    public int vida;
    public int vidaMaxima;
    String lado;
    public JLabel imagemLabel = new JLabel();

    public Pokemon(String nome, String lado) {
        this.nome = nome;
        this.lado = lado;
        this.vida = encontrarvida(nome);
        this.vidaMaxima = this.vida;
        // Lado precisa ser front ou back
        defirImage(nome, lado);

    }
    private void defirImage(String pokeString, String lado){
        // Criar path com base no nome e lado do pokemon
        String imagePath = "assets/pokemons/" + pokeString.toLowerCase() + "/" + lado + ".png"; 
        System.out.println(imagePath);

        // Aqui todas as imagens estao sendo redimencionadas para o tamanho padra 256 x 256
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
            Image image = icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH);
            imagemLabel.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a imagem: " + imagePath);
        }
    }
    private static Integer encontrarvida(String pokemonNome){
        String nomedoarquivo = "pokemonhp.csv";
        try (BufferedReader leitor= new BufferedReader(new FileReader(nomedoarquivo))){
            String linha;
            while ((linha = leitor.readLine()) != null){
                String[] partes = linha.split(",");
                if(partes.length == 2 && partes[0].trim().equalsIgnoreCase(pokemonNome)){
                    return Integer.parseInt(partes[1].trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    // pegar a vidaMaxima
    public int getVidaMaxima() {
        return vidaMaxima;
    }

    // Pegar a label da imagem
    public JLabel getImagemLabel() {
        return imagemLabel;
    }
}
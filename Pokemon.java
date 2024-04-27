import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Pokemon implements Serializable {
    private String nome;
    private int vida;
    private int vidaMaxima;
    private String lado;
    private JLabel imagemLabel = new JLabel();
    private String nomeAnterior ;

    public String getNomeAnterior() {
        return nomeAnterior;
    }

    public void setNomeAnterior(String nomeAnterior) {
        this.nomeAnterior = nomeAnterior;
    }

    public Pokemon(String nome, String lado) {
        this.nome = nome;
        this.lado = lado;
        this.vida = encontrarvida(nome);
        this.vidaMaxima = this.vida;
        // Lado precisa ser front ou back
        defirImage(nome, lado);
    }

    private void defirImage(String pokeString, String lado) {
        // Criar path com base no nome e lado do pokemon
        String imagePath = "assets/pokemons/" + pokeString.toLowerCase() + "/" + lado + ".png";
        // System.out.println(imagePath);

        // Aqui todas as imagens estao sendo redimencionadas para o tamanho padra 256 x
        // 256
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
            Image image = icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH);
            imagemLabel.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a imagem: " + imagePath);
        }
    }

    private static Integer encontrarvida(String pokemonNome) {
        String nomedoarquivo = "pokemonhp.csv";
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomedoarquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2 && partes[0].trim().equalsIgnoreCase(pokemonNome)) {
                    return Integer.parseInt(partes[1].trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Getter do lado
    public String getLado() {
        return lado;
    }

    // Setter do lado
    public void setLado(String lado) {
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

    public void evoluir(int nivel, Game frame) {
        vidaMaxima += 5 * nivel;
        vida += 5 * nivel;
        Player.ataqueValue += (int) (nivel / 2);
        nomeAnterior = nome;

        if (PokemonsBatle.playerLv == 2 || PokemonsBatle.playerLv == 3) {
            aplicarEvolucao();
            Player.pokemonNome = nome;
            defirImage(nome, "back");
            System.out.println("O pokemon evoluiu para " + nome);
            
            EvolucaoPage evolucaoPage = new EvolucaoPage(frame, Player.pokemonSelecionado);
            frame.mudarTela(evolucaoPage);
        }
        System.out.println("O pokemon do player subiu de nivel");
    }

    private void aplicarEvolucao() {
        
        if (nome.equals("Bulbasaur")) {
            nome = "Ivysaur";
        } else if (nome.equals("Ivysaur")) {
            nome = "Venusaur";
        } else if (nome.equals("Charmander")) {
            nome = "Charmeleon";
        } else if (nome.equals("Charmeleon")) {
            nome = "Charizard";
        } else if (nome.equals("Squirtle")) {
            nome = "Wartortle";
        } else if (nome.equals("Wartortle")) {
            nome = "Blastoise";
        }
    }
}
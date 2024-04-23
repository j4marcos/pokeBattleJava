import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Options extends JPanel {
    private BufferedImage backgroundImage;
    private Font Fonte;
    private Game frame;
    private InterfaceCaixa interfaceCaixa;

    public Options(Game frame, InterfaceCaixa interfaceCaixa) { // Modificado
        this.frame = frame;
        this.interfaceCaixa = interfaceCaixa;
        Fonte = DefinirFonte.fonte();
        editar();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Colocar a imagem como plano de fundo
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    private void editar() {
        definirBackground();
        setLayout(null);

        botao("LUTAR", 40, 30);
        botao("BOLSA", 270, 30);
        botao("POKEMON", 40, 100);
        botao("SAIR", 270, 100);
    }

    private void definirBackground() {
        // Carregar background
        try {
            backgroundImage = ImageIO.read(new File("assets/battleElements/rightMenu.png"));
        } catch (IOException e) {
            e.printStackTrace(); // Erro se o arquivo não estiver lá
        }
    }

    private void botao(String nome, int x, int y) {
        JButton botao = new JButton(nome);
        // Parte do background
        botao.setContentAreaFilled(false); // Tirar qualquer coisa que faça os botões ficarem coloridos
        botao.setBorderPainted(false); // Tirar as bordas
        botao.setFont(Fonte.deriveFont(Font.PLAIN, 60)); // Definir fonte

        botao.setBounds(x, y, botao.getPreferredSize().width, botao.getPreferredSize().height); // Definir posição e tamanho

        botao.addActionListener(e -> {
            switch (nome) {
                case "LUTAR":
                    interfaceCaixa.mudarInterfaceBattleLayout("poderes");
                    System.out.println(nome + " apertado!");
                    break;
                case "BOLSA":
                    Bag bag = new Bag(frame);
                    frame.mudarTela(bag);
                    System.out.println(nome + " apertado!");
                    break;
                case "POKEMON":
                PokemonsBagPage pokemonsBag = new PokemonsBagPage(frame);
                frame.mudarTela(pokemonsBag);
                System.out.println(nome + " apertado!");
                    break;
                case "SAIR":
                    Home home = new Home(frame);
                    frame.mudarTela(home);
                    System.out.println(nome + " apertado!");
                    break;
                default:
                    break;
            }
        });
        add(botao);
    }
}
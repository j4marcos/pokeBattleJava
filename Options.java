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
        setLayout(new GridLayout(2, 1));

        botao("FIGHT");
        botao("BAG");
        botao("POKEMON");
        botao("RUN");
    }

    private void definirBackground() {
        // Carregar background
        try {
            backgroundImage = ImageIO.read(new File("assets/battleElements/rightMenu.png"));
        } catch (IOException e) {
            e.printStackTrace(); // Erro se o arquivo não estiver lá
        }
    }

    private void botao(String nome) {
        JButton botao = new JButton(nome);
        // Parte do background
        botao.setOpaque(false); // Faz que o botão fique transparante
        botao.setContentAreaFilled(false); // Tirar qualquer coisa que faça os botões ficarem coloridos
        botao.setBorderPainted(false); // Tirar as bordas
        botao.setFont(Fonte.deriveFont(Font.PLAIN, 35)); // Definir fonte

        botao.addActionListener(e -> {
            switch (nome) {
                case "FIGHT":
                    interfaceCaixa.mudarInterfaceBattleLayout("poderes");
                    System.out.println(nome + " apertado!");
                    break;
                case "BAG":
                    Bag bag = new Bag(frame);
                    frame.mudarTela(bag);
                    System.out.println(nome + " apertado!");
                    break;
                case "POKEMON":
                    Home home = new Home(frame);
                    frame.mudarTela(home);
                    System.out.println(nome + " apertado!");
                    break;
                case "RUN":
                    Home home1 = new Home(frame);
                    frame.mudarTela(home1);
                    System.out.println(nome + " apertado!");
                    break;
                default:
                    break;
            }
        });
        add(botao);
    }
}
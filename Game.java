import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JFrame implements Runnable {

    public void editar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(915, 640);
        setLocationRelativeTo(null);
        add(new Battle());
        setTitle("pokeBattle");
        
        setVisible(true);
    }

    public void run() {
        editar();
    }

    public class Battle extends JPanel {
        protected InterfaceCaixa interface1;

        public Battle() {
            editar();
            SwingUtilities.invokeLater(() -> new MenuComNavegacao());
        }

        public void editar() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon("images/Battle Background.png"));

            interface1 = new InterfaceCaixa();
            add(label, BorderLayout.NORTH);
            add(interface1, BorderLayout.CENTER);

            // JLabel label = new JLabel();
            // label.setBackground(Color.white);
            // add(label, BorderLayout.WEST);
            // add(new Options(), BorderLayout.EAST);
        }

        
    }

    public class MenuComNavegacao extends JFrame implements ActionListener {
        private JPanel cardPanel;
        private CardLayout cardLayout;

        public MenuComNavegacao() {
            setTitle("Menu com Navegação");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);

            // Criação do CardLayout e JPanel para armazenar os "cartões"
            cardLayout = new CardLayout();
            cardPanel = new JPanel(cardLayout);

            // Criando e adicionando os "cartões"
            JPanel homePanel = new JPanel();
            homePanel.add(new JLabel("Tela Inicial"));

            JPanel aboutPanel = new JPanel();
            aboutPanel.add(new JLabel("Sobre"));

            JPanel settingsPanel = new JPanel();
            settingsPanel.add(new JLabel("Configurações"));

            cardPanel.add(homePanel, "home");
            cardPanel.add(aboutPanel, "about");
            cardPanel.add(settingsPanel, "settings");

            // Criação do menu
            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("Menu");

            JMenuItem homeItem = new JMenuItem("Home");
            homeItem.addActionListener(this);
            menu.add(homeItem);

            JMenuItem aboutItem = new JMenuItem("Sobre");
            aboutItem.addActionListener(this);
            menu.add(aboutItem);

            JMenuItem settingsItem = new JMenuItem("Configurações");
            settingsItem.addActionListener(this);
            menu.add(settingsItem);

            menuBar.add(menu);
            setJMenuBar(menuBar);

            getContentPane().add(cardPanel);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Altera o "cartão" exibido com base no item de menu selecionado
            String command = e.getActionCommand();
            switch (command) {
                case "Home":
                    cardLayout.show(cardPanel, "home");
                    break;
                case "Sobre":
                    cardLayout.show(cardPanel, "about");
                    break;
                case "Configurações":
                    cardLayout.show(cardPanel, "settings");
                    break;
            }
        }

    }

    public class Options extends JPanel {
        private BufferedImage backgroundImage;

        public Options() {
            editar();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Colocar a imagem como plano de fundo
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }

        public void editar() {
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
                backgroundImage = ImageIO.read(new File("assents/inBattleMenu/rightMenu.png"));
            } catch (IOException e) {
                e.printStackTrace(); // Erro se o arquivo não estiver lá
            }
        }

        public void botao(String nome) {
            JButton botao = new JButton(nome);
            // Parte do background
            botao.setOpaque(false); // Faz que o botão fique transparante
            botao.setContentAreaFilled(false); // Tirar qualquer coisa que faça os botões ficarem coloridos
            botao.setBorderPainted(false); // Tirar as bordas

            // Definir fonte
            try {
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("assents/font/pokemon_fire_red.ttf"));
                botao.setFont(customFont.deriveFont(Font.PLAIN, 35));
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
            botao.addActionListener(e -> {
                if (nome.equals("FIGHT")) {
                    System.out.println(nome + " apertado!");
                } else if (nome.equals("BAG")) {
                    System.out.println(nome + " apertado!");
                } else if (nome.equals("POKEMON")) {
                    System.out.println(nome + " apertado!");
                } else if (nome.equals("RUN")) {
                    System.out.println(nome + " apertado!");
                }
            });
            add(botao);
        }
    }

    public class InterfaceCaixa extends JPanel {
        private CaixaDialogo textDialogo = new CaixaDialogo();

        public InterfaceCaixa() {
            editar();
            textDialogo.dialogar(new String[] { "Batalha iniciada.", "Escolha sua ação." });
        }

        public void editar() {
            setBackground(Color.blue);
            setLayout(new GridBagLayout()); // Usar GridBagLayout para controlar o posicionamento dos componentes

            GridBagConstraints gbc = new GridBagConstraints();

            // Configuração do textDialogo para ocupar todo o espaço da esquerda
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            add(textDialogo, gbc);

            // Configuração de Options para ocupar todo o espaço da direita
            Options options = new Options();
            options.setBackground(Color.green);
            gbc.gridx = 1;
            gbc.weightx = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            add(options, gbc);

            Poderes poderes = new Poderes();
            poderes.setBackground(Color.green);
            gbc.gridx = 1;
            gbc.weightx = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            add(poderes, gbc);
            // Configuração do elemento acima para aparecer em cima do textDialogo

        }
    }

    public class CaixaDialogo extends JPanel {

        private JButton nextButton;
        private int indiceFalaAtual;
        private String[] falas;
        private JLabel textLabel;
        private Font Fonte;

        public CaixaDialogo() {
            definirFonte();
            editar();
        }

        private void definirFonte() {
            // Definir fonte. Problema, essa não é a fonte correta para esse botão
            // falta encontrar a fonte correta
            try {
                Fonte = Font.createFont(Font.TRUETYPE_FONT, new File("assents/font/pokemon_fire_red.ttf"));

            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
        }

        public void editar() {
            setLayout(new BorderLayout());

            // Define um painel para o botão "Próximo" com layout FlowLayout alinhado à
            // direita
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            add(buttonPanel, BorderLayout.EAST);
            // Tirei o acento por conta da fonte, não encontrei ainda com acentos em
            // portugues
            nextButton = new JButton("Proximo");
            nextButton.setFont(Fonte.deriveFont(Font.PLAIN, 20f));
            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirProximaFala();
                }
            });

            buttonPanel.add(nextButton); // Adiciona o botão ao painel
        }

        public void dialogar(String[] falas) {
            this.falas = falas;
            this.indiceFalaAtual = 0;
            criarInterfaceDeDialogo();
            exibirProximaFala();

        }

        public void criarInterfaceDeDialogo() {
            textLabel = new JLabel();
            add(textLabel, BorderLayout.CENTER);
            textLabel.setFont(Fonte.deriveFont(Font.PLAIN, 30f));
        }

        public void exibirProximaFala() {
            if (indiceFalaAtual < falas.length) {
                textLabel.setText(falas[indiceFalaAtual]);
                indiceFalaAtual++;
                System.out.println("Próxima fala.");

            } else {
                nextButton.setEnabled(false);
                // Remove o textLabel da interface
                remove(textLabel);
                revalidate(); // Atualiza o layout
                repaint(); // Redesenha a interface

            }
        }
    }

    public class Poderes extends JPanel {
        public Poderes() {
            editar();
        }

        public void editar() {
            setLayout(new GridLayout(2, 1));

            botao("chutao");
            botao("cabeçada");
            botao("peido venenoso");
            botao("mal olhado");
        }

        public void botao(String nome) {
            JButton botao = new JButton(nome);
            botao.addActionListener(e -> {
                System.out.println(nome + " disparado!!");

            });
            add(botao);
        }
    }

    // tela inicial do jogo
    public class Intro extends JPanel {

        public Intro() {
            editar();
        }
    
        public void editar() {
            setLayout(null);
    
            JLabel background = new JLabel();
            background.setFocusable(true); 
            background.setIcon(new ImageIcon("Untitled.png"));
            background.setBounds(0, 0, 910, 600);
            background.add(pressSpace());
            background.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        System.out.println("Espaço pressionado!");
                    }
                }
            });
            add(background);
        }
    
        public JLabel pressSpace() {
            JLabel pressSpace = new JLabel("Press Space");
            pressSpace.setFont(new Font("Arial", Font.BOLD, 50));
            pressSpace.setForeground(Color.WHITE);
            pressSpace.setBounds(170, 470, 350, 50);
            iniciarAnimacao(pressSpace);
            return pressSpace;
        }
    
        public void iniciarAnimacao(JLabel label) {
            Timer timer = new Timer(700, new ActionListener() {
                boolean isVisible = true;
    
                public void actionPerformed(ActionEvent e) {
                    label.setForeground(isVisible ? Color.WHITE : Color.BLACK);
                    isVisible = !isVisible;
                }
            });
            timer.start();
        }
    }

}

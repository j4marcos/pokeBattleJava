import java.awt.*;
import javax.swing.*;

public class Bag extends JPanel {
    private JLabel background = new JLabel();
    private Font Fonte = DefinirFonte.fonte();
    private JButton useButton = editarBotao("USE", 715, 485);
    private JButton cancelButton = editarBotao("CANCEL", 715, 545);
    private JLabel descricaol1;
    private JLabel descricaol2;
    private JLabel descricaol3; 
    private JLabel imgItemAtual;
    private int selectedIndex;
    private String[][] items = { 
        {"Dipirona", "assets/itens/potion (1).png", "Eh como a pocao de cabeca ", "fresca para aquele Pokemon com ", "dor de cabeca!", "15"}, 
        {"Paracetamol", "assets/itens/potion (2).png", "Uma pocao refrescante para ", "Pokemon que estao um pouco ", "febris.", "20"}, 
        {"Dorflex", "assets/itens/potion (3).png", "Esta pocao relaxante acaba ", "com as dores musculares dos ", "Pokemon!", "25"}, 
        {"Ibuprofeno", "assets/itens/potion (4).png", "Uma pocao rapida para alivio ", "imediato da dor para qualquer ", "Pokemon.", "30"}, 
        {"Losartana", "assets/itens/potion (5).png", "Mantem a pressao arterial dos ", "Pokemon sob controle.", "", "35"}, 
        {"Xarope", "assets/itens/potion (6).png", "Esta pocao e um abraco caloroso ", "para a garganta do seu Pokemon.", "", "40"}, 
        {"Buscopan", "assets/itens/potion (7).png", "Uma pocao calmante para os ", "desconfortos abdominais dos ", "Pokemon.", "45"}, 
        {"Neosoro", "assets/itens/potion (8).png", "Para aqueles Pokemon com narizes ", "tao entupidos quanto uma rota de", "migracao de Taillow.", "50"}, 
        {"Torsilax", "assets/itens/potion (9).png", "Uma pocao poderosa para alivio ", "extra da dor dos Pokemon.", "", "10"}, 
        {"Benzetacil", "assets/itens/potion (10).png", "Um impulso de saude ", "para fortalecer o sistema ", "imunologico dos seus Pokemon!", "50"} 
    };

    public Bag(Game frame) {
        editar(frame);
    }

    private void editar(Game frame) {
        setLayout(new BorderLayout());
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assets/backgroundImages/base-itens.png"));
        JScrollPane scrollPane = listaDeItens();
        background.add(scrollPane);
        background.revalidate();

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            PokemonsBatle pokemonsBatle = new PokemonsBatle(frame);
            frame.mudarTela(pokemonsBatle);
            System.out.println("Voltar apertado!");
        });
        backButton.setBounds(10, 10, 100, 40);
        background.add(backButton);

        add(background, BorderLayout.NORTH);
    }

    private JButton editarBotao(String nome, int x, int y) {
        JButton botao = new JButton(nome);

        botao.setContentAreaFilled(false); 
        botao.setBorderPainted(false); 
        botao.setFont(Fonte.deriveFont(Font.PLAIN,45f));
        botao.setBounds(x, y, 215, 50);

        botao.addActionListener(e -> {
            if (nome.equals("USE")) {
                System.out.println(nome + " apertado!");
                if (selectedIndex != -1) {
                    Player.curar(items[selectedIndex][5]);
                }
                background.setIcon(new ImageIcon("assets/backgroundImages/base-itens.png"));
                useButton.setVisible(false);
                cancelButton.setVisible(false);
                descricaol1.setVisible(false);
                descricaol2.setVisible(false);
                descricaol3.setVisible(false);
                imgItemAtual.setVisible(false);
            } else if (nome.equals("CANCEL")) {
                System.out.println(nome + " apertado!");
                background.setIcon(new ImageIcon("assets/backgroundImages/base-itens.png"));
                useButton.setVisible(false);
                cancelButton.setVisible(false);
                descricaol1.setVisible(false);
                descricaol2.setVisible(false);
                descricaol3.setVisible(false);
                imgItemAtual.setVisible(false);
            }
        });

        return botao;   
    }

    private JScrollPane listaDeItens() {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (int i = 0; i < items.length; i++) {
            modeloLista.addElement(items[i][0].toUpperCase());
        }

        JList<String> listaDeItens = new JList<>(modeloLista);
        listaDeItens.setFont(Fonte.deriveFont(Font.PLAIN,60f));
        listaDeItens.setBackground(new Color(0, 0, 0, 0)); // Tornando a JList transparente
        
        JScrollPane scrollPane = new JScrollPane(listaDeItens);
        scrollPane.setBounds(360, 40, 560, 365);
        scrollPane.getViewport().addChangeListener((e) -> scrollPane.getParent().repaint());
        scrollPane.addMouseWheelListener(e -> repaint());

        descricaol1 = new JLabel();
        descricaol2 = new JLabel();
        descricaol3 = new JLabel(); 
        descricaol1.setBounds(185, 475, 470, 50);
        descricaol2.setBounds(185, 515, 470, 50);
        descricaol3.setBounds(185, 555, 470, 50);
        descricaol1.setFont(Fonte.deriveFont(Font.PLAIN,45));
        descricaol2.setFont(Fonte.deriveFont(Font.PLAIN,45));
        descricaol3.setFont(Fonte.deriveFont(Font.PLAIN,45));
        
        imgItemAtual = new JLabel();
        imgItemAtual.setBounds(32, 497, 96, 96);

        background.add(imgItemAtual);
        background.add(descricaol1);
        background.add(descricaol2);
        background.add(descricaol3);

        listaDeItens.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                if (listaDeItens.getSelectedIndex() != -1) {
                    selectedIndex = listaDeItens.getSelectedIndex();
                    descricaol1.setText(String.format("%s", items[selectedIndex][2]));
                    descricaol2.setText(String.format("%s", items[selectedIndex][3]));
                    descricaol3.setText(String.format("%s", items[selectedIndex][4]));
                    background.setIcon(new ImageIcon("assets/backgroundImages/nova-base.png"));
                    imgItemAtual.setIcon(new ImageIcon(items[selectedIndex][1]));
                    background.revalidate();
                    scrollPane.getParent().repaint();
                    
                    background.add(useButton);
                    background.add(cancelButton);
                    useButton.setVisible(true);
                    cancelButton.setVisible(true);
                    descricaol1.setVisible(true);
                    descricaol2.setVisible(true);
                    descricaol3.setVisible(true);
                    imgItemAtual.setVisible(true);
                }
            }
        });
        
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        scrollPane.revalidate();
        return scrollPane;
    }
}

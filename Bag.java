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
    private JLabel imgItem;
    private String[][] itemNome = { 
        {"Dipirona", "assets/itens/potion (1).png", "Melhor amigo para", "uma dor de cabeca!", ""}, 
        {"Paracetamol", "assets/itens/potion (2).png", "Para quando", "voce se sente um pouco febril.", ""}, 
        {"Dorflex", "assets/itens/potion (3).png", "Diga adeus as dores", "musculares!", ""}, 
        {"Ibuprofeno", "assets/itens/potion (4).png", "Para quando", "voce precisa de um alivio", "rapido da dor."}, 
        {"Losartana", "assets/itens/potion (5).png", "Mantem a pressao", "arterial sob controle.", ""}, 
        {"Xarope", "assets/itens/potion (6).png", "Para quando sua", "garganta precisa de um", "pouco de amor."}, 
        {"Buscopan", "assets/itens/potion (7).png", "Alivio para o", "desconforto abdominal.", ""}, 
        {"Neosoro", "assets/itens/potion (8).png", "Para quando seu", "nariz esta mais entupido que", "um transito na hora do rush."}, 
        {"Torsilax", "assets/itens/potion (9).png", "Para quando voce", "precisa de um alivio extra", "da dor."}, 
        {"Benzetacil", "assets/itens/potion (10).png", "Para quando", "voce precisa de um impulso", "no sistema imunologico."} 
    };

    public Bag(Game frame) {
        editar(frame);
    }

    public Bag() {
        setLayout(new BorderLayout());
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assets/backgroundImages/base-itens.png"));
        JScrollPane scrollPane = listaDeItens();
        background.add(scrollPane);
        background.revalidate();

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            // PokemonsBatle pokemonsBatle = new PokemonsBatle(frame);
            // frame.mudarTela(pokemonsBatle);
            System.out.println("Voltar apertado!");
        });
        backButton.setBounds(10, 10, 100, 40);
        background.add(backButton);

        add(background, BorderLayout.NORTH);
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

    private JLabel itemAtual() {
        JLabel itemAtual = new JLabel();
        itemAtual.setBounds(30, 495, 96, 96);
        return itemAtual;
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
            } else if (nome.equals("CANCEL")) {
                System.out.println(nome + " apertado!");
                useButton.setVisible(false);
                cancelButton.setVisible(false);
                background.setIcon(new ImageIcon("assets/backgroundImages/base-itens.png"));
                descricaol1.setVisible(false);
                descricaol2.setVisible(false);
                descricaol3.setVisible(false);
                imgItem.setVisible(false);
            }
        });

        return botao;   
    }

    private JScrollPane listaDeItens() {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (int i = 0; i < itemNome.length; i++) {
            modeloLista.addElement(itemNome[i][0]);
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
        imgItem = itemAtual();
        background.add(imgItem);
        background.add(descricaol1);
        background.add(descricaol2);
        background.add(descricaol3);

        listaDeItens.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                if (listaDeItens.getSelectedIndex() != -1) {
                    int i = listaDeItens.getSelectedIndex();
                    descricaol1.setText(String.format("%s,  %s", listaDeItens.getSelectedValue(), itemNome[i][2]));
                    descricaol2.setText(String.format("%s", itemNome[i][3]));
                    descricaol3.setText(String.format("%s", itemNome[i][4]));
                    background.setIcon(new ImageIcon("assets/backgroundImages/nova-base.png"));
                    imgItem.setIcon(new ImageIcon(itemNome[i][1]));
                    background.revalidate();
                    scrollPane.getParent().repaint();
                    
                    background.add(useButton);
                    background.add(cancelButton);
                    useButton.setVisible(true);
                    cancelButton.setVisible(true);
                    descricaol1.setVisible(true);
                    descricaol2.setVisible(true);
                    descricaol3.setVisible(true);
                    imgItem.setVisible(true);
                }
            }
        });
        
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        scrollPane.revalidate();
        return scrollPane;
    }
}

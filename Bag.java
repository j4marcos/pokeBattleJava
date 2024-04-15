import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Bag extends JPanel {
    JLabel background = new JLabel();
    Font Fonte = DefinirFonte.fonte();
    private JButton useButton = editarBotao("USE", 715, 485);
    private JButton cancelButton = editarBotao("CANCEL", 715, 545);
    JLabel item;
    JLabel imgItem;

    public Bag(Game frame) {
        editar(frame);
    }

    public void editar(Game frame) {
        setLayout(new BorderLayout());
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundImages/base-itens.png"));
        JScrollPane scrollPane = listaDeItens();
        background.add(scrollPane);
        background.revalidate();

        // esse botao deveria voltar para a tela de batalha, mas nao esta funcionando por algum motivo
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            PokemonsBatle pokemonsBatle = new PokemonsBatle(frame);
            pokemonsBatle.setName("pokemonsBatle");
            frame.mudarTela(pokemonsBatle);
            System.out.println("Voltar apertado!");
        });
        backButton.setBounds(10, 10, 100, 40);
        background.add(backButton);

        add(background, BorderLayout.NORTH);
    }

    public JLabel itemAtual() {
        JLabel itemAtual = new JLabel();
        itemAtual.setBounds(30, 495, 96, 96);

        return itemAtual;
    }

    public JButton editarBotao(String nome, int x, int y) {
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
                background.setIcon(new ImageIcon("assents/backgroundImages/base-itens.png"));
                item.setVisible(false);
                imgItem.setVisible(false);
            }
        });

        return botao;   
    }

    public JScrollPane listaDeItens() {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (int i = 0; i < 20; i++) {
            modeloLista.addElement(String.format("ITEM  %02d", (i + 1)));
        }

        JList<String> listaDeItens = new JList<>(modeloLista);
        listaDeItens.setFont(Fonte.deriveFont(Font.PLAIN,60f));
        listaDeItens.setBackground(new Color(0, 0, 0, 0)); // Tornando a JList transparente
        
        JScrollPane scrollPane = new JScrollPane(listaDeItens);
        scrollPane.setBounds(360, 40, 560, 365);
        scrollPane.getViewport().addChangeListener((e) -> scrollPane.getParent().repaint());

        scrollPane.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                repaint(); 
            }
        });

        item = new JLabel();
        item.setBounds(200, 490, 400, 100);
        item.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        imgItem = itemAtual();
        background.add(imgItem);
        background.add(item);
                        

        listaDeItens.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (listaDeItens.getSelectedIndex() != -1) {
                        item.setText(String.format("%s  is  selected.", listaDeItens.getSelectedValue()));
                        background.setIcon(new ImageIcon("assents/backgroundImages/nova-base.png"));
                        imgItem.setIcon(new ImageIcon("assents/backgroundImages/super-potion.png"));
                        background.revalidate();
                        scrollPane.getParent().repaint();
                        
                        background.add(useButton);
                        background.add(cancelButton);
                        useButton.setVisible(true);
                        cancelButton.setVisible(true);
                        item.setVisible(true);
                        imgItem.setVisible(true);
                    }
                }
            }
        });
        

        scrollPane.setBackground(new Color(0, 0, 0, 0)); // Tornando o JScrollPane transparente
        scrollPane.revalidate();
        return scrollPane;
    }
}

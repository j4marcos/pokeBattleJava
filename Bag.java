import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Bag extends JPanel {
    JLabel background = new JLabel();

    public Bag() {
        editar();
    }

    public void editar() {
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundImages/cabase-itens.png"));
        JScrollPane scrollPane = listaDeItens();
        background.add(scrollPane);

        add(background);
    }

    public JLabel itemAtual() {
        JLabel itemAtual = new JLabel();
        itemAtual.setIcon(new ImageIcon("assents/backgroundImages/super-potion.png")); // link do sprite: https://github.com/msikma/pokesprite/blob/master/items-outline/medicine/super-potion.png
        itemAtual.setBounds(15, 460, 98, 98);

        return itemAtual;
    }

    public JScrollPane listaDeItens() {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (int i = 0; i < 20; i++) {
            modeloLista.addElement(String.format("ITEM %02d", (i + 1)));
        }

        JList<String> listaDeItens = new JList<>(modeloLista);
        listaDeItens.setFont(new Font("Arial", Font.BOLD, 50));
        listaDeItens.setBackground(new Color(0, 0, 0, 0)); // Tornando a JList transparente
        
        JScrollPane scrollPane = new JScrollPane(listaDeItens);
        scrollPane.setBounds(340, 30, 520, 350);

        scrollPane.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                repaint(); 
            }
        });

        listaDeItens.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (listaDeItens.getSelectedIndex() != -1) {
                        JLabel item = new JLabel(String.format("%s is selected.", listaDeItens.getSelectedValue()));
                        item.setBounds(180, 460, 400, 100);
                        item.setFont(new Font("Arial", Font.BOLD, 40));
                        background.setIcon(new ImageIcon("assents/backgroundImages/nova-base.png"));
                        background.add(item);
                        background.add(itemAtual());
                    }
                }
            }
        });
        

        scrollPane.setBackground(new Color(0, 0, 0, 0)); // Tornando o JScrollPane transparente
        
        return scrollPane;
    }
}

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

public class Bag extends JPanel {

    public Bag() {
        editar();
    }

    public void editar() {
        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assents/backgroundsImages/base-itens.png"));
        JScrollPane scrollPane = listaDeItens();
        background.add(scrollPane);
        background.add(itemAtual());

        add(background);
    }

    public JLabel itemAtual() {
        JLabel itemAtual = new JLabel();
        itemAtual.setIcon(new ImageIcon("assents/backgroundsImages/super-potion.png")); // link do sprite: https://github.com/msikma/pokesprite/blob/master/items-outline/medicine/super-potion.png
        itemAtual.setBounds(25, 460, 98, 98);

        return itemAtual;
    }

    public JScrollPane listaDeItens() {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (int i = 0; i < 20; i++) {
            modeloLista.addElement("Item " + (i + 1));
        }

        JList<String> listaDeItens = new JList<>(modeloLista);
        listaDeItens.setFont(new Font("Arial", Font.BOLD, 50));
        listaDeItens.setBackground(new Color(0, 0, 0, 0)); // Tornando a JList transparente
        
        JScrollPane scrollPane = new JScrollPane(listaDeItens);
        scrollPane.setBounds(340, 30, 520, 350);

        scrollPane.addMouseWheelListener(new MouseWheelListener() { // bug corrigido
            public void mouseWheelMoved(MouseWheelEvent e) {
                repaint(); 
            }
        });

        

        scrollPane.setBackground(new Color(0, 0, 0, 0)); // Tornando o JScrollPane transparente
        
        return scrollPane;
    }
}

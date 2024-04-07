// import javax.swing.SwingUtilities;

// public class Main {
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(new Game());
//     }
// }

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuComNavegacao());
    }
}

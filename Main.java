import javax.swing.*;

class Main implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main());
    }

    public void run() {
        JFrame frame = new JFrame("jogo");
        Player player = new Player();
        Enemies enemies = new Enemies();
        Background background = new Background();

        frame.add(player);
        frame.add(enemies);
        frame.add(background);
        frame.setLayout(null);
        frame.setSize(650, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

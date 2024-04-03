import javax.swing.*;

class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("jogo");
        Player player = new Player();
        Background background = new Background();

        frame.add(player);
        frame.add(background);
        frame.setLayout(null);
        frame.setSize(650, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

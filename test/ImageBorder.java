package test;



import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ImageBorder extends JPanel {
    public ImageBorder() {
        // Configuração básica do JPanel
        setPreferredSize(new Dimension(300, 200));
        setBorder(new CustomBorder());
        
        // Adicionando um JLabel para demonstrar o efeito da borda
        JLabel label = new JLabel("Conteúdo do componente");
        add(label);
    }
    
    // Classe para a borda personalizada
    private static class CustomBorder implements Border {
        private Image image;
        
        public CustomBorder() {
            // Carrega a imagem que você deseja usar como borda
            // Substitua "border_image.jpg" pelo caminho da sua própria imagem
            image = new ImageIcon("border_image.jpg").getImage();
        }
        
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            // Desenha a imagem como borda
            g.drawImage(image, 0, 0, c.getWidth(), c.getHeight(), c);
        }
        
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(10, 10, 10, 10); // Ajuste conforme necessário
        }
        
        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Exemplo de borda com imagem");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ImageBorder());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}


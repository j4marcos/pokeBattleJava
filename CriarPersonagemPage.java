import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CriarPersonagemPage extends JPanel{
    private JButton personagem1;
    private JButton personagem2;
    private Font Fonte = DefinirFonte.fonte();
    private JLabel setaSelection = new JLabel(new ImageIcon("assets/battleMenu/seta.png"));

    
    public CriarPersonagemPage(Game frame) {
        editar(frame);
    }

    private void editar(Game frame) {
        setLayout(new BorderLayout());

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assets/backgroundImages/criarPerosnagemBackground.png"));
        background.setBounds(0, 0, 960, 640); 

        JTextField textField = new JTextField();
        textField.setBackground(Color.WHITE);
        textField.setBounds(390, 200, 220, 50);
        textField.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        background.add(textField);


        JButton nextButton = new JButton("OK");
        nextButton.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        nextButton.addActionListener(e -> {
            Tutorial tutorial = new Tutorial(frame, new String[]{ "Escolha seu pokemon Inicial" }, new EscolherPokemonInicial(frame));
            frame.mudarTela(tutorial);
        });
        nextButton.setBounds(760, 520, 110, 35);

        JPanel panelSelecaoPersonagem = new JPanel();
        panelSelecaoPersonagem.setBackground(Color.WHITE);
        panelSelecaoPersonagem.setBounds(90, 320, 620, 260);

        JLabel label = new JLabel("Selecione o personagem");
        label.setFont(Fonte.deriveFont(Font.PLAIN, 50f));
        label.setBounds(200, 320, 620, 50);
        background.add(label);

        ImageIcon image = new ImageIcon("assets/personagens/ash.png");
        Image scaledImage = image.getImage().getScaledInstance(90, 150, Image.SCALE_SMOOTH);
        personagem1 = new JButton(new ImageIcon(scaledImage));
        personagem1.setBounds(150, 380, 200, 200);
        personagem1.setContentAreaFilled(false); // Tirar qualquer coisa que faça os botões ficarem coloridos
        personagem1.setBorderPainted(false); // Tirar as bordas
        personagem1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse sobre ash");
                personagem1.setBorderPainted(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                personagem1.setBorderPainted(false);

            }
            @Override
            public void mouseClicked(MouseEvent e) {
                personagem1.setBackground(new Color(0,0,0,0));
                personagem2.setBackground(new Color(0,0,0,0));

                personagem1.setBackground(Color.GRAY);
            }
        });
        background.add(personagem1);

        ImageIcon img = new ImageIcon("assets/personagens/girl.png");
        Image scaledImage2 = img.getImage().getScaledInstance(90, 150, Image.SCALE_SMOOTH);
        personagem2 = new JButton(new ImageIcon(scaledImage2));
        personagem2.setBounds(450, 380, 200, 200);
        personagem2.setContentAreaFilled(false); // Tirar qualquer coisa que faça os botões ficarem coloridos
        personagem2.setBorderPainted(false); // Tirar as bordas
        personagem2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse sobre girl");
                personagem2.setBorderPainted(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                personagem2.setBorderPainted(false);

            }
            @Override
            public void mouseClicked(MouseEvent e) {
                personagem1.setBackground(new Color(0,0,0,0));
                personagem2.setBackground(new Color(0,0,0,0));

                personagem2.setBackground(Color.GRAY);
            }
        });
        
        background.add(personagem2);

        background.add(panelSelecaoPersonagem);

        background.add(nextButton);

        add(background, BorderLayout.NORTH);
    }
}
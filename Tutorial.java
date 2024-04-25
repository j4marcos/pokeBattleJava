import javax.swing.*;
import java.awt.*;

public class Tutorial extends JPanel {
    private String[] falas = {
        "Ola, bem vindo ao mundo Pokemon!",
        "Neste jogo você enfrentar desafios", 
        "e batalhas para se tornar um mestre Pokemon.",
        "Agora me conte mais sobre voce."
    };
    private int falaIndex = 0;
    private JPanel nextPage;

    public Tutorial(Game frame ,String[] falas, JPanel nextPage) {
        this.falas = falas;
        this.nextPage = nextPage;   
        editar(frame);
    }

    private void editar(Game frame) {
        setLayout(new BorderLayout());
        Font Fonte = DefinirFonte.fonte();

        JLabel background = new JLabel();
        background.setFocusable(true);
        background.setIcon(new ImageIcon("assets/backgroundImages/focusPage.png"));
        background.setBounds(0, 0, 960, 640); 

        JLabel Personagem= new JLabel();
        Personagem.setFocusable(true);
        Personagem.setIcon(new ImageIcon("assets/personagens/professor.png"));
        Personagem.setBounds(  350 , -50 , 960, 640); 

        JLabel TextArea= new JLabel();
        TextArea.setFocusable(true);
        TextArea.setIcon(new ImageIcon("assets/backgroundImages/textarea.png"));
        TextArea.setBounds(  25,200, 960, 640); 

        JButton caixaFalaBtn = new JButton(falas[falaIndex]);
        caixaFalaBtn.setFont(Fonte.deriveFont(Font.PLAIN,50f));
        caixaFalaBtn.setContentAreaFilled(false); // Tirar qualquer coisa que faça os botões ficarem coloridos
        caixaFalaBtn.setBorderPainted(false); // Tirar as bordas
        JButton DialogoBox = caixaFalaBtn;
        DialogoBox.addActionListener(e -> {
            System.out.println("Clicou no botao");
            if (falaIndex < falas.length - 1) {
                System.out.println("Proxima fala");
                falaIndex++;
                DialogoBox.setText(falas[falaIndex]);
                revalidate();
                repaint();
            
            } else {
                System.out.println("proxima cena");
                frame.mudarTela(nextPage);
            }
        });
        DialogoBox.setBounds(  60,450, 850, 140);
        
        background.add(DialogoBox);
        background.add(TextArea);
        background.add(Personagem);

        add(background, BorderLayout.NORTH);
    }
}
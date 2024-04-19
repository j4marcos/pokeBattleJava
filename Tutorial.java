import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tutorial extends JPanel {
    String[] falas = {
        "Olá, bem vindo ao mundo Pokémon!",
        "Neste jogo você enfrentar desafios", 
        "e batalhas para se tornar um mestre Pokémon.",
        "Agora me conte mais sobre você."
    };
    int falaIndex = 0;
    JPanel nextPage;

    public Tutorial(Game frame ,String[] falas, JPanel nextPage) {
        this.falas = falas;
        this.nextPage = nextPage;   
        editar(frame);
    }

    public void editar(Game frame) {
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

        // adicionei esse botao temporario pra testar a batalha
        // JButton nextButton = new JButton("Próximo");
        // nextButton.addActionListener(e -> {
        //     CriarPersonagemPage criarPersonagem = new CriarPersonagemPage(frame);
        //     frame.mudarTela(criarPersonagem);
        // });
        // nextButton.setBounds(800, 20, 100, 40);
        // background.add(nextButton);

       // Label fala = new Label(falas[falaIndex]);
       // fala.setBounds(  25,200, 160, 140);

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
        //DialogoBox.setBackground(Color.BLUE);
        DialogoBox.setBounds(  60,450, 850, 140);

        
        //DialogoBox.add(fala);
        background.add(DialogoBox);

        background.add(TextArea);
        background.add(Personagem);

        add(background, BorderLayout.NORTH);
    }


}
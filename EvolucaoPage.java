// import javax.swing.JPanel;

// public class EvolucaoPage extends JPanel{

//     public EvolucaoPage(Game frame , Pokemon pokemon) {
//         editar(frame);
//     }

//     private void editar(Game frame) {
//         setLayout(new BorderLayout());
//         Font Fonte = DefinirFonte.fonte();

//         JLabel background = new JLabel();
//         background.setFocusable(true);
//         background.setIcon(new ImageIcon("assets/backgroundImages/focusPage.png"));
//         background.setBounds(0, 0, 960, 640); 

//         JLabel Personagem= new JLabel();
//         Personagem.setFocusable(true);
//         Personagem.setIcon(new ImageIcon("assets/personagens/professor.png"));
//         Personagem.setBounds(  350 , -50 , 960, 640); 

//         JLabel TextArea= new JLabel();
//         TextArea.setFocusable(true);
//         TextArea.setIcon(new ImageIcon("assets/backgroundImages/textarea.png"));
//         TextArea.setBounds(  25,200, 960, 640); 

//         JButton caixaFalaBtn = new JButton(falas[falaIndex]);
//         caixaFalaBtn.setFont(Fonte.deriveFont(Font.PLAIN,50f));
//         caixaFalaBtn.setContentAreaFilled(false); // Tirar qualquer coisa que faça os botões ficarem coloridos
//         caixaFalaBtn.setBorderPainted(false); // Tirar as bordas
//         JButton DialogoBox = caixaFalaBtn;
//         DialogoBox.addActionListener(e -> {
//             System.out.println("Clicou no botao");
//             if (falaIndex < falas.length - 1) {
//                 System.out.println("Proxima fala");
//                 falaIndex++;
//                 DialogoBox.setText(falas[falaIndex]);
//                 revalidate();
//                 repaint();
            
//             } else {
//                 System.out.println("proxima cena");
//                 frame.mudarTela(nextPage);
//             }
//         });
//         DialogoBox.setBounds(  60,450, 850, 140);
        
//         background.add(DialogoBox);
//         background.add(TextArea);
//         background.add(Personagem);

//         add(background, BorderLayout.NORTH);
//     }
    
// }

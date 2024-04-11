
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class PokemonsBatle extends JPanel{
    protected InterfaceCaixa interface1;
    private JLabel aliado;
    private JLabel inimigo;

    public PokemonsBatle(){
        setBattleCardLayout();
    }

    public void setBattleCardLayout() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("images/Battle Background.png"));

        interface1 = new InterfaceCaixa();
        
        aliado = new JLabel();
        aliado.setIcon(new ImageIcon("images/charizard costas.png"));
        aliado.setBounds(120, 180, 240, 232);
        
        inimigo = new JLabel();
        inimigo.setIcon(new ImageIcon("images/charizard frente.png"));
        inimigo.setBounds(550, 20, 240, 232);

        label.add(inimigo);
        label.add(aliado);
        add(label, BorderLayout.NORTH);
        add(interface1, BorderLayout.CENTER);
    }
    
}
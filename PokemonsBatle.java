
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class PokemonsBatle extends JPanel{
    protected InterfaceCaixa interface1;

    public PokemonsBatle(){
        setBattleCardLayout();
    }

    public void setBattleCardLayout() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("images/Battle Background.png"));

        interface1 = new InterfaceCaixa();
        add(label, BorderLayout.NORTH);
        add(interface1, BorderLayout.CENTER);

    }
    
}
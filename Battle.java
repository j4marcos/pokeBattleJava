import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class Battle extends JPanel {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    // private Player player; 
    // private Enemy enemy; 
    

    public Battle() {

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel pokemonsSelectionPanel = new JPanel();
        pokemonsSelectionPanel.add(new JLabel("seleção de pokemons"));
        JButton buttonPokemonsSelection = new JButton("cancelar");
        buttonPokemonsSelection.addActionListener(e -> mudarTela("battle"));
        pokemonsSelectionPanel.add(buttonPokemonsSelection);

        JPanel battlePanel = new JPanel();
        battlePanel.add(new PokemonsBatle(null));

        JPanel inventarioPanel = new JPanel();
        inventarioPanel.add(new Bag(null));
        inventarioPanel.setLayout(new GridLayout(1, 1));

        cardPanel.add(battlePanel, "battle"); // Corrigido aqui
        cardPanel.add(pokemonsSelectionPanel, "pokemonsSelection");
        cardPanel.add(inventarioPanel, "inventario");

        add(cardPanel);
        setVisible(true);
    }

    public void mudarTela(String nomeTela) {
        System.out.println("Mudando para a tela " + nomeTela);
        cardLayout.show(cardPanel, nomeTela);
        cardPanel.revalidate();
    }

}
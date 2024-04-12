public class Player {

    Pokemon pokemonSelecionado;

    public Player() {
        pokemonSelecionado = new Pokemon("pokemonSelecionado", 100);
        pokemonSelecionado.imagemLabel.setLocation(120, 180);
    }

}
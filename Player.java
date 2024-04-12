public class Player {

    static Pokemon pokemonSelecionado = new Pokemon("Pokemon 007", 100, "images/charizard costas.png");;

    public Player() {
        pokemonSelecionado = new Pokemon("pokemonSelecionado", 100);
        pokemonSelecionado.imagemLabel.setLocation(120, 180);
    }

    public void atacar() {
        Enemy.inimigoAtual.vida -= 10;
        System.out.println("O pokemon do player atacou o pokemon inimigo e causou 10 de dano");
    }

    public void curar() {
        pokemonSelecionado.vida += 10;
        System.out.println("O pokemon do player foi curado e recuperou 10 de vida");
    }
}
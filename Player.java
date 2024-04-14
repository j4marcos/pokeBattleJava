public class Player {

    static Pokemon pokemonSelecionado;
    static String nome;

    public Player() {
        pokemonSelecionado = new Pokemon("Pokemon 007", 100, "images/charizard costas.png");
    }

    public static void atacar() {
        Enemy.inimigoAtual.vida -= 10;
        System.out.println("O pokemon do player atacou o pokemon inimigo e causou 10 de dano");
        Enemy.trocarInimigo();
        PokemonsBatle.instance.atualizarInimigo();
    }

    public void curar() {
        pokemonSelecionado.vida += 10;
        System.out.println("O pokemon do player foi curado e recuperou 10 de vida");
    }
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void firstPlayerWinTest() {
        Player player1 = new Player(1, "Ivan", 120);
        Player player2 = new Player(2, "Petya", 100);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(1, game.round("Ivan", "Petya"));
    }

    @Test
    public void secondPlayerWinTest() {
        Player player1 = new Player(1, "Ivan", 100);
        Player player2 = new Player(2, "Petya", 120);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(2, game.round("Ivan", "Petya"));
    }

    @Test
    public void tieTest() {
        Player player1 = new Player(1, "Ivan", 100);
        Player player2 = new Player(2, "Petya", 100);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(0, game.round("Ivan", "Petya"));
    }

    @Test
    public void firstPlayerDoesntExistTest() {
        Player player1 = new Player(1, "Ivan", 100);
        Player player2 = new Player(2, "Petya", 120);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sasha", "Petya"));
    }

    @Test
    public void secondPlayerDoesntExistTest() {
        Player player1 = new Player(1, "Ivan", 100);
        Player player2 = new Player(2, "Petya", 120);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ivan", "Dasha"));
    }
}

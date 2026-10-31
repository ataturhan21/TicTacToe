# Tic Tac Toe with JavaFX

A desktop Tic Tac Toe game with a JavaFX interface and an AI opponent.

![Tic Tac Toe Screenshot](screenshot.png)

## Requirements

- JDK 17, matching the compiler target in [pom.xml](tictactoe/pom.xml).
- Maven available as `mvn` on your PATH.
- A graphical desktop session and internet access for the first Maven dependency download.

The project currently pins JavaFX `21-ea+5`. The existing dependency versions are preserved; compatibility with other JavaFX versions is not established here.

## Run locally

```bash
git clone https://github.com/ataturhan21/TicTacToe.git
cd TicTacToe
bash script.sh
```

The launcher finds the nested Maven project relative to its own location and preserves the current display configuration.

On Windows, or to run Maven directly:

```text
cd tictactoe
mvn clean javafx:run
```

To compile and package without opening a game window, run from the repository root:

```bash
mvn -f tictactoe/pom.xml clean package
```

## Play

Click an empty cell to make your move, then wait for the AI. The game announces a winner or a draw. Use **Restart** to clear the board.

## Project guide

| Path | Contents |
| --- | --- |
| [TicTacToe.java](tictactoe/src/main/java/com/fx/tictactoejavafx/TicTacToe.java) | Board UI, game state, winner checks, and AI moves |
| [Resources](tictactoe/src/main/resources/) | Images and JavaFX resources |
| [pom.xml](tictactoe/pom.xml) | Java, JavaFX, and Maven configuration |
| [script.sh](script.sh) | Bash launcher |

If Maven reports a Java version error, compare `java -version` with `mvn -version`; Maven may be using a different JDK. If no window opens in a remote session, configure your desktop display before launching.

## License

See [LICENSE](LICENSE).

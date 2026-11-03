# Tic Tac Toe with JavaFX

[![Tic Tac Toe checks](https://github.com/ataturhan21/TicTacToe/actions/workflows/java-tests.yml/badge.svg)](https://github.com/ataturhan21/TicTacToe/actions/workflows/java-tests.yml)

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

`./script.sh` works too, since the script is executable. The launcher finds the nested Maven project relative to its own location and preserves the current display configuration.

On Windows, or to run Maven directly:

```text
cd tictactoe
mvn clean javafx:run
```

To compile and package without opening a game window, run from the repository root:

```bash
mvn -f tictactoe/pom.xml clean package
```

## Run the tests

The turn-sequencing checks need only a JDK, no display or Maven. From the repository root:

```bash
javac -d out tictactoe/src/main/java/com/fx/tictactoejavafx/TurnState.java tests/TurnStateTest.java
java -cp out com.fx.tictactoejavafx.TurnStateTest
```

A successful run prints a line starting with `PASS:`. GitHub Actions runs the same checks and a Maven package build on every push and pull request.

## Play

Click an empty cell to make your move (you play O), then wait for the AI (X). The game announces a winner or a draw. When the game ends, **Restart** becomes available and clears the board.

## Project guide

| Path | Contents |
| --- | --- |
| [TicTacToe.java](tictactoe/src/main/java/com/fx/tictactoejavafx/TicTacToe.java) | Board UI, game state, winner checks, and AI moves |
| [TurnState.java](tictactoe/src/main/java/com/fx/tictactoejavafx/TurnState.java) | Blocks extra clicks while the AI move is pending and ignores stale AI callbacks |
| [tests/TurnStateTest.java](tests/TurnStateTest.java) | Headless checks for turn sequencing |
| [Resources](tictactoe/src/main/resources/) | O and X mark images |
| [pom.xml](tictactoe/pom.xml) | Java, JavaFX, and Maven configuration |
| [script.sh](script.sh) | Bash launcher |

If Maven reports a Java version error, compare `java -version` with `mvn -version`; Maven may be using a different JDK. If no window opens in a remote session, configure your desktop display before launching.

## License

See [LICENSE](LICENSE).

package com.fx.tictactoejavafx;

/** Run with javac/java; no desktop toolkit or external services required. */
public class TurnStateTest {
    public static void main(String[] args) {
        TurnState state = new TurnState();
        check(state.beginTurn(), "first human move must be accepted");
        long firstRound = state.getGeneration();
        check(!state.beginTurn(), "rapid second human move must be blocked");
        check(state.completeTurn(firstRound), "scheduled AI move must complete once");
        check(!state.completeTurn(firstRound), "duplicate AI callback must be ignored");
        check(state.beginTurn(), "human may play after AI completes");
        check(!state.completeTurn(firstRound), "earlier turn callback must not consume the next turn");
        state.reset();
        check(!state.isWaitingForAi(), "restart must accept input");
        check(state.beginTurn(), "new round human move must be accepted");
        check(!state.completeTurn(firstRound), "old AI callback must not consume new round turn");
        check(state.isWaitingForAi(), "new round must still wait for its own AI callback");
        check(state.completeTurn(state.getGeneration()), "new round AI move must complete");
        System.out.println("PASS: rapid clicks, duplicate callbacks, restart, stale callbacks");
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}

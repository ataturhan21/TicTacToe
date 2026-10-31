package com.fx.tictactoejavafx;

/** Keeps delayed AI callbacks tied to the turn that scheduled them. */
final class TurnState {
    private boolean waitingForAi;
    private long generation;

    boolean beginTurn() {
        if (waitingForAi) return false;
        generation++;
        waitingForAi = true;
        return true;
    }

    boolean completeTurn(long expectedGeneration) {
        if (expectedGeneration != generation || !waitingForAi) return false;
        waitingForAi = false;
        return true;
    }

    boolean isWaitingForAi() {
        return waitingForAi;
    }

    long getGeneration() {
        return generation;
    }

    void reset() {
        generation++;
        waitingForAi = false;
    }
}

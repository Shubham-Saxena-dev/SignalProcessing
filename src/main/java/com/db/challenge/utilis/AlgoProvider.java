package com.db.challenge.utilis;

public enum AlgoProvider {
    INSTANCE;

    private static class AlgoHolder {
        static final Algo algo = new Algo();
    }

    public Algo getAlgo() {
        return AlgoHolder.algo;
    }
}

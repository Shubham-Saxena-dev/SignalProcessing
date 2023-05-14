package com.db.challenge.model;

import com.db.challenge.utilis.Algo;

public class Command {

    private final Algo algo;
    private final int param1;
    private final int param2;

    public Command(Builder builder) {
        this.algo = builder.algo;
        this.param1 = builder.param1;
        this.param2 = builder.param2;
    }

    public Algo getAlgo() {
        return algo;
    }

    public int getParam1() {
        return param1;
    }

    public int getParam2() {
        return param2;
    }

    public static final class Builder {

        private Algo algo;
        private int param1;
        private int param2;

        public Builder setAlgo(Algo algo) {
            this.algo = algo;
            return this;
        }

        public Builder setParam1(int param1) {
            this.param1 = param1;
            return this;
        }

        public Builder setParam2(int param2) {
            this.param2 = param2;
            return this;
        }

        public Command build() {
            return new Command(this);
        }
    }
}

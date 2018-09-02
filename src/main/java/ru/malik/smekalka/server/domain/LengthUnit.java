package ru.malik.smekalka.server.domain;

public enum LengthUnit {
    KILOMETER {
        public double toSI(double value) {
            return value * 1000;
        }

        @Override
        public double fromSI(double value) {
            return value/1000;
        }
    };

    public abstract double toSI(double value);

    public abstract double fromSI(double value);
}

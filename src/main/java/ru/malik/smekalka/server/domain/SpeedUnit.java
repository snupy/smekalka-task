package ru.malik.smekalka.server.domain;

public enum SpeedUnit {
    METER_PER_SECOND {
        public double toSI(double value) {
            return value;
        }

        @Override
        public double fromSI(double value) {
            return value;
        }
    };

    public abstract double toSI(double value);

    public abstract double fromSI(double value);
}
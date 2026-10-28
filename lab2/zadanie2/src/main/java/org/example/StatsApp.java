package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StatsApp {
    public static final class Stats{
        private final double mean;
        private final double sd;
        private final double var;

        Stats(double mean, double sd, double var){
            this.mean = mean;
            this.sd = sd;
            this.var = var;
        }
        public double getMean() { return mean; }
        public double getSd() { return sd; }
        public double getVar() { return var; }

        @Override
        public String toString() {
            return String.format("Srednia: %.4f%nOdchylenie standardowe: %.4f%nWariancja: %.4f",
                    mean, sd, var);
        }
    }

    public static Stats computeStats(double... values){
        if (values == null || values.length == 0){
            throw new IllegalArgumentException("Podaj co najmniej jedna liczbe");
        }
        DescriptiveStatistics ds = new DescriptiveStatistics(values);
        return new Stats(ds.getMean(), ds.getStandardDeviation(), ds.getVariance());
    }

    public static void main(String[] args){
        double[] values = args.length > 0
                ? Arrays.stream(args).mapToDouble(Double::parseDouble).toArray()
                : new double[]{2, 4, 5, 6, 1, 7, 7};
        System.out.println(computeStats(values));
    }
}

class Solution {
    public double[] convertTemperature(double celsius) {
        double[] result = new double[2];
        double c = celsius;
        result[0] =  c + 273.15;
        result[1] =  (c * 1.80) + 32;
        return result;
    }
}
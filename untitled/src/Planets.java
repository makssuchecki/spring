public class Planets {
    private static final double EARTH_YEAR_IN_SECONDS = 31557600.0;
    public static double ageOnAPlanet(int ageInSeconds, String planet){
        double mercuryOrbitInEarthYears = 0.2408467;
        double venusOrbitInEarthYears = 0.61519726;
        double marsOrbitInEarthYears = 1.8808158;
        double jupiterOrbitInEarthYears = 11.862615;
        double saturnOrbitInEarthYears = 29.447498;
        double uranusOrbitInEarthYears = 84.016846;
        double neptunOrbitInEarthYears = 164.79132;

        switch(planet){
            case "Mercury":
                return ageInSeconds / (EARTH_YEAR_IN_SECONDS  * mercuryOrbitInEarthYears);
            case "Venus":
                return ageInSeconds / (EARTH_YEAR_IN_SECONDS  * venusOrbitInEarthYears);
            default:
                return 0.0;
        }
    }
    public static void main(String[] args){
        System.out.println(ageOnAPlanet(1000000000, "Mercury"));

    }
}

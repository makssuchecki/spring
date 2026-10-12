public class Planets {
    private static final double EARTH_YEAR_IN_SECONDS = 31557600.0;
    public static double ageOnAPlanet(int ageInSeconds, String planet){
        double mercuryOrbitInEarthYears = 0.2408467;
        double venusOrbitInEarthYears = 0.61519726;
        double marsOrbitInEarthYears = 1.8808158;
        double jupiterOrbitInEarthYears = 11.862615;
        double saturnOrbitInEarthYears = 29.447498;
        double uranusOrbitInEarthYears = 84.016846;
        double neptuneOrbitInEarthYears = 164.79132;

        return switch (planet) {
            case "Mercury" -> ageInSeconds / (EARTH_YEAR_IN_SECONDS * mercuryOrbitInEarthYears);
            case "Venus" -> ageInSeconds / (EARTH_YEAR_IN_SECONDS * venusOrbitInEarthYears);
            case "Earth" -> ageInSeconds / EARTH_YEAR_IN_SECONDS;
            case "Mars" -> ageInSeconds / (EARTH_YEAR_IN_SECONDS * marsOrbitInEarthYears);
            case "Jupiter" -> ageInSeconds / (EARTH_YEAR_IN_SECONDS * jupiterOrbitInEarthYears);
            case "Saturn" -> ageInSeconds / (EARTH_YEAR_IN_SECONDS * saturnOrbitInEarthYears);
            case "Uranus" -> ageInSeconds / (EARTH_YEAR_IN_SECONDS * uranusOrbitInEarthYears);
            case "Neptune" -> ageInSeconds / (EARTH_YEAR_IN_SECONDS * neptuneOrbitInEarthYears);

            default -> 0.0;
        };
    }

    public static void main(String[] args){
        System.out.println(ageOnAPlanet(1000000000, "Mercury"));
        System.out.println(ageOnAPlanet(1000000000, "Venus"));
        System.out.println(ageOnAPlanet(1000000000, "Jupiter"));
        System.out.println(ageOnAPlanet(1000000000, "Neptune"));

    }
}

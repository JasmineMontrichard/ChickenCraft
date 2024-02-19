
/**
 * This class represents the model, which is the blueprint for each chicken that is created (each instance
 * created of the ChickenModel class).
 *
 * @author Jasmine Montrichard
 * @version 1
 */

public class ChickenModel {
    private String name;
    private String mood;
    private String lifeStatus;
    private int healthHearts;
    private double massSeeds;

    public ChickenModel(String name) {
        this.name = name;
        this.mood = "happy";
        this.lifeStatus = "alive";
        this.healthHearts = 4;
        this.massSeeds = 0.1;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getMood() {
        return mood;
    }

    public String getLifeStatus() {
        return lifeStatus;
    }

    public int getHealthHearts() {
        return healthHearts;
    }

    public double getMassSeeds() {
        return massSeeds;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setLifeStatus(String lifeStatus) {
        this.lifeStatus = lifeStatus;
    }

    public void setHealthHearts(int healthHearts) {
        this.healthHearts = healthHearts;
    }

    public void setMassSeeds(double massSeeds) {
        this.massSeeds = massSeeds;
    }
}
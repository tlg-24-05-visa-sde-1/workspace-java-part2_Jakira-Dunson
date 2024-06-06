package com.entertainment;

import java.util.Objects;

public class Television {

    // static fields and properties

    // properties
    private String brand;
    private int volume;

    // Television HAS-A Tuner (for all things related to channel changing)
    private final Tuner tuner = new Tuner();  // instantiated internally when a Television is created

    // constructors
    public Television() {
        super();
    }

    public Television(String brand, int volume) {
        super();
        setBrand(brand);
        setVolume(volume);
    }

    // business methods
    public int getCurrentChannel() {
        return tuner.getChannel();     // delegate to contained Tuner object
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);     // delegate to contained Tuner object
    }

    // accessor methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int hashCode() {
        // this is a poor hash function, because it easily yields "hash collisions"
        // a "hash collision" is when "different" objects happen to have the same hashcode by dumb luck.
        // return getBrand().length() + getVolume();

        // this is a "scientifically correct" hash function, i.e.,
        // it minimizes the probability of hash collisions
        //this combines the hash codes from brand and volume and combines it as one
        return Objects.hash(getBrand(), getVolume());
    }

    // equals()
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        // check that 'obj' is really referring to a Television object
        //if (obj instanceof Television) {This is a IS -A  check
        if (this.getClass() == obj.getClass()) { //are we the exact same type
            //If obj is an instance of Television, we cast obj to a Television type and assign it to a new variable other.
            // This allows us to access Television-specific methods and fields.
            // downcast 'obj' to more specific reference type Television, for getName(), getAge()
            Television other = (Television) obj;

            // do the checks: business equality is defined as brand, volume
            //the current object is the 'this' the other obj is the 'other'
            //Objects.equals(this.getBrand(), other.getBrand()): This checks if the brand of both televisions are equal.
            // The Objects.equals method is used for a null-safe check (i.e., it handles cases where either or both brands might be null).
            //this.getVolume() == other.getVolume(): This checks if the volume of both televisions are equal.
            // Since volume is likely a primitive type (e.g., int), it cannot be null.
            result = Objects.equals(this.getBrand(), other.getBrand()) &&  // null-safe check
                    this.getVolume() == other.getVolume();                // primitives can't be null
        }
        return result;
    }

    // toString()
    @Override
    public String toString() {
        return String.format("%s: brand=%s, volume=%s, currentChannel=%s",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }
}
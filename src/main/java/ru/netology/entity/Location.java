package ru.netology.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int builing;

    public Location(String city, Country country, String street, int builing) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.builing = builing;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuiling() {
        return builing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, street, builing);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Location loc = (Location) obj;
        return StringUtils.equals(city, loc.city) &&
                (country == loc.country) &&
                StringUtils.equals(street, loc.street) &&
                (builing == loc.builing);
    }
}

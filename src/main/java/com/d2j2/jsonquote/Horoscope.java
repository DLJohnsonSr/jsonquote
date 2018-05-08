package com.d2j2.jsonquote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Horoscope {

    private String horoscope;
    private String sunsign;
    private String week;

    public Horoscope() {
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getSunsign() {
        return sunsign;
    }

    public void setSunsign(String sunsign) {
        this.sunsign = sunsign;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "Horoscope{" +
                "horoscope='" + horoscope + '\'' +
                ", sunsign='" + sunsign + '\'' +
                ", week='" + week + '\'' +
                '}';
    }
}

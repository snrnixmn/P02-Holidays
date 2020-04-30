package com.example.p02_holidays;

public class Holidays {
    private String holiday;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Holidays(String holiday, String date) {
        this.holiday = holiday;
        this.date = date;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

}

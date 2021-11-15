package com.example.bankappnew._pojo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class items {
    public static class Atm {
        String address;
        String type;
        boolean isWork;
        Date startTime;
        Date endTime;

        public Atm(String address, String type, Date startTime, Date endTime) {
            this.address = address;
            this.type = type;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getAddress() {
            return address;
        }

        public String getType() {
            return type;
        }

        public boolean isWork() {
            Date currentTime = new Date();
            return currentTime.after(startTime) && currentTime.before(endTime);
        }

        public Date getStartTime() {
            return startTime;
        }

        public Date getEndTime() {
            return endTime;
        }
    }

    public static class Course {
        int icon;
        String name;
        String fullName;
        String buy;
        String sell;

        public Course(int icon, String name, String fullName, String buy, String sell) {
            this.icon = icon;
            this.name = name;
            this.fullName = fullName;
            this.buy = buy;
            this.sell = sell;
        }

        public int getIcon() {
            return icon;
        }

        public String getName() {
            return name;
        }

        public String getFullName() {
            return fullName;
        }

        public String getBuy() {
            return buy;
        }

        public String getSell() {
            return sell;
        }
    }

}

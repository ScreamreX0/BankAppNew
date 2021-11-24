package com.example.bankappnew._pojo;

import com.example.bankappnew.menu.IMenuItems;

import java.util.Date;

public class items {
    public static class Atm {
        String address;
        String type;
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

        public String isWork() {
            Date currentTime = new Date();
            if (currentTime.after(startTime) && currentTime.before(endTime)) {
                return "Работает";
            } else {
                return "Не работает";
            }

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

    public static class MenuHeader implements IMenuItems {
        String header;

        public MenuHeader(String header) {
            this.header = header;
        }

        public String getHeader() {
            return header;
        }

        @Override
        public int getType() {
            return 0;
        }
    }

    public static class Card implements IMenuItems {
        private final int icon;
        private final String cardNumber;
        private final String money;

        public Card(int icon, String cardNumber, String money) {
            this.icon = icon;
            this.cardNumber = cardNumber;
            this.money = money;
        }

        public int getIcon() {
            return icon;
        }

        public String getCardNumber(boolean hide) {
            if (hide) {
                return cardNumber.substring(0, 4) + "***" + cardNumber.substring(12, 16);
            } else {
                return cardNumber;
            }
        }

        public String getMoney() {
            return money + " рублей";
        }

        @Override
        public int getType() {
            return 1;
        }
    }

    public static class Account implements IMenuItems {
        private final String accountNumber;
        private final String money;

        public Account(String accountNumber, String money) {
            this.accountNumber = accountNumber;
            this.money = money;
        }

        public String getAccountNumber(boolean hide) {
            if (hide) {
                return accountNumber.substring(5, 10);
            } else {
                return accountNumber;
            }
        }

        public String getMoney() {
            return money + " рублей";
        }

        @Override
        public int getType() {
            return 2;
        }
    }

    public static class Credit implements IMenuItems {
        private final String paymentDate;
        private final String money;

        public Credit(String paymentDate, String money) {
            this.paymentDate = paymentDate;
            this.money = money;
        }

        public String getPaymentDate() {
            return "Платеж " + paymentDate;
        }

        public String getMoney() {
            return money + " рублей";
        }


        @Override
        public int getType() {
            return 3;
        }
    }

    public static class Setting {
        String header;

        public Setting(String header) {
            this.header = header;
        }

        public String getHeader() {
            return header;
        }
    }

}

package ru.job4j.tracker.stream;

public class TradeMark {
    private String product;
    private String manufacturer;
    private String country;
    private String sector;
    private int position;
    private int amount;
    private double price;

    public static class Builder {
        private String product;
        private String manufacturer;
        private String country;
        private String sector;
        private int position;
        private int amount;
        private double price;

        Builder buildProduct(String product) {
            this.product = product;
            return this;
        }

        Builder buildManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        Builder buildCountry(String country) {
            this.country = country;
            return this;
        }

        Builder buildSector(String sector) {
            this.sector = sector;
            return this;
        }

        Builder buildPosition(int position) {
            this.position = position;
            return this;
        }

        Builder buildAmount(int amount) {
            this.amount = amount;
            return this;
        }

        Builder buildPrice(double price) {
            this.price = price;
            return this;
        }

        TradeMark build() {
            TradeMark trade = new TradeMark();
            trade.product = product;
            trade.manufacturer = manufacturer;
            trade.country = country;
            trade.sector = sector;
            trade.position = position;
            trade.amount = amount;
            trade.price = price;
            return trade;
        }
    }

    @Override
    public String toString() {
        return "TradeMark{" + "product='" + product + '\''
                + ", manufacturer='" + manufacturer + '\''
                + ", country='" + country + '\''
                + ", sector='" + sector + '\''
                + ", position=" + position
                + ", amount=" + amount
                + ", price=" + price + '}';
    }

    public static void main(String[] args) {
        TradeMark trade = new Builder().buildProduct("Sugar")
                .buildManufacturer("ABF")
                .buildCountry("Great Britain")
                .buildSector("wholesale")
                .buildPosition(158)
                .buildAmount(39580)
                .buildPrice(3.39D)
                .build();
        System.out.println(trade);
    }
}

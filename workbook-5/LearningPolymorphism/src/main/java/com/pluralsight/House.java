
package com.pluralsight;

    class House extends Asset {
        // Create the variables, as private.
        private String address;
        private int condition;
        private int squareFoot;
        private int lotSize;

        // Create the contructor.
        public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
            super(description, dateAcquired, originalCost);
            this.address = address;
            this.condition = condition;
            this.squareFoot = squareFoot;
            this.lotSize = lotSize;
        }

        // Create the getters and setters.
        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public double getValue() {
            double value;
            switch (condition) {
                case 1:
                    value = 180.00 * squareFoot;
                    break;
                case 2:
                    value = 130.00 * squareFoot;
                    break;
                case 3:
                    value = 90.00 * squareFoot;
                    break;
                case 4:
                    value = 80.00 * squareFoot;
                    break;
                default:
                    value = 0;
            }
            value += 0.25 * lotSize;
            return value;
        }
    }

}

public class VehicleDriver {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[20];
        int counter=0;
        vehicles[0] = new Vehicle(101212,"Toyota Camry","White", 121000,22000);
        vehicles[1] = new Vehicle(312542,"Ford Explorer","Black",200000,35000);
        vehicles[2] = new Vehicle(427813,"Honda Civic","Green",121000,15000);
        vehicles[3] = new Vehicle(231056,"Toyota Corolla","Red",89000,15000);
        vehicles[4] = new Vehicle(293130,"Mercedes Benz","Silver",67000, 55000);
        vehicles[5] = new Vehicle(005014,"Volkswagen Beetle","Red",151000,11000);
        System.out.println("What do you want to do?");
        System.out.println(" 1 - List all vehicles");
        System.out.println(" 2 - Search by make/model");
        System.out.println(" 3 - Search by price range");
        System.out.println(" 4 - Search by color");
        System.out.println(" 5 - Add a vehicle");
        System.out.println(" 6 - Quit");
        System.out.println("Enter your command: ");
        int command = scanner.nextInt();
        //  while (command != 6) {
        switch (command) {
            case 1:
                listAllVehicles(vehicles);
                break;
            case 2:
                findVehiclesByMakeModel(vehicles, "Toyota Camry");
                break;
            case 5:
                addAVehicle(vehicles,vehicle );
                break;
            case 6:
                return;
            //  }
        }
    }

    private static void addAVehicle(Vehicle[] vehicles, Vehicle vehicle) {
        for (int i = 0; i < vehicles.length; i++) {
            if(vehicles[i] ==null){
                vehicles[i] = vehicle;
                break;
            }
        }
    }

    private static void findVehiclesByMakeModel(Vehicle[] vehicles, String make) {
        for (Vehicle vehicle: vehicles){
            if (vehicle.getMakeModel().equals(make)){
                System.out.println(vehicle);
            }
        }

    }

    private static void listAllVehicles(Vehicle[] vehicles) {
        for (Vehicle vehicle: vehicles){
            if(vehicle!=null){
                System.out.println(vehicle);
            }
        }
    }
}


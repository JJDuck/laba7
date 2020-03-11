public class Vehicle {
    private String registrationNumber;
    private String manufacturer;
    private String model;
    private VehicleTypes type;
    public static Vehicle NO_VEHICLE = new Vehicle();

    public Vehicle(){
        registrationNumber = "";
        manufacturer = "";
        model = "";
        type = VehicleTypes.NONE;
    }

    public Vehicle(String registrationNumber, String manufacturer, String model, VehicleTypes type){
        this.registrationNumber = registrationNumber;
        this.manufacturer = manufacturer;
        this.model=model;
        this.type = type;
    }

    public VehicleTypes getType(){
        return type;
    }
    public String getRegistrationNumber(){
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }

    public  String getManufacturer(){
        return manufacturer;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }


}

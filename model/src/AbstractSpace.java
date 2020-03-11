public abstract class AbstractSpace implements  Space {
    private Person person;
    private Vehicle vehicle;
    protected AbstractSpace(){
        person = Person.UNKNOWN_PERSON;
        vehicle = Vehicle.NO_VEHICLE;
    }
    protected AbstractSpace(Person person){
        this.person = person;
        vehicle = Vehicle.NO_VEHICLE;
    }
    protected AbstractSpace(Person person, Vehicle vehicle){
        this.person = person;
        this.vehicle = vehicle;
    }

    public Person getPerson(){
        return person;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }

    public  void setPerson(Person person){
        this.person = person;
    }

    public  void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public boolean isEmpty(){
        return vehicle.equals(Vehicle.NO_VEHICLE)||vehicle.getType().equals(VehicleTypes.NONE);
    }
}

public interface Floor {
    public boolean add(Space space);
    public boolean add(int index, Space space);
    public Space get(int index);
    public Space get(String registrationNumber);
    public int hasSpace(String registrationNumber);
    public Space set(int index, Space space);
    public Space remove(int index);
    public Space remove(String registrationNumber);
    public int size();
    public Vehicle[] getVehicles();
    public void increaseArray();
    public Space[] getSpaces();
    public Space[] getSpaces(VehicleTypes vehicleTypes);
    public Space[] getEmptySpaces();
}

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Parking {
    private Floor[] floors;
    private int size;
    private int count;

    public Parking(int size){
        this.size = size;
        this.floors = new Floor[size];
    }

    public Parking(Floor[] ownersFloors){
        this.floors = ownersFloors;
    }

    public boolean add(Floor floor){
        if (floor == null){
            throw new NullPointerException("Exception: floor is null!");
        }
        boolean temp = false;
        for (int i = size-1; i >= 0; i--){
            if (floors[i]==null){
                floors[i] =floor;
                count++;
                temp = true;
                break;
            }
        }
        if (temp){
            return temp;
        }
        else{
            increaseArray();
            return temp;
        }

    }

    public boolean add(int index, Floor floor){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("Exception: IndexOutOfBoundsException!");
        }
        if (floor == null){
            throw new NullPointerException("Exception: floor is null!");
        }
        if (index<size && floors[index]==null){
            floors[index] =floor;
            count++;
            return true;
        }
        else{
            increaseArray();
            return false;
        }
    }

    public Floor get(int index){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("Exception: IndexOutOfBoundsException!");
        }
        return floors[index];
    }

    public Floor set(int index, Floor floor){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("Exception: IndexOutOfBoundsException!");
        }
        if (floor == null){
            throw new NullPointerException("Exception: floor is null!");
        }
        if (index < size){
            floors[index] = floor;
            return floors[index];
        }
        else {
            return null;
        }
    }

    public Floor remove(int index){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("Exception: IndexOutOfBoundsException!");
        }
        if (index < size && floors[index]!=null){
            Floor floor = floors[index];
            count--;
            for (int i=index+1;i<size;i++){
                floors[i-1] = floors[i];
            }

            floors[size-1]=null;
            return floor;
        }
        else {
            return null;
        }
    }

    public int size(){
        return count;
    }

    public Floor[] getFloors() {
        return floors;
    }
    public Floor[] getFloorsSort(){
        Floor[] sortFloors = floors;
        Floor floor;
        for (int i = 0; i < size-1; i++) {
            for (int j = 1; j < size; j++) {
                if (sortFloors[i].size()<sortFloors[j].size()){
                    floor = sortFloors[i];
                    sortFloors[i]= sortFloors[j];
                    sortFloors[j] = floor;
                }
            }
        }
        return  sortFloors;
    }

    public Vehicle[] getVehicle(){
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            if (floors[i]!=null){
                size+=floors[i].size();
            }
        }
        int k = 0;
        Vehicle[] getVehicle = new Vehicle[size];
        for (int i = 0; i < this.size; i++) {
            Vehicle[] newGetVehicle = floors[i].getVehicles();
            if (floors[i].size()!=0){
                for (int j = 0; j < size; j++) {
                    getVehicle[k]=newGetVehicle[j];
                    k++;
                }
            }

        }
        return  getVehicle;
    }

    public Space getSpace(String registrationNumber){
        if (registrationNumber == null){
            throw new NullPointerException("Exception: registrationNumber is null!");
        }
        if (!Pattern.matches("[ABEKMHOPCTYX]\\d\\d\\d[ABEKMHOPCTYX][ABEKMHOPCTYX]\\d{2,3}",registrationNumber)){
            throw new RegistrationNumberFormatException("Exception: wrong format registrationNumber!");
        }
        for (int i = 0; i < size; i++) {
            Space[] getSpace = floors[i].getSpaces();
            for (int j = 0; j < floors[i].size(); j++) {
                if (getSpace[j].getVehicle().getRegistrationNumber().equals(registrationNumber)){
                    return getSpace[j];
                }
            }
        }
        throw new NoSuchElementException("Exception: not found space with registrationNumber!");
    }

    public Space removeSpace(String registrationNumber){
        if (registrationNumber == null){
            throw new NullPointerException("Exception: registrationNumber is null!");
        }
        if (!Pattern.matches("[ABEKMHOPCTYX]\\d\\d\\d[ABEKMHOPCTYX][ABEKMHOPCTYX]\\d{2,3}",registrationNumber)){
            throw new RegistrationNumberFormatException("Exception: wrong format registrationNumber!");
        }
        for (int i = 0; i < size; i++) {
            Space[] getSpace = floors[i].getSpaces();
            for (int j = 0; j < floors[i].size(); j++) {
                if (getSpace[j].getVehicle().getRegistrationNumber().equals(registrationNumber)){
                    return floors[i].remove(registrationNumber);
                }
            }
        }
        throw new NoSuchElementException("Exception: not found space with registrationNumber!");
    }

    public Space setSpace(String registrationNumber, Space space){
        if (registrationNumber == null){
            throw new NullPointerException("Exception: registrationNumber is null!");
        }
        if (space == null){
            throw new NullPointerException("Exception: space is null!");
        }
        if (!Pattern.matches("[ABEKMHOPCTYX]\\d\\d\\d[ABEKMHOPCTYX][ABEKMHOPCTYX]\\d{2,3}",registrationNumber)){
            throw new RegistrationNumberFormatException("Exception: wrong format registrationNumber!");
        }
        for (int i = 0; i < size; i++) {
            Space[] getSpace = floors[i].getSpaces();
            for (int j = 0; j < floors[i].size(); j++) {
                if (getSpace[j].getVehicle().getRegistrationNumber().equals(registrationNumber)){
                    return floors[i].set(j,space);

                }
            }
        }
        throw new NoSuchElementException("Exception: not found space with registrationNumber!");
    }

    public int imptySpacesQuantity(){
        int count = 0;
        Floor floors[] = getFloors();
        for (int i = 0; i < size; i++) {
            count += floors[i].getEmptySpaces().length;
        }
        return count;
    }

    public int vehiclesQuantity(VehicleTypes vehicleTypes){
        if (vehicleTypes == null){
            throw new NullPointerException("Exception: vehicleTypes is null!");
        }
        int count = 0;
        Floor floors[] = getFloors();
        for (int i = 0; i < size; i++) {
            count+=floors[i].getSpaces(vehicleTypes).length;
        }
        return count;
    }

    public void increaseArray(){
        Floor newFloors[] = new Floor[this.size*2];
        for (int i = 0;i<size;i++)
        {
            newFloors[i]=floors[i];
        }
        size *=2;
        floors = newFloors;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(String.format("Floors (%d total):\n",size()));
        Floor[] returnSpace = getFloors();
        for (int i = 0; i < returnSpace.length; i++) {
            sb.append(returnSpace[i].toString()+"\n");
        }
        return sb.toString();
    }

    public Floor[] getFloorsWithPerson(Person person){
        if (person == null){
            throw new NullPointerException("Exception: person is null!");
        }
        int j=0;
        for (int i = 0; i < size; i++) {
            if (floors[i]!=null && floors[i].spacesQuantity(person)!=0){
                j++;
            }
        }
        Floor[] floorsWithPerson = new Floor[j];
        j=0;
        for (int i = 0; i < size; i++) {
            if (floors[i]!=null && floors[i].spacesQuantity(person)!=0){
                floorsWithPerson[j] = floors[i];
                j++;
            }
        }
        return  floorsWithPerson;
    }

}

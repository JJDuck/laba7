public class OwnersFloor implements Floor {
    private Space[] spaces;
    private int size;
    private int count;
    public OwnersFloor(){
        this.size = 16;
        this.spaces = new Space[size];
        this.count=0;
    }

    public OwnersFloor(int size){
        this.size = size;
        this.spaces = new Space[size];
        this.count=0;
    }

    public OwnersFloor(Space[] spaces){
        this.size = size();
        this.spaces = spaces;
    }



    public boolean add(Space space){
        boolean temp = false;
        for (int i = size-1; i >= 0; i--){
            if (spaces[i]==null){
                spaces[i] =space;
                count++;
                temp = true;
                break;
            }
        }
        return temp;
    }

    public boolean add(int index, Space space){
        if (index<size && spaces[index]==null){
            spaces[index] =space;
            count++;
            return true;
        }
        else{
            return false;
        }
    }

    public Space get(int index){
        return spaces[index];
    }

    public Space get(String registrationNumber){
        for (int i = 0;i<size;i++)
        {
            if (spaces[i]!=null && spaces[i].getVehicle().getRegistrationNumber().equals(registrationNumber)){
                return spaces[i];
            }
        }
        return null;
    }

    public int hasSpace(String registrationNumber){
        for (int i = 0;i<size;i++)
        {
            if (spaces[i]!=null && spaces[i].getVehicle().getRegistrationNumber().equals(registrationNumber)){
                return i;
            }
        }
        return -1;
    }

    public Space set(int index, Space space){
        if (index < size){
            spaces[index] = space;
            return spaces[index];
        }
        else {
            return null;
        }
    }

    public Space remove(int index){
        if (index < size && spaces[index]!=null){
            Space space = spaces[index];
            count--;
            for (int i=index+1;i<size;i++){
                spaces[i-1] = spaces[i];
            }

            spaces[size-1]=null;
            return space;
        }
        else {
            return null;
        }
    }

    public Space remove(String registrationNumber){
        for (int i = 0;i<size;i++)
        {
            if (spaces[i]!=null && spaces[i].getVehicle().getRegistrationNumber().equals(registrationNumber)){
                Space space = spaces[i];
                count--;
                for (int j = i+1;j<size;j++){
                    spaces[j-1] = spaces[j];
                }
                spaces[size-1]=null;
                return space;
            }
        }
        return null;
    }

    public int size() {
        return count;
    }

    public Space[] getSpaces() {
        Space[] getSpaces = new Space[count];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (spaces[i]!=null){
                getSpaces[j]=spaces[i];
                j++;
            }
        }
        return getSpaces;
    }

    public Space[] getEmptySpaces() {
        Space[] getSpaces = new Space[getSpaces().length];
        int j = 0;
        for (int i = 0; i < getSpaces().length; i++) {
            if (getSpaces()[i].isEmpty()){
                getSpaces[j]=getSpaces()[i];
                j++;
            }
        }
        Space[] returnSpace = new Space[j];
        int k = 0;
        for (int i = 0; i < j; i++) {
            if (getSpaces[i]!=null){
                returnSpace[k] = getSpaces[i];
                k++;
            }
        }
        return returnSpace;
    }

    public Space[] getSpaces(VehicleTypes vehicleTypes){
        Space[] getSpaces = getSpaces();
        Space[] getTypesSpaces = new Space[count];
        int j = 0;
        for (int i = 0; i < count; i++) {
            if (getSpaces[i].getVehicle().getType().equals(vehicleTypes)){
                getSpaces[j]=getSpaces[i];
                j++;
            }
        }
        Space[] returnSpace = new Space[j];
        int k = 0;
        for (int i = 0; i < j; i++) {
            if (getSpaces[i]!=null){
                returnSpace[k] = getSpaces[i];
                k++;
            }
        }
        return returnSpace;
    }

    public Vehicle[] getVehicles(){
        Vehicle[] getVehicles = new Vehicle[count];
        int j= 0;
        for (int i = 0; i < size; i++) {
            if (spaces[i] != null) {
                getVehicles[j] = spaces[i].getVehicle();
                j++;
            }
        }
        return getVehicles;
    }

    public void increaseArray(){
        Space newSpaces[] = new Space[this.size*2];
        for (int i = 0;i<size;i++)
        {
            newSpaces[i]=spaces[i];
        }
        size *=2;
        spaces = newSpaces;
    }

}

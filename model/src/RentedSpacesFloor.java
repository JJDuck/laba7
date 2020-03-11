public class  RentedSpacesFloor implements Floor{
    private Node head;
    private int size;
    public RentedSpacesFloor(){
        initialHead();
    }

    public RentedSpacesFloor(Space[] spaces){
        for (Space space : spaces) {
            addNode(space);
        }
    }

    private void initialHead(){
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    private Node getNodeByIndex(int index) {
        Node node = head;
        for (; index != 0; index--) {
            node = node.next;
        }
        return node;
    }

    private void addNode(Space space) {
        if (head == null) {
            initialHead();
        }
        Node node = head;
        for (int i = 0; i < size; i++) {
            node = node.next;
        }
        node.next = new Node(space, node.next, node);
        node.previous = node.next;
        size++;
    }

    @Override
    public boolean add(Space space) {
        return add(size,space);
    }

    @Override
    public boolean add(int index, Space space) {
        Node newNodes = new Node(space);
        Node currentNodes = getNodeByIndex(index);
        newNodes.next = currentNodes.next;
        newNodes.previous = currentNodes;
        currentNodes.next = newNodes;
        size++;
        return true;
    }

    @Override
    public Space get(int index) {
        return getNodeByIndex(index + 1).value;
    }

    @Override
    public Space get(String registrationNumber) {
        Node node = head.next;
        for (int i = 0; i < size; i++, node = node.next) {
            if (node.value.getVehicle().getRegistrationNumber().equals(registrationNumber)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public int hasSpace(String registrationNumber) {
        Node node = head.next;
        for (int i = 0; i < size; i++, node = node.next) {
            if (node.value.getVehicle().getRegistrationNumber().equals(registrationNumber)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Space set(int index, Space space) {
        Node node = getNodeByIndex(index + 1);
        Space oldSpace = node.value;
        node.value = space;
        return oldSpace;
    }

    @Override
    public Space remove(int index) {
        Node node = getNodeByIndex(index);
        Space removedSpace = node.next.value;
        node.next = node.next.next;
        node.next.next.previous = node;
        size--;
        return removedSpace;
    }

    @Override
    public Space remove(String registrationNumber) {
        return remove(hasSpace(registrationNumber));
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Vehicle[] getVehicles() {
        Vehicle[] vehicles = new Vehicle[size];
        Node node = head.next;
        for (int i = 0; i < size; i++, node = node.next) {
            vehicles[i] = node.value.getVehicle();
        }
        return vehicles;
    }

    @Override
    public void increaseArray() {

    }

    @Override
    public Space[] getSpaces() {
        Space[] spaces = new Space[size];
        Node node = head.next;
        for (int i = 0; i < size; i++, node = node.next) {
            spaces[i] = node.value;
        }
        return spaces;
    }

    public Space[] getSpaces(VehicleTypes vehicleTypes) {
        Space[] spaces = new Space[size];
        Node node = head.next;
        int j = 0;
        for (int i = 0; i < size; i++, node = node.next) {
            if (node.value.getVehicle().getType().equals(vehicleTypes)){
                spaces[j] = node.value;
                j++;
            }

        }
        Space[] returnSpace = new Space[j];
        int k = 0;
        for (int i = 0; i < j; i++) {
            if (spaces[i]!=null){
                returnSpace[k] = spaces[i];
                k++;
            }
        }
        return returnSpace;
    }

    public Space[] getEmptySpaces() {
        Space[] spaces = new Space[size];
        Node node = head.next;
        int j = 0;
        for (int i = 0; i < size; i++, node = node.next) {
            if (node.value.isEmpty()){
                spaces[i] = node.value;
                j++;
            }
        }
        Space[] returnSpace = new Space[j];
        int k = 0;
        for (int i = 0; i < j; i++) {
            if (spaces[i]!=null){
                returnSpace[k] = spaces[i];
                k++;
            }
        }
        return returnSpace;
    }


    public class Node {
        Node next;
        Node previous;
        Space value;
        Node(Space value){
            this.value = value;
        }
        Node(Space value, Node next, Node previous){
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}

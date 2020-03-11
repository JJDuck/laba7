public class Test {
    static void lab1testsOwnersFloor(){
        Person nik = new Person("Николай","Щербаков");
        Person art = new Person("Артем","Бондарев");
        Person anonim = new Person("Ким","Кимыч");
        Person max = new Person("Максим","Данилин");
        Vehicle gran = new Vehicle("1234","Lada", "Granta",VehicleTypes.CAR);
        Vehicle mas = new Vehicle("000", "mazda", "cx 5",VehicleTypes.CAR);
        OwnersFloor ownersFloor = new OwnersFloor(3);
        RentedSpace space = new RentedSpace(nik,gran);
        RentedSpace space1  = new RentedSpace(art,gran);
        RentedSpace space2 = new RentedSpace(anonim,mas);
        RentedSpace space3 = new RentedSpace(max,mas);
        while (!ownersFloor.add(4,space)){
            ownersFloor.increaseArray();
        }
        System.out.println(ownersFloor.add(space));
        System.out.println(ownersFloor.add(space1));
        System.out.println(ownersFloor.add(2,space2));
        System.out.println(ownersFloor.add(space3));
        ownersFloor.get("1234");
        System.out.println(ownersFloor.get("1234"));
        System.out.println(ownersFloor.get(2));
        System.out.println(ownersFloor.hasSpace("123"));
        System.out.println(ownersFloor.remove(0));
        System.out.println(ownersFloor.size());
        Space[] receiveSpace = ownersFloor.getSpaces();
        for (int i = 0; i < ownersFloor.size(); i++) {
            System.out.println(receiveSpace[i].getPerson().getFirstName());
        }
        Vehicle[] receiveVehicle = ownersFloor.getVehicles();
        for (int i = 0; i < ownersFloor.size(); i++) {
            System.out.println(receiveVehicle[i].getRegistrationNumber());
        }
        Space space4 = new RentedSpace(nik,mas);

        Parking parking = new Parking(3);
        parking.add(ownersFloor);
        parking.add(new OwnersFloor(10));
        parking.add(new OwnersFloor(6));

        Floor[] floors = parking.getFloors();
        for (int i = 0; i < parking.size(); i++) {
            System.out.println(floors[i]);
        }
        Floor[] sortFloors = parking.getFloorsSort();
        for (int i = 0; i < parking.size(); i++){
            System.out.println(sortFloors[i]);
        }

        System.out.println(parking.getVehicle());

        System.out.println(parking.getSpace("1234"));
        System.out.println(parking.removeSpace("1234"));
        System.out.println(parking.setSpace("1234",space1));

    }

    static void lab2tests(){
        Person nik = new Person("Николай","Щербаков");
        Person art = new Person("Артем","Бондарев");
        Person max = new Person("Максим","Данилин");
        Person vach = new Person("Вячеслав","Сучков");
        Person anonim = new Person("Ким","Кимыч");
        Vehicle gran = new Vehicle("1234","Lada", "Granta",VehicleTypes.CAR);
        Vehicle mas = new Vehicle("0000", "Mazda", "cx 5",VehicleTypes.CAR);
        Vehicle volk = new Vehicle("1928", "Volkswagen", "Polo",VehicleTypes.CAR);
        Vehicle ren = new Vehicle("5557", "Renault", "Sandero",VehicleTypes.CAR);
        Vehicle kia = new Vehicle("2548", "KIA", "Rio",VehicleTypes.CAR);
        Space space1 = new RentedSpace(nik,kia);
        Space space2 = new RentedSpace(max,volk);
        Space space3 = new RentedSpace(art,mas);
        Space space4 = new RentedSpace(anonim,gran);
        Space space5 = new RentedSpace(vach,ren);
        System.out.println(space1.getVehicle().getRegistrationNumber());
        System.out.println(space2.isEmpty());
        Parking parking = new Parking(3);
        parking.add(new RentedSpacesFloor());
        parking.add(new RentedSpacesFloor());
        parking.add(new RentedSpacesFloor());
        parking.get(0).add(space1);
        parking.get(0).add(space4);
        parking.get(0).add(0,space5);
        parking.get(1).add(space3);
        parking.get(2).add(space2);
        parking.get(2).add(space4);
        for (int i = 0; i < parking.size(); i++) {
            System.out.println("Этаж"+ (i+1));
            for (int j = 0; j < parking.get(i).size(); j++) {
                System.out.println(parking.get(i).get(j).getPerson().getFirstName()+"-"+parking.get(i).get(j).getVehicle().getRegistrationNumber());
            }
        }

    }

    static void lab3tests(){
        Person nik = new Person("Николай","Щербаков");
        Person art = new Person("Артем","Бондарев");
        Person max = new Person("Максим","Данилин");
        Person vach = new Person("Вячеслав","Сучков");
        Person anonim = new Person("Ким","Кимыч");
        Vehicle gran = new Vehicle("1234","Lada", "Granta",VehicleTypes.CAR);
        Vehicle mas = new Vehicle("0000", "Mazda", "cx 5",VehicleTypes.CAR);
        Vehicle volk = new Vehicle("1928", "Volkswagen", "Polo",VehicleTypes.CAR);
        Vehicle ren = new Vehicle("5557", "Renault", "Sandero",VehicleTypes.CAR);
        Vehicle kia = new Vehicle("2548", "KIA", "Rio",VehicleTypes.CAR);
        Space space1 = new RentedSpace(nik,kia);
        Space space2 = new RentedSpace(max,volk);
        Space space3 = new RentedSpace(art,mas);
        Space space4 = new RentedSpace(anonim,gran);
        Space space5 = new RentedSpace(vach,ren);
        Space space0 = new RentedSpace();
        Parking parking = new Parking(3);
        parking.add(new RentedSpacesFloor());
        parking.add(new RentedSpacesFloor());
        parking.add(new RentedSpacesFloor());
        parking.get(0).add(space1);
        parking.get(0).add(space4);
        parking.get(0).add(0,space5);
        parking.get(1).add(space3);
        parking.get(1).add(space0);
        parking.get(1).add(space0);
        parking.get(2).add(space2);
        parking.get(2).add(space4);
        System.out.println(parking.vehiclesQuantity(VehicleTypes.CAR));
        System.out.println(parking.imptySpacesQuantity());
    }
    public static void main(String[] args) {
        lab3tests();
        //lab2tests();
        //lab1testsOwnersFloor();
    }
}

public class Person {
    private String firstName;
    private String lastName;
    public static final Person UNKNOWN_PERSON = new Person("","");

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
}

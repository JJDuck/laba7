import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class RentedSpace extends AbstractSpace {

    public RentedSpace(){
        super();
    }

    public RentedSpace(Person person, Vehicle vehicle){
        super(person,vehicle);
    }
}

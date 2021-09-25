package Week4.two;

public class Simulator {
    public static void main(String[] args) {
        PrivatePerson pp = new PrivatePerson();
        pp.setAge(21);
        pp.setName("Steven");
        System.out.println("AGE: "+pp.getAge()+"\nNAME: "+pp.getName());
    }
}

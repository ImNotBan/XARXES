
public class Main {
    public static void main(String[] args) {

        // age (year), name
        PacMan p1 = new PacMan(2, "Manolo");
        PacMan p2 = new PacMan();

        // fa anys i hem de sumar 1
        p1.birthday();

        System.out.println(p1);
        System.out.println(p2);
    }

}
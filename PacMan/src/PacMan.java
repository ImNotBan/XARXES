public class PacMan {

    // atributs
    private int age;
    private String name;

    public PacMan(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public PacMan() {
        this.age = 0;
        this.name = null;
    }

    public void birthday() {
        this.age++;
    }

    public String toString(){
        String str = "Name: " + this.name + "\nAge: " + this.age + "\n";
        return str;
    }
}

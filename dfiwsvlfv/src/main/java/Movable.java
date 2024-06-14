interface Movable {
    default void Move() {
        System.out.println("I am moving");
    }
}
public class Program {
    public static void main(String[] args) {
        Movable item = new Movable();
        item.Move();
        }

    }
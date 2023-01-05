package app;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        Control control = new Control(database);
        control.playgame();
    }
}

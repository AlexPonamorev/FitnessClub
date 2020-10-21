public class Client {
    private String name;
    private String surname;
    private int year;

    public Client(String name, String surname, int year) {
        SetClient(name, surname, year);
    }

    private void SetClient(String name, String surname, int year) {
        if ((name == null || surname == null) || (name.trim().length() < 1) || surname.trim().length() < 1) {
            throw new IllegalArgumentException(" Name is not correct ");
        } else {
            this.name = name;
            this.surname = surname;
            this.year = year;
        }
    }

    public Client() {
    }

    ;

    @Override
    public String toString() {
        return "Клиент " +
                "имя = " + name +
                ", фамилия = " + surname +
                ' ';

    }
}
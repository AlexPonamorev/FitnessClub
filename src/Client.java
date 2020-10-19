public class Client {
    protected String name;
    protected String surname;
    protected int year;

    public Client(String name,String surname, int year){
        SetClient(name,surname,year);
    }
    public void SetClient(String name,String surname, int year){
        if((name == null || surname == null) || (name.trim().length() < 1) || surname.trim().length() < 1){
            throw new IllegalArgumentException(" Name is not correct ");
        }
        else {
            this.name = name;
            this.surname = surname;
            this.year = year;
        }
    }
    public Client(){};

    public Client(String name,String surname){
        SetClient(name, surname,year);
    }


}

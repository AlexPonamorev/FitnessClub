public class Client {
    private String Name;
    private String Surname;


    public void SetClient(String name,String surname){
        if((name == null || surname == null) || (name.trim().length() < 1) || surname.trim().length() < 1){
            throw new IllegalArgumentException(" Name is not correct ");
        }
        else {
            this.Name = name;
            this.Surname = surname;
        }
    }
    public Client(){};

    public Client(String name,String surname){
        SetClient(name, surname);
    }


}

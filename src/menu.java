import java.util.Scanner;

public class menu {
    private static int sel;

    protected int SetSel() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int sel = in.nextInt();
        return sel;
    }

    protected void SetOption (int sel/*  сюда принимаю обьект класа Fitness и использую его static методы*/){
        switch (sel) {
            case 1:
                break;
            case 2:
                break;


        }
    }


}

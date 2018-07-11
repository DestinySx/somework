package study.patter.singleton.test;

import study.patter.singleton.seriable.Seriable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeriableTest {

    public static void main(String[] args) {
        Seriable seriable_1 = null;
        Seriable seriable_2 = Seriable.
                getIntance();

        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("Seriable.obj");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(seriable_2);
            out.flush();
            out.close();


            FileInputStream fin = new FileInputStream("Seriable.obj");
            ObjectInputStream in = new ObjectInputStream(fin);
            seriable_1 = (Seriable) in.readObject();
            in.close();

            System.out.println(seriable_1);
            System.out.println(seriable_2);
            System.out.println(seriable_1 == seriable_2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

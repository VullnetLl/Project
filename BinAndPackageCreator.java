package bin;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class BinAndPackageCreator 
   {
     
    public void randomBinPack(Bin[] b, packagee[] pack, int binVolume, int maxPackageVolume) {
        for (int i = 0; i < b.length; i++) {
            b[i] = new Bin(binVolume);
        }
        for (int i = 0; i < pack.length; i++) {
            pack[i] = new packagee((int) ((Math.random() * (maxPackageVolume - 1)) + 1));
        }
    }

    public void manualBinPack(Bin[] b, packagee[] p)
      {
        System.out.println("Please enter the number of bins sizes one by one");
        for (int i = 0; i < b.length; i++) {
            System.out.println("Bin: " + (i + 1) + " has size:");
            b[i] = new Bin(insertNum());
        }
        System.out.println("Please enter the number of packages volumes one by one");
        for (int i = 0; i < p.length; i++) {
            System.out.println("Package: " + (i + 1) + " has volume:");
            p[i] = new packagee(insertNum());
        }
    }
   /** insertNum is method that requires integers using scanner */
    public int insertNum() {
        Scanner s = new Scanner(System.in);
        int answer;
        try {
            answer = s.nextInt();
            } catch (Exception e) 
            {
            System.out.print("Wrong input, enter again!");
            answer = insertNum();
            }
        if (answer <= 0) 
        {
            System.out.print("Wrong input, please enter again!");
            answer = insertNum();
        }
        return answer;
    }
}


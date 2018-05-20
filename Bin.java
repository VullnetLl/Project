

import javax.swing.*;
import java.awt.*;
public class Bin 
   {

    private final int size;
    private int binIsFill;
    private int PackNo;
    private packagee[] pack = new packagee[0];

    public Bin(int size) {
        binIsFill = 0;
        PackNo = 0;
        this.size = size;
    }
   
   /** fillPackage returns true if the there is place for package and inserts it into the bin,
     * otherwise it returns false*/
    public boolean fillPackage(packagee p) 
    {
        boolean ans = false;
        if ((size - binIsFill) >= p.getSize()) 
        {
            PackNo++;
            insertPack(p);
            binIsFill += p.getSize();
            ans = true;
        }
        return ans;
    }
   //insertPack is a void method that inserts a package into the bin
    public void insertPack(packagee p) 
    {
        packagee[] temp = new packagee[pack.length + 1];
        //System.arraycopy(pack, 0, temp, 0, pack.length);
        for (int i = 0; i < pack.length; i++)
         {
            temp[i] = pack[i];
         }
        temp[pack.length] = p;
        pack = temp;
    }
    
    public packagee[] getPackage()
     {
        return pack;
     }

    public int getPackNo() {
        return PackNo;
    }

    public int getSize() {
        return size;
    }
}

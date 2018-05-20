package bin;

public class BubbleSort 
{

    public packagee[] bubblesort(packagee[] pack, boolean b) 
    {
        boolean sw = true;
        while (sw)
         {
            sw = false;
            //stores the packages from the smallest
            for (int k = 0; k < pack.length - 1; k++) 
            {
                if (pack[k].getSize() > pack[k + 1].getSize())
                 {
                    packagee temp = pack[k + 1];
                    pack[k + 1] = pack[k];
                    pack[k] = temp;
                    sw = true;
                 }
            }
          }
        //stores the packages from the largest
        if (!b)
         {
            packagee[] temp = new packagee[pack.length];
            for (int i = 0; i < temp.length; i++) 
            {
                temp[i] = pack[temp.length - 1 - i];
            }
            pack = temp;
        }
        return pack;
    }

    public Bin[] bubblesort(Bin[] bin, boolean b) {
        boolean sw = true;
        while (sw) 
        {
            sw = false;

            for (int k = 0; k < bin.length - 1; k++) 
            {
                if (bin[k].getSize() > bin[k + 1].getSize()) {
                    Bin temp = bin[k + 1];
                    bin[k + 1] = bin[k];
                    bin[k] = temp;
                    sw = true;
                }
            }
        }
        

        if (!b) 
        {
            Bin[] temp = new Bin[bin.length];
            for (int i = 0; i < temp.length; i++) 
            {
                temp[i] = bin[temp.length - 1 - i];
            }
            bin = temp;
        }
        return bin;
    }
}

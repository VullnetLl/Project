package bin;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class BinPackingController 
   {

    private packagee[] pack;
    private Bin[] bin;

    public BinPackingController()
     {
        int numbOfBins = numOf("bins");
        int numbOfPackages = numOf("packages");
        bin = new Bin[numbOfBins];
        pack = new packagee[numbOfPackages];
        controller();
     }

    public void controller() 
    {
        Object[] object = {"A", "B", "C"};
     Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "BinPacking", JOptionPane.INFORMATION_MESSAGE, null, object, object[0]);
        if (selectedValue == null) 
        {
            JOptionPane.showMessageDialog(null, "Please choose one!");
            controller();
        } 
        else if (selectedValue.equals(object[0]))
         {
            controller1("A");
         } 
        else if (selectedValue.equals(object[1])) 
        {
            controller1("B");
        } 
        else if (selectedValue.equals(object[2])) 
        {
            controller1("C");
        }
    }

    public void controller1(String a) 
    {
        BinAndPackageCreator creator = new BinAndPackageCreator();
        BubbleSort b = new BubbleSort();
        Object[] object = {"Random", "Manual"};
        Object selectedValue = JOptionPane.showInputDialog(null, "Choose one", "BinPacking", JOptionPane.INFORMATION_MESSAGE, null, object, object[0]);
        if (selectedValue == null)
         {
            System.exit(0);
         }
         else if (selectedValue.equals(object[0])) 
         {
            creator.randomBinPack(bin, pack, numOf("bin volume"), numOf("maxium package volume"));
         }
         else if (selectedValue.equals(object[1])) 
         {
            creator.manualBinPack(bin, pack);
         }
        switch (a) {
            case "A":
                bin = b.bubblesort(bin, true);
                pack = b.bubblesort(pack, true);
                break;
            case "B":
                bin = b.bubblesort(bin, false);
                pack = b.bubblesort(pack, false);
                break;
            default:

                break;
        }
        /**this gets the int return of insert method which means if its not equal zero there
         *are packages that have been left out*/
        int p = insert(bin, pack);
        print(bin, pack);
        if (p != 0) {
            System.out.print("There isn't enoght space for every package, " + p + " packages has been left out!");
        }
    }
   /** numOf is a method that returns an integer based on our input*/
      public int numOf(String a)
        {
        int n = 0;
        try
         {

            n = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of " + a));
         }
         catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Wrong input, please enter a positive number");
            n = numOf(a);
        }
        if (n <= 0) {
            n = numOf(a);
        }
        return n;
    }



   /* insert checks if the package of the required size can be placed in the bin because of its size
    *,otherwise it creates another bin
    *it returns an int value (zero if all the packages could fit into the bin)*/
    public int insert(Bin[] b, packagee[] p) 
    {
        int tempPackNo = 0;
        for (int i = 0; i < b.length; i++) {
            boolean state = true;   //bins state
            while (tempPackNo < p.length && state) {
                boolean temp = b[i].fillPackage(p[tempPackNo]);
                if (temp) 
                {
                    tempPackNo++;
                } else 
                {
                    state = false;
                }
            }
        }
        return (p.length - tempPackNo);//it equals zero if all packages have been placed into the bin
      }


   /** print is a void method that prints main details about the bin and the packages that 
    * could fit into it*/
    public void print(Bin[] b,packagee[] p) 
    {
        int index = 0;
        for (int i = 0; i < b.length; i++) 
        {
            System.out.println("Bin" + (i + 1) + " has volume " + b[i].getSize() + " and has " + b[i].getPackNo() + " packages:");
            for (int j = 0; j < b[i].getPackNo(); j++)
             {
                System.out.println("Package " + (index + 1) + " has volume: " + p[index].getSize());
                index++;
             }
            System.out.println();
        }
    }

}

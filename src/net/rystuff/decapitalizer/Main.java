package net.rystuff.decapitalizer;

import java.io.File;

public class Main
{

    public static String dir;
    public static File[] dirs;
    public static String[] split;
    public static String char1;
    public static StringBuilder newDir;
    public static File old;
    public static File neW;

    public static void main(String[] args)
    {
	    if (args.length==1)
        {
            dir= args[0];
            dirs = new File(dir).listFiles();

            for (File d : dirs)
            {
                split = d.toString().split("\\\\");
                char1 = split[split.length-1].substring(0, 1);
                String before = split[split.length-1];
                if (char1.toUpperCase().equals(char1))
                {
                    char1 = char1.toLowerCase();
                    newDir = new StringBuilder(split[split.length-1].substring(1));
                    newDir.insert(0, char1);
                    neW = new File(d.toString().replace(before, newDir));
                    old = d;
                    if (old.renameTo(neW))
                    {
                        System.out.println("Rename successful! :)");
                    }
                    else
                    {
                        System.out.println("Rename failed! :(");
                    }
                }
            }
        }
        else
        {
            System.out.println("Add some arguments man!");
        }
    }
}

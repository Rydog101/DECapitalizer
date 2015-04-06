package net.rystuff.decapitalizer;

import java.io.File;

public class Main
{
    public static void main(String[] args)
    {
	    if (args.length==1)
        {
            File[] dirs = new File(args[0]).listFiles();
            for (File d : dirs)
            {
                String[] split = d.toString().split(File.separator.toString());
                String char1 = split[split.length-1].substring(0, 1);
                String before = split[split.length-1];
                if (char1.toUpperCase().equals(char1))
                {
                    StringBuilder newDir = new StringBuilder(split[split.length-1].substring(1));
                    newDir.insert(0, char1.toLowerCase());
                    File neW = new File(d.toString().replace(before, newDir));
                    if (d.renameTo(neW))
                        System.out.println("Rename successful! :)");
                    else
                        System.out.println("Rename failed! :(");
                }
            }
        }
        else
        {
            System.out.println("Add some arguments man!");
            System.out.println("1 argument for the directory of files");
        }
    }
}

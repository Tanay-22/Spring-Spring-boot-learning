public class Shop
{
    public static void main(String[] args)
    {
        Door door = new Door();
        if(door.getLock().isUnlocked(args[0]))
            System.out.println("Shop has closed");
        else
            System.out.println("Shop is open");
//        System.out.println(args[1]+", "+args[2]);
    }
}

//public class Door
//{
//    public boolean isLocked(String key)
//    {
//        class Lock
//        {
//            public boolean isLocked(String key)
//            {
//                if (key.equals("Vimdhayak_ji"))
//                    return false;
//                return true;
//            }
//        }
//        return new Lock().isLocked(key);
//    }
//}

abstract class Lock
{
    public abstract boolean isUnlocked(String keyCode);
}
public class Door
{
    Lock lock = new Lock()
    {
        @Override
        public boolean isUnlocked(String keyCode)
        {
            if(keyCode.equals("Vimdhayak"))
                return true;
            return false;
        }
    };

    public Lock getLock()
    {
        return lock;
    }
}

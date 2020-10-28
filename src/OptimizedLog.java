import java.util.ArrayList;
import java.util.Iterator;

public class OptimizedLog implements Iterable<Object>,Iterator<Object>{

    private ArrayList<OptimizedLogItem> list;
    private int index;

    /**
     * Created an optimized log
     */
    public OptimizedLog()
    {
        list = new ArrayList<OptimizedLogItem>();
        index = -1;
    }

    /**
     *  This just makes toString work properly.
     */
    @Override
    public String toString() {
        String ThingToReturn = "";
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getRepetition() == 1)
            {
                ThingToReturn = ThingToReturn + "[" + list.get(i).getDateTime() + "]";
                ThingToReturn = ThingToReturn + list.get(i).toString() + "\n";
            }
            else
            {
                ThingToReturn = ThingToReturn + "[" + list.get(i).getDateTime() + "]";
                ThingToReturn = ThingToReturn + list.get(i).toString();
                ThingToReturn = ThingToReturn + " Repeated " + list.get(i).getRepetition() + " Times\n";
            }
        }

        return ThingToReturn;
    }

    /**
     * Adds an item to the optimized log.
     * @param ObjToAdd : the object to add to the log.
     */
    public void add(Object ObjToAdd)
    {
        //is the either the list empty or the object not identical to the last object?
        if( list.size() == 0 || !list.get(list.size()-1).getLoggedItem().equals(ObjToAdd))
        {
            OptimizedLogItem ItemToAdd = new OptimizedLogItem(ObjToAdd);
            list.add(ItemToAdd);
        }
        else
        {
            list.get(list.size()-1).incrementRepetition();
        }
    }

    /**
     *  Returns the item at index index.
     * @param index : The index of the item to return.
     * @return The item at index index.
     */
    public Object get(int index)
    {
        return list.get(index).getLoggedItem();
    }

    /**
     * @return wether there are any items left.
     */
    @Override
    public boolean hasNext() {
        return list.size()-1 > index;
    }

    /**
     * @return The next item in the list (just the message)
     */
    @Override
    public Object next() {
        if(index >= list.size())
            throw new IndexOutOfBoundsException();
        index ++;
        return list.get(index).getLoggedItem();
    }

    /**
     * this method implements iterable.
     */
    @Override
    public Iterator<Object> iterator() {
        return this;
    }
}

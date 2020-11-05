import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class OptimizedLog implements Collection,Iterator<Object> {

    private final ArrayList<OptimizedLogItem> list;
    private int index;

    /**
     * Created an optimized log
     */
    public OptimizedLog()
    {
        list = new ArrayList<>();
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
    public boolean add(Object ObjToAdd)
    {
        //is the either the list empty or the object not identical to the last object?
        if( list.size() == 0 || !list.get(list.size()-1).getLoggedItem().equals(ObjToAdd))
        {
            OptimizedLogItem ItemToAdd = new OptimizedLogItem(ObjToAdd);
            list.add(ItemToAdd);
            return true;
        }
        else
        {
            list.get(list.size()-1).incrementRepetition();
            return true;
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

    //implementing the collection interface here.


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean removeIf(Predicate filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Object[] toArray(IntFunction generator) {
        return list.toArray();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return list.toArray();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection c) {
        return list.addAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}

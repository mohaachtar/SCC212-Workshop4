import java.time.*;
public class OptimizedLogItem {
    final LocalDateTime LoggedDateTime;
    private final Object LoggedItem;
    private int repetition;

    /**
     * Constructor for a logged item.
     *
     * @param ItemToLog : The Object to add in the loggeditem.
     */
    public OptimizedLogItem(Object ItemToLog) {
        LoggedDateTime = LocalDateTime.now();
        LoggedItem = ItemToLog;
        repetition = 1;
    }

    @Override
    public String toString() {
        return LoggedItem.toString();
    }

    /**
     * Returns the LocalDateTime the object was created.
     *
     * @return the LocalDateTime the object was created.
     */
    public LocalDateTime getDateTime() {
        return LoggedDateTime;
    }

    /**
     * Increments the amount of times this item has been added in a row.
     */
    public void incrementRepetition() {
        repetition++;
    }

    /**
     * @return How many times this item has been repeated in a row.
     */
    public int getRepetition()
    {
        return repetition;
    }

    /**
     * @return The actual log message.
     */
    public Object getLoggedItem()
    {
        return LoggedItem;
    }
}

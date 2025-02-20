package seedu.elisa.model.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.elisa.commons.core.item.Item;
import seedu.elisa.testutil.TypicalItems;

public class TaskListTest {
    private Item validTask = TypicalItems.ITEM_WITH_TASK;
    private Item invalidTask = TypicalItems.ITEM_WITH_EVENT;
    private TaskList testList = new TaskList();

    @Test
    public void add_validTask_returnTrue() {
        assertTrue(testList.add(validTask));
    }

    @Test
    public void add_invalidTask_returnFalse() {
        assertFalse(testList.add(invalidTask));
    }

    @Test
    public void add_repeatedItem_returnFalse() {
        testList.add(validTask);
        assertFalse(testList.add(validTask));
    }

    @Test
    public void deepCopyTest () {
        testList.add(validTask);
        TaskList tempList = (TaskList) testList.deepCopy();
        assertEquals(testList, tempList);
        assertFalse(testList == tempList);
        assertEquals(validTask, tempList.get(0));
        assertFalse(validTask == tempList.get(0));
    }

    @Test
    public void sort_returnNewList () {
        testList.add(validTask);
        assertFalse(testList == testList.sort());
        assertEquals(testList, testList.sort());
    }
}

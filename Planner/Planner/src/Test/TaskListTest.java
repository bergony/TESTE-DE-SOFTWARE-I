package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.ldj.planner.list.TaskList;
import edu.ldj.planner.task.Task;

public class TaskListTest {

	@Test
	public void testConstruct() {
		TaskList taskList = new TaskList();
		assertEquals(taskList.getTasks(), new ArrayList< Task >());
		
	}

}

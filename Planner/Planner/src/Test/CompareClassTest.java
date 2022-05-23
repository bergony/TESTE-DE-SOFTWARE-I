package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ldj.planner.compare.CompareClass;
import edu.ldj.planner.task.Task;

public class CompareClassTest {

	@Test
	public void test() {
		 CompareClass<Task> comparator = new CompareClass<Task>();
		 Task task1 = new Task();
		 task1.setTaskClass("classe 1");
		 
		 Task task2 = new Task();
		 task2.setTaskClass("classe 2");
		 
		 int valorCompare = comparator.compare(task1, task2);
		 
		 assertEquals(valorCompare, -1);
		 
		 
	}

}

package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ldj.planner.task.EasyDate;
import edu.ldj.planner.task.Task;

public class TaskTest {

	@Test
	public void testConstrotor() {
		Task task = new Task();
		assertEquals(task.getTaskName(), "");
		assertEquals(task.getPriority(), 0);
		assertEquals(task.getTaskClass(), "");
		assertEquals(task.getTaskDetails(), "");
		
		EasyDate date = new EasyDate();
		assertEquals(task.getDueDate().toString(), date.toString());
		assertEquals(task.getTimeEstimate(), 0, 0);
	}
	
	@Test
	public void testConstrotorPara() {
		Task task = new Task(1,new EasyDate(), 2.0, "bergony", "noo", "classe1");
		assertEquals(task.getTaskName(), "bergony");
		assertEquals(task.getPriority(), 1);
		assertEquals(task.getTaskClass(), "classe1");
		assertEquals(task.getTaskDetails(), "noo");
		
		EasyDate date = new EasyDate();
		assertEquals(task.getDueDate().toString(), date.toString());
		assertEquals(task.getTimeEstimate(), 2.0, 0);
	}
	
	@Test
	public void testTaksString() {
		Task task = new Task(1,new EasyDate(), 2.0, "bergonysdfdsafadsfadsfasdfadsfadsfasd", "noosdafsdfadsfdsafasdfdsafsdafsdafdasfdasfdsa", "classe1adsfadsfdsafasdfsdfasdfasdfsad");
		EasyDate date = new EasyDate();
		assertEquals(task.toString(), "       1 |   "+date.toString()+" | bergonysd... | noosdafsdfadsfdsafasdfdsafs... |   2.0 | classe1ad...");
		
		Task task1 = new Task(1,new EasyDate(), 1000000.0, "bergony", "noo", "classe1");
		assertEquals(task1.toString(), "       1 |   "+date.toString()+" |      bergony |                            noo | 10000 |      classe1");
		
	}
	
	@Test
	public void testTaksFile() {
		EasyDate date = new EasyDate();
		Task task1 = new Task(1,new EasyDate(), 1.0, "bergony", "noo", "classe1");
		
		String a = task1.toFile();
		
		String b = "1	"+date.getYear()+"	"+date.getMonth()+"	"+date.getDay()+"	1	bergony	1	noo	1,000000	1	classe1";
		
		assertEquals(a.trim(), b.trim());
		
	}

}

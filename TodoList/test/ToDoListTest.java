import org.junit.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class ToDoListTest {
	private Task task1;
	private Task task2;
	private Task task3;
	private Task task4;
	private ToDoList todoList;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		task1 = new Task ("desc 1");
		task2 = new Task ("desc 2");
		task3 = new Task ("desc 3");
		task4 = new Task ("desc 4");
		todoList = new ToDoList();
	}
	@After
	 public void tearDown() throws Exception{
		task1 = null;
		task2 = null;
		task3 = null;
		task4 = null;
		todoList = null;
	}

	@Test
	public void testAddTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(1, todoList.getAllTasks().size());
		assertEquals(task1, todoList.getTask(task1.getDescription()));
	}
	@Test
	public void testgetStatus() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(1, todoList.getAllTasks().size()); //Just for Takuya Test
		assertEquals(false, todoList.getStatus(task1.getDescription()));
		todoList.completeTask(task1.getDescription());
		assertEquals(true, todoList.getStatus(task1.getDescription()));
	}
	@Test
	public void testRemoveTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		todoList.addTask(task2);;
		todoList.removeTask(task1.getDescription());
		assertNull(todoList.getTask(task1.getDescription()));	
	}
	@Test
	public void testGetCompletedTasks() {
		task1.setComplete(true);
		task3.setComplete(true);
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);
		todoList.addTask(task4);
		Collection<Task> tasks = todoList.getCompletedTasks();
		assertEquals(2, tasks.size());
	}
	@Test
	public void testGetNumberofTask() {
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);
		todoList.addTask(task4);
		assertEquals(4,todoList.getNumberofTask());
	}
	@Test
	public void testSetDate() {
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);
		todoList.addTask(task4);
		todoList.addTask(task4);
		Calendar c = Calendar.getInstance();
        c.set(2020, 10, 16); 
		todoList.setDate("desc 1", c.getTime());
		assertEquals(todoList.getDate("desc 1"), c.getTime());
	}
}

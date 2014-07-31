package liaoyu.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liaoyu.service.book.OrderService;

public class OrderTest {
	private static ApplicationContext ac=null;
	private static OrderService os=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ac=new ClassPathXmlApplicationContext("beans.xml");
			os=(OrderService) ac.getBean("orderServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getBookId() {
		System.out.println(os.getLatelyBookId());
	}
	@Test
	public void getMyOrder() {
		System.out.println(os.getMyOrder(1).size());
	}
	@Test
	public void getMyBook() {
		System.out.println(os.getHaveBuyBook(1).size());
	}
}

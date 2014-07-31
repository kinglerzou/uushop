package liaoyu.junit;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liaoyu.bean.book.Order;
import com.liaoyu.bean.user.Type;
import com.liaoyu.bean.user.User;
import com.liaoyu.service.user.UserService;

public class UserTest {
	private static ApplicationContext ac=null;
	private static UserService us=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ac=new ClassPathXmlApplicationContext("beans.xml");
			us=(UserService) ac.getBean("userServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void add() {
		us.save(new User("liaoyu@163.com", "Manager", "liaoyu",Type.MANAGER));
	}
	@Test
	public void exists() {
		System.out.println(us.exists("liaoyu@163.com"));
	}
	@Test
	public void setNickname() {
		String str="liaoyu753@163.com";
		System.out.println(str.indexOf("@"));
		System.out.println(str.substring(0, str.indexOf("@")));
	}
	@Test
	public void getAllUser() {
		System.out.println(us.getScrollData(0, 5, "type!=?", new Object[]{Type.MANAGER}).getRecordtotal());
	}	
	//通过用户查找所有订单相关信息
	@Test
	public void getOrderInfo(){
		User user=us.find(1);
		Set<Order> orders=(Set<Order>) user.getOrder();
		for(Order order:orders){
			System.out.println(order.getCreateDate()+"\t"+order.getOrderItem().size());
		}
	}

}

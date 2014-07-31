package liaoyu.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liaoyu.service.user.NoticeService;

public class NoticeTest {
	private static ApplicationContext ac=null;
	private static NoticeService ns=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ac=new ClassPathXmlApplicationContext("beans.xml");
			ns=(NoticeService) ac.getBean("noticeServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getNotice(){
		System.out.println(ns.getNoticeContent());
	}
}

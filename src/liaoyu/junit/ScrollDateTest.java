package liaoyu.junit;

import java.util.LinkedHashMap;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liaoyu.bean.QueryResult;
import com.liaoyu.bean.book.Book;
import com.liaoyu.service.book.BookService;

public class ScrollDateTest {
	private static ApplicationContext ac=null;
	private static BookService bs=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ac=new ClassPathXmlApplicationContext("beans.xml");
			bs=(BookService) ac.getBean("bookServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test1() {
		LinkedHashMap<String, String> orderBy=new LinkedHashMap<String, String>();
		orderBy.put("bid", "desc");
		QueryResult<Book> qr=bs.getScrollData(0, 5, "price=?1", new Object[]{12f}, orderBy);
		System.out.println(qr.getRecordtotal());
		for(Book book:qr.getResultlist())
			System.out.println(book.getBid()+"\t"+book.getBname()+"\t"+book.getAuthor());
	}

}

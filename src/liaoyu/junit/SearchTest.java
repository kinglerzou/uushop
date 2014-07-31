package liaoyu.junit;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liaoyu.bean.QueryResult;
import com.liaoyu.bean.book.Book;
import com.liaoyu.service.book.SearchBookService;

public class SearchTest {
	private static ApplicationContext ac=null;
	private static SearchBookService sbs=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac=new ClassPathXmlApplicationContext("beans.xml");
		sbs=(SearchBookService) ac.getBean("searchBookBean");
	}

	@Test
	public void test() {
		QueryResult<Book> books=sbs.searchBookByKeyword("外国小说", 0, 10);
		List<Book> list=books.getResultlist();
		System.out.println(list.get(0).getBname());
		System.out.println(list.size());
		System.out.println(list.get(0).getBookType().getbType());
		System.out.println(list.get(0).getBookType().getsType());
	}

}

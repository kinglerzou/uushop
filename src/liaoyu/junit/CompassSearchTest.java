package liaoyu.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liaoyu.bean.QueryResult;
import com.liaoyu.bean.book.Book;
import com.liaoyu.service.book.SearchBookService;

public class CompassSearchTest {
	private static ApplicationContext ac=null;
	private static SearchBookService sbs=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ac=new ClassPathXmlApplicationContext("beans.xml");
			sbs=(SearchBookService) ac.getBean("searchBookBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void searchBook() {
		QueryResult<Book>  qr=sbs.searchBookByKeyword("人间失格",0, 5);
		System.out.println("命中数量："+qr.getRecordtotal());
		for(Book book:qr.getResultlist())
			System.out.println(book.getBid()+"\t"+book.getBname()+"\t"+book.getAuthor());
	}
	
}

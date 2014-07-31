package liaoyu.junit;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liaoyu.bean.QueryResult;
import com.liaoyu.bean.book.Book;
import com.liaoyu.bean.book.BookType;
import com.liaoyu.service.book.BookService;
import com.liaoyu.service.book.BookTypeService;

public class BookTest {
	private static ApplicationContext ac=null;
	private static BookService bs=null;
	private static BookTypeService bts=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ac=new ClassPathXmlApplicationContext("beans.xml");
			bs=(BookService) ac.getBean("bookServiceBean");
			bts=(BookTypeService) ac.getBean("bookTypeServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addBook() {
		for(int i=1;i<44;i++){
			Book book=new Book();
			book.setBname("人间失格"+i);
			book.setAuthor("岩井俊二");
			book.setBookInfo("haha");
			book.setPrice(12.0f);
			book.setPublishCompany("富士映画");
			book.setPublishDate("2012-2-2");
			book.setSaleCount(i);
			book.setInventoryCount(50);
			book.setCollectCount(44-i);
			if(i<12)book.setRecommend(1);
			BookType booktype=bts.find(9);
			book.setBookType(booktype);
			bs.addBook(book, booktype.getbType(), booktype.getsType());
		}
	}
	@Test
	public void getBestSellerBooks(){
		 QueryResult<Book> books=bs.getBestSellerBook(7);
		 for(Book book:books.getResultlist())
			 System.out.println(book.getBid()+"\t"+book.getSaleCount());
	}
	@Test
	public void getBestCommentBooks(){
		QueryResult<Book> books=bs.getBestSellerBook(7);
		for(Book book:books.getResultlist())
			System.out.println(book.getBid()+"\t"+book.getCommentCount());
	}
	@Test
	public void getBestCollectBooks(){
		QueryResult<Book> books=bs.getBestSellerBook(7);
		for(Book book:books.getResultlist())
			System.out.println(book.getBid()+"\t"+book.getCollectCount());
	}
	@Test
	public void getRecommendBooks(){
		QueryResult<Book> books=bs.getRecommendtBook();
		for(Book book:books.getResultlist())
			System.out.println(book.getBid()+"\t"+book.getRecommend());
	}
	@Test
	public void getSameTypeBook(){
		List books=bs.getSameTypeBook(9);
		for(int i=0;i<books.size();i++){
			Object []obj=(Object[])books.get(i);
			System.out.println(obj[0]+"\t"+obj[1]+"\t"+obj[2]+"\t"+obj[3]);
		}
	}
	//获取收藏的图书
	@Test
	public void getCollectBook(){
		List<Book> books=bs.getCollectBook(1);
		System.out.println(books.get(0).getBname());
	}
}

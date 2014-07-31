package liaoyu.junit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liaoyu.bean.book.TransientBookType;
import com.liaoyu.service.book.BookTypeService;

public class BookTypeTest {
	private static ApplicationContext ac=null;
	private static BookTypeService bts=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ac=new ClassPathXmlApplicationContext("beans.xml");
			bts=(BookTypeService) ac.getBean("bookTypeServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectScrollBookType() {
		Map<String, List> books=bts.searchAllDistinctBookType();
		for(Map.Entry<String, List> bookss:books.entrySet()){
			System.out.println(bookss.getKey());
			for(Object sType:bookss.getValue() )
				System.out.println(sType.toString());
			System.out.println("********************************************");
		}
	}
	@Test
	public void selectScrollBookTypeBySize() {
		Map<String, List> books=bts.searchDistinctBookType(5);
		for(Map.Entry<String, List> bookss:books.entrySet()){
			System.out.println(bookss.getKey());
			for(Object sType:bookss.getValue() )
				System.out.println(sType.toString());
					System.out.println("********************************************");
		}
	}
	@Test
	public void selectAnalysisBookType(){
		List<TransientBookType> booktypes=bts.getBookTypeCount();
		StringBuffer buffer=new StringBuffer();
		buffer.append("[");
		for(TransientBookType item:booktypes)
			buffer.append("{value:"+item.getValue()+",name:'"+item.getName()+"'},");
		buffer.deleteCharAt(buffer.length()-1);
		buffer.append("]");
		System.out.println(buffer.toString());
	}
	
}

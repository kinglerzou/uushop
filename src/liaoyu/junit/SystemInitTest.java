package liaoyu.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liaoyu.bean.book.BookType;
import com.liaoyu.bean.user.Type;
import com.liaoyu.bean.user.User;
import com.liaoyu.service.book.BookTypeService;
import com.liaoyu.service.user.UserService;
import com.liaoyu.utils.MD5;

public class SystemInitTest {
	private static ApplicationContext ac=null;
	private static BookTypeService bts=null;
	private static UserService us=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ac=new ClassPathXmlApplicationContext("beans.xml");
			bts=(BookTypeService) ac.getBean("bookTypeServiceBean");
			us=(UserService) ac.getBean("userServiceBean");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sysInit() {
		//添加用户
		//us.save(new User("liaoyu753@163.com", MD5.MD5Encode("liaoyu"), "liaoyu753",Type.MANAGER));
		//添加图书类别
		List<BookType> bookTypes=new ArrayList<BookType>();
		bookTypes.add(new BookType("文学", "散文/随笔"));
		bookTypes.add(new BookType("文学", "中国文学"));
		bookTypes.add(new BookType("文学", "外国文学"));
		bookTypes.add(new BookType("文学", "作品集"));
		bookTypes.add(new BookType("文学", "儿童文学"));
		bookTypes.add(new BookType("小说", "中国当代小说"));
		bookTypes.add(new BookType("小说", "中国古典小说"));
		bookTypes.add(new BookType("小说", "网络小说"));
		bookTypes.add(new BookType("小说", "外国小说"));
		bookTypes.add(new BookType("小说", "世界名著"));
		bookTypes.add(new BookType("小说", "乡土"));
		bookTypes.add(new BookType("小说", "科幻"));
		bookTypes.add(new BookType("青春文学", "校园"));
		bookTypes.add(new BookType("青春文学", "爱情/情感"));
		bookTypes.add(new BookType("青春文学", "叛逆/成长"));
		bookTypes.add(new BookType("青春文学", "娱乐/偶像"));
		bookTypes.add(new BookType("青春文学", "韩国青春文学"));
		bookTypes.add(new BookType("数据库", "mysql"));
		bookTypes.add(new BookType("数据库", "oracle"));
		bookTypes.add(new BookType("数据库", "sql server"));
		bookTypes.add(new BookType("编程语言", "Java"));
		bookTypes.add(new BookType("编程语言", "C#"));
		bookTypes.add(new BookType("编程语言", "Python"));
		bookTypes.add(new BookType("传记", "历史人物"));
		bookTypes.add(new BookType("传记", "经典传记"));
		bookTypes.add(new BookType("传记", "自传"));
		bookTypes.add(new BookType("艺术", "摄影"));
		bookTypes.add(new BookType("艺术", "设计"));
		bookTypes.add(new BookType("艺术", "绘画"));
		bookTypes.add(new BookType("艺术", "音乐"));
		bookTypes.add(new BookType("励志与成功", "经典著作"));
		bookTypes.add(new BookType("励志与成功", "心灵鸡汤"));
		bookTypes.add(new BookType("励志与成功", "演讲与口才"));
		bookTypes.add(new BookType("心理学", "大众心理学"));
		bookTypes.add(new BookType("心理学", "变态/病态心理学"));
		bookTypes.add(new BookType("心理学", "心理过程与心理状态"));
		for(BookType bookType:bookTypes){
			bts.save(bookType);
		}
	}


}

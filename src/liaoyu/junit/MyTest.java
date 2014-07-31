package liaoyu.junit;

import org.apache.commons.lang.StringUtils;

public class MyTest {

	public static void main(String[] args) {
		String fileName="d";
		String fileName2=null;
/*		System.out.println(fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()));
		System.out.println(UUID.randomUUID());*/
		if(fileName==null||fileName2==null||StringUtils.isEmpty(fileName.trim())||StringUtils.isEmpty(fileName2.trim()))
			System.out.println("为空");
	}

}

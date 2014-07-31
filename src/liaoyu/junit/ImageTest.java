package liaoyu.junit;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.liaoyu.utils.ImageSizer;
import com.liaoyu.utils.ImageUtil;

public class ImageTest {

	public static void main(String[] args) {
		/*String fileType="img/jpg";
		System.out.println(fileType.substring(fileType.indexOf("/")+1));
		try {
			ImageSizer.resize(new File("d:/d3.jpg"), new File("d:/d31.jpg"), 120, "jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//System.out.println(ImageUtil.getImageFormatName(new File("d:/d3.jpg")));
		try {
			ImageUtil.zoom(ImageIO.read(new File("d:/d3.jpg")), new File("d:/d32.jpg"), 160, 120);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

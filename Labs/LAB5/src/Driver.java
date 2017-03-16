import java.util.*;

public class Driver {

	public static void main(String[] args) {
		Books[] b1 = new Books[20];
		Random rand = new Random();
		for (int i = 0; i < b1.length; i++) {
			if (rand.nextInt(2)==0) {
				b1[i] = new Ebook("Java Rocks!", "John Doe", , 5);
			}
			
		}
	}

}

package models;

import java.util.ArrayList;
import java.util.List;

public class MovieDao {

	public List<Integer> getShowtimes(String title) {
		List<Integer> list = new ArrayList<>();
		switch(title) {
		case "안시성":
			list.add(8);	list.add(12);	list.add(16); 	list.add(20);
			break;
		case "명당":
			list.add(7);	list.add(9);	list.add(11); 	list.add(13);
			break;
		case "서치" :
			list.add(15);	list.add(18);	list.add(21); 	
			break;
		default :
			list.add(9);	list.add(12);	list.add(15);	list.add(18);	list.add(21);
		}
		return list;
	}
}

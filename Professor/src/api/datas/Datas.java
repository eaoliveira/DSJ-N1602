package api.datas;

import java.util.Calendar;
import java.util.Date;

public class Datas {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 4);
		c.set(Calendar.MONTH, Calendar.NOVEMBER);
		c.set(Calendar.YEAR, 1994);
		c.add(Calendar.HOUR_OF_DAY, 7);
	  @SuppressWarnings("unused")
		Date d = c.getTime();
	  Calendar c2 = Calendar.getInstance();
		Date d2 = new Date();
	  c2.setTime(d2);
		System.out.println(d2);
		System.out.println(
				String.format("%1$tb - %1$tA , %1$td do " +
				"mês %1$tm de %1$tY\n" +
				"Hora %1$tH-%1$tM-%1$tS",d2));
	}
}








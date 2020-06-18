package day_07;

class MyDate {
	int year;
	int month;
	int date;
}

public class TryCatch {
	public static void main(String[] args) {
		MyDate d = null;

		try {
			System.out.printf("%d³â %d¿ù %dÀÏ\n", d.year, d.month, d.date);
		} catch (NullPointerException e) {
			// System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
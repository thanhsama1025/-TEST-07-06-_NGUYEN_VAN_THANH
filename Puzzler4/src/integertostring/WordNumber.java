package integertostring;

public class WordNumber {
	private final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen","Nineteen" };
	private final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety" };
	private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		int i = 0;
		String words = "";

		while (num > 0) {
			if(helper(num%1000).equals("")){
				words = helper(num % 1000) + " " + words;
			} else{
				words = helper(num % 1000) + THOUSANDS[i] + " " + words;
			}
			num /= 1000;
			i++;
		}

		return words.trim();
	}

	private String helper(int num) {
		if (num == 0) {
			return "";
		} else if (num < 20) {
			return LESS_THAN_20[num] + " ";
		} else if (num < 100) {
			return TENS[num / 10] + " " + helper(num % 10);
		} else {
			return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
		}
	}

	public static void main(String[] args) {
		WordNumber w = new WordNumber();
		int n = 1025654;
		System.out.println(w.numberToWords(n));
	}
}

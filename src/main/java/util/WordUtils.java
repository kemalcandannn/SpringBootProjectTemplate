package util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.enums.CaseSizeEnum;

public class WordUtils {

	public static final int MINIMUM_CHARACTER_OF_PASSWORD = 8;
	private static final Locale TURKISH = Locale.forLanguageTag("tr-TR");

	public static boolean equals(String str1, String str2) {
		if(str1 == null && str2 == null) {
			return true;
		}else if((str1 == null && str2 != null) || (str1 != null && str2 == null)) {
			return false;
		}else {
			if(str1.toLowerCase(TURKISH).trim().equals(str2.toLowerCase(TURKISH).trim())) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static String toEnglish(String text, CaseSizeEnum fontSize) {
		if (Util.empty(text))
			return text;

		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("ö", "o")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("ö", "o")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("ö", "O")) : "o";
		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("Ö", "o")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("Ö", "O")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("Ö", "O")) : "O";
		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("ç", "c")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("ç", "c")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("ç", "C")) : "c";
		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("Ç", "c")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("Ç", "C")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("Ç", "C")) : "C";
		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("ş", "s")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("ş", "s")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("ş", "S")) : "s";
		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("Ş", "s")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("Ş", "S")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("Ş", "S")) : "S";
		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("ü", "u")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("ü", "u")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("ü", "U")) : "u";
		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("Ü", "u")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("Ü", "U")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("Ü", "U")) : "U";
		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("ğ", "g")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("ğ", "g")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("ğ", "G")) : "g";
		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("Ğ", "g")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("Ğ", "G")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("Ğ", "G")) : "G";
		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("ı", "i")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("ı", "i")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("ı", "I")) : "i";
		text = fontSize.equals(CaseSizeEnum.LOWER) ? (text.replaceAll("İ", "i")) : fontSize.equals(CaseSizeEnum.NORMAL) ? (text.replaceAll("İ", "I")) : fontSize.equals(CaseSizeEnum.UPPER) ? (text.replaceAll("İ", "I")) : "I";

		return text;
	}

	public static String firstCharCapital(String text) {
		if (Util.empty(text)) {
			return text;
		}

		String[] textArray = text.split(" ");
		String result = "";

		if (textArray != null && textArray.length > 0) {
			for (int i = 0; i < textArray.length; i++) {
				String tempText = textArray[i];
				result += tempText.substring(0, 1).toUpperCase() + tempText.substring(1).toLowerCase();

				if (i != textArray.length - 1) {
					result += " ";
				}
			}
		}
		return result;
	}

	public static boolean containsUpper(String password) {
		if(Util.empty(password))
			return false;
		return !password.equals(password.toLowerCase());
	}
	
	public static boolean containsDigit(String password) {
		if(Util.empty(password))
			return false;
		Pattern numericPatter = Pattern.compile(".*\\d.*");
		Matcher m1 = numericPatter.matcher(password);
		return m1.matches();
	}
	
	public static boolean containsPanctuation(String password) {
		if(Util.empty(password))
			return false;
		return !password.matches("[A-Za-z0-9 ]*");
	}
	
	public static boolean isGreaterMinimumCharacterOfPassword(String password) {
		if(Util.empty(password))
			return false;
		return password.length() >= MINIMUM_CHARACTER_OF_PASSWORD;
	}

}
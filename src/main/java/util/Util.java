package util;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.PasswordGenerator.PasswordGeneratorBuilder;

public class Util {
	public static final int comboLimit = 30;

	public static boolean empty(Object object) {
		if (object instanceof String) {
			String str = (String) object;
			return str == null || str.isEmpty();
		} else {
			return object == null;
		}
	}

	public static boolean notEmpty(Object object) {
		if (object instanceof String) {
			String str = (String) object;
			return str != null && str.isEmpty() == false;
		} else {
			return object != null;
		}
	}

	public static boolean isValidIPAddress(String ip) {

		String zeroTo255 = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";
		String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
		Pattern p = Pattern.compile(regex);

		if (ip == null) {
			return false;
		}

		Matcher m = p.matcher(ip);

		return m.matches();
	}

	public static String randomName(int length, boolean useDigit, boolean useUpper, boolean useLower,
			boolean usePanctuation) {
		PasswordGenerator pg = new PasswordGenerator(new PasswordGeneratorBuilder()
				.useDigit(useDigit)
				.useUpper(useUpper)
				.useLower(useLower)
				.usePunctuation(usePanctuation));

		return pg.generate(length);
	}

	public static long randomNumber(int length) {
		PasswordGenerator pg = new PasswordGenerator(new PasswordGeneratorBuilder()
				.useDigit(true)
				.useUpper(false)
				.useLower(false)
				.usePunctuation(false));

		long randomNumber = Long.MAX_VALUE;
		try {
			randomNumber = Long.parseLong(pg.generate(length));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return randomNumber;
	}

	public static long randomNumber(long origin, long bound) {
		return new SecureRandom().nextLong(origin, bound);
	}

}

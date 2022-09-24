package util;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class DateTimeUtil {

	public static Date getDateClass(String date) {
		if (Util.empty(date))
			return null;

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dateClass = null;

		if (Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$").matcher(date).find()) {
			format = new SimpleDateFormat("dd/MM/yyyy");

			try {
				dateClass = (Date) format.parse(date);
			} catch (Exception e1) {
				format = new SimpleDateFormat("MM/dd/yyyy");
				try {
					dateClass = (Date) format.parse(date);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		} else if (Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$").matcher(date).find()) {
			format = new SimpleDateFormat("dd-MM-yyyy");

			try {
				dateClass = (Date) format.parse(date);
			} catch (Exception e1) {
				format = new SimpleDateFormat("MM-dd-yyyy");
				try {
					dateClass = (Date) format.parse(date);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		} else if (Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$").matcher(date).find()) {
			format = new SimpleDateFormat("dd.MM.yyyy");

			try {
				dateClass = (Date) format.parse(date);
			} catch (Exception e1) {
				format = new SimpleDateFormat("MM.dd.yyyy");
				try {
					dateClass = (Date) format.parse(date);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}
		if (Pattern.compile("^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}$").matcher(date).find()) {
			format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

			try {
				dateClass = (Date) format.parse(date);
			} catch (Exception e1) {
				format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
				try {
					dateClass = (Date) format.parse(date);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		} else if (Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$").matcher(date).find()) {
			format = new SimpleDateFormat("yyyy-MM-dd");

			try {
				dateClass = (Date) format.parse(date);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (Pattern.compile("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}$").matcher(date).find()) {
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			try {
				dateClass = (Date) format.parse(date);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (Pattern.compile("^\\d{8}$").matcher(date).find()) {
			format = new SimpleDateFormat("ddMMyyyy");

			try {
				dateClass = (Date) format.parse(date);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return dateClass;
	}

	public static Time getTimeClass(String time) {
		Time timeClass = null;
		try {
			if (Pattern.compile("^\\d{2}$").matcher(time).find()) {
				timeClass = Time.valueOf(time + ":00" + ":00");
			} else if (Pattern.compile("^\\d{2}:\\d{2}$").matcher(time).find()) {
				timeClass = Time.valueOf(time + ":00");
			} else if (Pattern.compile("^\\d{2}:\\d{2}:\\d{2}$").matcher(time).find()) {
				timeClass = Time.valueOf(time);
			}

		} catch (Exception e) {
		}
		return timeClass;
	}

	public static String getDateString(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		if (Util.empty(pattern)) {
			pattern = "dd/MM/yyyy";
		}

		String dateString = null;
		try {
			dateString = (new SimpleDateFormat(pattern)).format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateString;
	}

	public static String getTimeString(Time time, String pattern) {
		if (time == null) {
			return null;
		}
		if (Util.empty(pattern)) {
			pattern = "HH:mm";
		}

		String dateString = null;

		try {
			dateString = (new SimpleDateFormat(pattern)).format(time).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateString;
	}

	public static String getYear(Date date) {
		if (date != null) {
			return (new SimpleDateFormat("yyyy")).format(date);
		} else {
			return (new SimpleDateFormat("yyyy")).format(new Date());
		}
	}

	public static String getMonth(Date date, String locale) {
		if (Util.empty(locale)) {
			locale = "en";
		}

		if (date != null) {
			return (new SimpleDateFormat("MMMM", new Locale(locale))).format(date);
		} else {
			return (new SimpleDateFormat("MMMM", new Locale(locale))).format(new Date());
		}
	}

	public static long howManyDaysBetween(Calendar startDate, Calendar endDate) {
	    try {
	    	long end = endDate.getTimeInMillis();
		    long start = startDate.getTimeInMillis();
		    return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
	    }
	    catch(Exception e) {
	    	return -1;
	    }
	}

	public static Time generateRandomTime() {
		Time randomTime = null;
		
		while(true) {
			try {
				int tmpHour = (int) Util.randomNumber(0, 24);
				int tmpMinute = (int) Util.randomNumber(0, 60);
				int tmpSecond = (int) Util.randomNumber(0, 60);

				String hour = tmpHour < 10 ? "0" + tmpHour : tmpHour + "";
				String minute = tmpMinute < 10 ? "0" + tmpMinute : tmpMinute + "";
				String second = tmpSecond < 10 ? "0" + tmpSecond : tmpSecond + "";

				randomTime = Time.valueOf(hour + ":" + minute + ":" + second);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(randomTime != null) {
				break;
			}
		}
		
		return randomTime;
	}

	public static Date generateRandomDate(int yearOrigin, int yearBound) {
		Date randomDate = null;

		while(true) {
			try {
				Calendar calendar = Calendar.getInstance();
				
				int year = (int) Util.randomNumber(yearOrigin, yearBound);
				int month = (int) Util.randomNumber(0, 12);
				int day = (int) Util.randomNumber(0, 31);
				int hour = (int) Util.randomNumber(0, 23);
				int minute = (int) Util.randomNumber(0, 59);
				int second = (int) Util.randomNumber(0, 59);

				calendar.set(Calendar.YEAR, year);
				calendar.set(Calendar.MONTH, month);
				calendar.set(Calendar.DAY_OF_MONTH, day);
				calendar.set(Calendar.HOUR_OF_DAY, hour);
				calendar.set(Calendar.MINUTE, minute);
				calendar.set(Calendar.SECOND, second);
				randomDate = calendar.getTime();
			} catch (Exception e) {}
			
			if(randomDate != null) {
				break;
			}
		}
		
		return randomDate;
	}
	
}
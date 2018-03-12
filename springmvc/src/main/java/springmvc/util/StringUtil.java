package springmvc.util;

public class StringUtil {

	public static void p(String outString) {
		System.out.println(outString);
	}

	public static boolean equals(String fString, String sString) {
		boolean result = false;
		if (fString.equals(sString)) {
			result = true;
		}
		return result;
	}

	public static boolean isNull(Object obj) {
		boolean result = false;
		if (null == obj) {
			result = true;
		}

		return result;
	}

	public static boolean isEmpty(Object obj) {
		boolean result = false;
		if (null == obj || obj == "") {
			result = true;
		}

		return result;
	}

	public static boolean isBlank(Object obj) {
		boolean result = false;
		if (obj == "") {
			result = true;
		}

		return result;
	}

}

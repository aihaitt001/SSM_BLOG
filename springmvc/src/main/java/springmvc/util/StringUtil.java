package springmvc.util;

public class StringUtil {

	public void p(String outString) {
		System.out.println(outString);
	}

	public boolean equals(String fString, String sString) {
		boolean result = false;
		if (fString.equals(sString)) {
			result = true;
		}
		return result;
	}

	public boolean isNull(Object obj) {
		boolean result = false;
		if (null == obj) {
			result = true;
		}

		return result;
	}

}

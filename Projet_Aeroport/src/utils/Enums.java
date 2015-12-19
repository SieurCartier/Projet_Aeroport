package utils;

public class Enums {
	public static <T extends Enum<T>> String[] toStringArray(T[] values) {
		int taille = values.length;
		String[] ret = new String[taille];
		for (int i = 0; i < taille; i++) {
			ret[i] = values[i].name();
		}
		return ret;
	}
}

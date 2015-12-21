import java.util.*;

public class ObjectDescriber {

	private List<String> listShowable = new ArrayList<String>();
	private List<String> listSearchable = new ArrayList<String>();

	public void add(String fieldName, boolean showable, boolean searchable) {
		if (showable)
			listShowable.add(fieldName);
		if (searchable)
			listSearchable.add(fieldName);
	}

	public boolean isShowable(String fieldName) {
		return listShowable.contains(fieldName);
	}

	public boolean isSearchable(String fieldName) {
		return listSearchable.contains(fieldName);
	}

}

package domaine;

/**
 * This class represents a general <code>DatabaseItem</code>
 * 
 * @author Gaston Lemaire
 */
public class DatabaseItem {
	private int id;

	public DatabaseItem(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DatabaseItem)) {
			return false;
		}
		DatabaseItem other = (DatabaseItem) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

}

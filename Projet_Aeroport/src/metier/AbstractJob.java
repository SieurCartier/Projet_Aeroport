package metier;

import java.util.HashMap;

import domaine.DatabaseItem;
import fabrics.AbstractFabric;

public abstract class AbstractJob<T extends DatabaseItem, F extends AbstractFabric<T>> {

	protected F fab;

	public abstract T create(HashMap<String, String> fields);

	public abstract void remove(T t);

}

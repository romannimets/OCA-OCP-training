package genericsAndCollections.classes;

import genericsAndCollections.interfaces.Shippable;

public class CassaShippableAbstract<U> implements Shippable<U> {
	@Override
	public void ship(U t) {
		System.out.println(" é stato spedito");

	}
}

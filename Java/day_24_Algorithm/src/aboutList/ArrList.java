package aboutList;

public class ArrList<E> {
	private E arr[];
	private int size;

	public ArrList() {
		arr = (E[]) new Object[1];
		size = 0;
	}

	public void resize(int newSize) {
		E[] newArr = (E[]) new Object[newSize];

		for (int i = 0; i < size; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

	public void insertLast(E newItem) {
		if (size == arr.length) {
			int newSize = size * 2;
			resize(newSize);
		} else if (size < arr.length / 4) {
			int newSize = size / 4;
			resize(newSize);
		} else {
			arr[size] = newItem;
			size++;
		}
	}

	public void insert(E newItem, int k) {
		if (size == arr.length) {
			int newSize = size * 2;
			resize(newSize);
		}

		for (int i = size - 1; i >= k; i--) {
			arr[i + 1] = arr[i];
		}
		arr[k] = newItem;
		size++;

	}

	public void delete(E newItem, int k) {
		if (size < arr.length / 4) {
			int newSize = size / 4;
			resize(newSize);
		}
		for (int i = k + 1; i < size + 1; i++) {
			arr[i - 1] = arr[i];
		}
		size--;

	}
}

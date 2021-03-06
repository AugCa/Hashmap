public class DoubleHashingProbingHashTable<T> extends ProbingHashTable<T> {

	/*
	 * Denna metod ska skrivas klart. Den ska använda bokens förslag på andra
	 * hashalgoritm: f(i) = i * hash2(x), där hash2(x) = R - (x mod R) och R är
	 * ett primtal mindre än tabellstorleken.
	 */
	@Override
	protected int findPos(T x) {
		int r = smallerPrimeThanCapacity();
		int hash1 = myhash(x) % r;
		int currentPos = hash1;
		int hash2 = r - (myhash(x) % r);
		int j = 1;
		while(continueProbing(currentPos, x)){
			currentPos = hash1 + (j*hash2);
			j++;
			while(currentPos >= capacity()) {
				currentPos -= capacity();
			}
		}

		return currentPos;
 	}

	/*
	 * Denna metod ger ett primtal mindre än tabellens storlek. Detta primtal ska
	 * användas i metoden ovan.
	 */
	protected int smallerPrimeThanCapacity() {
		int n = capacity() - 2;
		while (!isPrime(n)) {
			n -= 2;
		}
		return n;
	}

}

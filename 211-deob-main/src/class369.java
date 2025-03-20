import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class class369 implements Iterator {

	class370 field3583;

	int field3582 = 0;

	int field3584;

	class369(class370 var1) {
		this.field3584 = this.field3583.field3588;
		this.field3583 = var1;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	public Object next() {
		if (this.field3583.field3588 != this.field3584) {
			throw new ConcurrentModificationException();
		} else if (this.field3582 < this.field3583.field3587) {
			Object var1 = this.field3583.field3589[this.field3582].field3581;
			++this.field3582;
			return var1;
		} else {
			throw new NoSuchElementException();
		}
	}

	public boolean hasNext() {
		return this.field3582 < this.field3583.field3587;
	}

	static void changeWorldSelectSorting(int var0, int var1) {
		int[] var2 = new int[4];
		int[] var3 = new int[4];
		var2[0] = var0;
		var3[0] = var1;
		int var4 = 1;

		for (int var5 = 0; var5 < 4; ++var5) {
			if (World.World_sortOption1[var5] != var0) {
				var2[var4] = World.World_sortOption1[var5];
				var3[var4] = World.World_sortOption2[var5];
				++var4;
			}
		}

		World.World_sortOption1 = var2;
		World.World_sortOption2 = var3;
		class156.sortWorlds(class88.World_worlds, 0, class88.World_worlds.length - 1, World.World_sortOption1,
				World.World_sortOption2);
	}
}

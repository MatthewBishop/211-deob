public class HealthBar extends Node {

	HealthBarDefinition definition;

	IterableNodeDeque updates = new IterableNodeDeque();

	HealthBar(HealthBarDefinition var1) {
		this.definition = var1;
	}

	void put(int var1, int var2, int var3, int var4) {
		HealthBarUpdate var5 = null;
		int var6 = 0;

		for (HealthBarUpdate var7 = (HealthBarUpdate) this.updates
				.last(); var7 != null; var7 = (HealthBarUpdate) this.updates.previous()) {
			++var6;
			if (var7.cycle == var1) {
				var7.set(var1, var2, var3, var4);
				return;
			}

			if (var7.cycle <= var1) {
				var5 = var7;
			}
		}

		if (var5 == null) {
			if (var6 < 4) {
				this.updates.addLast(new HealthBarUpdate(var1, var2, var3, var4));
			}

		} else {
			IterableNodeDeque.IterableNodeDeque_addBefore(new HealthBarUpdate(var1, var2, var3, var4), var5);
			if (var6 >= 4) {
				this.updates.last().remove();
			}

		}
	}

	HealthBarUpdate get(int var1) {
		HealthBarUpdate var2 = (HealthBarUpdate) this.updates.last();
		if (var2 != null && var2.cycle <= var1) {
			for (HealthBarUpdate var3 = (HealthBarUpdate) this.updates.previous(); var3 != null
					&& var3.cycle <= var1; var3 = (HealthBarUpdate) this.updates.previous()) {
				var2.remove();
				var2 = var3;
			}

			if (this.definition.int5 + var2.cycleOffset + var2.cycle > var1) {
				return var2;
			} else {
				var2.remove();
				return null;
			}
		} else {
			return null;
		}
	}

	boolean isEmpty() {
		return this.updates.method1912();
	}

	static boolean method556(int var0, int var1, int var2) {
		return var0 >= 0 && var0 < 4 && var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104;
	}

	public static boolean method554(int var0) {
		return var0 == WorldMapDecorationType.field3051.id;
	}

	static void method555(GameEngine var0) {
		class205 var1 = Client.keyHandlerInstance;
		class205 var2 = var1;

		while (var2.method1085()) {
			if (var2.field1832 == 13) {
				class17.method65();
				return;
			}

			if (var2.field1832 == 96) {
				if (Login.worldSelectPage > 0 && StudioGame.worldSelectLeftSprite != null) {
					--Login.worldSelectPage;
				}
			} else if (var2.field1832 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount
					&& class205.worldSelectRightSprite != null) {
				++Login.worldSelectPage;
			}
		}

		if (MouseHandler.MouseHandler_lastButton == 1
				|| !ClanMate.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
			int var3 = Login.xPadding + 280;
			if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + 14
					&& MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class369.changeWorldSelectSorting(0, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var3 + 15
					&& MouseHandler.MouseHandler_lastPressedX <= var3 + 80
					&& MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class369.changeWorldSelectSorting(0, 1);
				return;
			}

			int var4 = Login.xPadding + 390;
			if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14
					&& MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class369.changeWorldSelectSorting(1, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15
					&& MouseHandler.MouseHandler_lastPressedX <= var4 + 80
					&& MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class369.changeWorldSelectSorting(1, 1);
				return;
			}

			int var5 = Login.xPadding + 500;
			if (MouseHandler.MouseHandler_lastPressedX >= var5 && MouseHandler.MouseHandler_lastPressedX <= var5 + 14
					&& MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class369.changeWorldSelectSorting(2, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var5 + 15
					&& MouseHandler.MouseHandler_lastPressedX <= var5 + 80
					&& MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class369.changeWorldSelectSorting(2, 1);
				return;
			}

			int var6 = Login.xPadding + 610;
			if (MouseHandler.MouseHandler_lastPressedX >= var6 && MouseHandler.MouseHandler_lastPressedX <= var6 + 14
					&& MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class369.changeWorldSelectSorting(3, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var6 + 15
					&& MouseHandler.MouseHandler_lastPressedX <= var6 + 80
					&& MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class369.changeWorldSelectSorting(3, 1);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708
					&& MouseHandler.MouseHandler_lastPressedY >= 4
					&& MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50
					&& MouseHandler.MouseHandler_lastPressedY <= 20) {
				class17.method65();
				return;
			}

			if (Login.hoveredWorldIndex != -1) {
				World var7 = class88.World_worlds[Login.hoveredWorldIndex];
				VarbitComposition.changeWorld(var7);
				class17.method65();
				return;
			}

			if (Login.worldSelectPage > 0 && StudioGame.worldSelectLeftSprite != null
					&& MouseHandler.MouseHandler_lastPressedX >= 0
					&& MouseHandler.MouseHandler_lastPressedX <= StudioGame.worldSelectLeftSprite.subWidth
					&& MouseHandler.MouseHandler_lastPressedY >= class127.canvasHeight / 2 - 50
					&& MouseHandler.MouseHandler_lastPressedY <= class127.canvasHeight / 2 + 50) {
				--Login.worldSelectPage;
			}

			if (Login.worldSelectPage < Login.worldSelectPagesCount && class205.worldSelectRightSprite != null
					&& MouseHandler.MouseHandler_lastPressedX >= GameEngine.canvasWidth
							- class205.worldSelectRightSprite.subWidth - 5
					&& MouseHandler.MouseHandler_lastPressedX <= GameEngine.canvasWidth
					&& MouseHandler.MouseHandler_lastPressedY >= class127.canvasHeight / 2 - 50
					&& MouseHandler.MouseHandler_lastPressedY <= class127.canvasHeight / 2 + 50) {
				++Login.worldSelectPage;
			}
		}

	}
}

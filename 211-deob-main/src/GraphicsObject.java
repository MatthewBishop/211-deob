public class GraphicsObject extends Renderable {

	int id;

	int cycleStart;

	int plane;

	int x;

	int z;

	int y;

	SequenceDefinition sequenceDefinition;

	int frame;

	int frameCycle;

	boolean isFinished;

	GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		this.frame = 0;
		this.frameCycle = 0;
		this.isFinished = false;
		this.id = var1;
		this.plane = var2;
		this.x = var3;
		this.y = var4;
		this.z = var5;
		this.cycleStart = var7 + var6;
		int var8 = MouseRecorder.SpotAnimationDefinition_get(this.id).sequence;
		if (var8 != -1) {
			this.isFinished = false;
			this.sequenceDefinition = class85.SequenceDefinition_get(var8);
		} else {
			this.isFinished = true;
		}

	}

	final void advance(int var1) {
		if (!this.isFinished) {
			this.frameCycle += var1;
			if (!this.sequenceDefinition.isCachedModelIdSet()) {
				while (this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
					this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
					++this.frame;
					if (this.frame >= this.sequenceDefinition.frameIds.length) {
						this.isFinished = true;
						break;
					}
				}
			} else {
				this.frame += var1;
				if (this.frame >= this.sequenceDefinition.method1060()) {
					this.isFinished = true;
				}
			}

		}
	}

	protected final Model getModel() {
		SpotAnimationDefinition var1 = MouseRecorder.SpotAnimationDefinition_get(this.id);
		Model var2;
		if (!this.isFinished) {
			var2 = var1.getModel(this.frame);
		} else {
			var2 = var1.getModel(-1);
		}

		return var2 == null ? null : var2;
	}

	public GraphicsObject() {
	}
}

public final class NPC extends Actor {

    static int field1053 = 1;

    static int field1054 = 1;

    NPCComposition definition;

    String nameChange = "";

    int field1049 = 31;

    class474 field1050;

    NewShit field1048;

    NewShit field1047;

    void method558(String var1) {
        this.nameChange = var1 == null ? "" : var1;
    }

    protected final Model getModel() {
        if (this.definition == null) {
            return null;
        } else {
            SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0
                    ? class85.SequenceDefinition_get(super.sequence)
                    : null;
            SequenceDefinition var2 = super.movementSequence == -1
                    || super.idleSequence == super.movementSequence && var1 != null ? null
                            : class85.SequenceDefinition_get(super.movementSequence);
            Model var3 = this.definition.method958(var1, super.sequenceFrame, var2, super.movementFrame,
                    this.field1048);
            if (var3 == null) {
                return null;
            } else {
                var3.calculateBoundsCylinder();
                super.defaultHeight = var3.height;
                int var4 = var3.triangleCount;
                if (super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
                    Model var5 = MouseRecorder.SpotAnimationDefinition_get(super.spotAnimation)
                            .getModel(super.spotAnimationFrame);
                    if (var5 != null) {
                        var5.offsetBy(0, -super.spotAnimHeight, 0);
                        Model[] var6 = new Model[] { var3, var5 };
                        var3 = new Model(var6, 2);
                    }
                }

                if (this.definition.size == 1) {
                    var3.isSingleTile = true;
                }

                if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle
                        && Client.cycle < super.recolourEndCycle) {
                    var3.overrideHue = super.recolourHue;
                    var3.overrideSaturation = super.recolourSaturation;
                    var3.overrideLuminance = super.recolourLuminance;
                    var3.overrideAmount = super.recolourAmount;
                    var3.field2176 = (short) var4;
                } else {
                    var3.overrideAmount = 0;
                }

                return var3;
            }
        }
    }

    void method559(int var1) {
        this.field1049 = var1;
    }

    boolean method560(int var1) {
        if (var1 >= 0 && var1 <= 4) {
            return (this.field1049 & 1 << var1) != 0;
        } else {
            return true;
        }
    }

    final String method561() {
        if (!this.nameChange.isEmpty()) {
            return this.nameChange;
        } else {
            NPCComposition var1 = this.definition;
            if (var1.transforms != null) {
                var1 = var1.transform();
                if (var1 == null) {
                    var1 = this.definition;
                }
            }

            return var1.name;
        }
    }

    final void move(int var1, MoveSpeed var2) {
        int var3 = super.pathX[0];
        int var4 = super.pathY[0];
        if (var1 == 0) {
            --var3;
            ++var4;
        }

        if (var1 == 1) {
            ++var4;
        }

        if (var1 == 2) {
            ++var3;
            ++var4;
        }

        if (var1 == 3) {
            --var3;
        }

        if (var1 == 4) {
            ++var3;
        }

        if (var1 == 5) {
            --var3;
            --var4;
        }

        if (var1 == 6) {
            --var4;
        }

        if (var1 == 7) {
            ++var3;
            --var4;
        }

        if (super.sequence != -1 && class85.SequenceDefinition_get(super.sequence).priority == 1) {
            super.sequence = -1;
        }

        if (super.pathLength < 9) {
            ++super.pathLength;
        }

        for (int var5 = super.pathLength; var5 > 0; --var5) {
            super.pathX[var5] = super.pathX[var5 - 1];
            super.pathY[var5] = super.pathY[var5 - 1];
            super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
        }

        super.pathX[0] = var3;
        super.pathY[0] = var4;
        super.pathTraversed[0] = var2;
    }

    final void method562(int var1, int var2, boolean var3) {
        if (super.sequence != -1 && class85.SequenceDefinition_get(super.sequence).priority == 1) {
            super.sequence = -1;
        }

        if (!var3) {
            int var4 = var1 - super.pathX[0];
            int var5 = var2 - super.pathY[0];
            if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
                if (super.pathLength < 9) {
                    ++super.pathLength;
                }

                for (int var6 = super.pathLength; var6 > 0; --var6) {
                    super.pathX[var6] = super.pathX[var6 - 1];
                    super.pathY[var6] = super.pathY[var6 - 1];
                    super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
                }

                super.pathX[0] = var1;
                super.pathY[0] = var2;
                super.pathTraversed[0] = MoveSpeed.WALK;
                return;
            }
        }

        super.pathLength = 0;
        super.field1006 = 0;
        super.field951 = 0;
        super.pathX[0] = var1;
        super.pathY[0] = var2;
        super.x = super.pathX[0] * 128 + super.field939 * 64;
        super.y = super.pathY[0] * 128 + super.field939 * 64;
    }

    int[] method573() {
        return this.field1050 != null ? this.field1050.method2445() : this.definition.method970();
    }

    short[] method572() {
        return this.field1050 != null ? this.field1050.method2446() : this.definition.method967();
    }

    void method564(int var1, int var2, short var3) {
        if (this.field1050 == null) {
            this.field1050 = new class474(this.definition);
        }

        this.field1050.method2447(var1, var2, var3);
    }

    void method557(int[] var1, short[] var2) {
        if (this.field1050 == null) {
            this.field1050 = new class474(this.definition);
        }

        this.field1050.method2448(var1, var2);
    }

    void method567() {
        this.field1050 = null;
    }

    void method566(NewShit var1) {
        this.field1047 = var1;
    }

    NewShit method569() {
        return this.field1047;
    }

    void method570(NewShit var1) {
        this.field1048 = var1;
    }

    final boolean isVisible() {
        return this.definition != null;
    }

    void method574() {
        this.field1047 = null;
    }

    void method568() {
        this.field1048 = null;
    }

    public static int method576(int var0) {
        return class431.field3811[var0 & 16383];
    }

    static final void method575(int var0) {
        var0 = Math.min(Math.max(var0, 0), 127);
        PacketWriter.clientPreferences.setAreaSoundEffectsVolume(var0);
    }
}

public enum class6 implements class349 {

    field7(0, 0);

    public static AbstractArchive musicTrackArchive;

    final int field10;

    final int field9;

    class6(int var3, int var4) {
        this.field10 = var3;
        this.field9 = var4;
    }

    public int rsOrdinal() {
        return this.field9;
    }

    public static double method15(double var0) {
        return Math.exp(var0 * -var0 / 2.0D) / Math.sqrt(6.283185307179586D);
    }

    public static void method18(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
        SequenceDefinition.SequenceDefinition_archive = var0;
        SequenceDefinition.SequenceDefinition_animationsArchive = var1;
        class16.SequenceDefinition_skeletonsArchive = var2;
    }

    static int method17(int var0, int var1) {
        ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.get((long) var0);
        if (var2 == null) {
            return -1;
        } else {
            return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
        }
    }

    static final void method20(String var0) {
        Decimator.method306("Please remove " + var0 + " from your ignore list first");
    }

    static int method14(int var0, Script var1, boolean var2) {
        int var3;
        if (var0 == 4200) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = TileItem
                    .ItemDefinition_get(var3).name;
            return 1;
        } else {
            int var4;
            ItemComposition var5;
            if (var0 == 4201) {
                class302.Interpreter_intStackSize -= 2;
                var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                var5 = TileItem.ItemDefinition_get(var3);
                if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
                    Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize
                            - 1] = var5.groundActions[var4 - 1];
                } else {
                    Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                }

                return 1;
            } else if (var0 == 4202) {
                class302.Interpreter_intStackSize -= 2;
                var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                var5 = TileItem.ItemDefinition_get(var3);
                if (var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
                    Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize
                            - 1] = var5.inventoryActions[var4 - 1];
                } else {
                    Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                }

                return 1;
            } else if (var0 == 4203) {
                var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = TileItem
                        .ItemDefinition_get(var3).price;
                return 1;
            } else if (var0 == 4204) {
                var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
                        - 1] = TileItem.ItemDefinition_get(var3).isStackable == 1 ? 1 : 0;
                return 1;
            } else {
                ItemComposition var6;
                if (var0 == 4205) {
                    var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                    var6 = TileItem.ItemDefinition_get(var3);
                    if (var6.noteTemplate == -1 && var6.note >= 0) {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var6.note;
                    } else {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3;
                    }

                    return 1;
                } else if (var0 == 4206) {
                    var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                    var6 = TileItem.ItemDefinition_get(var3);
                    if (var6.noteTemplate >= 0 && var6.note >= 0) {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var6.note;
                    } else {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3;
                    }

                    return 1;
                } else if (var0 == 4207) {
                    var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                    Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
                            - 1] = TileItem.ItemDefinition_get(var3).isMembersOnly ? 1 : 0;
                    return 1;
                } else if (var0 == 4208) {
                    var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                    var6 = TileItem.ItemDefinition_get(var3);
                    if (var6.placeholderTemplate == -1 && var6.placeholder >= 0) {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var6.placeholder;
                    } else {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3;
                    }

                    return 1;
                } else if (var0 == 4209) {
                    var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                    var6 = TileItem.ItemDefinition_get(var3);
                    if (var6.placeholderTemplate >= 0 && var6.placeholder >= 0) {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var6.placeholder;
                    } else {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3;
                    }

                    return 1;
                } else if (var0 == 4210) {
                    String var7 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                    var4 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                    class382.findItemDefinitions(var7, var4 == 1);
                    Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
                            - 1] = class378.foundItemIdCount;
                    return 1;
                } else if (var0 != 4211) {
                    if (var0 == 4212) {
                        WorldMapLabelSize.foundItemIndex = 0;
                        return 1;
                    } else if (var0 == 4213) {
                        var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                        var4 = TileItem.ItemDefinition_get(var3).getShiftClickIndex();
                        if (var4 == -1) {
                            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4;
                        } else {
                            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4 + 1;
                        }

                        return 1;
                    } else if (var0 == 4214) {
                        var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = TileItem
                                .ItemDefinition_get(var3).maleModel;
                        return 1;
                    } else if (var0 == 4215) {
                        var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = TileItem
                                .ItemDefinition_get(var3).maleModel1;
                        return 1;
                    } else if (var0 == 4216) {
                        var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = TileItem
                                .ItemDefinition_get(var3).maleModel2;
                        return 1;
                    } else if (var0 == 4217) {
                        var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                        var6 = TileItem.ItemDefinition_get(var3);
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var6.field1765;
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    if (VarbitComposition.foundItemIds != null
                            && WorldMapLabelSize.foundItemIndex < class378.foundItemIdCount) {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize
                                - 1] = VarbitComposition.foundItemIds[++WorldMapLabelSize.foundItemIndex - 1]
                                        & '\uffff';
                    } else {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
                    }

                    return 1;
                }
            }
        }
    }

    static String method16(String var0) {
        PlayerType[] var1 = ArchiveLoader.PlayerType_values();

        for (int var2 = 0; var2 < var1.length; ++var2) {
            PlayerType var3 = var1[var2];
            if (var3.modIcon != -1 && var0.startsWith(ObjectSound.addImageTag(var3.modIcon))) {
                var0 = var0.substring(6 + Integer.toString(var3.modIcon).length());
                break;
            }
        }

        return var0;
    }
}

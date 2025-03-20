import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionCheck extends Node {

    static int field172;

    int[] intReplaceValues;

    int id;

    int size;

    int[] operations;

    int[] creationErrors;

    Field[] fields;

    Method[] methods;

    byte[][][] arguments;

    public static IterableNodeDeque reflectionChecks = new IterableNodeDeque();

    static class134 method170(int var0) {
        class134[] var1 = new class134[] { class134.field1282, class134.field1271, class134.field1272,
                class134.field1273, class134.field1274, class134.field1281, class134.field1276, class134.field1275,
                class134.field1278 };
        class134 var2 = (class134) class4.findEnumerated(var1, var0);
        if (var2 == null) {
            var2 = class134.field1278;
        }

        return var2;
    }

    static void method171(int var0) {
        if (var0 != Login.loginIndex) {
            Login.loginIndex = var0;
        }
    }

    static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3, boolean var4) {
        ArchiveDisk var5 = null;
        if (JagexCache.JagexCache_dat2File != null) {
            var5 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, class18.JagexCache_idxFiles[var0], 1000000);
        }

        return new Archive(var5, class12.masterDisk, var0, var1, var2, var3, var4);
    }

    static final void changeGameOptions(int var0) {
        class123.process();

        for (ObjectSound var1 = (ObjectSound) ObjectSound.objectSounds
                .last(); var1 != null; var1 = (ObjectSound) ObjectSound.objectSounds.previous()) {
            if (var1.obj != null) {
                var1.set();
            }
        }

        int var3 = TaskHandler.VarpDefinition_get(var0).type;
        if (var3 != 0) {
            int var2 = Varps.Varps_main[var0];
            if (var3 == 1) {
                if (var2 == 1) {
                    Rasterizer3D.Rasterizer3D_setBrightness(0.9D);
                    ((TextureProvider) Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.9D);
                    ItemComposition.ItemDefinition_cachedSprites.clear();
                    PacketWriter.clientPreferences.setBrightness(0.9D);
                }

                if (var2 == 2) {
                    Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
                    ((TextureProvider) Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.8D);
                    ItemComposition.ItemDefinition_cachedSprites.clear();
                    PacketWriter.clientPreferences.setBrightness(0.8D);
                }

                if (var2 == 3) {
                    Rasterizer3D.Rasterizer3D_setBrightness(0.7D);
                    ((TextureProvider) Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.7D);
                    ItemComposition.ItemDefinition_cachedSprites.clear();
                    PacketWriter.clientPreferences.setBrightness(0.7D);
                }

                if (var2 == 4) {
                    Actor.method505(0.6D);
                }
            }

            if (var3 == 3) {
                if (var2 == 0) {
                    Player.method488(255);
                }

                if (var2 == 1) {
                    Player.method488(192);
                }

                if (var2 == 2) {
                    Player.method488(128);
                }

                if (var2 == 3) {
                    Player.method488(64);
                }

                if (var2 == 4) {
                    Player.method488(0);
                }
            }

            if (var3 == 4) {
                if (var2 == 0) {
                    class203.method1073(127);
                }

                if (var2 == 1) {
                    class203.method1073(96);
                }

                if (var2 == 2) {
                    class203.method1073(64);
                }

                if (var2 == 3) {
                    class203.method1073(32);
                }

                if (var2 == 4) {
                    class203.method1073(0);
                }
            }

            if (var3 == 5) {
                Client.leftClickOpensMenu = var2 == 1;
            }

            if (var3 == 6) {
                Client.chatEffects = var2;
            }

            if (var3 == 9) {
                Client.field547 = var2;
            }

            if (var3 == 10) {
                if (var2 == 0) {
                    NPC.method575(127);
                }

                if (var2 == 1) {
                    NPC.method575(96);
                }

                if (var2 == 2) {
                    NPC.method575(64);
                }

                if (var2 == 3) {
                    NPC.method575(32);
                }

                if (var2 == 4) {
                    NPC.method575(0);
                }
            }

            if (var3 == 17) {
                Client.followerIndex = var2 & '\uffff';
            }

            if (var3 == 18) {
                Client.playerAttackOption = (AttackOption) class4.findEnumerated(WorldMapArea.method1355(), var2);
                if (Client.playerAttackOption == null) {
                    Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
                }
            }

            if (var3 == 19) {
                if (var2 == -1) {
                    Client.combatTargetPlayerIndex = -1;
                } else {
                    Client.combatTargetPlayerIndex = var2 & 2047;
                }
            }

            if (var3 == 22) {
                Client.npcAttackOption = (AttackOption) class4.findEnumerated(WorldMapArea.method1355(), var2);
                if (Client.npcAttackOption == null) {
                    Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
                }
            }

        }
    }

    public static void performReflectionCheck(PacketBuffer var0) {
        ReflectionCheck var1 = (ReflectionCheck) ReflectionCheck.reflectionChecks.last();
        if (var1 != null) {
            int var2 = var0.offset;
            var0.writeInt(var1.id);

            for (int var3 = 0; var3 < var1.size; ++var3) {
                if (var1.creationErrors[var3] != 0) {
                    var0.writeByte(var1.creationErrors[var3]);
                } else {
                    try {
                        int var4 = var1.operations[var3];
                        Field var5;
                        int var6;
                        if (var4 == 0) {
                            var5 = var1.fields[var3];
                            var6 = var5.getInt((Object) null);
                            var0.writeByte(0);
                            var0.writeInt(var6);
                        } else if (var4 == 1) {
                            var5 = var1.fields[var3];
                            var5.setInt((Object) null, var1.intReplaceValues[var3]);
                            var0.writeByte(0);
                        } else if (var4 == 2) {
                            var5 = var1.fields[var3];
                            var6 = var5.getModifiers();
                            var0.writeByte(0);
                            var0.writeInt(var6);
                        }

                        Method var25;
                        if (var4 != 3) {
                            if (var4 == 4) {
                                var25 = var1.methods[var3];
                                var6 = var25.getModifiers();
                                var0.writeByte(0);
                                var0.writeInt(var6);
                            }
                        } else {
                            var25 = var1.methods[var3];
                            byte[][] var10 = var1.arguments[var3];
                            Object[] var7 = new Object[var10.length];

                            for (int var8 = 0; var8 < var10.length; ++var8) {
                                ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                                var7[var8] = var9.readObject();
                            }

                            Object var11 = var25.invoke(null, var7);
                            if (var11 == null) {
                                var0.writeByte(0);
                            } else if (var11 instanceof Number) {
                                var0.writeByte(1);
                                var0.writeLong(((Number) var11).longValue());
                            } else if (var11 instanceof String) {
                                var0.writeByte(2);
                                var0.writeStringCp1252NullTerminated((String) var11);
                            } else {
                                var0.writeByte(4);
                            }
                        }
                    } catch (ClassNotFoundException var13) {
                        var0.writeByte(-10);
                    } catch (InvalidClassException var14) {
                        var0.writeByte(-11);
                    } catch (StreamCorruptedException var15) {
                        var0.writeByte(-12);
                    } catch (OptionalDataException var16) {
                        var0.writeByte(-13);
                    } catch (IllegalAccessException var17) {
                        var0.writeByte(-14);
                    } catch (IllegalArgumentException var18) {
                        var0.writeByte(-15);
                    } catch (InvocationTargetException var19) {
                        var0.writeByte(-16);
                    } catch (SecurityException var20) {
                        var0.writeByte(-17);
                    } catch (IOException var21) {
                        var0.writeByte(-18);
                    } catch (NullPointerException var22) {
                        var0.writeByte(-19);
                    } catch (Exception var23) {
                        var0.writeByte(-20);
                    } catch (Throwable var24) {
                        var0.writeByte(-21);
                    }
                }
            }

            var0.writeCrc(var2);
            var1.remove();
        }
    }

    static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
        if (var0.equals("B")) {
            return Byte.TYPE;
        } else if (var0.equals("I")) {
            return Integer.TYPE;
        } else if (var0.equals("S")) {
            return Short.TYPE;
        } else if (var0.equals("J")) {
            return Long.TYPE;
        } else if (var0.equals("Z")) {
            return Boolean.TYPE;
        } else if (var0.equals("F")) {
            return Float.TYPE;
        } else if (var0.equals("D")) {
            return Double.TYPE;
        } else if (var0.equals("C")) {
            return Character.TYPE;
        } else {
            return var0.equals("void") ? Void.TYPE : Class.forName(var0);
        }
    }

    public static void readReflectionCheck(Buffer var0, int var1) {
        ReflectionCheck var2 = new ReflectionCheck();
        var2.size = var0.readUnsignedByte();
        var2.id = var0.readInt();
        var2.operations = new int[var2.size];
        var2.creationErrors = new int[var2.size];
        var2.fields = new Field[var2.size];
        var2.intReplaceValues = new int[var2.size];
        var2.methods = new Method[var2.size];
        var2.arguments = new byte[var2.size][][];
        for (int var3 = 0; var3 < var2.size; ++var3) {
            try {
                int var4 = var0.readUnsignedByte();
                String var5;
                String var6;
                int var7;
                if (var4 != 0 && var4 != 1 && var4 != 2) {
                    if (var4 == 3 || var4 == 4) {
                        var5 = var0.readStringCp1252NullTerminated();
                        var6 = var0.readStringCp1252NullTerminated();
                        var7 = var0.readUnsignedByte();
                        String[] var8 = new String[var7];

                        for (int var9 = 0; var9 < var7; ++var9) {
                            var8[var9] = var0.readStringCp1252NullTerminated();
                        }

                        String var20 = var0.readStringCp1252NullTerminated();
                        byte[][] var10 = new byte[var7][];
                        int var12;
                        if (var4 == 3) {
                            for (int var11 = 0; var11 < var7; ++var11) {
                                var12 = var0.readInt();
                                var10[var11] = new byte[var12];
                                var0.readBytes(var10[var11], 0, var12);
                            }
                        }

                        var2.operations[var3] = var4;
                        Class[] var21 = new Class[var7];

                        for (var12 = 0; var12 < var7; ++var12) {
                            Class c = loadClassFromDescriptor(var8[var12]);
                            var21[var12] = loadClassFromDescriptor(var8[var12]);
                        }

                        Class var22 = loadClassFromDescriptor(var20);
                        if (loadClassFromDescriptor(var5).getClassLoader() == null) {
                            throw new SecurityException();
                        }

                        Method[] var13 = loadClassFromDescriptor(var5).getDeclaredMethods();
                        Method[] var14 = var13;

                        for (int var15 = 0; var15 < var14.length; ++var15) {
                            Method var16 = var14[var15];
                            if (var16.getName().equals(var6)) {
                                Class[] var17 = var16.getParameterTypes();
                                if (var17.length == var21.length) {
                                    boolean var18 = true;

                                    for (int var19 = 0; var19 < var21.length; ++var19) {
                                        if (var17[var19] != var21[var19]) {
                                            var18 = false;
                                            break;
                                        }
                                    }

                                    if (var18 && var22 == var16.getReturnType()) {
                                        var2.methods[var3] = var16;
                                    }
                                }
                            }
                        }

                        var2.arguments[var3] = var10;
                    }
                } else {
                    var5 = var0.readStringCp1252NullTerminated();
                    var6 = var0.readStringCp1252NullTerminated();
                    var7 = 0;
                    if (var4 == 1) {
                        var7 = var0.readInt();
                    }

                    var2.operations[var3] = var4;
                    var2.intReplaceValues[var3] = var7;
                    if (loadClassFromDescriptor(var5).getClassLoader() == null) {
                        throw new SecurityException();
                    }

                    var2.fields[var3] = loadClassFromDescriptor(var5).getDeclaredField(var6);
                }
            } catch (ClassNotFoundException var24) {
                var2.creationErrors[var3] = -1;
            } catch (SecurityException var25) {
                var2.creationErrors[var3] = -2;
            } catch (NullPointerException var26) {
                var2.creationErrors[var3] = -3;
            } catch (Exception var27) {
                var2.creationErrors[var3] = -4;
            } catch (Throwable var28) {
                var2.creationErrors[var3] = -5;
            }
        }

        reflectionChecks.addFirst(var2);
    }
}

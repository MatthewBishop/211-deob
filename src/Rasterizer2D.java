public class Rasterizer2D extends DualNode {

    public static int[] Rasterizer2D_pixels;

    public static int graphicsPixelsWidth;

    public static int Rasterizer2D_height;

    public static int drawingAreaTop = 0;

    public static int drawingAreaBottom = 0;

    public static int drawRegionX = 0;

    public static int drawingAreaRight = 0;

    public static void Rasterizer2D_replace(int[] var0, int var1, int var2) {
        Rasterizer2D_pixels = var0;
        graphicsPixelsWidth = var1;
        Rasterizer2D_height = var2;
        Rasterizer2D_setClip(0, 0, var1, var2);
    }

    public static void Rasterizer2D_resetClip() {
        drawRegionX = 0;
        drawingAreaTop = 0;
        drawingAreaRight = graphicsPixelsWidth;
        drawingAreaBottom = Rasterizer2D_height;
    }

    public static void Rasterizer2D_setClip(int var0, int var1, int var2, int var3) {
        if (var0 < 0) {
            var0 = 0;
        }

        if (var1 < 0) {
            var1 = 0;
        }

        if (var2 > graphicsPixelsWidth) {
            var2 = graphicsPixelsWidth;
        }

        if (var3 > Rasterizer2D_height) {
            var3 = Rasterizer2D_height;
        }

        drawRegionX = var0;
        drawingAreaTop = var1;
        drawingAreaRight = var2;
        drawingAreaBottom = var3;
    }

    public static void Rasterizer2D_expandClip(int var0, int var1, int var2, int var3) {
        if (drawRegionX < var0) {
            drawRegionX = var0;
        }

        if (drawingAreaTop < var1) {
            drawingAreaTop = var1;
        }

        if (drawingAreaRight > var2) {
            drawingAreaRight = var2;
        }

        if (drawingAreaBottom > var3) {
            drawingAreaBottom = var3;
        }

    }

    public static void Rasterizer2D_getClipArray(int[] var0) {
        var0[0] = drawRegionX;
        var0[1] = drawingAreaTop;
        var0[2] = drawingAreaRight;
        var0[3] = drawingAreaBottom;
    }

    public static void Rasterizer2D_setClipArray(int[] var0) {
        drawRegionX = var0[0];
        drawingAreaTop = var0[1];
        drawingAreaRight = var0[2];
        drawingAreaBottom = var0[3];
    }

    public static void Rasterizer2D_clear() {
        int var0 = 0;

        int var1;
        for (var1 = graphicsPixelsWidth * Rasterizer2D_height - 7; var0 < var1; Rasterizer2D_pixels[var0++] = 0) {
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
            Rasterizer2D_pixels[var0++] = 0;
        }

        for (var1 += 7; var0 < var1; Rasterizer2D_pixels[var0++] = 0) {
            ;
        }

    }

    static void drawCircle(int var0, int var1, int var2, int var3) {
        if (var2 == 0) {
            Rasterizer2D_setPixel(var0, var1, var3);
        } else {
            if (var2 < 0) {
                var2 = -var2;
            }

            int var4 = var1 - var2;
            if (var4 < drawingAreaTop) {
                var4 = drawingAreaTop;
            }

            int var5 = var2 + var1 + 1;
            if (var5 > drawingAreaBottom) {
                var5 = drawingAreaBottom;
            }

            int var6 = var4;
            int var7 = var2 * var2;
            int var8 = 0;
            int var9 = var1 - var4;
            int var10 = var9 * var9;
            int var11 = var10 - var9;
            if (var1 > var5) {
                var1 = var5;
            }

            int var12;
            int var13;
            int var14;
            int var15;
            while (var6 < var1) {
                while (var11 <= var7 || var10 <= var7) {
                    var10 = var10 + var8 + var8;
                    var11 += var8++ + var8;
                }

                var12 = var0 - var8 + 1;
                if (var12 < drawRegionX) {
                    var12 = drawRegionX;
                }

                var13 = var0 + var8;
                if (var13 > drawingAreaRight) {
                    var13 = drawingAreaRight;
                }

                var14 = var12 + var6 * graphicsPixelsWidth;

                for (var15 = var12; var15 < var13; ++var15) {
                    Rasterizer2D_pixels[var14++] = var3;
                }

                ++var6;
                var10 -= var9-- + var9;
                var11 -= var9 + var9;
            }

            var8 = var2;
            var9 = var6 - var1;
            var11 = var7 + var9 * var9;
            var10 = var11 - var2;

            for (var11 -= var9; var6 < var5; var10 += var9++ + var9) {
                while (var11 > var7 && var10 > var7) {
                    var11 -= var8-- + var8;
                    var10 -= var8 + var8;
                }

                var12 = var0 - var8;
                if (var12 < drawRegionX) {
                    var12 = drawRegionX;
                }

                var13 = var0 + var8;
                if (var13 > drawingAreaRight - 1) {
                    var13 = drawingAreaRight - 1;
                }

                var14 = var12 + var6 * graphicsPixelsWidth;

                for (var15 = var12; var15 <= var13; ++var15) {
                    Rasterizer2D_pixels[var14++] = var3;
                }

                ++var6;
                var11 = var11 + var9 + var9;
            }

        }
    }

    public static void Rasterizer2D_drawCircleAlpha(int var0, int var1, int var2, int var3, int var4) {
        if (var4 != 0) {
            if (var4 == 256) {
                drawCircle(var0, var1, var2, var3);
            } else {
                if (var2 < 0) {
                    var2 = -var2;
                }

                int var5 = 256 - var4;
                int var6 = (var3 >> 16 & 255) * var4;
                int var7 = (var3 >> 8 & 255) * var4;
                int var8 = var4 * (var3 & 255);
                int var12 = var1 - var2;
                if (var12 < drawingAreaTop) {
                    var12 = drawingAreaTop;
                }

                int var13 = var2 + var1 + 1;
                if (var13 > drawingAreaBottom) {
                    var13 = drawingAreaBottom;
                }

                int var14 = var12;
                int var15 = var2 * var2;
                int var16 = 0;
                int var17 = var1 - var12;
                int var18 = var17 * var17;
                int var19 = var18 - var17;
                if (var1 > var13) {
                    var1 = var13;
                }

                int var9;
                int var10;
                int var11;
                int var20;
                int var21;
                int var22;
                int var23;
                int var24;
                while (var14 < var1) {
                    while (var19 <= var15 || var18 <= var15) {
                        var18 = var18 + var16 + var16;
                        var19 += var16++ + var16;
                    }

                    var20 = var0 - var16 + 1;
                    if (var20 < drawRegionX) {
                        var20 = drawRegionX;
                    }

                    var21 = var0 + var16;
                    if (var21 > drawingAreaRight) {
                        var21 = drawingAreaRight;
                    }

                    var22 = var20 + var14 * graphicsPixelsWidth;

                    for (var23 = var20; var23 < var21; ++var23) {
                        var9 = var5 * (Rasterizer2D_pixels[var22] >> 16 & 255);
                        var10 = (Rasterizer2D_pixels[var22] >> 8 & 255) * var5;
                        var11 = var5 * (Rasterizer2D_pixels[var22] & 255);
                        var24 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                        Rasterizer2D_pixels[var22++] = var24;
                    }

                    ++var14;
                    var18 -= var17-- + var17;
                    var19 -= var17 + var17;
                }

                var16 = var2;
                var17 = -var17;
                var19 = var15 + var17 * var17;
                var18 = var19 - var2;

                for (var19 -= var17; var14 < var13; var18 += var17++ + var17) {
                    while (var19 > var15 && var18 > var15) {
                        var19 -= var16-- + var16;
                        var18 -= var16 + var16;
                    }

                    var20 = var0 - var16;
                    if (var20 < drawRegionX) {
                        var20 = drawRegionX;
                    }

                    var21 = var0 + var16;
                    if (var21 > drawingAreaRight - 1) {
                        var21 = drawingAreaRight - 1;
                    }

                    var22 = var20 + var14 * graphicsPixelsWidth;

                    for (var23 = var20; var23 <= var21; ++var23) {
                        var9 = var5 * (Rasterizer2D_pixels[var22] >> 16 & 255);
                        var10 = (Rasterizer2D_pixels[var22] >> 8 & 255) * var5;
                        var11 = var5 * (Rasterizer2D_pixels[var22] & 255);
                        var24 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                        Rasterizer2D_pixels[var22++] = var24;
                    }

                    ++var14;
                    var19 = var19 + var17 + var17;
                }

            }
        }
    }

    public static void Rasterizer2D_fillRectangleAlpha(int var0, int var1, int var2, int var3, int var4, int var5) {
        if (var0 < drawRegionX) {
            var2 -= drawRegionX - var0;
            var0 = drawRegionX;
        }

        if (var1 < drawingAreaTop) {
            var3 -= drawingAreaTop - var1;
            var1 = drawingAreaTop;
        }

        if (var0 + var2 > drawingAreaRight) {
            var2 = drawingAreaRight - var0;
        }

        if (var3 + var1 > drawingAreaBottom) {
            var3 = drawingAreaBottom - var1;
        }

        var4 = (var5 * (var4 & 16711935) >> 8 & 16711935) + (var5 * (var4 & '\uff00') >> 8 & '\uff00');
        int var6 = 256 - var5;
        int var7 = graphicsPixelsWidth - var2;
        int var8 = var0 + graphicsPixelsWidth * var1;

        for (int var9 = 0; var9 < var3; ++var9) {
            for (int var10 = -var2; var10 < 0; ++var10) {
                int var11 = Rasterizer2D_pixels[var8];
                var11 = ((var11 & 16711935) * var6 >> 8 & 16711935) + (var6 * (var11 & '\uff00') >> 8 & '\uff00');
                Rasterizer2D_pixels[var8++] = var11 + var4;
            }

            var8 += var7;
        }

    }

    public static void Rasterizer2D_fillRectangle(int var0, int var1, int var2, int var3, int var4) {
        if (var0 < drawRegionX) {
            var2 -= drawRegionX - var0;
            var0 = drawRegionX;
        }

        if (var1 < drawingAreaTop) {
            var3 -= drawingAreaTop - var1;
            var1 = drawingAreaTop;
        }

        if (var0 + var2 > drawingAreaRight) {
            var2 = drawingAreaRight - var0;
        }

        if (var3 + var1 > drawingAreaBottom) {
            var3 = drawingAreaBottom - var1;
        }

        int var5 = graphicsPixelsWidth - var2;
        int var6 = var0 + graphicsPixelsWidth * var1;

        for (int var7 = -var3; var7 < 0; ++var7) {
            for (int var8 = -var2; var8 < 0; ++var8) {
                Rasterizer2D_pixels[var6++] = var4;
            }

            var6 += var5;
        }

    }

    public static void Rasterizer2D_fillRectangleGradient(int var0, int var1, int var2, int var3, int var4, int var5) {
        if (var2 > 0 && var3 > 0) {
            int var6 = 0;
            int var7 = 65536 / var3;
            if (var0 < drawRegionX) {
                var2 -= drawRegionX - var0;
                var0 = drawRegionX;
            }

            if (var1 < drawingAreaTop) {
                var6 += (drawingAreaTop - var1) * var7;
                var3 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var0 + var2 > drawingAreaRight) {
                var2 = drawingAreaRight - var0;
            }

            if (var3 + var1 > drawingAreaBottom) {
                var3 = drawingAreaBottom - var1;
            }

            int var8 = graphicsPixelsWidth - var2;
            int var9 = var0 + graphicsPixelsWidth * var1;

            for (int var10 = -var3; var10 < 0; ++var10) {
                int var11 = 65536 - var6 >> 8;
                int var12 = var6 >> 8;
                int var13 = (var12 * (var5 & 16711935) + var11 * (var4 & 16711935) & -16711936)
                        + (var12 * (var5 & '\uff00') + var11 * (var4 & '\uff00') & 16711680) >>> 8;

                for (int var14 = -var2; var14 < 0; ++var14) {
                    Rasterizer2D_pixels[var9++] = var13;
                }

                var9 += var8;
                var6 += var7;
            }

        }
    }

    public static void Rasterizer2D_fillRectangleGradientAlpha(int var0, int var1, int var2, int var3, int var4,
            int var5, int var6, int var7) {
        if (var2 > 0 && var3 > 0) {
            int var8 = 0;
            int var9 = 65536 / var3;
            if (var0 < drawRegionX) {
                var2 -= drawRegionX - var0;
                var0 = drawRegionX;
            }

            if (var1 < drawingAreaTop) {
                var8 += (drawingAreaTop - var1) * var9;
                var3 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var0 + var2 > drawingAreaRight) {
                var2 = drawingAreaRight - var0;
            }

            if (var3 + var1 > drawingAreaBottom) {
                var3 = drawingAreaBottom - var1;
            }

            int var10 = graphicsPixelsWidth - var2;
            int var11 = var0 + graphicsPixelsWidth * var1;

            for (int var12 = -var3; var12 < 0; ++var12) {
                int var13 = 65536 - var8 >> 8;
                int var14 = var8 >> 8;
                int var15 = (var13 * var6 + var14 * var7 & '\uff00') >>> 8;
                if (var15 == 0) {
                    var11 += graphicsPixelsWidth;
                    var8 += var9;
                } else {
                    int var16 = (var14 * (var5 & 16711935) + var13 * (var4 & 16711935) & -16711936)
                            + (var14 * (var5 & '\uff00') + var13 * (var4 & '\uff00') & 16711680) >>> 8;
                    int var17 = 255 - var15;
                    int var18 = ((var16 & 16711935) * var15 >> 8 & 16711935)
                            + (var15 * (var16 & '\uff00') >> 8 & '\uff00');

                    for (int var19 = -var2; var19 < 0; ++var19) {
                        int var20 = Rasterizer2D_pixels[var11];
                        if (var20 == 0) {
                            Rasterizer2D_pixels[var11++] = var18;
                        } else {
                            var20 = ((var20 & 16711935) * var17 >> 8 & 16711935)
                                    + (var17 * (var20 & '\uff00') >> 8 & '\uff00');
                            Rasterizer2D_pixels[var11++] = var18 + var20;
                        }
                    }

                    var11 += var10;
                    var8 += var9;
                }
            }

        }
    }

    public static void Rasterizer2D_drawGradientPixels(int var0, int var1, int var2, int var3, int var4, int var5,
            byte[] var6, int var7) {
        if (var0 + var2 >= 0 && var3 + var1 >= 0) {
            if (var0 < graphicsPixelsWidth && var1 < Rasterizer2D_height) {
                int var8 = 0;
                int var9 = 0;
                if (var0 < 0) {
                    var8 -= var0;
                    var2 += var0;
                }

                if (var1 < 0) {
                    var9 -= var1;
                    var3 += var1;
                }

                if (var0 + var2 > graphicsPixelsWidth) {
                    var2 = graphicsPixelsWidth - var0;
                }

                if (var3 + var1 > Rasterizer2D_height) {
                    var3 = Rasterizer2D_height - var1;
                }

                int var10 = var6.length / var7;
                int var11 = graphicsPixelsWidth - var2;
                int var12 = var4 >>> 24;
                int var13 = var5 >>> 24;
                int var14;
                int var15;
                int var16;
                int var17;
                int var18;
                if (var12 == 255 && var13 == 255) {
                    var14 = var0 + var8 + (var9 + var1) * graphicsPixelsWidth;

                    for (var15 = var9 + var1; var15 < var3 + var9 + var1; ++var15) {
                        for (var16 = var0 + var8; var16 < var0 + var8 + var2; ++var16) {
                            var17 = (var15 - var1) % var10;
                            var18 = (var16 - var0) % var7;
                            if (var6[var18 + var17 * var7] != 0) {
                                Rasterizer2D_pixels[var14++] = var5;
                            } else {
                                Rasterizer2D_pixels[var14++] = var4;
                            }
                        }

                        var14 += var11;
                    }
                } else {
                    var14 = var0 + var8 + (var9 + var1) * graphicsPixelsWidth;

                    for (var15 = var9 + var1; var15 < var3 + var9 + var1; ++var15) {
                        for (var16 = var0 + var8; var16 < var0 + var8 + var2; ++var16) {
                            var17 = (var15 - var1) % var10;
                            var18 = (var16 - var0) % var7;
                            int var19 = var4;
                            if (var6[var18 + var17 * var7] != 0) {
                                var19 = var5;
                            }

                            int var20 = var19 >>> 24;
                            int var21 = 255 - var20;
                            int var22 = Rasterizer2D_pixels[var14];
                            int var23 = ((var19 & 16711935) * var20 + (var22 & 16711935) * var21 & -16711936)
                                    + (var20 * (var19 & '\uff00') + var21 * (var22 & '\uff00') & 16711680) >> 8;
                            Rasterizer2D_pixels[var14++] = var23;
                        }

                        var14 += var11;
                    }
                }

            }
        }
    }

    public static void Rasterizer2D_drawRectangle(int var0, int var1, int var2, int var3, int var4) {
        Rasterizer2D_drawHorizontalLine(var0, var1, var2, var4);
        Rasterizer2D_drawHorizontalLine(var0, var3 + var1 - 1, var2, var4);
        Rasterizer2D_drawVerticalLine(var0, var1, var3, var4);
        Rasterizer2D_drawVerticalLine(var0 + var2 - 1, var1, var3, var4);
    }

    public static void Rasterizer2D_drawRectangleAlpha(int var0, int var1, int var2, int var3, int var4, int var5) {
        Rasterizer2D_drawHorizontalLineAlpha(var0, var1, var2, var4, var5);
        Rasterizer2D_drawHorizontalLineAlpha(var0, var3 + var1 - 1, var2, var4, var5);
        if (var3 >= 3) {
            Rasterizer2D_drawVerticalLineAlpha(var0, var1 + 1, var3 - 2, var4, var5);
            Rasterizer2D_drawVerticalLineAlpha(var0 + var2 - 1, var1 + 1, var3 - 2, var4, var5);
        }

    }

    public static void Rasterizer2D_drawHorizontalLine(int var0, int var1, int var2, int var3) {
        if (var1 >= drawingAreaTop && var1 < drawingAreaBottom) {
            if (var0 < drawRegionX) {
                var2 -= drawRegionX - var0;
                var0 = drawRegionX;
            }

            if (var0 + var2 > drawingAreaRight) {
                var2 = drawingAreaRight - var0;
            }

            int var4 = var0 + graphicsPixelsWidth * var1;

            for (int var5 = 0; var5 < var2; ++var5) {
                Rasterizer2D_pixels[var4 + var5] = var3;
            }

        }
    }

    static void Rasterizer2D_drawHorizontalLineAlpha(int var0, int var1, int var2, int var3, int var4) {
        if (var1 >= drawingAreaTop && var1 < drawingAreaBottom) {
            if (var0 < drawRegionX) {
                var2 -= drawRegionX - var0;
                var0 = drawRegionX;
            }

            if (var0 + var2 > drawingAreaRight) {
                var2 = drawingAreaRight - var0;
            }

            int var5 = 256 - var4;
            int var6 = (var3 >> 16 & 255) * var4;
            int var7 = (var3 >> 8 & 255) * var4;
            int var8 = var4 * (var3 & 255);
            int var12 = var0 + graphicsPixelsWidth * var1;

            for (int var13 = 0; var13 < var2; ++var13) {
                int var9 = var5 * (Rasterizer2D_pixels[var12] >> 16 & 255);
                int var10 = (Rasterizer2D_pixels[var12] >> 8 & 255) * var5;
                int var11 = var5 * (Rasterizer2D_pixels[var12] & 255);
                int var14 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                Rasterizer2D_pixels[var12++] = var14;
            }

        }
    }

    public static void Rasterizer2D_drawVerticalLine(int var0, int var1, int var2, int var3) {
        if (var0 >= drawRegionX && var0 < drawingAreaRight) {
            if (var1 < drawingAreaTop) {
                var2 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var2 + var1 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var1;
            }

            int var4 = var0 + graphicsPixelsWidth * var1;

            for (int var5 = 0; var5 < var2; ++var5) {
                Rasterizer2D_pixels[var4 + var5 * graphicsPixelsWidth] = var3;
            }

        }
    }

    static void Rasterizer2D_drawVerticalLineAlpha(int var0, int var1, int var2, int var3, int var4) {
        if (var0 >= drawRegionX && var0 < drawingAreaRight) {
            if (var1 < drawingAreaTop) {
                var2 -= drawingAreaTop - var1;
                var1 = drawingAreaTop;
            }

            if (var2 + var1 > drawingAreaBottom) {
                var2 = drawingAreaBottom - var1;
            }

            int var5 = 256 - var4;
            int var6 = (var3 >> 16 & 255) * var4;
            int var7 = (var3 >> 8 & 255) * var4;
            int var8 = var4 * (var3 & 255);
            int var12 = var0 + graphicsPixelsWidth * var1;

            for (int var13 = 0; var13 < var2; ++var13) {
                int var9 = var5 * (Rasterizer2D_pixels[var12] >> 16 & 255);
                int var10 = (Rasterizer2D_pixels[var12] >> 8 & 255) * var5;
                int var11 = var5 * (Rasterizer2D_pixels[var12] & 255);
                int var14 = (var8 + var11 >> 8) + (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8);
                Rasterizer2D_pixels[var12] = var14;
                var12 += graphicsPixelsWidth;
            }

        }
    }

    public static void Rasterizer2D_drawLine(int var0, int var1, int var2, int var3, int var4) {
        var2 -= var0;
        var3 -= var1;
        if (var3 == 0) {
            if (var2 >= 0) {
                Rasterizer2D_drawHorizontalLine(var0, var1, var2 + 1, var4);
            } else {
                Rasterizer2D_drawHorizontalLine(var0 + var2, var1, -var2 + 1, var4);
            }

        } else if (var2 == 0) {
            if (var3 >= 0) {
                Rasterizer2D_drawVerticalLine(var0, var1, var3 + 1, var4);
            } else {
                Rasterizer2D_drawVerticalLine(var0, var3 + var1, -var3 + 1, var4);
            }

        } else {
            if (var3 + var2 < 0) {
                var0 += var2;
                var2 = -var2;
                var1 += var3;
                var3 = -var3;
            }

            int var5;
            int var6;
            if (var2 > var3) {
                var1 <<= 16;
                var1 += 32768;
                var3 <<= 16;
                var5 = (int) Math.floor((double) var3 / (double) var2 + 0.5D);
                var2 += var0;
                if (var0 < drawRegionX) {
                    var1 += var5 * (drawRegionX - var0);
                    var0 = drawRegionX;
                }

                if (var2 >= drawingAreaRight) {
                    var2 = drawingAreaRight - 1;
                }

                while (var0 <= var2) {
                    var6 = var1 >> 16;
                    if (var6 >= drawingAreaTop && var6 < drawingAreaBottom) {
                        Rasterizer2D_pixels[var0 + var6 * graphicsPixelsWidth] = var4;
                    }

                    var1 += var5;
                    ++var0;
                }
            } else {
                var0 <<= 16;
                var0 += 32768;
                var2 <<= 16;
                var5 = (int) Math.floor((double) var2 / (double) var3 + 0.5D);
                var3 += var1;
                if (var1 < drawingAreaTop) {
                    var0 += (drawingAreaTop - var1) * var5;
                    var1 = drawingAreaTop;
                }

                if (var3 >= drawingAreaBottom) {
                    var3 = drawingAreaBottom - 1;
                }

                while (var1 <= var3) {
                    var6 = var0 >> 16;
                    if (var6 >= drawRegionX && var6 < drawingAreaRight) {
                        Rasterizer2D_pixels[var6 + graphicsPixelsWidth * var1] = var4;
                    }

                    var0 += var5;
                    ++var1;
                }
            }

        }
    }

    static void Rasterizer2D_setPixel(int var0, int var1, int var2) {
        if (var0 >= drawRegionX && var1 >= drawingAreaTop && var0 < drawingAreaRight
                && var1 < drawingAreaBottom) {
            Rasterizer2D_pixels[var0 + graphicsPixelsWidth * var1] = var2;
        }
    }

    public static void Rasterizer2D_fillMaskedRectangle(int var0, int var1, int var2, int[] var3, int[] var4) {
        int var5 = var0 + graphicsPixelsWidth * var1;

        for (var1 = 0; var1 < var3.length; ++var1) {
            int var6 = var5 + var3[var1];

            for (var0 = -var4[var1]; var0 < 0; ++var0) {
                Rasterizer2D_pixels[var6++] = var2;
            }

            var5 += graphicsPixelsWidth;
        }

    }
}

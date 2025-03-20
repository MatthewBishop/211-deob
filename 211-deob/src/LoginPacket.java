public class LoginPacket implements class278 {

    public static final LoginPacket field2682 = new LoginPacket(14, 0);

    static final LoginPacket field2677 = new LoginPacket(15, 4);

    public static final LoginPacket NEW_LOGIN_CONNECTION = new LoginPacket(16, -2);

    public static final LoginPacket RECONNECT_LOGIN_CONNECTION = new LoginPacket(18, -2);

    public static final LoginPacket field2678 = new LoginPacket(19, -2);

    static final LoginPacket field2681 = new LoginPacket(27, 0);

    static final LoginPacket[] field2680 = new LoginPacket[32];

    public final int id;

    static {
        LoginPacket[] var0 = Canvas.method82();

        for (int var1 = 0; var1 < var0.length; ++var1) {
            field2680[var0[var1].id] = var0[var1];
        }

    }

    LoginPacket(int var1, int var2) {
        this.id = var1;
    }
}

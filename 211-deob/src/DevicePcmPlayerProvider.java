public class DevicePcmPlayerProvider implements class50 {

    static AbstractArchive VarbitDefinition_archive;

    public PcmPlayer player() {
        return new DevicePcmPlayer();
    }

    public static void method81(AbstractArchive var0) {
        DbTableType.field3990 = var0;
    }
}

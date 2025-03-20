import java.util.Date;

public class ArchiveDiskAction extends Node {

    int type;

    byte[] data;

    ArchiveDisk archiveDisk;

    Archive archive;

    static boolean method1791(Date var0) {
        Date var1 = StudioGame.method1786();
        return var0.after(var1);
    }
}

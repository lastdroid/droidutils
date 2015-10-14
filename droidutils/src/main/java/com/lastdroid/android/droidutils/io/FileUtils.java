package com.lastdroid.android.droidutils.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ming on 10/13/15.
 */
public class FileUtils {

    /**
     * save your file data safely.
     *
     * If you just use SharedPreferences or SQLite, you can relax, because we’ve made sure they
     * Do The Right Thing about buffering. But if you have your own on-disk format, keep in mind
     * that your data doesn't actually consistently reach the flash chip when you write() it or
     * even when you close() it. There are several layers of buffering between you and the hardware!
     * And because of ext4 buffering policy, any POSIX guarantees that you thought you had before
     * (but actually didn't), you especially don't have now.
     *
     * Some Android devices are already running non-YAFFS filesystems, but as we brought up the
     * Nexus S, buffering issues have actually bitten us a couple of times in framework code.
     * When the Gingerbread source code becomes available, you’ll find lots of examples of how
     * file I/O should be done.
     *
     * see http://android-developers.blogspot.com/2010/12/saving-data-safely.html
     *
     * @param stream file stream you need sync cache to disk.
     * @return true indicate success, otherwise false.
     */
    public static boolean sync(FileOutputStream stream) {
        try {
            if (stream != null) {
                stream.getFD().sync();
            }
            return true;
        } catch (IOException e) {
        }
        return false;
    }
}

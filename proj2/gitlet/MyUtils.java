package gitlet;

import java.io.File;

import static gitlet.Utils.message;

/**
 * Utility functions.
 *
 * @author Exuanbo
 */
public class MyUtils {

    /**
     * Create a directory from the File object.
     *
     * @param dir File object
     */
    public static void mkdir(File dir) {
        if (!dir.mkdir()) {
            throw new IllegalArgumentException(String.format("mkdir: %s: Failed to create.", dir.getPath()));
        }
    }

    /**
     * Delete the file if exists.
     *
     * @param file File instance
     */
    public static void rm(File file) {
        if (!file.delete()) {
            throw new IllegalArgumentException(String.format("rm: %s: Failed to delete.", file.getPath()));
        }
    }

    /**
     * Delete the object file and its directory if no other files exist.
     *
     * @param file File instance
     */
    @SuppressWarnings("ConstantConditions")
    public static void rmObjectFile(File file) {
        rm(file);
        File dir = file.getParentFile();
        if (dir.list().length == 0) {
            rm(dir);
        }
    }

    /**
     * Print a message and exit with status code 0.
     *
     * @param msg  String to print
     * @param args Arguments referenced by the format specifiers in the format string
     */
    public static void exit(String msg, Object... args) {
        message(msg, args);
        System.exit(0);
    }
}

package zlh.test.hello;

import java.io.File;
import java.io.FileFilter;

public class LambdaTest {
    public static void normalFunc1() {
        File dir = new File("D:\\Program Files");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
        File[] dirs = dir.listFiles(fileFilter);
        for (int i = 0; i < dirs.length; i++) {

            System.out.println("normalFunc1:" + dirs[i].getPath());
        }
    }

    static void lambdaFunc1() {
        File dir = new File("D:\\Program Files");
        File[] dirs = dir.listFiles(f -> f.isDirectory());
        for (int i = 0; i < dirs.length; i++) {

            System.out.println("lambdaFunc1:" + dirs[i].getPath());
        }
    }

}

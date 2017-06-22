package hns.gwi.javacallc.test;
import com.sun.jna.Library;

public interface MathAdd extends Library{

 int add_ex(int i,int j);
 int fnCppDllTest();
 
}

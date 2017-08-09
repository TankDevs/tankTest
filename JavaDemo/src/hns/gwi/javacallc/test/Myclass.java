package hns.gwi.javacallc.test;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public class Myclass {
    public static void main(String[] args) {

        // MathAdd mathAdd=
        // (MathAdd)Native.loadLibrary("CppDllTest",MathAdd.class);
        // int sum=0;
        // sum= mathAdd.add_ex(3, 4);
        // sum= mathAdd.fnCppDllTest();
        // System.out.println(sum);

        Pointer pszRcCodePointer = new Memory(260L);
        // GWI_ReceiptPrinter_Driver.dll.Receipt_CloseDevice(pszRcCodePointer);

        GWI_ReceiptPrinter_Driver dll = (GWI_ReceiptPrinter_Driver) Native.loadLibrary("GWI_ReceiptPrinter_Driver",
                GWI_ReceiptPrinter_Driver.class);

        dll.Receipt_SetDeviceTraceLevel(0x1111);
        // Pointer pszRcCodePointer = new Memory(260L);
        pszRcCodePointer.setString(0, "");
        Pointer devType = new Memory(260L);
        devType.setString(0, "MB510");// ¡°KS80T¡±¡¢ ¡°KS76M¡±
                                      // ¡¢¡°TGH2480¡±¡¢¡°MB510¡±¡¢¡°MB500¡±¡¢¡°TUP542¡±¡¢¡°NP3511¡±¡¢¡°KP80T¡±
        Pointer devPort = new Memory(260L);
        devPort.setString(0, "COM6");
        Pointer devPortParam = new Memory(260L);
        devPortParam.setString(0, "9600,n,8,1");
        int setDeviceParamResult = dll.Receipt_SetDeviceParam(devType, devPort, devPortParam, pszRcCodePointer);

        System.out.println("setDeviceParamResult:" + setDeviceParamResult);
        System.out.println("pszRcCode:" + pszRcCodePointer.getString(0, "UTF-8"));

        pszRcCodePointer.clear(265L);
        pszRcCodePointer = new Memory(265L);

        int OpenDeviceResult = dll.Receipt_OpenDevice(pszRcCodePointer);
        System.out.println("OpenDeviceResult:" + OpenDeviceResult);
        System.out.println("pszRcCode:" + pszRcCodePointer.getString(0, "UTF-8"));

        int resetResult = dll.Receipt_Reset(5000, pszRcCodePointer);
        System.out.println("resetResult:" + resetResult);
        System.out.println("pszRcCode:" + pszRcCodePointer.getString(0, "UTF-8"));

        IntByReference status = new IntByReference();
        status.setValue(0);

        int getStatusResult = dll.Receipt_GetStatus(5000, status, pszRcCodePointer);
        Pointer printData = new Memory(260L);
        System.out.println("getStatusResult:" + getStatusResult);
        System.out.println("status:" + status.getValue());
        System.out.println("pszRcCode:" + pszRcCodePointer.getString(0, "UTF-8"));

        printData.setString(0, "JavaCallC Print RowData Success");
        int printRowDataResult = dll.Receipt_PrintRowData(printData, 5000, pszRcCodePointer);
        System.out.println("printRowDataResult:" + printRowDataResult);
        System.out.println("pszRcCode:" + pszRcCodePointer.getString(0, "UTF-8"));

        int cutPaperResult = dll.Receipt_CutPaper(5000, pszRcCodePointer);
        System.out.println("cutPaperResult:" + cutPaperResult);
        System.out.println("pszRcCode:" + pszRcCodePointer.getString(0, "UTF-8"));

        int closeDeviceResult = dll.Receipt_CloseDevice(pszRcCodePointer);
        System.out.println("closeDeviceResult:" + closeDeviceResult);
        System.out.println("pszRcCode:" + pszRcCodePointer.getString(0, "UTF-8"));

        System.out.println("Hello");

    }
}

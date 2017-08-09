
package hns.gwi.javacallc.test;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public interface GWI_ReceiptPrinter_Driver extends Library {

    // GWI_ReceiptPrinter_Driver dll =
    // Native.loadLibrary("GWI_ReceiptPrinter_Driver",
    // GWI_ReceiptPrinter_Driver.class);

    void Receipt_SetDeviceTraceLevel(int level);

    int Receipt_SetDeviceParam(Pointer devType, Pointer devPort, Pointer devPortParam, Pointer pszRcCode);

    int Receipt_OpenDevice(Pointer pszRcCode);

    int Receipt_Reset(int dwTimeOut, Pointer pszRcCode);

    int Receipt_GetStatus(int dwTimeOut, IntByReference status, Pointer pszRcCode);

    int Receipt_PrintRowData(Pointer printData, int dwTimeOut, Pointer pszRcCode);

    int Receipt_CutPaper(int dwTimeOut, Pointer pszRcCode);

    int Receipt_CloseDevice(Pointer pszRcCode);
}
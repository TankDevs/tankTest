import java.util.logging.Logger;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class JF_window extends ApplicationWindow {
    private Text txtName;
    private Text txtSex;
    private Text txtAge;
    private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
    private Table table;

    /**
     * Create the application window.
     */
    public JF_window() {
        super(null);
        createActions();
        addToolBar(SWT.FLAT | SWT.WRAP);
        addMenuBar();
        addStatusLine();
    }

    /**
     * Create contents of the application window.
     * 
     * @param parent
     */
    @Override
    protected Control createContents(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        {
            Button btnNewButton = new Button(container, SWT.NONE);
            btnNewButton.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                }
            });
            /*
             * btnNewButton.addSelectionListener(new SelectionAdapter() {
             * 
             * @Override public void widgetSelected(SelectionEvent e) {
             * //MessageDialog.openInformation((Shell) parent, "提示",
             * txtName.getText()+txtAge.getText()+txtSex.getText());
             * MessageDialog.openInformation((Shell) parent, "widgetSelected事件",
             * "Hello"); } });
             */
            btnNewButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseDown(MouseEvent e) {
                    int i = 0;
                    String str = "Hello world！！！！！";
                    Logger logs = Logger.getLogger("logAAA");
                    MessageDialog.openInformation((Shell) parent, "提示", txtName.getText() + i + str);
                    logs.info("It's OK!");
                    logs.warning("It's warning!");
                    str += "sdfsjiasdf";

                }
            });
            btnNewButton.setBounds(54, 132, 80, 27);
            btnNewButton.setText("\u6D4B\u8BD5\u6309\u94AE");
        }

        Label label = new Label(container, SWT.NONE);
        label.setBounds(23, 10, 36, 17);
        label.setText("\u59D3\u540D\uFF1A");

        txtName = new Text(container, SWT.BORDER);
        txtName.setBounds(61, 7, 73, 23);

        Label label_1 = new Label(container, SWT.NONE);
        label_1.setBounds(23, 49, 36, 17);
        label_1.setText("\u6027\u522B\uFF1A");

        Label label_2 = new Label(container, SWT.NONE);
        label_2.setBounds(23, 85, 36, 17);
        label_2.setText("\u5E74\u9F84\uFF1A");

        txtSex = new Text(container, SWT.BORDER);
        txtSex.setBounds(61, 46, 73, 23);

        txtAge = new Text(container, SWT.BORDER);
        txtAge.setBounds(61, 82, 73, 23);

        table = formToolkit.createTable(container, SWT.NONE);
        table.setBounds(199, 10, 176, 129);
        formToolkit.paintBordersFor(table);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableItem tableItem_2 = new TableItem(table, SWT.NONE);
        tableItem_2.setText("New TableItem");

        TableItem tableItem = new TableItem(table, SWT.NONE);
        tableItem.setText("New TableItem");

        TableItem tableItem_1 = new TableItem(table, SWT.NONE);
        tableItem_1.setText("New TableItem");

        TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn.setWidth(100);
        tblclmnNewColumn.setText("New Column");

        TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn_1.setWidth(100);
        tblclmnNewColumn_1.setText("New Column");

        return container;
    }

    /**
     * Create the actions.
     */
    private void createActions() {
        // Create the actions
    }

    /**
     * Create the menu manager.
     * 
     * @return the menu manager
     */
    @Override
    protected MenuManager createMenuManager() {
        MenuManager menuManager = new MenuManager("menu");
        return menuManager;
    }

    /**
     * Create the toolbar manager.
     * 
     * @return the toolbar manager
     */
    @Override
    protected ToolBarManager createToolBarManager(int style) {
        ToolBarManager toolBarManager = new ToolBarManager(style);
        return toolBarManager;
    }

    /**
     * Create the status line manager.
     * 
     * @return the status line manager
     */
    @Override
    protected StatusLineManager createStatusLineManager() {
        StatusLineManager statusLineManager = new StatusLineManager();
        return statusLineManager;
    }

    /**
     * Launch the application.
     * 
     * @param args
     */
    public static void main(String args[]) {
        try {
            JF_window window = new JF_window();
            window.setBlockOnOpen(true);
            window.open();
            Display.getCurrent().dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Configure the shell.
     * 
     * @param newShell
     */
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("HelloWorld!-My first JFace window application！！！");
    }

    /**
     * Return the initial size of the window.
     */
    @Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }
}

package zlh.test.annotation.standard;

class AppleService {

    public void displayName() {
        System.out.println("ˮ���������ǣ�ƻ��");
    }

    /**
     * @deprecated �÷����Ѿ����ڣ����Ƽ�ʹ��!!!
     */
    @Deprecated
    public void showTaste() {
        System.out.println("ˮ����ƻ���Ŀڸ��ǣ�����");
    }

    /**
     * @author ZLH
     * @param typeId
     *            ����
     * @return void
     */
    public void showTaste(int typeId) {
        if (typeId == 1) {
            System.out.println("ˮ����ƻ���Ŀڸ��ǣ���ɬ");
        } else if (typeId == 2) {
            System.out.println("ˮ����ƻ���Ŀڸ��ǣ�����");
        } else {
            System.out.println("ˮ����ƻ���Ŀڸ��ǣ�����");
        }
    }
}

public class FruitRun {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.displayName();

        AppleService appleService = new AppleService();
        appleService.showTaste();
        appleService.showTaste(0);
        appleService.showTaste(2);
    }

}
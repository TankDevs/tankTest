package zlh.test.annotation.standard;

public class Fruit {

    public void displayName() {
        System.out.println("ˮ���������ǣ�*****");
    }
}

class Orange extends Fruit {
    // @Override
    public void displayName() {
        System.out.println("ˮ���������ǣ�����");
    }
}

class Apple extends Fruit {
    // @Override
    public void displayname() {
        System.out.println("ˮ���������ǣ�ƻ��");
    }
}
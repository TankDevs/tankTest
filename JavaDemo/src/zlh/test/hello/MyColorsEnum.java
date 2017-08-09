package zlh.test.hello;

public enum MyColorsEnum {

    RED(2), BLACK(2);

    private int _value;

    private MyColorsEnum(int value) {
        _value = value;
    }

    public int value() {
        return _value;
    }

}

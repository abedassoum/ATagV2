package org.example;

public class HTag extends Tag {

    private byte number;

    public HTag(int hnum) {
        number = (byte) hnum;
        this.setTagName("h" + number);
    }

    public byte getNumber() {
        return number;
    }

    public void setNumber(byte number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = (byte) number;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + "HTag{" +
                "number=" + number +
                '}';
    }
}

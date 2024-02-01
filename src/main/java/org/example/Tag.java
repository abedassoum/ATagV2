package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public abstract class Tag {

    private String id;
    private String tagName;
    private String text;
    private List<Tag> children;
    private String color = ""; //#ff0000 = red

    public Tag() {
        children = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(int red, int green, int blue) {
        String re = Integer.toHexString(red);
        String gree = Integer.toHexString(green);
        String blu = Integer.toHexString(blue);
        this.setColor("#" + re + gree + blu);
    }

    public static String rgbToColorString(int red, int green, int blue) {
        // Ensure that the color components are within the valid range (0-255)
        red = Math.min(255, Math.max(0, red));
        green = Math.min(255, Math.max(0, green));
        blue = Math.min(255, Math.max(0, blue));

        // Convert the RGB values to a color string in hexadecimal format
        String colorString = String.format("#%02X%02X%02X", red, green, blue);

        return colorString;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public List<Tag> getChildren() {
        return children;
    }

    public void setChildren(List<Tag> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", tagName='" + tagName + '\'' +
                ", text='" + text + '\'' + " children=" + this.children.size() +
                '}';
    }

    public String toHtmlStringNoChildren() {
        String s1 = "<" + tagName + ">";
        s1 = s1 + text + "</" + tagName + ">";
        return s1;
    }


    public String toHtmlString() {
        String s1 = "";
        if (this.getColor().length() > 0) {
            s1 = "<" + tagName + " style=" + '"' + "background-color:" + color + '"' + ">";
        } else {
            s1 = "<" + tagName + ">";
        }
        for (Tag tag: children) {
            String child = tag.toHtmlString();
            s1 = s1 + (char) 10 + child;
        }
        s1 = s1 + text + "</" + tagName + ">";
        return s1;
    }

    public String toHtmlStringFile(String fileName)  {
        String outputFile = fileName;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(this.toHtmlString());
            writer.close();
        } catch (Exception msg) {
            System.out.println(msg.getMessage());
        }
        return fileName;
    }

}

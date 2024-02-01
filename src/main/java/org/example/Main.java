package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello world!");

        HTag hTag = new HTag(1);
        hTag.setText("jeg er et h tag");

        //System.out.println(hTag);
        //System.out.println("nu er jeg på git");

        System.out.println(hTag.toHtmlString());

        List<Tag> hTags = new ArrayList<>();
        for (int i = 19; i>0; i--) {
            HTag hTag2 = new HTag(5-(i % 5));
            hTag2.setText("Jeg er et " + hTag2.getTagName() + " tag");
            hTag2.setColor(i*4, i*8, i*5);
            hTags.add(hTag2);
            for (int j=1; j<=5; j++) {
                PTag ptag = new PTag();
                ptag.setText("Jeg er en ptag indeni " + hTag2.getTagName());
                ptag.setColor(i+50, i+100, i+200);
                hTags.add(ptag);
            }
        }

        System.out.println(hTags.size());

        for (Tag tag: hTags) {
            //System.out.println(tag.toHtmlString());
            if (tag instanceof PTag) {
                //System.out.println("PPPPPPPPP");
            }
        }

        BodyTag body = new BodyTag();
        body.setChildren(hTags);
        System.out.println(body);
        System.out.println(body.toHtmlString());
        body.toHtmlStringFile("index.html");


        body.setColor(255, 10, 15);
        System.out.println(body.getColor());


    }
}
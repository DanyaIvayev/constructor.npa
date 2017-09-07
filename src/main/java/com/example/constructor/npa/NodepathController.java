package com.example.constructor.npa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by root on 9/5/17.
 */
@RestController
public class NodepathController {
    private static final String template = " %s";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping("/hello")
//    public Nodepath nodepath() {
//        ModeShapeWork msw = new ModeShapeWork();
//        try {
//            msw.start();
//            System.out.println("start");
//            msw.openSession();
//            System.out.println("open");
//            msw.uploadFiles();
//            System.out.println("upload");
//            Set<String> children = msw.getNodes();
//            String c = "";
//            msw.findNodes();
//            msw.logout();
//            for(String ch : children){
//                c+=children+"\n";
//            }
//            return new Nodepath(counter.incrementAndGet(),
//                    String.format(template, c));
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
}

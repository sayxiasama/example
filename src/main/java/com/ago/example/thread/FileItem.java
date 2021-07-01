package com.ago.example.thread;

import lombok.*;

import java.util.IdentityHashMap;

/**
 * @author ：Ago
 * @date ：Created in 2020/12/25 16:15
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FileItem {

    private String name;


    public static void main(String[] args) {


        IdentityHashMap<FileItem, String> objectObjectIdentityHashMap = new IdentityHashMap<>();

        FileItem fileItem = new FileItem("1");
        FileItem fileItem2 = new FileItem("1");

        objectObjectIdentityHashMap.put(fileItem, "ok");
        objectObjectIdentityHashMap.put(fileItem2, "fail");

        System.out.println(objectObjectIdentityHashMap.toString());

    }
}

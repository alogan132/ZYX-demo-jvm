package org.ZYX.demo.jvm.classpath.impl;

import org.ZYX.demo.jvm.classpath.Entry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * create by ZYX on 2021/05/13
 */
public class DirEntry implements Entry {

    private Path absolutePath;

    public DirEntry(String path){
        //获取绝对路径
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        return Files.readAllBytes(absolutePath.resolve(className));
    }

    @Override
    public String toString() {
        return this.absolutePath.toString();
    }
}

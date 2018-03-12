package com.example.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

import java.io.File;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;

public class ATest {
    public static void main(String[] args) {
        Collection<File> list=FileUtils.listFilesAndDirs(Paths.get("F:\\图片\\20170501").toFile(),new ImgIOFileFilter(),new DirIOFileFilter());
        for (File file:list){
            System.out.print("; "+file);
        }
    }
    static class ImgIOFileFilter implements IOFileFilter{

        @Override
        public boolean accept(File file) {
            System.out.println("ImgIOFileFilter:"+file.getName());
            return file.getName().endsWith(".png");
        }

        @Override
        public boolean accept(File dir, String name) {
            return false;
        }
    }

    static class DirIOFileFilter implements IOFileFilter{

        @Override
        public boolean accept(File file) {
            return file.getName().startsWith("banner");
        }

        @Override
        public boolean accept(File dir, String name) {
            return false;
        }
    }
}


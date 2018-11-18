package cn.gandan.day08.demo03;

import java.io.File;
import java.io.FileFilter;

public class FileFilterImpl implements FileFilter{
    @Override
    public boolean accept(File pathname) {
        if(pathname.isDirectory()){
            return true;
        }
        return pathname.getPath().toLowerCase().endsWith(".java");
    }
}

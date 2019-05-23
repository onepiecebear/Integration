package com.ebupt.reflect;

import com.ebupt.pojo.ServiceQuota;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @Author: yushibo
 * @Date: 2019/5/21 20:03
 * @Description:
 */
public class ReflectUtils {
    /**
     * 获得包下面的所有的class
     *
     * @param
     *
     * @return List包含所有class的实例
     */

    public static Class[] getClasssFromPackage(String packageName) {
        Class[] clazzs = new Class[50];
//        Set<Class<?>> clazzs = new LinkedHashSet<Class<?>>();
        // 是否循环搜索子包
        boolean recursive = true;
        // 包名对应的路径名称
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs;

        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {

                URL url = dirs.nextElement();
                String protocol = url.getProtocol();

                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findClassInPackageByFile(packageName, filePath, recursive, clazzs);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clazzs;
    }

    /**
     * 在package对应的路径下找到所有的class
     */
    public static void findClassInPackageByFile(String packageName, String filePath, final boolean recursive,
                                                Class[] clazzs) {
        File dir = new File(filePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 在给定的目录下找到所有的文件，并且进行条件过滤
        File[] dirFiles = dir.listFiles(new FileFilter() {

            public boolean accept(File file) {
                boolean acceptDir = recursive && file.isDirectory();// 接受dir目录
                boolean acceptClass = file.getName().endsWith("class");// 接受class文件
                return acceptDir || acceptClass;
            }
        });

        for (int i = 0; i < dirFiles.length; i++) {
            if (dirFiles[i].isDirectory()) {
                findClassInPackageByFile(packageName + "." + dirFiles[i].getName(), dirFiles[i].getAbsolutePath(), recursive, clazzs);
            } else {
                String className = dirFiles[i].getName().substring(0, dirFiles[i].getName().length() - 6);
                try {
                    clazzs[i]=Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Class[] clazzs =  getClasssFromPackage("com.ebupt.pojo");
        for (int i = 0; i < clazzs.length; i++) {
            System.out.println(clazzs[i].getSimpleName());
        }
        XStream xStream = new XStream();
        xStream.processAnnotations(clazzs);
    }
}

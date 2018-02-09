package io.lim.keeps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author linmin1 on 2018/2/8.
 */

public class ProguardFileOuter {

    private File mFile;

    private ProguardFileOuter(String filePath){
        mFile = new File(filePath);
        if(mFile.exists()){
            mFile.delete();
        }
        try {
            mFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ProguardFileOuter build(String path){
        return new ProguardFileOuter(path);
    }

    public synchronized void println(String str) {
        if(null == str || "".equals(str))
            return;
        String withEndl= str +"\n";
        System.out.println(withEndl);
        FileWriter writer = null;
        try{
            writer = new FileWriter(mFile,true);
            writer.write(withEndl);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

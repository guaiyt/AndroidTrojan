package com.example.gx.androidtrojan;

import java.io.*;

/**
 * 针对 .jpg/.jpeg 类型的文件的隐写
 */
public class FileTail {
    private static final int PREV = 255;
    private static final int NEXT = 217;

    /**
     * 将信息隐藏在 .jpg/.jpeg 文件末尾
     *
     * @param imageStream 载体图片文件
     * @param message     待隐藏的信息
     * @param resultPath  隐写的结果文件存储路径
     */
    public static void encode(InputStream imageStream, String message, String resultPath) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(imageStream);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(resultPath));

        int data = bis.read();
        while (data != -1) {
            bos.write(data);
            data = bis.read();
        }
        bos.write(message.getBytes());

        bis.close();
        bos.close();
    }

    /**
     * 将隐藏在 .jpg/.jpeg 图片中的信息提取出来
     *
     * @param imagePath 图片文件路径
     * @return 隐藏的信息
     */
    public static String decode(String imagePath) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imagePath));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int prev, next;
        int data = bis.read();
        while (data != -1) {
            prev = data;
            data = bis.read();
            next = data;

            if (prev == PREV && next == NEXT) {
                System.out.println("found image end mark");
                break;
            }
        }

        data = bis.read();
        while (data != -1) {
            baos.write(data);
            data = bis.read();
        }

        return new String(baos.toByteArray());
    }
}

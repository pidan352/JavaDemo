package com.aliai.utils;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.*;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

/**
 * Desc:
 *
 * @author <a href="mailto:yllin1@chinaums.com">林亦亮</a>
 * @since 2025/03/28 09:01:02
 */
@Slf4j
public class CompressImageUtil {

    /**
     * 默认压缩参数
     */
    private final static float defaultQuantity = 0.3F;


    /**
     * 压缩图片
     *
     * @param sourceFile 源文件
     * @param outPutFile 输出的文件   不填则输出  源文件-ys.*
     * @param size       大于等于size，压缩,单位KB
     * @param quantity   压缩参数 0F-1F
     * @return 大于size返回压缩后的文件，否则返回源文件
     */
    public static String compressImage(String sourceFile, String outPutFile, int size, float quantity) throws IOException {

        if (StrUtil.isBlank(sourceFile)) {
            throw new FileNotFoundException("文件路径为空：" + sourceFile);
        }
        File srcFileJPG = new File(sourceFile);

        if (!srcFileJPG.exists()) {
            throw new FileNotFoundException("文件不存在: " + sourceFile);
        }

        int index = sourceFile.lastIndexOf(".");
        if (index == -1) {
            throw new FileNotFoundException("错误的输入文件格式 : " + sourceFile);
        }

        if (StrUtil.isNotBlank(outPutFile)) {
            if (outPutFile.lastIndexOf(".") == -1) {
                throw new FileNotFoundException("错误的输出文件格式 : " + outPutFile);
            }
        }

        String destFile;
        try {
            String fileExtension = sourceFile.substring(index);
            if (StrUtil.isBlank(outPutFile)) {
                destFile = sourceFile.substring(0, index) + "-ys" + fileExtension;
            } else {
                destFile = outPutFile;
            }

            long srcFileSizeJPG = srcFileJPG.length();

            // 判断大小，如果小于size，不压缩；如果大于等于size，压缩
            if (srcFileSizeJPG <= size * 1024L) {
                return sourceFile;
            }

            compress(srcFileJPG, new File(destFile), quantity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return destFile;
    }

    /**
     * 压缩图片 默认参数参数0.3F
     *
     * @param sourceFile 源文件
     * @param size       大于等于size，压缩,单位KB
     * @return 大于size返回压缩后的文件，否则返回源文件
     */
    public static String compressImage(String sourceFile, int size) throws IOException {
        return compressImage(sourceFile, null, size, defaultQuantity);
    }

    /**
     * 压缩图片 默认参数参数0.3F
     *
     * @param sourceFile 源文件
     * @param outPutFile 输出文件
     * @param size       大于等于size，压缩,单位KB
     * @return 大于size返回压缩后的文件，否则返回源文件
     */
    public static String compressImage(String sourceFile, String outPutFile, int size) throws IOException {
        return compressImage(sourceFile, outPutFile, size, defaultQuantity);
    }

    private static void compress(File inputFile, File outputFile, float quality) throws IOException {

        try (
                ImageInputStream iis = ImageIO.createImageInputStream(inputFile);
                FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
                ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(fileOutputStream)
        ) {
            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
            if (!readers.hasNext()) {
                throw new IOException("不支持的图片格式: " + inputFile.getAbsolutePath());
            }

            ImageReader reader = readers.next();
            reader.setInput(iis);

            String formatName = reader.getFormatName().toLowerCase();

            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(formatName);
            if (!writers.hasNext()) {
                throw new IOException("找不到该格式的编码器: " + formatName);
            }

            BufferedImage image = ImageIO.read(inputFile);

            ImageWriter writer = writers.next();
            writer.setOutput(imageOutputStream);

            ImageWriteParam imageWriteParam = writer.getDefaultWriteParam();
            if (imageWriteParam != null) {
                if (imageWriteParam.canWriteCompressed()) {
                    imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                    imageWriteParam.setCompressionQuality(quality);
                }else {
                    //无法压缩时
                    // 将图片转换为 8 位索引颜色模式
                    BufferedImage indexedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_INDEXED);
                    Graphics2D g2d = indexedImage.createGraphics();
                    g2d.drawImage(image, 0, 0, null);
                    g2d.dispose();
                    image = indexedImage;
                }
            }

            writer.write(null, new IIOImage(image, null, null), imageWriteParam);
            writer.dispose();
        }
    }

    public static byte[] compressMultipartFile(MultipartFile file, float quality) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("文件为空");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(file.getBytes());
        ImageInputStream iis = ImageIO.createImageInputStream(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
        try {
            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
            if (!readers.hasNext()) {
                throw new IOException("不支持的图片格式");
            }

            ImageReader reader = readers.next();
            reader.setInput(iis);

            String formatName = reader.getFormatName().toLowerCase();

            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(formatName);
            if (!writers.hasNext()) {
                throw new IOException("找不到该格式的编码器: " + formatName);
            }

            BufferedImage image = reader.read(0);

            ImageWriter writer = writers.next();
            writer.setOutput(ios);

            javax.imageio.ImageWriteParam imageWriteParam = writer.getDefaultWriteParam();
            if (imageWriteParam != null) {
                if (imageWriteParam.canWriteCompressed()) {
                    imageWriteParam.setCompressionMode(javax.imageio.ImageWriteParam.MODE_EXPLICIT);
                    imageWriteParam.setCompressionQuality(quality);
                } else {
                    //png可能出现无法压缩
                    // 将图片转换为 8 位索引颜色模式
                    BufferedImage indexedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_INDEXED);
                    Graphics2D g2d = indexedImage.createGraphics();
                    g2d.drawImage(image, 0, 0, null);
                    g2d.dispose();
                    image = indexedImage;
                }
            }

            writer.write(null, new IIOImage(image, null, null), imageWriteParam);
            byte[] byteArray = baos.toByteArray();
            writer.dispose();

            return byteArray;
        } finally {
            bais.close();
            iis.close();
            baos.close();
            ios.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String s = compressImage("/nfs/jiadian/jiadian-server/pic/20250313/202503071518035a479b.png", 1024);
        System.out.println(s);
    }

}

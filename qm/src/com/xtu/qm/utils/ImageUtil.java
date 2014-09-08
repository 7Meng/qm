package com.xtu.qm.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public final class ImageUtil {
	 /** 
     * * ͼƬ�ļ���ȡ 
     *  
     * @param srcImgPath 
     * @return 
     */  
    private static BufferedImage InputImage(String srcImgPath) throws RuntimeException { 
  
        BufferedImage srcImage = null;
        FileInputStream in = null;
        try {  
            // ����BufferedImage����  
            File file = new File(srcImgPath);  
            in = new FileInputStream(file);  
            byte[] b = new byte[5];  
            in.read(b);  
            srcImage = javax.imageio.ImageIO.read(file); 
        } catch (IOException e) {  
        	e.printStackTrace();  
        	throw new RuntimeException("��ȡͼƬ�ļ�����", e);
        } finally {
        	if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					throw new RuntimeException("��ȡͼƬ�ļ�����", e);
				}
			}
        }
        return srcImage;  
    }  
  
    /** 
     * * ��ͼƬ����ָ����ͼƬ�ߴ硢ԴͼƬ����ѹ��(Ĭ������Ϊ1) 
     *  
     * @param srcImgPath 
     *            :ԴͼƬ·�� 
     * @param outImgPath 
     *            :�����ѹ��ͼƬ��·�� 
     * @param new_w 
     *            :ѹ�����ͼƬ�� 
     * @param new_h 
     *            :ѹ�����ͼƬ�� 
     */  
    public static void resize(String srcImgPath, String outImgPath,  
            int new_w, int new_h) {  
        resize(srcImgPath, outImgPath, new_w, new_h, 1F);  
    }  
  
    /** 
     * ��ͼƬ����ָ���ĳߴ������ԴͼƬ����ѹ��(Ĭ������Ϊ1) 
     *  
     * @param srcImgPath 
     *            :ԴͼƬ·�� 
     * @param outImgPath 
     *            :�����ѹ��ͼƬ��·�� 
     * @param ratio 
     *            :ѹ�����ͼƬ�ߴ���� 
     * @param per 
     *            :�ٷֱ� 
     */  
    public static void resize(String srcImgPath, String outImgPath,  
            float ratio) {  
        resize(srcImgPath, outImgPath, ratio, 1F);  
    }  
  
    /** 
     * ��ͼƬ����ָ�������߿�����ֵ��ѹ��ͼƬ(Ĭ������Ϊ1) 
     *  
     * @param srcImgPath 
     *            :ԴͼƬ·�� 
     * @param outImgPath 
     *            :�����ѹ��ͼƬ��·�� 
     * @param maxLength 
     *            :�����߿�����ֵ 
     * @param per 
     *            :ͼƬ���� 
     */  
    public static void resize(String srcImgPath, String outImgPath,  
            int maxLength) {  
        resize(srcImgPath, outImgPath, maxLength, 1F);  
    }  
  
    /** 
     * * ��ͼƬ����ָ����ͼƬ�ߴ硢ͼƬ����ѹ�� 
     *  
     * @param srcImgPath 
     *            :ԴͼƬ·�� 
     * @param outImgPath 
     *            :�����ѹ��ͼƬ��·�� 
     * @param new_w 
     *            :ѹ�����ͼƬ�� 
     * @param new_h 
     *            :ѹ�����ͼƬ�� 
     * @param per 
     *            :�ٷֱ� 
     */  
    public static void resize(String srcImgPath, String outImgPath,  
            int new_w, int new_h, float per) {  
        // �õ�ͼƬ  
        BufferedImage src = InputImage(srcImgPath);  
        int old_w = src.getWidth();  
        // �õ�Դͼ��  
        int old_h = src.getHeight();  
        // �õ�Դͼ��  
        // ����ԭͼ�Ĵ�С���ɿհ׻���  
        BufferedImage tempImg = new BufferedImage(old_w, old_h,  
                BufferedImage.TYPE_INT_RGB);  
        // ���µĻ���������ԭͼ������ͼ  
        Graphics2D g = tempImg.createGraphics();  
        g.setColor(Color.white);  
        g.fillRect(0, 0, old_w, old_h);  
        g.drawImage(src, 0, 0, old_w, old_h, Color.white, null);  
        g.dispose();  
        BufferedImage newImg = new BufferedImage(new_w, new_h,  
                BufferedImage.TYPE_INT_RGB);  
        newImg.getGraphics().drawImage(  
                tempImg.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0,  
                0, null);  
        // ���÷������ͼƬ�ļ�  
        outImage(outImgPath, newImg, per);  
    }  
  
    /** 
     * * ��ͼƬ����ָ���ĳߴ������ͼƬ����ѹ�� 
     *  
     * @param srcImgPath 
     *            :ԴͼƬ·�� 
     * @param outImgPath 
     *            :�����ѹ��ͼƬ��·�� 
     * @param ratio 
     *            :ѹ�����ͼƬ�ߴ���� 
     * @param per 
     *            :�ٷֱ� 
     */  
    public static void resize(String srcImgPath, String outImgPath,  
            float ratio, float per) {  
        // �õ�ͼƬ  
        BufferedImage src = InputImage(srcImgPath);  
        int old_w = src.getWidth();  
        // �õ�Դͼ��  
        int old_h = src.getHeight();  
        // �õ�Դͼ��  
        int new_w = Math.round(old_w * ratio);  
        // ��ͼ�Ŀ�  
        int new_h = Math.round(old_h * ratio);  
        // ��ͼ�ĳ�  
        BufferedImage tempImg = new BufferedImage(old_w, old_h,  
                BufferedImage.TYPE_INT_RGB);  
        Graphics2D g = tempImg.createGraphics();  
        g.setColor(Color.white);  
        // ��ԭͼ��ȡ��ɫ������ͼg.fillRect(0, 0, old_w, old_h);  
        g.drawImage(src, 0, 0, old_w, old_h, Color.white, null);  
        g.dispose();  
        // ����ͼƬ�ߴ�ѹ���ȵõ���ͼ�ĳߴ�new_w = (int) Math.round(old_w * ratio);  
        new_h = (int) Math.round(old_h * ratio);  
        BufferedImage newImg = new BufferedImage(new_w, new_h,  
                BufferedImage.TYPE_INT_RGB);  
        newImg.getGraphics().drawImage(  
                tempImg.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0,  
                0, null);  
        outImage(outImgPath, newImg, per);  
    }  
  
    /** 
     * <b>
     * ָ�������߿�����ֵ��ѹ��ͼƬ
     * 	�Ƽ�ʹ�ô˷��� 
     * </b>
     * @param srcImgPath 
     *            :ԴͼƬ·�� 
     * @param outImgPath 
     *            :�����ѹ��ͼƬ��·�� 
     * @param maxLength 
     *            :�����߿�����ֵ 
     * @param per 
     *            :ͼƬ���� 
     */  
    public static void resize(String srcImgPath, String outImgPath,  
            int maxLength, float per) {  
        // �õ�ͼƬ  
        BufferedImage src = InputImage(srcImgPath);  
        int old_w = src.getWidth();  
        // �õ�Դͼ��  
        int old_h = src.getHeight();  
        // �õ�Դͼ��  
        int new_w = 0;  
        // ��ͼ�Ŀ�  
        int new_h = 0;  
        // ��ͼ�ĳ�  
        BufferedImage tempImg = new BufferedImage(old_w, old_h,  
                BufferedImage.TYPE_INT_RGB);  
        Graphics2D g = tempImg.createGraphics();  
        g.setColor(Color.white);  
        // ��ԭͼ��ȡ��ɫ������ͼ  
        g.fillRect(0, 0, old_w, old_h);  
        g.drawImage(src, 0, 0, old_w, old_h, Color.white, null);  
        g.dispose();  
        // ����ͼƬ�ߴ�ѹ���ȵõ���ͼ�ĳߴ�  
        if (old_w > old_h) {  
            // ͼƬҪ���ŵı���  
            new_w = maxLength;  
            new_h = (int) Math.round(old_h * ((float) maxLength / old_w));  
        } else {  
            new_w = (int) Math.round(old_w * ((float) maxLength / old_h));  
            new_h = maxLength;  
        }  
        BufferedImage newImg = new BufferedImage(new_w, new_h,  
                BufferedImage.TYPE_INT_RGB);  
        newImg.getGraphics().drawImage(  
                tempImg.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0,  
                0, null);  
        // ���÷������ͼƬ�ļ�  
        outImage(outImgPath, newImg, per);  
    }  
    
    /**
     * ��ͼƬѹ����ָ����ȣ� �߶ȵȱ�������
     * 
     * @param srcImgPath
     * @param outImgPath
     * @param width
     * @param per
     */
    public static void resizeFixedWidth(String srcImgPath, String outImgPath,  
    		int width, float per) {  
    	// �õ�ͼƬ  
    	BufferedImage src = InputImage(srcImgPath);  
    	int old_w = src.getWidth();  
    	// �õ�Դͼ��  
    	int old_h = src.getHeight();  
    	// �õ�Դͼ��  
    	int new_w = 0;  
    	// ��ͼ�Ŀ�  
    	int new_h = 0;  
    	// ��ͼ�ĳ�  
    	BufferedImage tempImg = new BufferedImage(old_w, old_h,  
    			BufferedImage.TYPE_INT_RGB);  
    	Graphics2D g = tempImg.createGraphics();  
    	g.setColor(Color.white);  
    	// ��ԭͼ��ȡ��ɫ������ͼ  
    	g.fillRect(0, 0, old_w, old_h);  
    	g.drawImage(src, 0, 0, old_w, old_h, Color.white, null);  
    	g.dispose();  
    	// ����ͼƬ�ߴ�ѹ���ȵõ���ͼ�ĳߴ�  
    	if (old_w > old_h) {  
    		// ͼƬҪ���ŵı���  
    		new_w = width;  
    		new_h = (int) Math.round(old_h * ((float) width / old_w));  
    	} else {  
    		new_w = (int) Math.round(old_w * ((float) width / old_h));  
    		new_h = width;  
    	}  
    	BufferedImage newImg = new BufferedImage(new_w, new_h,  
    			BufferedImage.TYPE_INT_RGB);  
    	newImg.getGraphics().drawImage(  
    			tempImg.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0,  
    			0, null);  
    	// ���÷������ͼƬ�ļ�  
    	outImage(outImgPath, newImg, per);  
    }  
  
    /** 
     * * ��ͼƬ�ļ������ָ����·���������趨ѹ������ 
     *  
     * @param outImgPath 
     * @param newImg 
     * @param per 
     * @author cevencheng
     */  
    private static void outImage(String outImgPath, BufferedImage newImg, float per) {  
        // �ж�������ļ���·���Ƿ���ڣ��������򴴽�  
        File file = new File(outImgPath);  
        if (!file.getParentFile().exists()) {  
            file.getParentFile().mkdirs();  
        }
        // ������ļ���
        FileOutputStream fos = null;
        try {  
            fos = new FileOutputStream(outImgPath);  
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);  
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(newImg);  
            // ѹ������  
            jep.setQuality(per, true);  
            encoder.encode(newImg, jep);  
            fos.close();  
        } catch (Exception e) { 
        	throw new RuntimeException(e);
        } finally {
        	if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
        }
    }  
  
    /**
     * ͼƬ���й��߷���
     * 
     * @param srcfile ԴͼƬ
     * @param outfile ����֮���ͼƬ
     * @param x ���ж��� X ����
     * @param y ���ж��� Y ����
     * @param width ����������
     * @param height ��������߶�
     * 
     * @throws IOException
     */
	public static void cut(File srcfile, File outfile, int x, int y, int width, int height) throws IOException {
		FileInputStream is = null;
		ImageInputStream iis = null;
		try {
			// ��ȡͼƬ�ļ�
			is = new FileInputStream(srcfile);

			/*
			 * ���ذ������е�ǰ��ע�� ImageReader �� Iterator����Щ ImageReader �����ܹ�����ָ����ʽ��
			 * ������formatName - ��������ʽ��ʽ���� .������ "jpeg" �� "tiff"���� ��
			 */
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpg");
			ImageReader reader = it.next();
			// ��ȡͼƬ��
			iis = ImageIO.createImageInputStream(is);

			/*
			 * <p>iis:��ȡԴ.true:ֻ��ǰ���� </p>.�������Ϊ ��ֻ��ǰ��������
			 * ��������ζ�Ű���������Դ�е�ͼ��ֻ��˳���ȡ���������� reader ���⻺���������ǰ�Ѿ���ȡ��ͼ����������ݵ���Щ���벿�֡�
			 */
			reader.setInput(iis, true);

			/*
			 * <p>������ζ������н������<p>.����ָ�����������ʱ�� Java Image I/O
			 * ��ܵ��������е���ת��һ��ͼ���һ��ͼ�������ض�ͼ���ʽ�Ĳ�� ������ ImageReader ʵ�ֵ�
			 * getDefaultReadParam �����з��� ImageReadParam ��ʵ����
			 */
			ImageReadParam param = reader.getDefaultReadParam();

			/*
			 * ͼƬ�ü�����Rectangle ָ��������ռ��е�һ������ͨ�� Rectangle ����
			 * �����϶�������꣨x��y������Ⱥ͸߶ȿ��Զ����������
			 */
			Rectangle rect = new Rectangle(x, y, width, height);

			// �ṩһ�� BufferedImage���������������������ݵ�Ŀ�ꡣ
			param.setSourceRegion(rect);

			/*
			 * ʹ�����ṩ�� ImageReadParam ��ȡͨ������ imageIndex ָ���Ķ��󣬲��� ����Ϊһ��������
			 * BufferedImage ���ء�
			 */
			BufferedImage bi = reader.read(0, param);

			// ������ͼƬ
			ImageIO.write(bi, "jpg", outfile);
		} finally {
			if (is != null) {
				is.close();
			}
			if (iis != null) {
				iis.close();
			}
		}
    }
}

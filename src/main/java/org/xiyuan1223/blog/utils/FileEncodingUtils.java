package org.xiyuan1223.blog.utils;

import java.io.File;
import java.io.FileFilter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * �ļ����빤����
 * 
 * @author wang.sheng
 * 
 */
public class FileEncodingUtils
{
	static Log log = LogFactory.getLog(FileEncodingUtils.class);

	private FileEncodingUtils()
	{
	}

	/**
	 * ��Դ�ļ����ݰ��ո�ʽ�������Ŀ���ļ���
	 * 
	 * @param sourceFile
	 * @param sourceEncoding
	 * @param destFile
	 * @param destEncoding
	 */
	public static void convertFile(File sourceFile, String sourceEncoding, File destFile, String destEncoding)
	{
		if (!sourceFile.isFile())
		{
			throw new IllegalArgumentException("sourceFile is not a file! " + sourceFile.getAbsolutePath());
		}
		try
		{
			String content = FileUtils.readFileToString(sourceFile, sourceEncoding);
			FileUtils.write(destFile, content, destEncoding);
			log.info("convertFile successful! source: " + sourceFile.getAbsolutePath() + " dest: " + destFile.getAbsolutePath());
		}
		catch (Exception e)
		{
			log.error("convert failed! sourceFile:" + sourceFile.getAbsolutePath(), e);
		}
	}

	/**
	 * Ŀ¼֮���ת��
	 * 
	 * @param sourceDir
	 * @param sourceEncoding
	 * @param destDir
	 * @param destEncoding
	 * @param fileFilter
	 */
	public static void convertDirectory(File sourceDir, String sourceEncoding, File destDir, String destEncoding, FileFilter fileFilter)
	{
		if (!sourceDir.isDirectory())
		{
			throw new IllegalArgumentException("sourceFile is not a Directory! " + sourceDir.getAbsolutePath());
		}
		if (!destDir.isDirectory())
		{
			throw new IllegalArgumentException("destDir is not a Directory! " + destDir.getAbsolutePath());
		}
		File[] files = sourceDir.listFiles(fileFilter);
		for (File file : files)
		{
			if (file.isDirectory())
			{
				// ��Ŀ¼
				File dir = new File(destDir, file.getName());
				dir.mkdir();
				convertDirectory(file, sourceEncoding, dir, destEncoding, fileFilter);// �ݹ����
			}
			else if (file.isFile())
			{
				// �ļ�
				File destFile = new File(destDir, file.getName());
				convertFile(file, sourceEncoding, destFile, destEncoding);// �ļ�����
			}
		}
	}

	public static void main(String[] args)
	{
		File sourceDir = new File("E:/jee-projects/polaris/sirius/src/com/polaris/framework/webapp/view");
		File destDir = new File(
				"E:/jee-projects/polaris/com.polaris.framework/com.polaris.framework.webapp/src/main/java/com/polaris/framework/webapp/view");
		convertDirectory(sourceDir, "GBK", destDir, "UTF-8", new FileFilter()
		{
			public boolean accept(File file)
			{
				String fileName = file.getName().toLowerCase();
				return file.isDirectory() || fileName.endsWith(".java");
			}

		});
	}
}

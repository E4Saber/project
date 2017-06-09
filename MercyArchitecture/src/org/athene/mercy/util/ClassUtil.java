package org.athene.mercy.util;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;


/**
 * �Զ�����������
 * @author 850030121
 *
 */

public class ClassUtil {
	
	static {
		
	}
	
	private static final Logger LOGGER = Logger.getLogger(ClassUtil.class);

	/**
	 * ��ȡ�������
	 * @return
	 */
	public static ClassLoader getClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}
	
	/**
	 * ������
	 * @param className
	 * @param isInitialized
	 * @return
	 */
	public static Class<?> loadClass(String className, boolean isInitialized) {
		Class<?> cls = null;
		try {
			cls = Class.forName(className, isInitialized, getClassLoader());
		} catch (ClassNotFoundException e) {
			LOGGER.error("ClassUtil loadClass failure!", e);
			throw new RuntimeException(e);
		}
		return cls;
	}
	
	/**
	 * ��ȡָ�����µ�������
	 * @param packageName
	 * @return
	 */
	public static Set<Class<?>> getClassSet(String packageName) {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		try {
			Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".","/"));
			while(urls.hasMoreElements()) {
				URL url = urls.nextElement();
				if(url!=null) {
					String protocol = url.getProtocol();
					if(protocol.equals("file")) {
						String packagePath = url.getPath().replaceAll("%20", " ");
						addClass(classSet, packagePath, packageName);
					} else if(protocol.equals("jar")) {
						JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
						if(jarURLConnection!=null) {
							JarFile jarFile = jarURLConnection.getJarFile();
							if(jarFile!=null) {
								Enumeration<JarEntry> jarEntries = jarFile.entries();
								while(jarEntries.hasMoreElements()) {
									JarEntry jarEntry = jarEntries.nextElement();
									String jarEntryName = jarEntry.getName();
									if(jarEntryName.endsWith(".class")) {
										String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
										doAddClass(classSet, className);
									}
								}
							}
						}
					}
				}
			}
		} catch(Exception e) {
			LOGGER.error("get class error!", e);
			throw new RuntimeException(e);
		}
		return classSet;
	}
	
	private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
		File[] files = new File(packagePath).listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return ((file.isFile() && file.getName().endsWith(".class"))||file.isDirectory());
			}
		});
		for(File file : files) {
			String fileName = file.getName();
			if(file.isFile()) {
				String className = fileName.substring(0, fileName.lastIndexOf("."));
				if(!StringUtil.isEmpty(packageName)) {
					className = packageName + "." + className;
				}
				doAddClass(classSet, className);
			} else {
				String subPackagePath = fileName;
				if(!StringUtil.isEmpty(packagePath)) {
					subPackagePath = packagePath + "/" + subPackagePath; 
				}
				String subPackageName = fileName;
				if(!StringUtil.isEmpty(packageName)) {
					subPackageName = packageName + "." + subPackageName;
				}
				addClass(classSet, subPackagePath, subPackageName);
			}
		}
	}
	
	private static void doAddClass(Set<Class<?>> classSet, String className) {
			Class<?> cls = loadClass(className, false);
			classSet.add(cls);
	}
}

package com.lms.accesslibrary.rent;

import java.lang.reflect.InvocationTargetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.accesslibrary.config.LibraryConfig;
import com.lms.accesslibrary.constant.Constants;

/*
 * Singleton pattern : It ensures a class has only one instance and provide a global point of access to it.
 * */
public class ItemFactorySelector {
	
	private static ItemFactory objectFactorySingleInstance = null;
	private static final String FACTORY_NAME = LibraryConfig.getProperty(Constants.MATERIAL_FACTORY);
	//private static final String FACTORY_NAME = "com.lms.accesslibrary.rent.MaterialFactory";
	
	public static ItemFactory getItemFactory() {
		try {
			if(objectFactorySingleInstance == null) {
				//Dynamically instantiate factory and factory name can be read from a properties file.
				Class klassFactory = Class.forName(FACTORY_NAME);
				objectFactorySingleInstance = (ItemFactory)klassFactory.getDeclaredConstructor().newInstance();
			}
		}catch(ClassNotFoundException cnf) {
			throw new RuntimeException("Cannot create the ItemFactory: "+ cnf.getMessage());
		}catch(InstantiationException ie) {
			throw new RuntimeException("Cannot create the ItemFactory: "+ ie.getMessage());
		}  catch (InvocationTargetException ite) {
			throw new RuntimeException("Cannot create the ItemFactory: "+ ite.getMessage());
		} catch (NoSuchMethodException nsme) {
			throw new RuntimeException("Cannot create the ItemFactory: "+ nsme.getMessage());
		} catch (SecurityException se) {
			throw new RuntimeException("Cannot create the ItemFactory: "+ se.getMessage());
		} catch (IllegalAccessException iae) {
			throw new RuntimeException("Cannot create the ItemFactory: "+ iae.getMessage());
		}
		
		return objectFactorySingleInstance;
	}
}

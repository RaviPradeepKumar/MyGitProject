package com.infotech.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	static {
		if(sessionFactory == null) {
			try {
				//create StandardServiceRegistry
				standardServiceRegistry  = new StandardServiceRegistryBuilder().configure().build();
				//create metadataSource
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				//create metadata
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				//create SessionFactory 
				sessionFactory  = metadata.getSessionFactoryBuilder().build();
			}//try
			catch(Exception e) {
				e.printStackTrace();
				if(standardServiceRegistry != null) {
					StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
				}//if
			}//catch
		}//if
	}//static
	//utility method to return sessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

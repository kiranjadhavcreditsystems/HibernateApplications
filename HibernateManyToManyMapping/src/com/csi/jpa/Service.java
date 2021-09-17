package com.csi.jpa;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Address a1 = new Address();
		a1.setAddressStreet("INSPIRIA MALL");
		a1.setAddressCity("PCMC");
		a1.setAddressState("MH");
		a1.setAddressCountry("INDIA");
		a1.setAddressPinCode(411044);

		session.save(a1);

		Address a2 = new Address();
		a2.setAddressStreet("AMANORA MALL");
		a2.setAddressCity("PUNE");
		a2.setAddressState("MH");
		a2.setAddressCountry("INDIA");
		a2.setAddressPinCode(411028);

		session.save(a2);

		List<Address> addressList = new LinkedList<Address>();

		addressList.add(a1);
		addressList.add(a2);

		Employee e1 = new Employee();

		e1.setEmpName("SWARA");
		e1.setEmpSalary(456567.89);
		e1.setAddresses(addressList);
		session.save(e1);

		Employee e2 = new Employee();

		e2.setEmpName("BINU");
		e2.setEmpSalary(989888.89);
		e2.setAddresses(addressList);
		session.save(e2);

		transaction.commit();

	}
}

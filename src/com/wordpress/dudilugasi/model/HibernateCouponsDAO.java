package com.wordpress.dudilugasi.model;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.Transaction;


import java.util.List;

/**
 * @author Dudi Lugasi
 */

/**
 * coupons DAO using Hibernate
 */
public class HibernateCouponsDAO implements ICouponsDAO {

    SessionFactory factory = null;

    //An instance of HibernateCouponsDAO for singleton implementation
    private static HibernateCouponsDAO instance;

    /**
     * creates an instance of HibernateCouponsDAO if not exists
     * @return instance of HibernateCouponsDAO
     */
    public static HibernateCouponsDAO getInstance()
    {
        if(instance==null)
        {
            instance = new HibernateCouponsDAO();
        }
        return instance;
    }

    /**
     * private constructor for singleton uses
     * creates the Session factory
     */
    private HibernateCouponsDAO() {
        factory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @Override
    /**
     * adds a coupon to the table
     * @param coupon to be added to the table
     * @return coupons id if coupon was successfully added
     * @throws CouponException
     */
    public Integer addCoupon(Coupon ob) throws CouponException {
        Session session = null;
        Integer id = null;
        try
        {
            session = factory.openSession();
            session.beginTransaction();
            id = (Integer) session.save(ob);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            if (session != null) {
                Transaction tx = session.getTransaction();
                if (tx.isActive()) tx.rollback();
            }
            throw new CouponException(e.getMessage());
        }
        finally {
            if (session != null) session.close();

        }
        return id;
    }

    @SuppressWarnings("unchecked")
	@Override
    /**
     * get a collection of coupons from the table
     * @return a collection of coupons from the table
     * @throws CouponException
     */
    public List<Coupon> getCoupons() throws CouponException {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return session.createQuery("from Coupon").list();
        }
        catch (HibernateException e) {
            if (session != null) {
                Transaction tx = session.getTransaction();
                if (tx.isActive()) tx.rollback();
            }
            throw new CouponException(e.getMessage());
        }
        finally {
            if (session != null) session.close();
        }
    }

    @Override
    /**
     * get a single coupon from the table.
     * the user must provide an id of the coupon required.
     * @param id of the coupon required.
     * @return coupon object that matched the id.
     * @throws CouponException
     */
    public Coupon getCoupon(int id) throws CouponException {
        Session session = null;
        try
        {
            session = factory.openSession();
            session.beginTransaction();
            Coupon coupon = (Coupon)session.get(Coupon.class,id);
            session.getTransaction().commit();
            return coupon;
        }
        catch (HibernateException e) {
            if (session != null) {
                Transaction tx = session.getTransaction();
                if (tx.isActive()) tx.rollback();
            }
            throw new CouponException(e.getMessage());
        }
        finally {
            if (session != null) session.close();
        }
    }

    @Override
    /**
     * delete a single coupon from the table.
     * the user must provide the id of the coupon he wants to delete.
     * @param id of the coupon to delete.
     * @return <tt>true</tt> if coupon was successfully deleted.
     * @throws CouponException
     */
    public void deleteCoupon(int id) throws CouponException {
        Session session = null;
        try
        {
            session = factory.openSession();
            session.beginTransaction();
            Coupon coupon = (Coupon)session.get(Coupon.class,id);
            session.delete(coupon);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            if (session != null) {
                Transaction tx = session.getTransaction();
                if (tx.isActive()) tx.rollback();
            }
            throw new CouponException(e.getMessage());
        }
        finally {
            if (session != null) session.close();
        }
    }

    @Override
    /**
     * change a coupon attributes in the table.
     * the user provide a coupon object with the updated attributes
     * @param coupon to be updated
     * @return <tt>true</tt> if coupon was successfully updated.
     * @throws CouponException
     */
    public void updateCoupon(Coupon coupon) throws CouponException {
        Session session = null;
        try
        {
            session = factory.openSession();
            session.beginTransaction();
            session.update(coupon);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            if (session != null) {
                Transaction tx = session.getTransaction();
                if (tx.isActive()) tx.rollback();
            }
            throw new CouponException(e.getMessage());
        }
        finally {
            if (session != null) session.close();
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Coupon> getCouponsByCategory(String category)
			throws CouponException {
		 Session session = null;
	        try {
	            session = factory.openSession();
	            session.beginTransaction();
	            return session.createQuery("from Coupon where category='" + category + "'").list();
	        }
	        catch (HibernateException e) {
	            if (session != null) {
	                Transaction tx = session.getTransaction();
	                if (tx.isActive()) tx.rollback();
	            }
	            throw new CouponException(e.getMessage());
	        }
	        finally {
	            if (session != null) session.close();
	        }
	    }
}

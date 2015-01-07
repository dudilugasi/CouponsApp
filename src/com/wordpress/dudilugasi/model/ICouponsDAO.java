package com.wordpress.dudilugasi.model;


import java.util.List;

/**
 * @author Dudi Lugasi
 */

/**
 * A coupons DAO interface. the user of this interface can edit a coupons table.
 */
public interface ICouponsDAO {
    /**
     * adds a coupon to the table
     * @param coupon to be added to the table
     * @return the id the coupon relieved
     * @throws CouponException
     */
    public Integer addCoupon(Coupon coupon) throws CouponException;

    /**
     * get a collection of coupons from the table
     * @return a collection of coupons from the table
     * @throws CouponException
     */
    public List<Coupon> getCoupons() throws CouponException;
    
    /**
     * get a collection of coupons from the table by category
     * @param category
     * @return
     * @throws CouponException
     */
    public List<Coupon> getCouponsByCategory(String category) throws CouponException;
    /**
     * get a single coupon from the table.
     * the user must provide an id of the coupon required.
     * @param id of the coupon required.
     * @return coupon object that matched the id
     * @throws CouponException
     */
    public Coupon getCoupon(int id) throws CouponException;

    /**
     * delete a single coupon from the table.
     * the user must provide the id of the coupon he wants to delete.
     * @param id of the coupon to delete.
     * @throws CouponException
     */
    public void deleteCoupon(int id) throws CouponException;

    /**
     * change a coupon attributes in the table.
     * the user provide a coupon object with the updated attributes
     * @param coupon to be updated
     * @return <tt>true</tt> if coupon was successfully updated.
     * @throws CouponException
     */
    public void updateCoupon(Coupon coupon) throws CouponException;
}

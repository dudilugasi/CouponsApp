package com.wordpress.dudilugasi

import org.junit.Test

/**
 * Created by dudi on 13/11/2014.
 */
class HibernateCouponsDAOTest extends GroovyTestCase {
    @Test
    public void testAddCoupon() {
        HibernateCouponsDAO test = HibernateCouponsDAO.getInstance();
        Coupon c1 = new Coupon(1,"testName","testDescription");
        assertNotNull(test.addCoupon(c1));
    }


    void testGetCoupon() {
        HibernateCouponsDAO test = HibernateCouponsDAO.getInstance();
        Coupon c2 = new Coupon(1,"testName","testDescription");
        Integer id = test.addCoupon(c2);
        c2.setId(id);
        assertEquals(test.getCoupon(id),c2);
    }

    void testDeleteCoupon() {
        HibernateCouponsDAO test = HibernateCouponsDAO.getInstance();
        Coupon c3 = new Coupon(1,"testName","testDescription");
        Integer id = test.addCoupon(c3);
        test.deleteCoupon(id);
        assertNull(test.getCoupon(id));
    }

    void testUpdateCoupon() {
        HibernateCouponsDAO test = HibernateCouponsDAO.getInstance();
        Coupon c4 = new Coupon(1,"testName","testDescription");
        Integer id = test.addCoupon(c4);
        c4.setName("testName1");
        test.updateCoupon(c4);
        assertEquals(test.getCoupon(id),c4);
    }
}

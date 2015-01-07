package com.wordpress.dudilugasi.model;


import java.sql.Timestamp;


/**
 * @autor Dudi Lugasi
 */

/**
 * coupon object that represent a row in the table
 */
public class Coupon {
    /**
     * coupons attributes.
     */
    private int id;
    private String name;
    private String description;
    private String category;
    private double x;
    private double y;
    private Timestamp expDate;
    private double price;

	

	/**
     * Default constructor.
     */
    public Coupon() {}

    /**
     * coupons constructor
     * @param id to be set in the coupon
     * @param name to be set to the coupon
     * @param description to be set to the coupon
     * @param catagory
     * @param x
     * @param y
     * @param expDate
     */
    public Coupon(int id, String name, String description, String category 
    		, double x , double y , Timestamp expDate , double price) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setCategory(category);
        this.setX(x);
        this.setY(y);
        this.setExpDate(expDate);
        this.setPrice(price);
    }
    
    public Timestamp getExpDate() {
		return expDate;
	}

	public void setExpDate(Timestamp expDate) {	
		this.expDate = expDate;
	}

    public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}


	/**
     * sets the coupon category
     * @param category
     */
    public void setCategory(String category) {
		if (category != null) {
			this.category = category;
		}
		
	}
    
    /**
     * 
     * @return coupons category
     */
    public String getCategory() {
    	return category;
    }

	/**
     * sets the coupon id.
     * @param id to be set in the coupon
     */
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    /**
     * set the coupon name.
     * @param name to be set to the coupon
     */
    public void setName(String name) {
        if (name != null)
            this.name = name;
    }

    /**
     * set the coupon description
     * @param description of the coupon
     */
    public void setDescription(String description) {
        if (description != null)
            this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

    @Override
    public String toString() {
        return  "{id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coupon)) return false;

        Coupon coupon = (Coupon) o;

        if (id != coupon.id) return false;
        if (!description.equals(coupon.description)) return false;
        if (!name.equals(coupon.name)) return false;

        return true;
    }


}

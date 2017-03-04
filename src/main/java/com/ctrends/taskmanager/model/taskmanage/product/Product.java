package com.ctrends.taskmanager.model.taskmanage.product;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@Column(name = "id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@Column(name ="product_code")
	private String productCode;
	
	@Column(name ="product_name")
	private String productName;

	@Column(name ="product_type")
	private String productType;
	
	@Column(name ="product_licence")
	private String productLicence;
	
	@Column(name ="product_quantity")
	private double productQuantity;
	
	@Column(name ="manufacturing_date")
	private Date manufacturingDate;
	
	@Column(name ="expire_date")
	private Date expireDate;
	
	@Column(name ="product_cost")
	private double productCost;
	 
	@Column(name="created_by_name")
	private String createdByName;
	
	@Column(name="created_by_username")
	private String createdByUsername;

	@Column(name="created_by_email")
	private String createdByEmail;
	
	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="updated_by_code")
	private String updatedByCode;
	
	@Column(name="updated_by_name")
	private String updatedByName;
	
	@Column(name="updated_by_username")
	private String updatedByUsername;

	@Column(name="updated_by_email")
	private String updatedByEmail;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductLicence() {
		return productLicence;
	}

	public void setProductLicence(String productLicence) {
		this.productLicence = productLicence;
	}

	public double getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(double productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public String getCreatedByUsername() {
		return createdByUsername;
	}

	public void setCreatedByUsername(String createdByUsername) {
		this.createdByUsername = createdByUsername;
	}

	public String getCreatedByEmail() {
		return createdByEmail;
	}

	public void setCreatedByEmail(String createdByEmail) {
		this.createdByEmail = createdByEmail;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedByCode() {
		return updatedByCode;
	}

	public void setUpdatedByCode(String updatedByCode) {
		this.updatedByCode = updatedByCode;
	}

	public String getUpdatedByName() {
		return updatedByName;
	}

	public void setUpdatedByName(String updatedByName) {
		this.updatedByName = updatedByName;
	}

	public String getUpdatedByUsername() {
		return updatedByUsername;
	}

	public void setUpdatedByUsername(String updatedByUsername) {
		this.updatedByUsername = updatedByUsername;
	}

	public String getUpdatedByEmail() {
		return updatedByEmail;
	}

	public void setUpdatedByEmail(String updatedByEmail) {
		this.updatedByEmail = updatedByEmail;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
}

package com.stock.products.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.stock.products.model.Product;
import com.stock.products.model.Purchase;

@Mapper
@Repository
public interface PurchaseMapper {
	
	@Select("Select * From purchase WHERE is_deleted=false")
	public List<Purchase> findAll();
	
	@Select("Select * From purchase where purchase_id=#{purchaseId}")
	@Results(value= {
			@Result(property="purchaseId",column="purchase_id"),
			@Result(property="id",column="id"),
			@Result(property="purchasedBy",column="purchased_by"),
			@Result(property="quantity",column="quantity"),
			@Result(property="contactNo",column="contact_no"),
			@Result(property="createdAt",column="created_at"),
			@Result(property="updatedAt",column="updated_at"),
			@Result(property="product", javaType=Product.class,column="id",
			one=@One(select="com.stock.products.mapper.ProductMapper.findById")  )})
	public Purchase findById(Integer PurchaseId);
	
	
	@Insert("insert into purchase ( id, purchased_by, quantity, contact_no, created_at, updated_at,is_deleted)"
			+ "values(#{id},#{purchasedBy},#{quantity},#{contactNo},#{createdAt},#{updatedAt},false)")
	@Options(useGeneratedKeys=true, keyProperty="purchaseId")
	public void insert(Purchase purchase);
	
	
	@Update("update purchase set id=#{id},purchased_by=#{purchasedBy},quantity=#{quantity},contact_no=#{contactNo},updated_at=#{updatedAt}"
			+ " where purchase_id=#{purchaseId}")
	public void update(Purchase purchase);
	
	
	@Update("update purchase set is_deleted=true where purchase_id=#{purchaseId}")
	public void deleteById(Integer purchaseId);

	
	@Select("Select * From purchase where id=#{id}")
	public List<Purchase>byId(Integer id);
	
}

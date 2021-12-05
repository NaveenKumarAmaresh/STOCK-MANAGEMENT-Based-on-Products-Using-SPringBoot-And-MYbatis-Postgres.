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

import com.stock.products.model.OrderDetails;
import com.stock.products.model.Product;

@Mapper
@Repository
public interface OrderMapper {
	
	@Select("Select * from orders WhERE is_deleted=false")
	public List<OrderDetails> findAll();
	
	@Select("Select * from orders WHERE order_id=#{orderId}  ")
	@Results(value= {
			@Result(property="orderId",column="order_id"),
			@Result(property="id",column="id"),
			@Result(property="orderedBy",column="ordered_by"),
			@Result(property="address",column="address"),
			@Result(property="contactNo",column="contact_no"),
			@Result(property="createdAt",column="created_at"),
			@Result(property="updatedAt",column="updated_at"),
			@Result(property="product", javaType=Product.class,column="id",
			one=@One(select="com.stock.products.mapper.ProductMapper.findById"))})
	public OrderDetails findById( Integer orderId);
	
	@Select("select * from orders where id =#{id}")
	public List<OrderDetails>byProductId(Integer id);
	
	@Insert("insert into orders (id,ordered_by,address,contact_no,created_at,updated_at,is_deleted)"
			+ " values(#{id},#{orderedBy},#{address},#{contactNo},#{createdAt},#{updatedAt},false)")
	@Options(useGeneratedKeys = true, keyProperty = "orderId")
	public void insert(OrderDetails orders);
	
	@Update("update orders set id=#{id},ordered_by=#{orderedBy},address=#{address},contact_no=#{contactNo},updated_at=#{updatedAt} "
			+ "WHERE order_id=#{orderId}")
    public  void update(OrderDetails orders);
	
	
	@Update("UPDATE orders set is_deleted=true WHERE order_id=#{orderId}")
	public  void deleteById( Integer orderId);
	

}

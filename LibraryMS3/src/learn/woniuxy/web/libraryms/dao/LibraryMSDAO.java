package learn.woniuxy.web.libraryms.dao;

import java.sql.Connection;
import java.util.List;

import learn.woniuxy.web.libraryms.po.Book;

public interface LibraryMSDAO {
	
	//增
	default boolean insert(Connection con,Book book) {
		return false;
	};
	
	/**
	 * 增加：传参
	 * @param con 连接交出
	 * @param args 传任意参数
	 * @return 如果sql成功，true
	 */
	boolean insert(Connection con,Object...args);

	/**
	 * 删除
	 * @param con con 连接交出
	 * @param bid 根据id号删除
	 * @return 如果sql成功，true
	 */
	boolean delete(Connection con,int bid);
	
	//改
	default boolean update(Connection con,Book book) {
		return false;	
	};
	
	/**
	 * 改：传参
	 * @param con  con 连接交出
	 * @param args  传任意参数
	 * @return 如果sql成功，true
	 */
	boolean update(Connection con,Object...args);

	//查
	/**
	 * 查单个
	 * @param con 链接交出
	 * @param bid 返回单个Book对象
	 * @return
	 */
	Book searchById(Connection con,int bid);
	
	/**
	 * 查所有信息
	 * @param con  链接交出
	 * @return 返回Book对象的集合
	 */
	List<Book> searchAll(Connection con);



}

package learn.woniuxy.web.libraryms.service;

import java.util.List;

import learn.woniuxy.web.libraryms.po.Book;

public interface LibraryService {
	/**
	 * 获取插入结果
	 * @param args 插入的参数
	 * @return 获取成功返回true
	 */
	Boolean  getInsert(Object...args);
	/**
	 * 获取删除结果
	 * @param bid 以id删除
	 * @return 获取成功返回true
	 */
	Boolean getDelete(int bid);
	/**
	 * 获取更新结果
	 * @param args 插入的参数
	 * @return 获取成功返回true
	 */
	Boolean getUpdate(Object...args);
	/**
	 * 获取按照id值得到的结果
	 * @param bid 插入的id
	 * @return book对象
	 */
	Book getSearchById(int bid);
	/**
	 * 获取所有内容
	 * @return 返回所有书籍对象的集合
	 */
	List<Book> getSearchAll();
	
	
}

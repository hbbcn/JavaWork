package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

/**
 *@ClassName BookServiceImpl
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/28 18:00
 *@Version 1.0
 */
public class BookServiceImpl implements BookService {

  private BookDao bookDao =  new BookDaoImpl();
    @Override
    public void addBook(Book book) {

        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {

        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {

        return bookDao.queryBookById(id);

    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal+=1;
        }
//        //设置总的页码
        page.setPageTotal(pageTotal);
        //设置当前页码
        page.setPageNo(pageNo);
        // 求当前也数据的索引
        int begin = (page.getPageNo()-1) * pageSize;
        //设置当前页数据
        //求当前页数据
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        //设置当前也数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int min, int max,int pageNo,int pageSize) {
        Page<Book> page = new Page<>();
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求在区间范围内的总记录数
        Integer pageTotalCount = bookDao.queryPriceTotalCount(min, max);
        //设置价格范围内的总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal =  pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal+=1;
        }
        //设置总的页码
        page.setPageTotal(pageTotal);
        //设置当前页码
        page.setPageNo(pageNo);

        // 求当前也数据的索引
        int begin = (page.getPageNo()-1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPagePrice(min, max, begin, pageSize);
        //设置当前的页数据
        page.setItems(items);

        return page;
    }


}


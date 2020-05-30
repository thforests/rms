import com.bean.Book;
import com.dao.BookDao;
import com.dao.IUserDao;
import com.dao.impl.BookDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void test(){
        IUserDao userDao = new UserDaoImpl();
        int i = userDao.updatePwd("123","123456","admin");
        System.out.println(i);
    }

    @Test
    public  void test2(){
        BookDao bookDao = new BookDaoImpl();
        //List <Book> emp = bookDao.selectFoodM("te");
        BookService bookService = new BookServiceImpl();
        List <Book> emps= bookService.selectFoodM("ha");
       // System.out.println(emp);
        for (Book b:emps){
            System.out.println(b);
        }
       // System.out.println("emps"+emps);
    }
}

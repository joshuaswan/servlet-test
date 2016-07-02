package Control;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by joshua on 2016/7/2.
 */
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        //截取字符串
        String requestURI = request.getRequestURI();
        String flagAction = requestURI.substring(requestURI.indexOf("/",1),requestURI.indexOf("."));

        IAction action = null;

        //根据字符串转发响应的Action
        if ("/Servlet/Add".equals(flagAction)){
            //TODO 采用读取配置文件，反射，这里省略，就直接NEW了
            action = new AddAction();
        }else if("/Servlet/Modify".equals(flagAction)){
            action = new ModifyAction();
        }

        //TODO 获取表单信息
        //TODO 将字符串转换为我们需要的格式等等，向下传递

        //得到转向信息
        String forwordString = action.Excute();

        //转发
        request.getRequestDispatcher(forwordString).forward(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

package Control;

import Model.Manage;

/**
 * Created by joshua on 2016/7/2.
 */
public class ModifyAction implements IAction {

    @Override
    public String Excute() {
        //执行MODEL层逻辑
        Manage manage = new Manage();
        manage.Modify();

        //返回转向信息
        //TODO 可以在配置文件中读取
        return "/ModifySuccess.jsp";
    }
}

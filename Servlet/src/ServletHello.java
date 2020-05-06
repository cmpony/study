import javax.servlet.*;
import java.io.IOException;

public class ServletHello implements Servlet {
    // 初始化Servlet， 只会被调用一次（用户第一次访问该servlet时被调用）
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    // 处理业务逻辑， 用户访问servlet都会被调用
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("service");
        servletResponse.getWriter().println("hello World");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    // 销毁servlet实例
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}

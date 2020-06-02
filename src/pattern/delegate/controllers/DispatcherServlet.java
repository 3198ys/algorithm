package pattern.delegate.controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: pattern.delegate.controllers
 *
 * 简单写一个DispatcherServlet  正常要继承 HttpServlet
 * @date:2020/6/2
 */
public class DispatcherServlet{


  List<Handler> handlerMapping=new ArrayList<>();
  public void init(){
    Class<?> memberControllerClass=MemberController.class;
    try {
      handlerMapping.add(new Handler().setController(memberControllerClass.newInstance()).setUrl("/abc/a").setMethod(memberControllerClass.getMethod("getMemberById",new Class[]{String.class})));
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }

  /**
   * 参数 HttpServletRequest request, HttpServletResponse response
   */
  private void doDispatch(){
    String uri="";
//    String uri = request.getRequestURI();
    //上面那一步就是获取 当前访问的uri]
    Handler handler=null;
    for (Handler h:handlerMapping) {
      if(h.getUrl().equals(uri)){
        handler=h;
        break;
      }
    }

    /**
     * 执行handler中方法 request.getParameter("mid") 反射的那个方法就可以用  request中获取的参数来做
     */
    Object object=null;
    try {
      object=handler.getMethod().invoke(handler.getController(),"a");
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  /**
   *
   *     参数 HttpServletRequest request, HttpServletResponse response
   * @throws IOException
   */
  protected void service() {
    try {
      doDispatch();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


class Handler{
  private Object controller;
  private Method method;
  private String url;

  public Object getController() {
    return controller;
  }

  public Handler setController(Object controller) {
    this.controller = controller;
    return this;
  }

  public Method getMethod() {
    return method;
  }

  public Handler setMethod(Method method) {
    this.method = method;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public Handler setUrl(String url) {
    this.url = url;
    return this;
  }
}

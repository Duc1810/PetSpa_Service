package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.Account;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css\"\n");
      out.write("            />\n");
      out.write("        <link\n");
      out.write("            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css\"\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            integrity=\"sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9\"\n");
      out.write("            crossorigin=\"anonymous\"\n");
      out.write("            />\n");
      out.write("        <link rel=\"stylesheet\" href=\"./style1.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header class=\"header\">\n");
      out.write("            <a href=\"MainController?action=home\" class=\"logo\"><i class=\"fas fa-paw\"></i>Dean</a>\n");
      out.write("            <nav class=\"navbar\">\n");
      out.write("                <a href=\"MainController?action=home\">Home</a>             \n");
      out.write("                <a href=\"MainController?action=serviceMenu\">Services</a>\n");
      out.write("                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                <a href=\"MainController?action=cabinMenu\">Cabins</a>\n");
      out.write("                <a href=\"MainController?action=viewcart\">cart</a>\n");
      out.write("                <a href=\"#contact\">contact</a>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("            <div class=\"dropdown\">\n");
      out.write("                <div class=\"icons\">\n");
      out.write("                    <a class=\"fas fa-bars ico \" type=\"button\" \n");
      out.write("                       id=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"></a>\n");
      out.write("                    <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"MainController?action=serviceMenu\" >List Services</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"MainController?action=cabinMenu\">List Cabins</a>\n");
      out.write("                        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                        ");
 HttpSession sesion = request.getSession();
                            Account acc = (Account) sesion.getAttribute("User");
                            if (acc != null) {
                                if (acc.getRole().equals("Admin")) {
                        
      out.write("\n");
      out.write("                        <a class=\"dropdown-item\" href=\"MainController?action=manageSV\">List Service Of Admin</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"ManageCustomerController\">List Customer</a>\n");
      out.write("                        ");

                                }
                            }
                        
      out.write("\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <a href=\"MainController?action=viewcart\" class=\"fas fa-shopping-cart\"></a>\n");
      out.write("                    <a  href=\"MainController?action=signin\"class=\"fas fa-user ico\" id=\"login-btn\"></a>\n");
      out.write("                    <form class=\"find\" action=\"FindCabinController\">                    \n");
      out.write("                        <input type=\"text\" id=\"find\" name=\"txtCabin\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.key}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                        <label for=\"find\"><i class=\"fa-solid fa-magnifying-glass\"></i></label>\n");
      out.write("                        <!--                  <input type=\"submit\" value=\"find\" name=\"action\"/>-->\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <section class=\"home\" id=\"home\">\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <h3><span>Hi</span> Welcome to our pet shop</h3>\n");
      out.write("                <a href=\"MainController?action=cabinMenu\" class=\"btn-demo\">Shop now</a>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <!-- services section starts -->\n");
      out.write("        <section class=\"services\" id=\"services\">\n");
      out.write("            <h1 class=\"heading\">our <span>services</span></h1>\n");
      out.write("            <div class=\"box-container\">\n");
      out.write("                <div class=\"top\">\n");
      out.write("                    <div class=\"box\">\n");
      out.write("                        <i class=\"fas fa-shield-dog\"></i>\n");
      out.write("                        <h3>Cabins List</h3>\n");
      out.write("                        <a href=\"MainController?action=cabinMenu\" class=\"btn\">See more</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"box\">\n");
      out.write("                        <i class=\"fas fa-bath\"></i>\n");
      out.write("                        <h3>Service List</h3>\n");
      out.write("                        <a href=\"MainController?action=serviceMenu\" class=\"btn\">See more</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"box\">\n");
      out.write("                        <i class=\"fas fa-cat\"></i>\n");
      out.write("                        <h3>cat boarding</h3>\n");
      out.write("                        <a href=\"listServiceController\" class=\"btn\">read more</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"bottom\">\n");
      out.write("                    <div class=\"box\">\n");
      out.write("                        <i class=\"fas fa-drumstick-bite\"></i>\n");
      out.write("                        <h3>healthy meal</h3>\n");
      out.write("                        <a href=\"#\" class=\"btn\">read more</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"box\">\n");
      out.write("                        <i class=\"fas fa-baseball-ball\"></i>\n");
      out.write("                        <h3>activity exercise</h3>\n");
      out.write("                        <a href=\"#\" class=\"btn\">read more</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"box\">\n");
      out.write("                        <i class=\"fas fa-heartbeat\"></i>\n");
      out.write("                        <h3>health care</h3>\n");
      out.write("                        <a href=\"#\" class=\"btn\">read more</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <section class=\"contact\" id=\"contact\">\n");
      out.write("            <div class=\"image\">\n");
      out.write("                <img src=\"./images/5664315.jpg\" alt=\"\"/>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"box_contact\"></div>\n");
      out.write("            <form  class=\"form_contact\" action=\"\">\n");
      out.write("                <h3>contact us</h3>\n");
      out.write("                <input type=\"number\" placeholder=\"your number\" class=\"box-c\">\n");
      out.write("                <input type=\"text\" placeholder=\"your name\" class=\"box-c\"/>       \n");
      out.write("                <input type=\"email\" placeholder=\"your name\" class=\"box-c\"/>\n");
      out.write("                <textarea name=\"\" placeholder=\"your message\" id=\"\" cols=\"30\" rows=\"10\"></textarea>\n");
      out.write("                <input type=\"submit\" value=\"send message\" class=\"btn\" />\n");
      out.write("            </form>\n");
      out.write("        </section>\n");
      out.write("        <!-- contact end -->\n");
      out.write("        <!-- footer -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<footer class=\"bg-white mt-3 \">\n");
      out.write("    <div class=\"containercc\">\n");
      out.write("        <div class=\"d-flex justify-content-evenly my-3\">\n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                <a class=\"text-decoration-none text-reset\" href=\"#\">\n");
      out.write("                    <span>Chính sách bảo mật</span>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                <a class=\"text-decoration-none text-reset\" href=\"#\">\n");
      out.write("                    <span>Quy chế hoạt động</span>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                <a class=\"text-decoration-none text-reset\" href=\"#\">\n");
      out.write("                    <span>Chính sách vận chuyển</span>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"text-center\">\n");
      out.write("                <a class=\"text-decoration-none text-reset\" href=\"#\">\n");
      out.write("                    <span>Chính sách trả hàng và hoàn tiền</span>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"text-center\">\n");
      out.write("            <div>\n");
      out.write("                Địa chỉ:Quận 9, Thành phố Hồ Chí Minh, Việt Nam. Tổng đài hỗ trợ: 1900xxxx - Email: cskh@hotro.pet.vn\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                Chịu Trách Nhiệm Quản Lý Nội Dung: Nguyễn Văn A - Điện thoại liên hệ: 012 3456xxxx\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                Mã số doanh nghiệp: 010677xxxx do Sở Kế hoạch & Đầu tư TP Hà Nội cấp lần đầu ngày 10/05/20xx\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                © 2015 - Bản quyền thuộc về Công ty TNHH Pet\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- footer end -->\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.User != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <a href=\"MainController?action=signin\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.User.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.User != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <a class=\"dropdown-item\" href=\"MainController?action=listpetCus\">List Pet Of Cust</a>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.User != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        <a class=\"dropdown-item\" href=\"MainController?action=logout\">Log Out</a>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }
}

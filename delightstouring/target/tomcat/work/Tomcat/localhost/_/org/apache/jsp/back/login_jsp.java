/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2020-10-30 11:32:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.back;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("    <meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("    <meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("    <title>登录界面</title>\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <!--必要样式-->\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/styles.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/demo.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/css/loaders.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class='login'>\r\n");
      out.write("    <div class='login_title'>\r\n");
      out.write("        <span>管理员登录</span>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class='login_fields'>\r\n");
      out.write("        <div class='login_fields__user'>\r\n");
      out.write("            <div class='icon'>\r\n");
      out.write("                <img alt=\"\" src='");
      out.print(request.getContextPath());
      out.write("/img/user_icon_copy.png'>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- 用户名 -->\r\n");
      out.write("            <input name=\"username\" id=\"username\" placeholder='用户名' maxlength=\"16\" type='text' autocomplete=\"off\"/>\r\n");
      out.write("            <div class='validation'>\r\n");
      out.write("                <img alt=\"\" src='../img/tick.png'>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class='login_fields__password'>\r\n");
      out.write("            <div class='icon'>\r\n");
      out.write("                <img alt=\"\" src='");
      out.print(request.getContextPath());
      out.write("/img/lock_icon_copy.png'>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- 密码 -->\r\n");
      out.write("            <input name=\"password\" id=\"password\" placeholder='密码' maxlength=\"16\" type='text' autocomplete=\"off\">\r\n");
      out.write("            <div class='validation'>\r\n");
      out.write("                <img alt=\"\" src='../img/tick.png'>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class='login_fields__password'>\r\n");
      out.write("            <div class='icon'>\r\n");
      out.write("                <img alt=\"\" src='");
      out.print(request.getContextPath());
      out.write("/img/key.png'>\r\n");
      out.write("            </div>\r\n");
      out.write("            <input name=\"code\" placeholder='验证码' maxlength=\"4\" type='text' name=\"ValidateNum\" autocomplete=\"off\">\r\n");
      out.write("            <div class='validation' style=\"opacity: 1; right: -5px;top: -3px;\">\r\n");
      out.write("                <canvas class=\"J_codeimg\" id=\"myCanvas\" onclick=\"Code();\">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class='login_fields__submit'>\r\n");
      out.write("            <input type='button' value='登录'>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class='success'>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class='disclaimer'>\r\n");
      out.write("        <p>欢迎登录后台管理系统</p>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class='authent'>\r\n");
      out.write("    <div class=\"loader\" style=\"height: 44px;width: 44px;margin-left: 28px;\">\r\n");
      out.write("        <div class=\"loader-inner ball-clip-rotate-multiple\">\r\n");
      out.write("            <div></div>\r\n");
      out.write("            <div></div>\r\n");
      out.write("            <div></div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <p>认证中...</p>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"OverWindows\"></div>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/layui/css/layui.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-ui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src='");
      out.print(request.getContextPath());
      out.write("/js/stopExecutionOnTimeout.js?t=1'></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/layui/layui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/Particleground.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/Treatment.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery.mockjax.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var canGetCookie = 0;//是否支持存储Cookie 0 不支持 1 支持\r\n");
      out.write("\r\n");
      out.write("    var CodeVal = 0;\r\n");
      out.write("    Code();\r\n");
      out.write("    function Code() {\r\n");
      out.write("        if(canGetCookie == 1){\r\n");
      out.write("            createCode(\"AdminCode\");\r\n");
      out.write("            var AdminCode = getCookieValue(\"AdminCode\");\r\n");
      out.write("            showCheck(AdminCode);\r\n");
      out.write("        }else{\r\n");
      out.write("            showCheck(createCode(\"\"));\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    function showCheck(a) {\r\n");
      out.write("        CodeVal = a;\r\n");
      out.write("        var c = document.getElementById(\"myCanvas\");\r\n");
      out.write("        var ctx = c.getContext(\"2d\");\r\n");
      out.write("        ctx.clearRect(0, 0, 1000, 1000);\r\n");
      out.write("        ctx.font = \"80px 'Hiragino Sans GB'\";\r\n");
      out.write("        ctx.fillStyle = \"#E8DFE8\";\r\n");
      out.write("        ctx.fillText(a, 0, 100);\r\n");
      out.write("    }\r\n");
      out.write("    $(document).keypress(function (e) {\r\n");
      out.write("        // 回车键事件\r\n");
      out.write("        if (e.which == 13) {\r\n");
      out.write("            $('input[type=\"button\"]').click();\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("    //粒子背景特效\r\n");
      out.write("    $('body').particleground({\r\n");
      out.write("        dotColor: '#E8DFE8',\r\n");
      out.write("        lineColor: '#133b88'\r\n");
      out.write("    });\r\n");
      out.write("    $('input[name=\"password\"]').focus(function () {\r\n");
      out.write("        $(this).attr('type', 'password');\r\n");
      out.write("    });\r\n");
      out.write("    $('input[type=\"text\"]').focus(function () {\r\n");
      out.write("        $(this).prev().animate({ 'opacity': '1' }, 200);\r\n");
      out.write("    });\r\n");
      out.write("    $('input[type=\"text\"],input[type=\"password\"]').blur(function () {\r\n");
      out.write("        $(this).prev().animate({ 'opacity': '.5' }, 200);\r\n");
      out.write("    });\r\n");
      out.write("    $('input[name=\"username\"],input[name=\"password\"]').keyup(function () {\r\n");
      out.write("        var Len = $(this).val().length;\r\n");
      out.write("        if (!$(this).val() == '' && Len >= 5) {\r\n");
      out.write("            $(this).next().animate({\r\n");
      out.write("                'opacity': '1',\r\n");
      out.write("                'right': '30'\r\n");
      out.write("            }, 200);\r\n");
      out.write("        } else {\r\n");
      out.write("            $(this).next().animate({\r\n");
      out.write("                'opacity': '0',\r\n");
      out.write("                'right': '20'\r\n");
      out.write("            }, 200);\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("    var open = 0;\r\n");
      out.write("    layui.use('layer', function () {\r\n");
      out.write("        //非空验证\r\n");
      out.write("        $('input[type=\"button\"]').click(function () {\r\n");
      out.write("            var username = $('input[name=\"username\"]').val();\r\n");
      out.write("            var password = $('input[name=\"password\"]').val();\r\n");
      out.write("            var code = $('input[name=\"code\"]').val();\r\n");
      out.write("            if (username == '') {\r\n");
      out.write("                ErroAlert('请输入您的账号');\r\n");
      out.write("            } else if (password == '') {\r\n");
      out.write("                ErroAlert('请输入密码');\r\n");
      out.write("            } else if (code == '' || code.length != 4) {\r\n");
      out.write("                ErroAlert('输入验证码');\r\n");
      out.write("            } else {\r\n");
      out.write("                if(code.toUpperCase() == CodeVal.toUpperCase()){\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        url:\"");
      out.print(request.getContextPath());
      out.write("/admin/login\",\r\n");
      out.write("                        type:\"post\",\r\n");
      out.write("                        dataType:\"json\",\r\n");
      out.write("                        // contentType: false,\r\n");
      out.write("                        // processData: false,\r\n");
      out.write("                        data:{\r\n");
      out.write("                            username:username,\r\n");
      out.write("                            password:password\r\n");
      out.write("                        },\r\n");
      out.write("                        success:function(data){\r\n");
      out.write("                            if(data){\r\n");
      out.write("                                window.location.href = \"");
      out.print(request.getContextPath());
      out.write("/back/index.jsp\";\r\n");
      out.write("                            } else {\r\n");
      out.write("                                ErroAlert(\"用户名密码错误\");\r\n");
      out.write("                            }\r\n");
      out.write("                        },\r\n");
      out.write("                        error:function(e){\r\n");
      out.write("                            alert(\"ajax请求失败\" + e.message);\r\n");
      out.write("                        }\r\n");
      out.write("                    })\r\n");
      out.write("                }else{\r\n");
      out.write("                    ErroAlert(\"验证码错误\")\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("    })\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

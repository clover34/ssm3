/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2020-10-31 06:15:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.scenicspot;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.lang.ref.ReferenceQueue;
import org.springframework.web.context.request.RequestScope;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>修改</title>\r\n");
      out.write("    <!-- 引入 jQuery 插件 -->\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-1.11.3.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("    <!-- 引入 boostarp 插件 -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/bootstrap.css\"/>\r\n");
      out.write("    <!-- 引入 bootstrap 框架插件 -->\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/js/bootstrap.min.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        $(function(){\r\n");
      out.write("            // 设置点击图片控件的时候选择文件\r\n");
      out.write("            $(\"#showImage\").click(function () {\r\n");
      out.write("                $(\"#photo\").click();\r\n");
      out.write("            })\r\n");
      out.write("            // 当 file 控件发生改变的时候\r\n");
      out.write("            $(\"#photo\").change(function(){\r\n");
      out.write("                // 获取整个上传文件控件标签\r\n");
      out.write("                var image = $(\"#photo\")[0];\r\n");
      out.write("                // image.files[0] 能获取到文件的名称，文件类型，文件大小，将此文件的对象传到 getUrl 方法\r\n");
      out.write("                var url = getUrl(image.files[0]);\r\n");
      out.write("                // 判断方法返回的 ULR 是否为空\r\n");
      out.write("                if(url == null){\r\n");
      out.write("                    alert(\"文件异常\")\r\n");
      out.write("                }else{\r\n");
      out.write("                    // 设置图片空间的 src 属性；给了一个路径\r\n");
      out.write("                    $(\"#showImage\").attr(\"src\",url);\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("            // 接受一个文件的参数\r\n");
      out.write("            function getUrl(file) {\r\n");
      out.write("                var url = null;\r\n");
      out.write("                if (window.createObjectURL != undefined) {\r\n");
      out.write("\r\n");
      out.write("                    url = window.createObjectURL(file);\r\n");
      out.write("                } else if (window.URL != undefined) {\r\n");
      out.write("                    // 根据传入的参数创建一个指向该参数对象的URL. 这个URL的生命仅存在于它被创建的这个文档里. 新的对象URL指向执行的File对象或者是Blob对象.\r\n");
      out.write("                    // File对象,就是一个文件,比如我用input type=\"file\"标签来上传文件,那么里面的每个文件都是一个File对象.\r\n");
      out.write("                    url = window.URL.createObjectURL(file);\r\n");
      out.write("                } else\r\n");
      out.write("                if (window.webkitURL != undefined) {\r\n");
      out.write("                    url = window.webkitURL.createObjectURL(file);\r\n");
      out.write("                }\r\n");
      out.write("                // 当没有进入上面的三个逻辑方法的时候 url 返回的是一个空\r\n");
      out.write("                return url;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            $(\"#pId\").focus(function () {\r\n");
      out.write("                // ajax 请求查询省份信息\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url:\"");
      out.print(request.getContextPath());
      out.write("/back/scenicspot/findProvinces\",\r\n");
      out.write("                    type:\"post\",\r\n");
      out.write("                    dataType: \"json\",\r\n");
      out.write("                    data:{},\r\n");
      out.write("                    success:function (data) {\r\n");
      out.write("                        var pIdTag = $(\"#pId\");\r\n");
      out.write("                        pIdTag.text(\"\");\r\n");
      out.write("                        var strHead = \"<option value='0'>---&nbsp;请选择&nbsp;---</option>\";\r\n");
      out.write("                        pIdTag.append(strHead);\r\n");
      out.write("                        $.each(data,function (i,province) {\r\n");
      out.write("                            var str = \"<option value='\"+ province.pId +\"'>\"+ province.pName +\"</option>\";\r\n");
      out.write("                            pIdTag.append(str);\r\n");
      out.write("                        })\r\n");
      out.write("                    },\r\n");
      out.write("                    error:function (e) {\r\n");
      out.write("                        alert(e)\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            // 当省份标签发生改变的时候\r\n");
      out.write("            $(\"#pId\").change(function () {\r\n");
      out.write("                var pIdVal = $(this).val();\r\n");
      out.write("                var rIdTag = $(\"#rId\");\r\n");
      out.write("                rIdTag.text(\"\");\r\n");
      out.write("                rIdTag.append(\"<option value='0'>---&nbsp;请选择&nbsp;---</option>\");\r\n");
      out.write("                if(pIdVal != 0){\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        url:\"");
      out.print(request.getContextPath());
      out.write("/back/scenicspot/findRegion\",\r\n");
      out.write("                        type:\"post\",\r\n");
      out.write("                        dataType:\"json\",\r\n");
      out.write("                        data:{\r\n");
      out.write("                            \"pId\":pIdVal,\r\n");
      out.write("                        },\r\n");
      out.write("                        success:function (data) {\r\n");
      out.write("                            $.each(data,function (i,region) {\r\n");
      out.write("                                rIdTag.append(\"<option value='\"+ region.rId +\"'>\"+ region.rName +\"</option>\")\r\n");
      out.write("                            })\r\n");
      out.write("                        },\r\n");
      out.write("                        error:function (e) {\r\n");
      out.write("                            alert(e)\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                    })\r\n");
      out.write("                } else {\r\n");
      out.write("                    rIdTag.text(\"\")\r\n");
      out.write("                    rIdTag.append(\"<option value='0'>---&nbsp;请选择&nbsp;---</option>\");\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            // 提交按钮被点击的时候\r\n");
      out.write("            $(\"#submitBtn\").click(function(){\r\n");
      out.write("                // ajax 提交数据\r\n");
      out.write("                sumbitData();\r\n");
      out.write("            })\r\n");
      out.write("            function sumbitData(){\r\n");
      out.write("                // 获取 id = add 的表单数据\r\n");
      out.write("                var formData = new FormData(document.getElementById(\"add\"));\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url:\"");
      out.print(request.getContextPath());
      out.write("/back/scenicspot/updateById\",\r\n");
      out.write("                    type:\"post\",\r\n");
      out.write("                    data:formData,\r\n");
      out.write("                    dataType:\"json\",\r\n");
      out.write("                    contentType: false,// 让 jq 不要处理请求头\r\n");
      out.write("                    processData: false,// 让 jq 不要处理请求数据\r\n");
      out.write("                    success: function(data){\r\n");
      out.write("                        alert(data ? \"修改成功\" : \"修改失败\");\r\n");
      out.write("                        location.href = \"");
      out.print(request.getContextPath());
      out.write("/back/scenicspot/findAll?pId=&rId=\";\r\n");
      out.write("                    },\r\n");
      out.write("                    error : function (e) {\r\n");
      out.write("                        alert(e);\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\" style=\"margin-top: 10px\">\r\n");
      out.write("    <div class=\"row clearfix\">\r\n");
      out.write("        <div class=\"col-md-4 column col-md-offset-4\">\r\n");
      out.write("            <form role=\"form\" id=\"add\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"ssId\">景点编号&nbsp;<span style=\"color: red\">*</span></label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"ssId\" id=\"ssId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${scenicspot.ssId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" readonly/>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"ssName\">景点名称&nbsp;<span style=\"color: red\">*</span></label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"ssName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${scenicspot.ssName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"ssName\" placeholder=\"景点名称\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"pId\">省份&nbsp;<span style=\"color: red\">*</span></label>\r\n");
      out.write("                    <select class=\"form-control\" name=\"pId\" id=\"pId\">\r\n");
      out.write("                        <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${scenicspot.pId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${scenicspot.province.pName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"rId\">地区&nbsp;<span style=\"color: red\">*</span></label>\r\n");
      out.write("                    <select class=\"form-control\" name=\"rId\" id=\"rId\">\r\n");
      out.write("                        <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${scenicspot.rId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${scenicspot.region.rName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"form-group text-center\">\r\n");
      out.write("                    <label for=\"ssName\">景点图片&nbsp;<span style=\"color: red\">*</span></label>\r\n");
      out.write("                    <img id=\"showImage\"  src=\"");
      out.print(request.getContextPath());
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${scenicspot.ssPhotopath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"img-rounded\"  style=\"height: 60px;width: 290px;cursor: pointer\">\r\n");
      out.write("                    <input type=\"file\" class=\"form-control-file\" value=\"");
      out.print(request.getContextPath());
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${scenicspot.ssPhotopath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"photo\" id=\"photo\" style=\"display: none\">\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"ssDescribe\">景点描述：&nbsp;<span style=\"color: red\">*</span></label>\r\n");
      out.write("                    <textarea class=\"form-control\" name=\"ssDescribe\" id=\"ssDescribe\" placeholder=\"景点描述\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${scenicspot.ssDescribe}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"ssAddress\">详细地址&nbsp;<span style=\"color: red\">*</span></label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${scenicspot.ssAddress}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"ssAddress\" id=\"ssAddress\" placeholder=\"详细地址\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"ssOpendate\">开放时间&nbsp;<span style=\"color: red\">*</span></label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${scenicspot.ssOpendate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"ssOpendate\" id=\"ssOpendate\" placeholder=\"开放时间\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <span id=\"info\"></span>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <button type=\"button\" id=\"submitBtn\" class=\"btn btn-primary col-md-12\" style=\"margin-top: 10px\">提交</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
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
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.89
 * Generated at: 2023-07-09 12:46:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.resources.SmartEditor.photo_005fuploader.popup;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.UUID;
import java.text.SimpleDateFormat;

public final class file_005fuploader_005fhtml5_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("java.util.UUID");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");

    //파일정보
    String sFileInfo = "";
    //파일명을 받는다 - 일반 원본파일명
    String filename = request.getHeader("file-name");
    //파일 확장자
    String filename_ext = filename.substring(filename.lastIndexOf(".") + 1);
    //확장자를소문자로 변경
    filename_ext = filename_ext.toLowerCase();
 
    //이미지 검증 배열변수
    String[] allow_file = { "jpg", "png", "bmp", "gif" };
 
    //돌리면서 확장자가 이미지인지 
    int cnt = 0;
    for (int i = 0; i < allow_file.length; i++) {
        if (filename_ext.equals(allow_file[i])) {
            cnt++;
        }
    }
 
    //이미지가 아님
    if (cnt == 0) {
        out.println("NOTALLOW_" + filename);
    } else {
        //이미지이므로 신규 파일로 디렉토리 설정 및 업로드   
        //파일 기본경로
        String dftFilePath = request.getSession().getServletContext().getRealPath("/resources/upload");
        //파일 기본경로 _ 상세경로
        String filePath = dftFilePath + File.separator;
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String realFileNm = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String today = formatter.format(new java.util.Date());
        realFileNm = today + UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
        String rlFileNm = filePath + realFileNm;
        ///////////////// 서버에 파일쓰기 ///////////////// 
        InputStream is = request.getInputStream();
        OutputStream os = new FileOutputStream(rlFileNm);
        int numRead;
        byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
        while ((numRead = is.read(b, 0, b.length)) != -1) {
            os.write(b, 0, numRead);
        }
        if (is != null) {
            is.close();
        }
        os.flush();
        os.close();
        ///////////////// 서버에 파일쓰기 /////////////////
 		String contextPath=request.getContextPath();
        // 정보 출력
        sFileInfo += "&bNewLine=true";    
        sFileInfo += "&sFileName=" + filename;    
        sFileInfo += "&sFileURL="+contextPath+"/resources/upload/"+realFileNm;
        out.println(sFileInfo);
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

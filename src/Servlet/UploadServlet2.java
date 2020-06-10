package Servlet;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet2")
@MultipartConfig(maxFileSize=1048576)  // 最大1M
public class UploadServlet2 extends HttpServlet {
	final File uploadDir = new File("C:\\pleiades\\workspace\\keijibankadai\\WebContent\\upload");  // ファイル保存先
	public void init() throws ServletException {
		uploadDir.mkdir();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		// ファイルの保存 ->
		String id = req.getParameter("id");
		Part fPart = req.getPart("file");
		String fName = (new StringBuilder(id)
				.append("_").append(System.currentTimeMillis())
				.append("_").append(fPart.getSubmittedFileName()
						).toString());
		save(fPart, new File(uploadDir, fName));
		// HTML を返す ->

		req.setAttribute("img",fName);

		String view = "/WEB-INF/view/index.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, res);


	}
	public void save(Part in, File out) throws IOException {
		BufferedInputStream br
		= new BufferedInputStream(in.getInputStream());
		try (BufferedOutputStream bw =
				new BufferedOutputStream(new FileOutputStream(out))
				) {
			int len = 0;
			byte[] buff = new byte[1024];
			while ((len = br.read(buff)) != -1) {
				bw.write(buff, 0, len);
			}
		}
	}
}
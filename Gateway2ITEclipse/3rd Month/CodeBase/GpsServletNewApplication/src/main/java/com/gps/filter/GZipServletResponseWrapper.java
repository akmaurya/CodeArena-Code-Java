package com.gps.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipServletResponseWrapper extends HttpServletResponseWrapper {

	private GZipServletOutputStream gzipOutputStream = null;
	private PrintWriter printWriter = null;

	public GZipServletResponseWrapper(HttpServletResponse response)
			throws IOException {
		super(response);
	}

	public void close() throws IOException {

		// PrintWriter.close does not throw exceptions. Thus, the call does not
		// need
		// be inside a try-catch block.
		if (this.printWriter != null) {
			this.printWriter.close();
		}

		if (this.gzipOutputStream != null) {
			this.gzipOutputStream.close();
		}
	}

	/**
	 * Flush OutputStream or PrintWriter
	 *
	 * @throws IOException
	 */

	@Override
	public void flushBuffer() throws IOException {

		// PrintWriter.flush() does not throw exception
		if (this.printWriter != null) {
			this.printWriter.flush();
		}

		IOException exception1 = null;
		try {
			if (this.gzipOutputStream != null) {
				this.gzipOutputStream.flush();
			}
		} catch (IOException e) {
			exception1 = e;
		}

		IOException exception2 = null;
		try {
			super.flushBuffer();
		} catch (IOException e) {
			exception2 = e;
		}

		if (exception1 != null)
			throw exception1;
		if (exception2 != null)
			throw exception2;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (this.printWriter != null) {
			throw new IllegalStateException(
					"PrintWriter obtained already - cannot get OutputStream");
		}
		if (this.gzipOutputStream == null) {
			this.gzipOutputStream = new GZipServletOutputStream(getResponse()
					.getOutputStream());
		}
		return this.gzipOutputStream;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (this.printWriter == null && this.gzipOutputStream != null) {
			throw new IllegalStateException(
					"OutputStream obtained already - cannot get PrintWriter");
		}
		if (this.printWriter == null) {
			this.gzipOutputStream = new GZipServletOutputStream(getResponse()
					.getOutputStream());
			this.printWriter = new PrintWriter(
					new OutputStreamWriter(this.gzipOutputStream, getResponse()
							.getCharacterEncoding()));
		}
		return this.printWriter;
	}

	@Override
	public void setContentLength(int len) {
		// ignore, since content length of zipped content
		// does not match content length of unzipped content.
	}
}

class GZipServletOutputStream extends ServletOutputStream {
	private GZIPOutputStream gzipOutputStream = null;

	public GZipServletOutputStream(OutputStream output) throws IOException {
		super();
		this.gzipOutputStream = new GZIPOutputStream(output);
	}

	@Override
	public void close() throws IOException {
		this.gzipOutputStream.close();
	}

	@Override
	public void flush() throws IOException {
		this.gzipOutputStream.flush();
	}

	@Override
	public void write(byte b[]) throws IOException {
		this.gzipOutputStream.write(b);
	}

	@Override
	public void write(byte b[], int off, int len) throws IOException {
		this.gzipOutputStream.write(b, off, len);
	}

	@Override
	public void write(int b) throws IOException {
		this.gzipOutputStream.write(b);
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWriteListener(WriteListener writeListener) {
		// TODO Auto-generated method stub
		
	}
}

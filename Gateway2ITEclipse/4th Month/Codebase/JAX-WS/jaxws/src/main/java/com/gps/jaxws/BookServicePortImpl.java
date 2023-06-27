package com.gps.jaxws;

import java.util.GregorianCalendar;

import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import com.gps.jaxws.BookServicePortType;
import com.gps.jaxws.BookServiceRequestType;
import com.gps.jaxws.BookServiceResponseType;
import com.gps.jaxws.BookType;

@WebService(endpointInterface = "com.gps.jaxws.BookServicePortType")
public class BookServicePortImpl implements BookServicePortType {

	@Override
	public BookServiceResponseType fetchBooks(
			BookServiceRequestType bookServiceRequest) {
		final BookServiceResponseType response = new BookServiceResponseType();
		for (int i = 0; i < bookServiceRequest.getLimit(); i++) {
			final BookType book = new BookType();
			book.setAuthor("GPSAmit " + i);
			try {
				book.setPublished(DatatypeFactory.newInstance()
						.newXMLGregorianCalendar(
								new GregorianCalendar(2011, 8, 14)));
			} catch (DatatypeConfigurationException e) {
			}
			book.setTitle("Programming Java Edition #" + i);
			response.getBook().add(book);
		}
		return response;
	}
}
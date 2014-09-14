package com.hijoy.utilcommon;

import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
	private String content;
	private String title;
	private String hostName;
	private String destination;
	private String source;
	private String password;

	public void send() {
		SimpleEmail email = new SimpleEmail();
		email.setHostName(hostName);
		email.setAuthentication(source, password);
		try {
			System.out.println("in sendEmail send function");
			email.addTo(destination);
			email.setFrom(source);
			email.setSubject(title);
			email.setMsg(content);
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("send email error");
		}
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * @param hostName
	 *            the hostName to set
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	// public static void main(String args[]) {
	// SendEmail se = new SendEmail();
	// se.setHostName("smtp.163.com");
	// se.setSource("xiaobinghu1989@163.com");
	// se.setPassword("19890302");
	// se.setDestination("vincentmo1989@gmail.com");
	// se.setTitle("Welcome from HiJoy");
	// se.setContent("Hi," + "mo" + ": welcome to join HiJoy, enjoy your time");
	// se.send();
	// }
}

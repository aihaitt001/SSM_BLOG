package springmvc.email;

import java.util.Map;
import java.util.Set;

public class SimpleEmail {

	private Set<String> toSet; // 收件人
	private String subject; // 主题
	private String content; // 正文
	private boolean isHtml; // 正文是否是HTML
	private Map<String, String> attachments; // 附件路径
	private boolean isAttachment; // 是否有附件

	public Set<String> getToSet() {
		return toSet;
	}

	public void setToSet(Set<String> toSet) {
		this.toSet = toSet;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isHtml() {
		return isHtml;
	}

	public void setHtml(boolean isHtml) {
		this.isHtml = isHtml;
	}

	public Map<String, String> getAttachments() {
		return attachments;
	}

	public void setAttachments(Map<String, String> attachments) {
		this.attachments = attachments;
	}

	public boolean isAttachment() {
		return isAttachment;
	}

	public void setAttachment(boolean isAttachment) {
		this.isAttachment = isAttachment;
	}

}
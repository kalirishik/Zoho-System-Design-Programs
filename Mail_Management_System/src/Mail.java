import java.util.*;
public class Mail{
    private String senderMail;
    private String receiverMail;
    private String subject;
    private String content;
    private List<String> tags;
    private boolean isSpam;

    public Mail(String senderMail, String receiverMail, String subject, String content) {
        this.senderMail = senderMail;
        this.receiverMail = receiverMail;
        this.subject = subject;
        this.content = content;
        this.tags=new ArrayList<>();
        this.isSpam = checkForSpam(subject, content);
    }

    public String getSenderMail() {
        return senderMail;
    }

    public String getReceiverMail() {
        return receiverMail;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public List<String> getTags() {
        return tags;
    }

    public boolean isSpam() {
        return isSpam;
    }

    public void setSpam(boolean spam) {
        isSpam = spam;
    }

    public void addTags(String tag){
        if(!tags.contains(tag)){
            tags.add(tag);
            System.out.println("Tag Name: "+tag+" Added Successfully");
        }
        else
            System.out.println("Tag Name: "+tag+" Already Added");
    }

    public void removeTag(String tag){
        tags.remove(tag);
    }

    private boolean checkForSpam(String subject, String content) {
        String[] spamKeywords = {"lottery", "win", "prize", "free", "money", "urgent", "job alert"};
        String combined = (subject + " " + content).toLowerCase();
        for (String word : spamKeywords) {
            if (combined.contains(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "senderMail='" + senderMail + '\'' +
                ", receiverMail='" + receiverMail + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", tags=" + tags +
                ", isSpam=" + isSpam ;
    }
}
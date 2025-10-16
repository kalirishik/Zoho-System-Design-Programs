import java.util.*;
import java.util.stream.Collectors;

public class MailManagementSystem {
    static List<Mail> mails;
    static List<String> spamWords;
    Scanner sc;
    public MailManagementSystem(){
        mails=new ArrayList<>();
        spamWords=new ArrayList<>(Arrays.asList("spam","price","lottery","winner","free","urgent","congratulations"));
        sc=new Scanner(System.in);
    }

    public void storeMail(String senderMail,String receiverMail,String subject,String content){
        Mail mail=new Mail(senderMail,receiverMail,subject,content);
        mails.add(mail);
        System.out.println("Mail Successfully Stored");
    }

    public void deleteMail(int index) {
        if(index>=0 && index< mails.size()){
            mails.remove(index);
            System.out.println("Mail index: "+index+" Deleted Successfully");
        }
        else
            System.out.println("Delete Mail Index Not Found");

    }

    public void addTag(int index) {
        if(index>=0 && index< mails.size()){
            System.out.print("Enter Tag Name: ");
            String tagName=sc.next();
            mails.get(index).addTags(tagName);
        }
        else
            System.out.println("Add Tag Mail Index Not Found");
    }

    public void showStats() {
        System.out.println("------------ Mail Statistics --------");
        System.out.println("Total Mails: "+mails.size());
        if(mails.size()!=0){
            System.out.print("Enter Number Of Recent Mails to Display: ");
            int recentMailCount=sc.nextInt();
            mails.stream()
                    .skip(Math.max(0,mails.size()-recentMailCount))
                    .forEach(System.out::println);
        }
    }

    public void search(String searchWord) {
        List<Mail> searchMail=mails.stream()
                .filter(mail -> mail.getSenderMail().contains(searchWord)
                                || mail.getReceiverMail().contains(searchWord)
                                || mail.getSubject().contains(searchWord)
                                || mail.getContent().contains(searchWord)
                                || mail.getTags().stream().anyMatch(tag->tag.contains(searchWord)))
                .collect(Collectors.toList());
        if(searchMail.isEmpty())
            System.out.println("No Mails Found The Query");
        else
            searchMail.forEach(System.out::println);
    }

    public void wildCardSearch(String wildCardSearchWord) {
        String pattern=wildCardSearchWord.replace("*",".*");
        List<Mail> searchMail=mails.stream()
                .filter(mail -> mail.getSenderMail().matches(pattern)
                        || mail.getReceiverMail().matches(pattern)
                        || mail.getSubject().matches(pattern)
                        || mail.getContent().matches(pattern)
                        || mail.getTags().stream().anyMatch(tag->tag.matches(pattern)))
                .collect(Collectors.toList());
        if(searchMail.isEmpty())
            System.out.println("No Mails Found The Query");
        else
            searchMail.forEach(System.out::println);
    }
}

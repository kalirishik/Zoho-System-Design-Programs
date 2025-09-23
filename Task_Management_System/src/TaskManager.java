import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class TaskManager {
    Scanner sc=new Scanner(System.in);
    Map<Integer,Task> tasks=new HashMap<>();
    int id=0;
    public void addTask(){
        System.out.print("Enter Task Id: ");
        int taskId=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Task Name: ");
        String taskName=sc.nextLine();
        System.out.print("Enter Task Description: ");
        String taskDescription=sc.nextLine();
        Date taskDueDate=null;
        while(taskDueDate==null){
            taskDueDate=getDate();
        }
        Priority priority=getPriority();
        Set<String> categories=getCategories();
        tasks.put(++id,new Task(taskId,taskName,taskDescription,taskDueDate,priority,categories));
        System.out.println("Task Added Successfully");
    }

    public void viewTask(){
        for(Map.Entry<Integer,Task> task:tasks.entrySet()){
            System.out.printf("\nTask ID: %-2d | Task Name: %-8s | Description: %-10s " +
                            "| Due Date: %-8s | Priority: %-8s | Categories: %-8s\n",
                    task.getValue().getTaskId(),task.getValue().getTaskName(),
                    task.getValue().getTaskDescriptions(),
                    dateToString(task.getValue().getDueDate()),
                    task.getValue().getPriority(),
                    setToString(task.getValue().getCategories()));
        }
    }
    public void viewTaskByPriority(){
        Map<Priority,List<Task>> taskByCategory=new HashMap<>();
        for(Priority priority:Priority.values()){
            taskByCategory.put(priority,new ArrayList<>());
        }
        for(Task task:tasks.values()){
            taskByCategory.get(task.getPriority()).add(task);
        }
        viewTask("HIGH",taskByCategory.get(Priority.HIGH));
        viewTask("MEDIUM",taskByCategory.get(Priority.MEDIUM));
        viewTask("LOW",taskByCategory.get(Priority.LOW));

    }
    public void viewTask(String Priority,List<Task> tasks){
        if(!tasks.isEmpty()){
            System.out.println("---------- "+Priority+" Priority Task --------------");
            for(Task task:tasks){
                System.out.printf("\nTask ID: %-2d | Task Name: %-8s | Description: %-10s " +
                                "| Due Date: %-8s | Priority: %-8s | Categories: %-8s\n",
                        task.getTaskId(),task.getTaskName(),
                        task.getTaskDescriptions(),
                        dateToString(task.getDueDate()),
                        task.getPriority(),
                        setToString(task.getCategories()));
            }
        }
    }

    public void viewTaskByCategory(){
        Map<String,List<Task>> categoryMap=new HashMap<>();
        for(Task task:tasks.values()){
            for(String category:task.getCategories()){
                if(!categoryMap.containsKey(category)){
                    categoryMap.put(category,new ArrayList<>());
                }
                categoryMap.get(category).add(task);
            }
        }
        for(Map.Entry<String,List<Task>> entry:categoryMap.entrySet()){
            System.out.println("\n----------- "+entry.getKey()+" ----------------");
            for(Task task:entry.getValue()){
                System.out.printf("\nTask ID: %-2d | Task Name: %-8s | Description: %-10s " +
                                "| Due Date: %-8s | Priority: %-8s | Categories: %-8s\n",
                        task.getTaskId(),task.getTaskName(),
                        task.getTaskDescriptions(),
                        dateToString(task.getDueDate()),
                        task.getPriority(),
                        setToString(task.getCategories()));
            }
        }

    }

    public Date getDate() {
        System.out.print("Enter Task Due Date (dd-mm-yyyy): ");
        String strDate=sc.nextLine();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        try{
            Date date=dateFormat.parse(strDate);
            if(date.before(new Date())){
                System.out.println("Enter Future Date");
                return null;
            }
            return date;
        }
        catch(ParseException e){
            System.out.println("Date Is Invalid Please Enter Valid Date");
        }
        return null;
    }
    public String dateToString(Date dueDate){
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(dueDate);
    }
    public Priority getPriority(){
        System.out.print("Enter Priority (HIGH,MEDIUM,LOW): ");
        String priority=sc.next().toUpperCase();
        try{
            return Priority.valueOf(priority);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Priority. Defaulting to MEDIUM");
            return Priority.MEDIUM;
        }
    }
    public Set<String> getCategories(){
        Set<String> categoriesSet=new HashSet<>();
        System.out.print("Enter Categories (Commas Separated):");
        sc.nextLine();
        String parts[]=sc.nextLine().split(",");
        for(String str:parts){
            String trimmedStr=str.trim();
            if(!trimmedStr.isEmpty())
                categoriesSet.add(trimmedStr);
        }
        return categoriesSet;
    }
    public String setToString(Set<String> str){
        return String.join(", ",str);
    }
}

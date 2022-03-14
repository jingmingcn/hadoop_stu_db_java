
public class Student{

    public static final String COLUMN_SEPERATOR = "\t";
    public static final int FIXED_LENGTH = 100;

    public String num;
    public String name;
    public String sex;
    public String college;
    public String phone;

    public Student(String str){
        String s[] = str.trim().split(COLUMN_SEPERATOR);
        this.num = s[0];
        this.name = s[1];
        this.sex = s[2];
        this.college = s[3];
        this.phone = s[4];
    }

    public Student(String num, String name, String sex, String college, String phone){
        this.num = num;
        this.name = name;
        this.sex = sex;
        this.college = college;
        this.phone = phone;
    }

    public String toString(){
        String str = num + COLUMN_SEPERATOR + name + COLUMN_SEPERATOR 
                + sex  + COLUMN_SEPERATOR + college  + COLUMN_SEPERATOR + phone;
        
        return String.format("%1$-"+(FIXED_LENGTH-1)+"s%n", str);
    }

}
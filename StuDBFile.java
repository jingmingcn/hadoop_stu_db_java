
import java.util.*;
import java.io.*;


public class StuDBFile{

    private static final String STU_DB_FILE = "stu.db";
    private static final String STU_INDEX_DB_FILE = "stu.index";
    static Map<String,Integer> indexMap = new HashMap<>();
    static File file;

    static {
        try{
            file = new File(STU_DB_FILE);

            File indexFile = new File(STU_INDEX_DB_FILE);
            BufferedReader br = new BufferedReader(new FileReader(indexFile));
            String str;
            while((str = br.readLine()) != null){
                String s[] = str.split("\t");
                indexMap.put(s[0],Integer.parseInt(s[1]));
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    private StuDBFile(){
        
    }

    public static boolean insertStu(Student stu) throws Exception{
        if (indexMap.get(stu.num) != null) return false;

        RandomAccessFile ra = new RandomAccessFile(STU_DB_FILE,"rw");
        int offset = maxOffset()+Student.FIXED_LENGTH;
        ra.seek(offset);
        ra.write(stu.toString().getBytes());
        ra.close();
        indexMap.put(stu.num, offset);
        writeIndex();
        return true;
    }

    public static boolean deleteStu(Student stu) throws Exception{
        if (indexMap.get(stu.num) == null) return false;

        RandomAccessFile ra = new RandomAccessFile(STU_DB_FILE,"rw");
        int offset = indexMap.get(stu.num);
        ra.seek(offset);
        ra.write(String.format("$-"+(Student.FIXED_LENGTH-1)+"s").getBytes());
        ra.close();
        indexMap.remove(stu.num);
        writeIndex();
        return true;
    }

    public static boolean updateStu(String num, Student stu) throws Exception{
        if (indexMap.get(num) == null) return false;
        
        RandomAccessFile ra = new RandomAccessFile(STU_DB_FILE,"rw");
        int offset = indexMap.get(num);
        ra.seek(offset);
        ra.write(stu.toString().getBytes());
        ra.close();
        if(!num.equals(stu.num)){
            indexMap.put(stu.num, offset);
            writeIndex();
        }
       
        return true;
    }

    public static Student selectStuByNum(String num) throws Exception{
        if (indexMap.get(num)==null) return null;
        RandomAccessFile ra = new RandomAccessFile(STU_DB_FILE,"rw");
        int offset = indexMap.get(num);
        ra.seek(offset);
        byte b[] = new byte[Student.FIXED_LENGTH];
        ra.read(b);
        return new Student(new String(b));
    }

    public static int selectStuByName(String name) throws Exception{
        return 0;
    }

    private static void writeIndex() throws Exception{
        FileWriter fw = new FileWriter(STU_INDEX_DB_FILE);
        indexMap.forEach((k,v)->{
            try{
                fw.write(k+"\t"+v+System.lineSeparator());
            }catch(Exception e){
                e.printStackTrace();
            }
            
        });
        fw.close();
    }

    private static int maxOffset() {

        int offset = -Student.FIXED_LENGTH;
        try{
            if(indexMap.size()>0){
                offset = Collections.max(indexMap.values());        
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return offset;
    }



}
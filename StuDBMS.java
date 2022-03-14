
public class StuDBMS{

    public static void main(String args[]){
        try{
            for(int i = 0; i < 1000; i++){
                String num = String.valueOf(getRandomNumber(1,(int)Math.pow(10,8)));
                String name = names[getRandomNumber(0,names.length)];
                String sex = sexes[getRandomNumber(0,sexes.length)];
                String college = colleges[getRandomNumber(0,colleges.length)];
                String phone = String.valueOf(getRandomNumber(1,(int)Math.pow(10,8)));

                Student stu = new Student(num,name,sex,college,phone);
                
                int action = getRandomNumber(1,5);
                switch(action){
                    case 1: StuDBFile.insertStu(stu); break;
                    case 2: StuDBFile.deleteStu(stu); break;
                    case 3: {
                        String old_num = num;
                        num = String.valueOf(getRandomNumber(1,(int)Math.pow(10,8)));
                        name = names[getRandomNumber(0,names.length)];
                        sex = sexes[getRandomNumber(0,sexes.length)];
                        college = colleges[getRandomNumber(0,colleges.length)];
                        phone = String.valueOf(getRandomNumber(1,(int)Math.pow(10,8)));
                        stu = new Student(num,name,sex,college,phone);
                        StuDBFile.updateStu(old_num, stu);
                    }break;
                    case 4:{
                        num = String.valueOf(getRandomNumber(1,(int)Math.pow(10,8)));
                        stu = StuDBFile.selectStuByNum(num);
                        
                    }
                }

            }
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    static String names[] = {"Wade","Dave","Seth","Ivan","Riley","Gilbert","Jorge","Dan","Brian","Roberto","Ramon","Miles","Liam","Nathaniel","Ethan","Lewis","Milton","Claude","Joshua","Glen","Harvey","Blake","Antonio","Connor","Julian","Aidan","Harold","Conner","Peter","Hunter","Eli","Alberto","Carlos","Shane","Aaron","Marlin","Paul","Ricardo","Hector","Alexis","Adrian","Kingston","Douglas","Gerald","Joey","Johnny","Charlie","Scott","Martin","Tristin","Troy","Tommy","Rick","Victor","Jessie","Neil","Ted","Nick","Wiley","Morris","Clark","Stuart","Orlando","Keith","Marion","Marshall","Noel","Everett","Romeo","Sebastian","Stefan","Robin","Clarence","Sandy","Ernest","Samuel","Benjamin","Luka","Fred","Albert","Greyson","Terry","Cedric","Joe","Paul","George","Bruce","Christopher","Mark","Ron","Craig","Philip","Jimmy","Arthur","Jaime","Perry","Harold","Jerry","Shawn","Walter"};
    static String sexes[] = {"Male","Female"};
    static String colleges[] = {"Academic Affairs","Academic Success Center","Accountability and Assessment","Accounting, Economics & Finance","Administration and Finance","Admissions Undergraduate","Advancement","Affirmative Action","African & African-Amer Studies","Anthropology","Art","Arthur O Eve - E O P Program","ASC Advisement and Retention","ASC Student Accessibility Svcs (Office for)","ASCTutoring","Athletics","Biology","Brockport Downtown","Budgeting","Business Administration","Campus Recreation","Career Services","CELT","Chemistry and Biochemistry","College Communications","Communication","Community Development","Computational Science","Computing Sciences","Counseling Center","Counselor Education","Criminal Justice","Dance","Delta College","Drake Memorial Library","Earth Sciences","Education and Human Development","Education, Health and Human Svcs (School of)","Educational Administration","English","Enrollment Mgt & Student Affairs","Environmental Health and Safety","Environmental Scienceand Ecology","EOC Academic Affairs","EOC Academic Preparation Dept","EOC Administration","EOC Admissions","EOC Attain","EOC Business Affairs","EOC Business and Info Technology","EOC Career Services","EOC College Connection","EOC Community Relations","EOC Cosmetology and Barbering","EOC Counselingand Student Life","EOC Culinary Arts","EOC Childhood Education","EOC Student Services","EOC Health Care","EOC Information Technology","EOC Library","EOC Maintenance","EOC Partnership & Collaboration","EOC Registrar","EOC RISE","EOC Security & Safety","EOC Testing","Equity, Diversity, and Inclusion","Facilities Automotive","Facilities Custodial","Facilities Grounds","Facilities Maintenance","Facilities Maintenance and Operations","Facilities Planning and Construction","Facilities Moving/Truck","Facilities Utilities","Finance and Management","Financial Aid Office","Global Education and Engagement (Center for)","Graduate Studies","Health Science","Health and Human Performance (School of)","Healthcare Studies","History","Honors College","Human Resources","Information Technology Services (BITS)","Institutional Research Analysis","Journalism, Broadcasting and Public Relations","Kinesiology, Sport Studies & P E","Mail Services","Marketing Communications","Mathematics","Modern Languages and Cultures","Nursing","Office of the President","Parking & Transportation Svcs","Payroll","Philosophy","Physics"};

}
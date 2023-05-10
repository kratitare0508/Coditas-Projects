package JDBCStu;

public class Students {

    int sid;
    String snmae;
    String sphoneno;
    String city;

    public Students(String snmae, String sphoneno, String city) {
       // this.sid = sid;
        this.snmae = snmae;
        this.sphoneno = sphoneno;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid=" + sid +
                ", snmae='" + snmae + '\'' +
                ", sphoneno='" + sphoneno + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

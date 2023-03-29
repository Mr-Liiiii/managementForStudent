package School;

public class Major {
    private String majorname;
    private int majorid;
    private int totalnum;
    private int currentnum;

    public Major() {
    }

    public Major(String majorname, int majorid) {
        this.majorname = majorname;
        this.majorid = majorid;
        this.currentnum = 0;
        this.totalnum = 30;
    }

    public Major(String majorname, int majorid, int totalnum, int currentnum) {
        this.majorname = majorname;
        this.majorid = majorid;
        this.totalnum = totalnum;
        this.currentnum = currentnum;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public int getMajorid() {
        return majorid;
    }

    public void setMajorid(int majorid) {
        this.majorid = majorid;
    }

    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    public int getCurrentnum() {
        return currentnum;
    }

    public void setCurrentnum(int currentnum) {
        this.currentnum = currentnum;
    }
}

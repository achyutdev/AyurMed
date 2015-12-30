package app.com.example.dev.weather;

/**
 * Created by Dev on 12/28/2015.
 */
public class DosaTestDesc {
    long id;
    String question;
    int answer;
    DoshaTestQType rowType;

    public DosaTestDesc() {}

    public DosaTestDesc(long id, String question, int answer, DoshaTestQType rowType) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.rowType = rowType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public DoshaTestQType getRowType() {
        return rowType;
    }

    public void setRowType(DoshaTestQType rowType) {
        this.rowType = rowType;
    }
}

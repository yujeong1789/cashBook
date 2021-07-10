/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.app.model;
import java.sql.Timestamp;

/**
 *
 * @author PARK YUJEONG
 */
public class spendDTO {

    private int s_no;
    private int spend_kind;
    private int s_money;
    private Timestamp s_regdate;

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    public int getSpend_kind() {
        return spend_kind;
    }

    public void setSpend_kind(int spend_kind) {
        this.spend_kind = spend_kind;
    }

    public int getS_money() {
        return s_money;
    }

    public void setS_money(int s_money) {
        this.s_money = s_money;
    }

    public Timestamp getS_regdate() {
        return s_regdate;
    }

    public void setS_regdate(Timestamp s_regdate) {
        this.s_regdate = s_regdate;
    }

    @Override
    public String toString() {
        return "spendDTO{" + "s_no=" + s_no + ", spend_kind=" + spend_kind + ", s_money=" + s_money + ", s_regdate=" + s_regdate + '}';
    }

   

    
   
    
}    
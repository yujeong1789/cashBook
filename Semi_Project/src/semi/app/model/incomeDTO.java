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
public class incomeDTO {
    
    //income
    private int i_no;
    private int income_kind;
    private int i_money;
    private Timestamp i_regdate;


    public int getI_no() {
        return i_no;
    }

    public void setI_no(int i_no) {
        this.i_no = i_no;
    }

    public int getIncome_kind() {
        return income_kind;
    }

    public void setIncome_kind(int income_kind) {
        this.income_kind = income_kind;
    }

    public int getI_money() {
        return i_money;
    }

    public void setI_money(int i_money) {
        this.i_money = i_money;
    }

    public Timestamp getI_regdate() {
        return i_regdate;
    }

    public void setI_regdate(Timestamp i_regdate) {
        this.i_regdate = i_regdate;
    }

    @Override
    public String toString() {
        return "incomeDTO{" + "i_no=" + i_no + ", income_kind=" + income_kind + ", i_money=" + i_money + ", i_regdate=" + i_regdate + '}';
    }
    
    
    
}   
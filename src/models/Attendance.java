package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 勤怠データのDTOモデル
 **/

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
@NamedQueries({
    @NamedQuery(
        name = "getAllAttend",
        query = "SELECT a FROM Attendance AS a ORDER BY a.id DESC"
    )
})
@Table(name="attend")
public class Attendance {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "attend_month", length = 2)
    private String attend_month;

    @Column(name = "attend_day", length = 2)
    private String attend_day;

    @Column(name = "attend_week", length = 2)
    private String attend_week;

    @Column(name = "attend_begin", length = 4)
    private String attend_begin;

    @Column(name = "attend_finish", length = 4)
    private String attend_finish;

    @Column(name = "attend_break", length = 4)
    private String attend_break;

    @Column(name = "attend_work", length = 4)
    private String attend_work;
}

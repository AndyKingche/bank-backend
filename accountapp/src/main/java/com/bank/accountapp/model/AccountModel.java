import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "b_acc_account")
@NamedQuery(name = "AccountModel.findAll", query = "SELECT b_acc_account FROM AccountModel b_acc_account")
@Data
public class AccountModel {

}

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "b_acc_transactions")
@NamedQuery(name = "TransactionsModel.findAll", query = "SELECT b_acc_transactions FROM TransactionsModel b_acc_transactions")
@Data
public class TransactionsModel implements Serializable{

}

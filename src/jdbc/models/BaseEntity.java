package jdbc.models;

import java.io.Serializable;

//@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    /*
    * @Id
    * @GeneratedValue(strategy = GenerationType.IDENTITY)
    * */
    private long id;
    //@Version
    private int version;
}

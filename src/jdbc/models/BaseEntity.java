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

    public BaseEntity() {
    }

    public BaseEntity(long id, int version) {
        this.id = id;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}

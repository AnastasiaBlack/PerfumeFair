package java;

import javax.persistence.*;

/**
 * Created by adminaccount on 6/9/2017.
 */
@Entity
@Table(name = "sales", schema = "perfumedb", catalog = "")
public class SalesEntity {
    private int id;
    private Integer volumeOrderedMl;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "volume_ordered_ml")
    public Integer getVolumeOrderedMl() {
        return volumeOrderedMl;
    }

    public void setVolumeOrderedMl(Integer volumeOrderedMl) {
        this.volumeOrderedMl = volumeOrderedMl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesEntity that = (SalesEntity) o;

        if (id != that.id) return false;
        if (volumeOrderedMl != null ? !volumeOrderedMl.equals(that.volumeOrderedMl) : that.volumeOrderedMl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (volumeOrderedMl != null ? volumeOrderedMl.hashCode() : 0);
        return result;
    }
}

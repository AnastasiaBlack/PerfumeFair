package java;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by adminaccount on 6/9/2017.
 */
@Entity
@Table(name = "offers", schema = "perfumedb", catalog = "")
public class OffersEntity {
    private int id;
    private Integer pricePerMl;
    private Integer volumeMl;
    private Date date;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price_per_ml")
    public Integer getPricePerMl() {
        return pricePerMl;
    }

    public void setPricePerMl(Integer pricePerMl) {
        this.pricePerMl = pricePerMl;
    }

    @Basic
    @Column(name = "volume_ml")
    public Integer getVolumeMl() {
        return volumeMl;
    }

    public void setVolumeMl(Integer volumeMl) {
        this.volumeMl = volumeMl;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OffersEntity that = (OffersEntity) o;

        if (id != that.id) return false;
        if (pricePerMl != null ? !pricePerMl.equals(that.pricePerMl) : that.pricePerMl != null) return false;
        if (volumeMl != null ? !volumeMl.equals(that.volumeMl) : that.volumeMl != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pricePerMl != null ? pricePerMl.hashCode() : 0);
        result = 31 * result + (volumeMl != null ? volumeMl.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}

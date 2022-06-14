package hiber.model;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "car")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private User user;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;

    public Car(){

    }
    public Car(int series,String model){
        this.series = series;
        this.model = model;

    }
    public Car(User user,int series,String model){
        this.user=user;
        this.series = series;
        this.model = model;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "model = " + model + '\'' +
                ", series = " + series ;
    }
}

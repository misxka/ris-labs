package models;

import java.math.BigDecimal;

public class Department {
    private Long id;

    private String name;

    private int studentsNumber;

    private BigDecimal price;


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentsNumber(int number) {
        this.studentsNumber = number;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStudentsNumber() {
        return studentsNumber;
    }
}

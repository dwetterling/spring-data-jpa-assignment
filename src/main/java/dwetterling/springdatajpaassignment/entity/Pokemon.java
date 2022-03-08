package dwetterling.springdatajpaassignment.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@NoArgsConstructor
@Table(name="Pokemon")
public class Pokemon {
        @Id
        @Column(name="pokemon_id")
        private int id;
        @Column(name="common_name")
        private String commonName;
        @Column(name="level")
        private int level;
        @Column(name="type")
        private String type;
        @Column(name="stock")
        private int stock;
        @Column(name="purchased")
        private int purchased;
        @Column(name="price")
        private int price;
        @Column(name="image_file_name")
        private String imageFileName;
    }

